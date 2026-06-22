class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Integer b = map.getOrDefault('b', 0);
        Integer a = map.getOrDefault('a', 0);
        Integer l = map.getOrDefault('l', 0)/2;
        Integer o = map.getOrDefault('o', 0)/2;
        Integer n = map.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}