public class CharSequenceIterable implements ICharListIterable {

	private final CharSequence BACKING;

	public CharSequenceIterable(CharSequence cs) {
		this.BACKING = cs;
	}

	public ICharIterator iterator() {
		return new CharSequenceIterator(this.BACKING);
	}

	public ICharIterator reverseIterator() {
		return new ReverseCharSequenceIterator(this.BACKING);
	}

}
