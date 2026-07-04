class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;  i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int w = r[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int[] edge : adj.get(node)) {
                int next = edge[0];
                int wt = edge[1];

                ans = Math.min(ans, wt);

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return ans;
    }
}