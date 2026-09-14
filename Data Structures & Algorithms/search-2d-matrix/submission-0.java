class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        int left=0, right=rows*cols-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            int r=mid/cols;
            int c=mid%cols;

            if(target==matrix[r][c])
                return true;
            if(target>matrix[r][c])
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}
