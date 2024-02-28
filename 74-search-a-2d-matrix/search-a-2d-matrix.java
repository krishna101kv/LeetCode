class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }
        
        // return false;
        int low=0,high=matrix.length*matrix[0].length-1;
        int m=matrix[0].length;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}