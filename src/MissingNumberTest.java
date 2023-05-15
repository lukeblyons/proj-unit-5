import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MissingNumberTest {
    @Test
    public void testFindMissingNumber_MissingNumber() {
        int[] nums = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        int max_num = 10;
        assertEquals(8, MissingNumber.findMissingNumber(nums, max_num));
    }

    @Test
    public void testFindMissingNumber_NoMissingNumber() {
        int[] nums = {2, 1, 4, 3, 6, 5, 7, 8, 10, 9};
        int max_num = 10;
        assertEquals(0, MissingNumber.findMissingNumber(nums, max_num));
    }
}
