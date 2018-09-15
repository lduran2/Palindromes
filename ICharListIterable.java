public interface ICharListIterable {
	ICharIterator iterator();
	ICharIterator reverseIterator();

	public class Null implements ICharListIterable {
		public ICharIterator iterator() {
			return new ICharIterator.Null();
		}

		public ICharIterator reverseIterator() {
			return new ICharIterator.Null();
		}
	}

	public class Filter implements ICharListIterable {

		private final ICharListIterable BACKING;
		private final ICharPredicate CONDITION;

		public Filter(final ICharListIterable anIterable, final ICharPredicate aPredicate) {
			this.BACKING = anIterable;
			this.CONDITION = aPredicate;
		}

		public ICharIterator iterator() {
			return new ICharIterator.Filter(this.BACKING.iterator(), this.CONDITION);
		}

		public ICharIterator reverseIterator() {
			return new ICharIterator.Filter(this.BACKING.reverseIterator(), this.CONDITION);
		}

	}

	public class MapToChars implements ICharListIterable {

		private final ICharListIterable BACKING;
		private final ICharToCharFunction FUNCTION;

		public MapToChars(final ICharListIterable anIterable, final ICharToCharFunction aFunction) {
			this.BACKING = anIterable;
			this.FUNCTION = aFunction;
		}

		public ICharIterator iterator() {
			return new ICharIterator.MapToChars(this.BACKING.iterator(), this.FUNCTION);
		}

		public ICharIterator reverseIterator() {
			return new ICharIterator.MapToChars(this.BACKING.reverseIterator(), this.FUNCTION);
		}

	}

}
