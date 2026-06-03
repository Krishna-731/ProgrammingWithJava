class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land = Integer.MAX_VALUE;
        int water = Integer.MAX_VALUE;
        int minLand = Integer.MAX_VALUE;
        int minWater = Integer.MAX_VALUE;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i = 0; i < n; i++) {
            land = Math.min(land, landStartTime[i] + landDuration[i]);
        }

        for(int i = 0; i < m; i++) {
            water = Math.min(water, waterStartTime[i] + waterDuration[i]);
            minLand = Math.min(minLand, Math.max(waterStartTime[i], land) + waterDuration[i]);
        }

        for(int i = 0; i < n; i++) {
            minWater = Math.min(minWater, Math.max(landStartTime[i], water) + landDuration[i]);
        }
        
        return Math.min(minLand, minWater);
    }
}