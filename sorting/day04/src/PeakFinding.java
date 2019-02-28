import java.util.Arrays;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
//    1D
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
//    2D
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
//    2D
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        // TODO
        // peakOneD Return -1 if left is higher, 1 if right is higher, 0 if peak
        int mid = nums.length/2;
        if (nums.length == 1) {
            return nums[0];
        }
        if (peakOneD(nums.length-1, nums) == 0) {
            return nums.length-1;
        }
        if (peakOneD(mid,nums) == 0) {
           return mid;
        } else if (peakOneD(mid,nums) < 0) {
            int[] halfnums = new int[nums.length/2];
            System.arraycopy(nums,0,halfnums,0,mid);
            return findOneDPeak(halfnums);
        } else {
            int[] halfnums = new int[nums.length/2];
            System.arraycopy(nums,mid,halfnums,0,nums.length-mid-1);
            return findOneDPeak(halfnums);
        }
//        return 0;
    }

    public static int[] findTwoDPeak(int[][] nums) {
        // TODO
//        for point nums[y][x] --> needs to be greater than:
//          nums[y-1][x], nums[y+1][x], nums[y][x-1] and nums[y[x+1]
        int[] answer = new int[2];
        int mid = nums.length/2;
        if (peakX(nums[0].length-1,nums.length-1,nums) == 0 && peakY(nums[0].length-1,nums.length-1,nums) == 0) {
            answer[0] = nums.length-1;
            answer[1] = nums[0].length-1;
            return answer;
        }
        if (mid == 0 || mid == nums.length-1) {
            answer[0] = mid;
            answer[1] = maxYIndex(mid,0,nums.length-1,nums);
            return answer;
        } else {
            answer[0] = mid;
            answer[1] = findOneDPeak(nums[mid]);
            System.out.println(Arrays.toString(answer));
            return answer;
        }
    }

    public static String print2D(int[][] nums) {
        for (int i=0; i<nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        return null;
    }

}
