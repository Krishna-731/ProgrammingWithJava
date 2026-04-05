class Solution {
    public boolean judgeCircle(String moves) {
        int[] check = new int[128];
        for(char c : moves.toCharArray()) {
            check[c]++;
        }
        return check['R'] == check['L'] && check['U'] == check['D'];
    }
}