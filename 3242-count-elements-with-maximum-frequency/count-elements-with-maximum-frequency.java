class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int total = 0;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num , 0) + 1);
            int freq = map.get(num);

            if (freq > max) {
                max = freq;
                total = freq;
            }

            else if (freq == max) {
                total += freq;
            }
        }
        return total;
    }
}