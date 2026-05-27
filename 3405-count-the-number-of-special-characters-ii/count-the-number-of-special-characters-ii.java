class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                int idx = c - 'a';
                arr1[idx] = i;
            }
            else {
                int idx = c - 'A';
                if (arr2[idx] == -1) {
                    arr2[idx] = i;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if (arr1[i] != -1 && arr2[i] != -1 && arr1[i] < arr2[i]) {
                ans++;
            }
        }

        return ans;

    }
}