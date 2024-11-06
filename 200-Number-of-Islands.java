class Solution {
    public static void bfs(int row, int col , char[][] grid,int rows,int cols){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row,col});
        grid[row][col]='0';

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currrow = curr[0];
            int currcol = curr[1];

            for(int[] dir:directions){
                int newrow = currrow + dir[0];
                int newcol = currcol + dir[1];
                if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && grid[newrow][newcol]=='1'){
                    grid[newrow][newcol]='0';
                    queue.add(new int[] {newrow,newcol});
                }
            }
           
        }

    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(i,j,grid,rows,cols);
                }
            }
        }
        return islands;
    }
}