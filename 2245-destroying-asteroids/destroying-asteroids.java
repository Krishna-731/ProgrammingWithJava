class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long currMass = mass;
        boolean canDestroy = true;
        for(int i = 0; i < n; i++) {
            if (currMass >= asteroids[i]) {
                currMass += asteroids[i];
            }
            else {
                canDestroy = false;
                break;
            }
        }
        return canDestroy;
    }
}