class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=101;
        for(int num:prices){
            min=Math.min(min, num);
            max=Math.max(max, num-min);
        }
        return max;
    }
}
