// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.ide.actions;

import com.intellij.ide.IdeBundle;
import com.intellij.ide.caches.CachesInvalidator;
import com.intellij.idea.ActionsBundle;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ex.ApplicationEx;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.registry.Registry;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.newvfs.persistent.FSRecords;
import com.intellij.util.SmartList;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.gist.GistManager;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

final class InvalidateCachesAction extends AnAction implements DumbAware {
  InvalidateCachesAction() {
    String text = ApplicationManager.getApplication().isRestartCapable() ? ActionsBundle.message("action.InvalidateCachesRestart.text")
                                                                         : ActionsBundle.message("action.InvalidateCaches.text");
    getTemplatePresentation().setText(text);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    final ApplicationEx app = (ApplicationEx)ApplicationManager.getApplication();
    boolean canRestart = app.isRestartCapable();

    String[] options = new String[canRestart ? 3 : 2];
    options[0] = canRestart ? IdeBundle.message("button.invalidate.and.restart") : IdeBundle.message("button.invalidate.and.exit");
    options[1] = IdeBundle.message("button.cancel.without.mnemonic");
    if (canRestart) {
      options[2] = IdeBundle.message("button.just.restart");
    }

    List<String> descriptions = new SmartList<>();
    boolean invalidateCachesInvalidatesVfs = Registry.is("idea.invalidate.caches.invalidates.vfs");

    if (invalidateCachesInvalidatesVfs) descriptions.add("Local History");

    for (CachesInvalidator invalidator : CachesInvalidator.EP_NAME.getExtensionList()) {
      ContainerUtil.addIfNotNull(descriptions, invalidator.getDescription());
    }
    Collections.sort(descriptions);

    String warnings = IdeBundle.message("dialog.message.warning");
    if (descriptions.size() == 1) {
      warnings += " "+ IdeBundle.message("dialog.message.will.be.also.cleared", descriptions.get(0));
    }
    else if (!descriptions.isEmpty()) {
      warnings += " "+IdeBundle.message("dialog.message.the.following.items")
                  + "\n"+StringUtil.join(descriptions, s -> "  " + s, "\n");
    }

    String message = IdeBundle.message("dialog.message.caches.will.be.invalidated", descriptions.isEmpty() ? "" : "\n\n" + warnings);
    int result = Messages.showDialog(e.getData(CommonDataKeys.PROJECT),
                                     message,
                                     IdeBundle.message("dialog.title.invalidate.caches"),
                                     options, 0,
                                     Messages.getWarningIcon());

    if (result == -1 || result == 1) {
      return;
    }

    if (result == 2) {
      app.restart(true);
      return;
    }

    if (invalidateCachesInvalidatesVfs) {
      FSRecords.invalidateCaches();
    }
    else {
      FileBasedIndex.getInstance().invalidateCaches();
      GistManager.getInstance().invalidateData();
    }

    CachesInvalidator.EP_NAME.forEachExtensionSafe(CachesInvalidator::invalidateCaches);

    if (result == 0) {
      app.restart(true);
    }
  }
}
