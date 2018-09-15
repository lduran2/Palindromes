public interface ICharIterator {

	char Current();
	int Index();
	void Next();
	boolean isValid();

	public class Null implements ICharIterator {
		public char Current() {
			return '\0';
		}

		public int Index() {
			return 0;
		}

		public void Next()
		{}

		public boolean isValid() {
			return false;
		}
	}

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

	public class MapToChars implements ICharIterator {

		private final ICharIterator BACKING;
		private final ICharToCharFunction FUNCTION;

		public MapToChars(final ICharIterator anIt, final ICharToCharFunction aFunction) {
			this.BACKING = anIt;
			this.FUNCTION = aFunction;
		}

		public char Current() {
			return this.FUNCTION.apply(this.BACKING.Current());
		}

		public int Index() {
			return this.BACKING.Index();
		}

		public void Next() {
			this.BACKING.Next();
		}

		public boolean isValid() {
			return this.BACKING.isValid();
		}

	}

}
