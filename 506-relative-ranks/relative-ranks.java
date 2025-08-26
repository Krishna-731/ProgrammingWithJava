class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>((p1,p2) -> (p2.getValue() - p1.getValue()));
        for(int i = 0; i < score.length; i++) {
            queue.add(new Pair(i, score[i]));
        }
        int place = 1;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> top = queue.poll();
            int ind = top.getKey();
            if (place == 1) {
                result[ind] = "Gold Medal";
            }
            else if (place == 2) {
                result[ind] = "Silver Medal";
            }
            else if (place == 3) {
                result[ind] = "Bronze Medal";
            }
            else {
                result[ind] = String.valueOf(place);
            }
            place++;
        }

        return result;
    }
}