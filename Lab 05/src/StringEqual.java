
public class StringEqual {
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "abcdefg";
		String str3 = "efg";
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		if (str2 == str3) {
			System.out.println("The Strings str2 and str3 are the same.");
		}
		else if (str2.endsWith("g") && str3.endsWith("g")) {
		System.out.println("The Strings are equal");
		}
		else {
			System.out.println("The Strings str2 & str3 are not the same.");
		}
	}

}
