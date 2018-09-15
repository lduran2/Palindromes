public class MappedCharToCharIterator implements ICharIterator {

	private final ICharIterator BACKING;
	private final ICharToCharFunction FUNCTION;

	public MappedCharToCharIterator(final ICharIterator anIt, final ICharToCharFunction aFunction) {
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
