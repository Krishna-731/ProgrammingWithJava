class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put( num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( (a,b) -> (b.getValue()- a.getValue()) );
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        int index = 0;
        int[] result = new int[k];
        while (index < k) {
            Map.Entry<Integer, Integer> m = queue.poll();
            result[index++] = m.getKey();
        }

        return result;
    }
}

