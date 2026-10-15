class Solution {
    public int arraySign(int[] nums) {
        boolean negative=false;
        for(int num:nums){
            if(num==0)
                return 0;
            if(num<0)
                negative=!negative;
        }
        if(negative) return -1;
        return 1;
    }
}