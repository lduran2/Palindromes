public interface ICharIterator {
	char Current();
	int Index();
	void Next();
	boolean isValid();
}