class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        int n=piles.length;
        for(int pile:piles) max=Math.max(max, pile);
        if(n==h) return max;

        int left=1, right=max;
        while(left<right){
            int mid=left+(right-left)/2;

            int needH=0;
            for(int pile:piles)
            needH+=(pile+mid-1)/mid;

            if(needH>h)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}
