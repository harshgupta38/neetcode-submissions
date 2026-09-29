class Solution {
    public void merge(int[] nums1, int len1, int[] nums2, int len2) {
        int k = nums1.length - 1;
        int i = len1 - 1;
        int j = len2 - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (i >= 0) 
            nums1[k--] = nums1[i--];
        while (j >= 0) 
            nums1[k--] = nums2[j--];
    }
}