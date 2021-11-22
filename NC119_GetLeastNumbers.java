public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || k <= 0) {
            return new ArrayList<>();
        }
        int resIndex = findKSmall(input, k - 1, 0, input.length - 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= resIndex; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public int findKSmall(int[] arr, int k, int left, int right) {
        int mid = partition(arr, left, right);
        while (mid != k) {
            System.out.println("---" + mid + "," + k);
            if (mid > k) {
                right = mid - 1;
                mid = partition(arr, left, right);
            } else {
                left = mid + 1;
                mid = partition(arr, left, right);
            }
        }

        return mid;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        //[0,1,2,1,2],3
        //[4,5,1,6,2,7,3,8],4
        //[4,5,1,6,2,7,3,8],0
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        ArrayList<Integer> res = getLeastNumbers.GetLeastNumbers_Solution(input, 0);
        System.out.println(Arrays.toString(input));
        System.out.println(res);
    }
