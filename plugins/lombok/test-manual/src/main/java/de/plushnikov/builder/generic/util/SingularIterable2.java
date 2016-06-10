// Generated by delombok at Fri Jun 10 16:27:47 CEST 2016
package de.plushnikov.builder.generic.util;

public class SingularIterable2<T> {
	private Iterable rawTypes;
	private Iterable<Integer> integers;
	private Iterable<T> generics;
	private Iterable<? extends Number> extendsGenerics;

	public static void main(String[] args) {
		SingularIterable2.<Float>builder().generic(20.0F).integer(10).extendsGeneric(2).rawType(2.0);
	}

	@java.lang.SuppressWarnings("all")
	@javax.annotation.Generated("lombok")
	SingularIterable2(final Iterable rawTypes, final Iterable<Integer> integers, final Iterable<T> generics, final Iterable<? extends Number> extendsGenerics) {
		this.rawTypes = rawTypes;
		this.integers = integers;
		this.generics = generics;
		this.extendsGenerics = extendsGenerics;
	}


	@java.lang.SuppressWarnings("all")
	@javax.annotation.Generated("lombok")
	public static class SingularIterableBuilder<T> {
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		private java.util.ArrayList<java.lang.Object> rawTypes;
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		private java.util.ArrayList<Integer> integers;
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		private java.util.ArrayList<T> generics;
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		private java.util.ArrayList<Number> extendsGenerics;

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		SingularIterableBuilder() {
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> rawType(final java.lang.Object rawType) {
			if (this.rawTypes == null) this.rawTypes = new java.util.ArrayList<java.lang.Object>();
			this.rawTypes.add(rawType);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> rawTypes(final java.util.Collection<?> rawTypes) {
			if (this.rawTypes == null) this.rawTypes = new java.util.ArrayList<java.lang.Object>();
			this.rawTypes.addAll(rawTypes);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> clearRawTypes() {
			if (this.rawTypes != null) this.rawTypes.clear();
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> integer(final Integer integer) {
			if (this.integers == null) this.integers = new java.util.ArrayList<Integer>();
			this.integers.add(integer);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> integers(final java.util.Collection<? extends Integer> integers) {
			if (this.integers == null) this.integers = new java.util.ArrayList<Integer>();
			this.integers.addAll(integers);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> clearIntegers() {
			if (this.integers != null) this.integers.clear();
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> generic(final T generic) {
			if (this.generics == null) this.generics = new java.util.ArrayList<T>();
			this.generics.add(generic);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> generics(final java.util.Collection<? extends T> generics) {
			if (this.generics == null) this.generics = new java.util.ArrayList<T>();
			this.generics.addAll(generics);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> clearGenerics() {
			if (this.generics != null) this.generics.clear();
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> extendsGeneric(final Number extendsGeneric) {
			if (this.extendsGenerics == null) this.extendsGenerics = new java.util.ArrayList<Number>();
			this.extendsGenerics.add(extendsGeneric);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> extendsGenerics(final java.util.Collection<? extends Number> extendsGenerics) {
			if (this.extendsGenerics == null) this.extendsGenerics = new java.util.ArrayList<Number>();
			this.extendsGenerics.addAll(extendsGenerics);
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterableBuilder<T> clearExtendsGenerics() {
			if (this.extendsGenerics != null) this.extendsGenerics.clear();
			return this;
		}

		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public SingularIterable2<T> build() {
			java.lang.Iterable<java.lang.Object> rawTypes;
			switch (this.rawTypes == null ? 0 : this.rawTypes.size()) {
			case 0: 
				rawTypes = java.util.Collections.emptyList();
				break;

			case 1: 
				rawTypes = java.util.Collections.singletonList(this.rawTypes.get(0));
				break;

			default: 
				rawTypes = java.util.Collections.unmodifiableList(new java.util.ArrayList<java.lang.Object>(this.rawTypes));
			}
			java.lang.Iterable<Integer> integers;
			switch (this.integers == null ? 0 : this.integers.size()) {
			case 0: 
				integers = java.util.Collections.emptyList();
				break;

			case 1: 
				integers = java.util.Collections.singletonList(this.integers.get(0));
				break;

			default: 
				integers = java.util.Collections.unmodifiableList(new java.util.ArrayList<Integer>(this.integers));
			}
			java.lang.Iterable<T> generics;
			switch (this.generics == null ? 0 : this.generics.size()) {
			case 0: 
				generics = java.util.Collections.emptyList();
				break;

			case 1: 
				generics = java.util.Collections.singletonList(this.generics.get(0));
				break;

			default: 
				generics = java.util.Collections.unmodifiableList(new java.util.ArrayList<T>(this.generics));
			}
			java.lang.Iterable<Number> extendsGenerics;
			switch (this.extendsGenerics == null ? 0 : this.extendsGenerics.size()) {
			case 0: 
				extendsGenerics = java.util.Collections.emptyList();
				break;

			case 1: 
				extendsGenerics = java.util.Collections.singletonList(this.extendsGenerics.get(0));
				break;

			default: 
				extendsGenerics = java.util.Collections.unmodifiableList(new java.util.ArrayList<Number>(this.extendsGenerics));
			}
			return new SingularIterable2<T>(rawTypes, integers, generics, extendsGenerics);
		}

		@java.lang.Override
		@java.lang.SuppressWarnings("all")
		@javax.annotation.Generated("lombok")
		public java.lang.String toString() {
			return "SingularIterable2.SingularIterableBuilder(rawTypes=" + this.rawTypes + ", integers=" + this.integers + ", generics=" + this.generics + ", extendsGenerics=" + this.extendsGenerics + ")";
		}
	}

	@java.lang.SuppressWarnings("all")
	@javax.annotation.Generated("lombok")
	public static <T> SingularIterableBuilder<T> builder() {
		return new SingularIterableBuilder<T>();
	}
}
