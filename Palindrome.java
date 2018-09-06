public enum Palindrome {
	;

	public static void main(final String... args) {
		for (String arg : args) {
			System.out.print(arg);
			System.out.print(" : ");
			System.out.print(isPalindrome(arg));
			System.out.println();
			System.out.println();
		}
	}

	public static boolean isPalindrome(final CharSequence cs) {
		final ICharIterator LEFT = new CharSequenceIterator(cs);
		final ICharIterator RIGHT = new ReverseCharSequenceIterator(cs);
		return isPalindrome(LEFT, RIGHT);
	}

	public static boolean isPalindrome(final ICharIterator left, final ICharIterator right) {
		boolean isSearching = true;

		for (; isSearching && (left.Index() <= right.Index()); left.Next(), right.Next()) {
			System.out.println(left.Index() + "," + right.Index());
			System.out.println(left.Current() + "," + right.Current());
			if (left.Current() != right.Current()) {
				isSearching = false;
			}
		}

		return isSearching;
	}
}
