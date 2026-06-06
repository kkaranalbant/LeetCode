package ispalindrome;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsPalindromeTest {

    private boolean invokeIsPalindrome(int x) throws Exception {
        Method method = IsPalindrome.class.getDeclaredMethod("isPalindrome", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, x);
    }

    @Test
    public void testExample1() throws Exception {
        assertEquals(true, invokeIsPalindrome(121));
    }

    @Test
    public void testExample2() throws Exception {
        assertEquals(false, invokeIsPalindrome(-121));
    }

    @Test
    public void testExample3() throws Exception {
        assertEquals(false, invokeIsPalindrome(10));
    }

    @Test
    public void testSingleDigit() throws Exception {
        assertEquals(true, invokeIsPalindrome(5));
    }
}
