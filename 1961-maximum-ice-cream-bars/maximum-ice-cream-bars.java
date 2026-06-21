class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        int n = costs.length;
        for(int cost : costs) {
            if (cost > coins) {
                break;
            }
            coins -= cost;
            result++;
        }
        return result;
    }
}