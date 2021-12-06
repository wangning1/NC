public class BinarySearchRepFirstNum {
    public int search (int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                if(mid == 0 || nums[mid - 1] != target){
                    return mid;
                }else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,4,5};
        BinarySearchRepFirstNum binarySearchRepFirstNum = new BinarySearchRepFirstNum();
        int res = binarySearchRepFirstNum.search(nums, 4);
        System.out.println(res);
    }
}
