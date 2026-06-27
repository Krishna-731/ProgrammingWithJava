class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Long> map = new HashMap<>();

        for(int num : nums) {
            map.put((long)num, map.getOrDefault((long)num, 0L) + 1);
        }

        long maxLength = 0;

        for(Map.Entry<Long, Long> m : map.entrySet()) {
            long current = m.getKey();

            if (current == 1) {
                maxLength = Math.max(maxLength, 
                map.get(1L)%2 == 0 ? map.get(1L)-1 : map.get(1L));
                continue;
            }

            long currentLength = 0;
            while (map.containsKey(current) && map.get(current) >= 2) {
                currentLength += 2;
                current *= current;
            }

            if (map.containsKey(current) && map.get(current) == 1) {
                currentLength++;
            }
            else {
                currentLength--;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return (int) maxLength;
    }
}