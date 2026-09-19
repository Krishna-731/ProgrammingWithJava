class Solution {


    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        int x = 0;
        int y = 0;
        if (yc < y1) {
            y = y1;
        }
        else if (yc >= y1 && yc <= y2) {
            y = yc;
        }
        else {
            y = y2;
        }
        if (xc < x1) {
            x = x1;
        }
        else if (xc >= x1 && xc <= x2) {
            x = xc;
        }
        else {
            x = x2;
        }

        return (xc - x) * (xc - x) + (yc - y) * (yc - y) <= r * r;
    }
}