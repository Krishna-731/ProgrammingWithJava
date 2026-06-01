class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int totalCost = 0;
        int candyPurchased = 0;
        int currCost = 0;
        for(int i = n-1; i >= 0; i--) {
            if (candyPurchased >= 2 && currCost >= cost[i]) {
                candyPurchased = 0;
                totalCost += currCost;
                currCost = 0;
                System.out.println("Total" + totalCost);
                continue;
            }
            currCost += cost[i];
            System.out.println("Current" + currCost);
            candyPurchased++;
            System.out.println("Candy" + candyPurchased);
        }
        if (currCost > 0) {
            totalCost += currCost;
        }

        return totalCost;
    }
}