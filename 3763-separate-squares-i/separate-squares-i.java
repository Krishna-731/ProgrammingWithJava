class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Integer.MAX_VALUE;
        double high = 0;

        for(int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            totalArea += l*l;
            low = Math.min(low, y);
            high = Math.max(high, y+l);
        }

        double halfArea = totalArea / 2.0;
        for(int i = 0; i < 100; i++) {
            double mid = low + (high-low)/2;

            if (helper(squares, mid) >= halfArea) {
                high = mid;
            }
            else {
                low = mid;
            }
        }

        return high;
    }

    public double helper(int[][] squares, double mid) {
        double area = 0;
        for(int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;

            if (y >= mid) {
                continue;
            }

            else if (y+l <= mid) {
                area += l*l;
            }
            
            else {
                area += l*(mid-y);
            }

        }

        return area;
    }
}