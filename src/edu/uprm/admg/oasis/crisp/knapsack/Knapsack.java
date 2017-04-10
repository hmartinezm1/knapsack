package edu.uprm.admg.oasis.crisp.knapsack;

/**
 * Created by howardmartinez
 * Author: Howard A. Martinez Meza
 * Email: howard.martinez@upr.edu
 * Project: Oasis - Crisp
 * Date: 08/04/17
 * Description:
 */
public class Knapsack {

    static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int weights[], int values[], int n) {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (weights[i-1] <= w)
                    K[i][w] = max(values[i-1] + K[i-1][w-weights[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
        return K[n][W];
    }
}
