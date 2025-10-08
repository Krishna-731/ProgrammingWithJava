class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int n = spells.length;

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            long s = spells[i];
            int idx = -1;
            int left = 0;
            int right = m-1;

            while (left <= right) {
                int mid = left + (right-left)/2;

                if (s * potions[mid] >= success) {
                    right = mid-1;
                    idx = mid;
                }
                else {
                    left = mid + 1;
                }
            }

            result[i] = (idx == -1) ? 0 : m - idx;
        }

        return result;
    }
}