class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int total = n1 + n2;
        int half = total / 2;
        boolean isOdd = total % 2 == 1;

        int left = -1, right = n1 - 1;
        while (true) {
            int mid1 = (left + right) / 2;
            int mid2 = half - mid1 - 2;

            int topLeftMax = mid1 >= 0 ? nums1[mid1] : Integer.MIN_VALUE;
            int topRightMin = mid1 + 1 < n1 ? nums1[mid1 + 1] : Integer.MAX_VALUE;

            int bottomLeftMax = mid2 >= 0 ? nums2[mid2] : Integer.MIN_VALUE;
            int bottomRightMin = mid2 + 1 < n2 ? nums2[mid2 + 1] : Integer.MAX_VALUE;

            if (topLeftMax <= bottomRightMin && bottomLeftMax <= topRightMin) {
                if (isOdd)
                    return (double)Math.min(topRightMin, bottomRightMin);
                return (double) (Math.min(topRightMin, bottomRightMin)
                           + Math.max(topLeftMax, bottomLeftMax))
                    / 2;
            } else if (topLeftMax > bottomRightMin) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }
    }
}
