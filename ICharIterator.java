public interface ICharIterator {

	char Current();
	int Index();
	void Next();
	boolean isValid();

	public static final class Filter implements ICharIterator {

		private final ICharIterator BACKING;
		private final ICharPredicate CONDITION;

		public Filter(final ICharIterator anIt, final ICharPredicate aPredicate) {
			this.BACKING = anIt;
			this.CONDITION = aPredicate;
		}

		public char Current() {
			this.nextUntilConditionIsTrue();
			return this.BACKING.Current();
		}

		public int Index() {
			this.nextUntilConditionIsTrue();
			return this.BACKING.Index();
		}

		public void Next() {
			this.BACKING.Next();
		}

		final public void nextUntilConditionIsTrue() {
			while (this.BACKING.isValid() && (!this.CONDITION.call(this.BACKING.Current()))) {
				this.BACKING.Next();
			}
		}

		public boolean isValid() {
			this.nextUntilConditionIsTrue();
			return this.BACKING.isValid();
		}

	}

}
