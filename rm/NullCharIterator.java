public class NullCharIterator implements ICharIterator {
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
