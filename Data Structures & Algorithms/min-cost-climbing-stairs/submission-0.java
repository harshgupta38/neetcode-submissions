class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int i_2=0, i_1=0;
        for(int c:cost){
            int i=Math.min(i_2, i_1)+c;
            i_2=i_1;
            i_1=i;
        }
        return Math.min(i_2, i_1);
    }
}
