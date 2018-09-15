public interface ICharListIterable {
	ICharIterator iterator();
	ICharIterator reverseIterator();

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

}
