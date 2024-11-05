class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.add(new int[] {i,j,0});
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            minutes = curr[2];

            for(int[] dir:direction){
                int newrow = row+dir[0];
                int newcol = col+dir[1];
                if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && grid[newrow][newcol]==1){
                    grid[newrow][newcol]=2;
                    freshOranges--;
                    queue.add(new int[] {newrow,newcol,minutes+1});
                }
            }
        }
            return freshOranges==0 ? minutes:-1;
    }
}