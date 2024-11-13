class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor==color){
            return image;
        }
        Queue<int[]> q=new LinkedList<>();
        int rows=image.length;
        int cols=image[0].length;

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        q.offer(new int[] {sr,sc});
        image[sr][sc]=color;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x=cur[0];
            int y=cur[1];

            for(int[] directions: dir){
                int newX = x+directions[0];
                int newY = y+directions[1];

                if(newX>=0 && newY >= 0 && newX<rows && newY<cols && image[newX][newY]==originalColor){
                    image[newX][newY]=color;
                    q.offer(new int[] {newX,newY});
                }

            }
        }
        return image;

    }
}