class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] visited_atl = new boolean[row][col];
        boolean[][] visited_pac = new boolean[row][col];

        Queue<int[]> queue_atl = new LinkedList<>();
        Queue<int[]> queue_pac = new LinkedList<>();

        for(int r = 0; r < row; r++) {
            queue_pac.add(new int[]{r, 0});
            queue_atl.add(new int[]{r, col-1});
            visited_pac[r][0] = true;
            visited_atl[r][col-1] = true;
        }

        for(int c = 0; c < col; c++) {
            queue_pac.add(new int[]{0, c});
            queue_atl.add(new int[]{row-1, c});
            visited_pac[0][c] = true;
            visited_atl[row-1][c] = true;
        }

        bfs(heights, visited_atl, queue_atl);
        bfs(heights, visited_pac, queue_pac);

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if (visited_pac[r][c] && visited_atl[r][c]) {
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;
    }

    public void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dir = {{0,1} , {0,-1}, {1,0}, {-1,0}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curr_row = curr[0];
            int curr_col = curr[1];

            for(int[] d : dir) {
                int next_row = curr_row + d[0];
                int next_col = curr_col + d[1];

                boolean c1 = next_row < 0 || next_row >= row || next_col < 0 || next_col >= col;
                boolean c2 = !c1 && visited[next_row][next_col];
                boolean c3 = !c1 && heights[next_row][next_col] < heights[curr_row][curr_col];

                if (c1 || c2 || c3) {
                    continue;
                }

                visited[next_row][next_col] = true;
                queue.add(new int[]{next_row, next_col});
            }
        }
    }
}