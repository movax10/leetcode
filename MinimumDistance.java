package com.udacity.boogle.maps;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumDistance {

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

    private static double bruteForce(int[][] coordinates) {
        double minDistance = Double.POSITIVE_INFINITY;;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                double distance = distance(coordinates[i], coordinates[j]);
                minDistance = Math.min(minDistance, distance);
            }
        }
        System.out.println("minDistance" + minDistance);
        return minDistance;
    }


    private static double optimized(int[][] coordinates){
        Arrays.sort(coordinates, Comparator.comparingInt(a -> a[0]));
        return divideAndConquer(coordinates, coordinates.length);
    }

    private static double divideAndConquer(int[][] coordinates, int n){
        if (coordinates.length<=3){

            return bruteForce(coordinates);
        }
        int mid = n/2;
        int[] midPoint = coordinates[mid];
        double distanceLeft = divideAndConquer(Arrays.copyOfRange(coordinates, 0, mid), mid);
        double distanceRight = divideAndConquer(Arrays.copyOfRange(coordinates, mid + 1, coordinates.length), mid);
        double distance = Math.min(distanceLeft, distanceRight);



        return distance;
    }



    public static void main(String[] args) {
        System.out.println("bruteForce " + bruteForce(coordinates));
        System.out.println("optimized " + optimized(coordinates));
    }

}
