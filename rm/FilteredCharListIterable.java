public class FilteredCharListIterable implements ICharListIterable {

	private final ICharListIterable BACKING;
	private final ICharPredicate CONDITION;

	public FilteredCharListIterable(final ICharListIterable anIterable, final ICharPredicate aPredicate) {
		this.BACKING = anIterable;
		this.CONDITION = aPredicate;
	}

	public ICharIterator iterator() {
		return new FilteredCharIterator(this.BACKING.iterator(), this.CONDITION);
	}

	public ICharIterator reverseIterator() {
		return new FilteredCharIterator(this.BACKING.reverseIterator(), this.CONDITION);
	}

}
