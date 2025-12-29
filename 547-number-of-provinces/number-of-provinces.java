class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                dfs(i, isConnected, visited);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int city, int[][] isConnected, Set<Integer> visited) {
        visited.add(city);
        for(int i = 0; i < isConnected[city].length; i++) {
            int connected = isConnected[city][i];
            if (connected == 1 && !visited.contains(i)) {
                dfs(i, isConnected, visited);
            }
        }
    }
}