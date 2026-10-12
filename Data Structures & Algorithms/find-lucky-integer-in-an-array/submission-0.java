class Solution {
    public int findLucky(int[] nums) {
        int n=nums.length;
        int[] freq=new int[n+1];
        for(int num:nums) if(num<=n) ++freq[num];

        for(int i=n;i>=1;i--)
        if(freq[i]==i)
        return i;
        return -1;
    }
}