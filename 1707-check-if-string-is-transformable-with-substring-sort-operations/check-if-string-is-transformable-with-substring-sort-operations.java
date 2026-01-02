class Solution {
    public boolean isTransformable(String s, String t) {
        List<Queue<Integer>> pos = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            pos.add(new LinkedList<>());
        }

        for(int i = 0; i < s.length(); i++) {
            pos.get(s.charAt(i)- '0').add(i);
        }

        for(char c : t.toCharArray()) {
            int d = c-'0';

            if (pos.get(d).isEmpty()) {
                return false;
            }

            int index = pos.get(d).poll();

            for(int x = 0; x < d; x++) {
                if (!pos.get(x).isEmpty() && pos.get(x).peek() < index) {
                    return false;
                }
            }
        }

        return true;
    }
}