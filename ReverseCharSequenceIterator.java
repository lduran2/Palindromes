public class ReverseCharSequenceIterator implements ICharIterator {

	private final CharSequence BACKING;
	private int index;

	public ReverseCharSequenceIterator(final CharSequence cs) {
		this.BACKING = cs;
		this.index = (this.BACKING.length() - 1);
	}

	public char Current() {
		return this.BACKING.charAt(this.index);
	}

	public int Index() {
		return this.index;
	}

	public void Next()
	{
		--this.index;
	}

	public boolean isValid() {
		return this.index <= 0;
	}

}
