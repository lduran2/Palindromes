public class CharSequenceIterator implements ICharIterator {

	private final CharSequence BACKING;
	private int index = 0;

	public CharSequenceIterator(final CharSequence cs) {
		this.BACKING = cs;
	}

	public char Current() {
		return this.BACKING.charAt(this.index);
	}

	public int Index() {
		return this.index;
	}

	public void Next()
	{
		++this.index;
	}

	public boolean isValid() {
		return this.index < this.BACKING.length();
	}

}
