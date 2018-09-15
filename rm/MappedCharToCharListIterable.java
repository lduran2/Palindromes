public class MappedCharToCharListIterable implements ICharListIterable {

	private final ICharListIterable BACKING;
	private final ICharToCharFunction FUNCTION;

	public MappedCharToCharListIterable(final ICharListIterable anIterable, final ICharToCharFunction aFunction) {
		this.BACKING = anIterable;
		this.FUNCTION = aFunction;
	}

	public ICharIterator iterator() {
		return new MappedCharToCharIterator(this.BACKING.iterator(), this.FUNCTION);
	}

	public ICharIterator reverseIterator() {
		return new MappedCharToCharIterator(this.BACKING.reverseIterator(), this.FUNCTION);
	}

}
