package validpalindrome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPalindromeTest {

    @Test
    public void testExample1() {
        assertEquals(true, ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testExample2() {
        assertEquals(false, ValidPalindrome.isPalindrome("race a car"));
    }

    @Test
    public void testExample3() {
        assertEquals(true, ValidPalindrome.isPalindrome(" "));
    }
}
