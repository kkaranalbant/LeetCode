package missingnumber;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTest {

    private int invokeFindMissing(int[] nums) throws Exception {
        Method method = MissingNumber.class.getDeclaredMethod("findMissing", int[].class);
        method.setAccessible(true);
        return (int) method.invoke(null, nums);
    }

    @Test
    public void testExample1() throws Exception {
        int[] nums = {3, 0, 1};
        assertEquals(2, invokeFindMissing(nums));
    }

    @Test
    public void testExample2() throws Exception {
        int[] nums = {0, 1};
        assertEquals(2, invokeFindMissing(nums));
    }

    @Test
    public void testExample3() throws Exception {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, invokeFindMissing(nums));
    }

    @Test
    public void testMissingFirst() throws Exception {
        int[] nums = {1, 2, 3};
        assertEquals(0, invokeFindMissing(nums));
    }
}
