public class MinDistance {
//find minimum distance between two points for the given array of points
  
      private static int[][] coordinates = new int[][]{
            {1, 2, 4},
            {2, 5, 6},
            {21, 15, 66},
            {3, 4, 6},
            {3, 0, 0},
            {0, 0, 0}
    };

    private static double distance(int[] x, int[] y) {
        return Math.sqrt(Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2) + Math
                .pow(x[2] - y[2], 2));
    }
    // your code here
    
    }
