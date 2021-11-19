package com.company;

public class NC88_FindKth {
    public int findKth(int[] a, int n, int K) {
        return findKth(a, K - 1, 0, a.length - 1);
    }

    public int findKth(int[] a, int K, int left, int right) {
        int mid = partion(a, left, right);
        while (mid != K) {
            if (mid > K) {
                right = mid - 1;
                mid = partion(a, left, right);
            } else {
                left = mid + 1;
                mid = partion(a, left, right);
            }
        }
        return a[mid];
    }

    public int partion(int[] a, int left, int right) {
        int pivot = a[right];
        while (left < right) {
            while (left < right && a[left] >= pivot) {
                left++;
            }
            a[right] = a[left];
            while ((left < right && a[right] <= pivot)) {
                right--;
            }
            a[left] = a[right];
        }
        a[right] = pivot;
        return right;
    }
}
