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
		final ICharListIterable ITERABLE;
		ITERABLE = new ICharListIterable.MapToChars(
			new ICharListIterable.Filter(
				new CharSequenceIterable(cs),
				(c) -> Character.isLetter(c)
			),
			(c) -> Character.toLowerCase(c)
		);
		return isPalindrome(ITERABLE);
	}

	public static boolean isPalindrome(final ICharListIterable iterable) {
		boolean isSearching = true;
		final ICharIterator LEFT = iterable.iterator();
		final ICharIterator RIGHT = iterable.reverseIterator();

		for (;
			isSearching && LEFT.isValid() && RIGHT.isValid()
				&& (LEFT.Index() <= RIGHT.Index());
			LEFT.Next(), RIGHT.Next()
		) {
			System.out.println(LEFT.Index() + "," + RIGHT.Index());
			System.out.println(LEFT.Current() + "," + RIGHT.Current());
			if (LEFT.Current() != RIGHT.Current()) {
				isSearching = false;
			}
		}

		return isSearching;
	}
}
