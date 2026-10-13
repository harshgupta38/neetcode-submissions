class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int N=n*n;
        boolean[] seen=new boolean[N+1];
        int seenNum=0;
        for(int[] row:grid) for(int num:row) if(seen[num]) seenNum=num; else seen[num]=true;
        for(int i=1;i<=N;i++)
        if(seen[i]==false)
        return new int[]{seenNum, i};
        return null;
    }
}