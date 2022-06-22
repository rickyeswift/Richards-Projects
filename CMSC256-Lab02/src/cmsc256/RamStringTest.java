/*
 * RamStringTest.java
 * Lab 02: Implementation of WackyStringInterface
 * CMSC 256-Summer2022
 * 06/01/2022
 * Richard Elliott Jr
 */
package cmsc256;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RamStringTest {
    WackyStringInterface normalString;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        normalString = new RamString("Computer Science @ VCU Summer 2022");
    }

    // test if the constructor properly sets the value of the string
    @Test
    public void testRamStringParameterizedConstructor1() {
        assertTrue("Computer Science @ VCU Summer 2022".equals(normalString.getWackyString()));
    }

    // test if the constructor correctly throws the exception for a null string
    @Test (expected = IllegalArgumentException.class)
    public void testRamStringParameterizedConstructor2() {
        RamString tryNull = new RamString(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWackyString() {
        RamString tryNull = new RamString();
        tryNull.setWackyString(null);
        assertEquals("Let's Go Rams and CS@VCU!", tryNull.getWackyString());
    }

    /** Returns a string that consists of all and only the characters
     * in every third positions (i.e., third, sixth, and so on) in
     * the current string, in the same order and with the same case as
     * in the current string. The first character in the string is
     * considered to be in Position 1.
     *	 * @return String made of characters in every third positions in
     * the current string
     */
    @Test
    public void testGetEveryThirdCharacter1() {
        String everyThird = normalString.getEveryThirdCharacter();
        assertTrue("mt ic@CSm 2".equals(everyThird));
    }

    @Test
    public void testGetEveryThirdCharacter2() {
        RamString testString = new RamString("Green Tea");
        assertTrue("e a".equals(testString.getEveryThirdCharacter()));
    }

    @Test
    public void testGetEveryThirdCharacter3() {
        RamString testString = new RamString("To the moon!");
        assertTrue(" eo!".equals(testString.getEveryThirdCharacter()));
    }

    @Test
    public void testGetEveryThirdCharacter4() {
        RamString testString = new RamString("Stranger Things");
        assertTrue("rg is".equals(testString.getEveryThirdCharacter()));
    }

    /** Returns a string that consists of all and only the characters
     * in either the odd positions (i.e., first, third, and so on)
     * or in the even positions (i.e., second, fourth, and so on)
     * current string, in the same order and with the same case as in
     * the current string. The first character in the string is
     * considered to be in Position 1.
     * @return 		String of characters in odd positions in the
     * 				current string
     * @throws  IllegalArgumentException for parameter other than
     *						"odd" or "even"
     */

    @Test (expected = IllegalArgumentException.class)
    public void testGetEvenOrOddCharacters1() {
        normalString.getEvenOrOddCharacters("test");
    }

    @Test
    public  void testGetEvenOrOddCharacters2() {
        assertTrue("optrSine@VUSme 02".equals(normalString.getEvenOrOddCharacters("even")));
    }

    @Test
    public  void testGetEvenOrOddCharacters3() {
        assertTrue("Cmue cec  C umr22".equals(normalString.getEvenOrOddCharacters("odd")));
    }

    @Test
    public  void testGetEvenOrOddCharacters4() {
        RamString testString = new RamString("Rams");
        assertTrue("Rm".equals(testString.getEvenOrOddCharacters("odd")));
    }

    @Test
    public  void testGetEvenOrOddCharacters5() {
        RamString testString = new RamString("Javascript");
        assertTrue("aacit".equals(testString.getEvenOrOddCharacters("even")));
    }

    /**Returns the number of characters that are digits in the string
     *  if two (and no more than two) digits appear side by side.
     * @return Number of double-digits in the current string
     */

    // test the countDoubleDigits with a string containing 0 double digits
    @Test
    public void testCountDoubleDigits1() {
        assertEquals(1, normalString.countDoubleDigits());
    }

    // test the countDoubleDigits with a string containing 1 double digit pair
    @Test
    public void testCountDoubleDigits2() {
        RamString temp = new RamString("Summer time is s00 h0t in Richmond");
        assertEquals(1, temp.countDoubleDigits());
    }

    @Test
    public void testCountDoubleDigits3() {
        RamString temp = new RamString("11266777998");
        assertEquals(2, temp.countDoubleDigits());
    }

    @Test
    public void testCountDoubleDigits4() {
        RamString temp = new RamString("22");
        assertEquals(1, temp.countDoubleDigits());
    }

    @Test
    public void testCountDoubleDigits5() {
        RamString temp = new RamString("Programming is c00l");
        assertEquals(1, temp.countDoubleDigits());
    }

    /** Returns true if the current string contains on or more characters
     *  before an '@' character, followed by either "vcu.edu"
     *	or "mymail.vcu.edu"
     *   For example, RodneyTheRam@vcu.edu a valid vcu email address
     *   and RamFan@gmail.com is not.
     * @return true if string is formatted as valid VCU email address
     * 	        Returns false otherwise.
     */

    @Test
    public void testIsValidVCUEmail1() {
        RamString temp = new RamString("joe@vcu.edu");
        assertTrue(temp.isValidVCUEmail());
    }

    @Test
    public void testIsValidVCUEmail2() {
        RamString temp = new RamString("@vcu.edu");
        assertFalse(temp.isValidVCUEmail());
    }

    @Test
    public void testIsValidVCUEmail3() {
        RamString temp = new RamString("tommy@gmail.com");
        assertFalse(temp.isValidVCUEmail());
    }

    @Test
    public void testIsValidVCUEmail4() {
        RamString temp = new RamString("nixon@mymail.vcu.edu");
        assertTrue(temp.isValidVCUEmail());
    }

    @Test
    public void testIsValidVCUEmail5() {
        RamString temp = new RamString("toocool@vcu.edu");
        assertTrue(temp.isValidVCUEmail());
    }

    /**
     * Extracts a phone number (with area code) from this String and returns it
     * in a standard format with the area code in parenthesis followed by a
     * then a dash separating the third and fourth digits "(000) 000-0000"
     * space if this string does not contain exactly 10 digits, returns the
     * message "This WackyString is not a phone number."
     * Note: any characters that are not digits should not be included
     *   in the returned string.
     *   For example: "Office phone: 804-828-7135" --> "(804) 828-7135"
     *
     =	 * @return			String containing the formatted phone number
     */

    @Test
    public void testStandardizedPhoneNumber1() {
        RamString temp = new RamString("7572553456");
        assertEquals("(757) 255-3456", temp.standardizePhoneNumber());
    }

    @Test
    public void testStandardizedPhoneNumber2() {
        RamString temp = new RamString("This student's phone number is: 8042334567");
        assertEquals("(804) 233-4567", temp.standardizePhoneNumber());
    }

    @Test
    public void testStandardizedPhoneNumber3() {
        RamString temp = new RamString("Not a phone number");
        assertEquals("This WackyString is not a phone number.", temp.standardizePhoneNumber());
    }

    /** Replace all occurrence of a single zero (0) with the string
     * "Go Rams" in the current string,
     * and all occurrence of a double zero (00) with the string "CS@VCU"
     */

    @Test
    public void testRamifyString1() {
        RamString temp = new RamString("0 00");
        temp.ramifyString();
        assertEquals("Go Rams CS@VCU", temp.getWackyString());
    }

    @Test
    public void testRamifyString2() {
        RamString temp = new RamString("We all cheer, 0!");
        temp.ramifyString();
        assertEquals("We all cheer, Go Rams!", temp.getWackyString());
    }

    @Test
    public void testRamifyString3() {
        RamString temp = new RamString("000");
        temp.ramifyString();
        assertEquals("000", temp.getWackyString());
    }

    @Test
    public void testRamifyString4() {
        RamString temp = new RamString("test");
        temp.ramifyString();
        assertEquals("test", temp.getWackyString());
    }

    @Test
    public void testRamifyString5() {
        RamString temp = new RamString("0");
        temp.ramifyString();
        assertEquals("Go Rams", temp.getWackyString());
    }


    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToRomanNumeralsInSubstring1() {
        RamString temp = new RamString("5");
        temp.convertDigitsToRomanNumeralsInSubstring(1,5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToRomanNumeralsInSubstring2() {
        RamString temp = new RamString("Test String");
        temp.convertDigitsToRomanNumeralsInSubstring(4,1);
    }

    @Test
    public void testConvertDigitsToRomanNumeralsInSubstring3() {
        RamString temp = new RamString("5401");
        temp.convertDigitsToRomanNumeralsInSubstring(1,4);
        assertEquals("VIV0I", temp.getWackyString());
    }

    @Test
    public void testConvertDigitsToRomanNumeralsInSubstring4() {
        RamString temp = new RamString("12345");
        temp.convertDigitsToRomanNumeralsInSubstring(3,5);
        assertEquals("12IIIIVV", temp.getWackyString());
    }

    @Test
    public void testConvertDigitsToRomanNumeralsInSubstring5() {
        RamString temp = new RamString("12345678");
        temp.convertDigitsToRomanNumeralsInSubstring(4,7);
        assertEquals("123IVVVIVII8", temp.getWackyString());
    }
}

