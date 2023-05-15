public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        int max_num = 10;
        int missingNumber = findMissingNumber(nums, max_num);
        System.out.println(missingNumber); // Output: 8
    }

    public static int findMissingNumber(int[] nums, int max_num) {
        int expectedSum = max_num * (max_num + 1) / 2; // sum of numbers from 1 to max_num
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }
}
