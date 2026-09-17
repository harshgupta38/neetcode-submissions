class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2)
            return findMedianSortedArrays(nums2, nums1);

        int total = l1 + l2;
        int half = total / 2;
        boolean isodd = total % 2 == 1;

        int left = -1, right = l1 - 1;
        while (true) {
            int mid1 = (left + right) / 2;
            int mid2 = half - mid1 - 2;

            int nums1LeftMax = mid1 >= 0 ? nums1[mid1] : Integer.MIN_VALUE;
            int nums1RightMin = mid1 + 1 < l1 ? nums1[mid1 + 1] : Integer.MAX_VALUE;
            int nums2LeftMax = mid2 >= 0 ? nums2[mid2] : Integer.MIN_VALUE;
            int nums2RightMin = mid2 + 1 < l2 ? nums2[mid2 + 1] : Integer.MAX_VALUE;

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                if (isodd)
                    return (double) Math.min(nums1RightMin, nums2RightMin);
                return (double) (Math.min(nums1RightMin, nums2RightMin) + Math.max(nums1LeftMax, nums2LeftMax)) / 2;
            } else if (nums1LeftMax > nums2RightMin) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }
    }
}

/*
1 2 3 4
  ^

1 2 3 4 5 6 7 8
      ^

total = 12
half = 6

left = 0
right = 3

mid1 = 3/2 = 1
mid2 = 8/2-1 = 3
*/
