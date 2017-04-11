package edu.uprm.admg.oasis.crisp.knapsack;

import java.util.Arrays;

/**
 * Created by howardmartinez
 * Author: Howard A. Martinez Meza
 * Email: howard.martinez@upr.edu
 * Project: Oasis - Crisp
 * Date: 08/04/17
 * Description:
 */
public class Knapsack implements Comparable<Knapsack>{

    private int weight;
    private int value;
    private double density;

    public Knapsack(){
        weight = 0;
        value = 0;
        density = 0;
    }

    public Knapsack(int weight, int value){
        if (weight == 0){
            this.weight = 0;
            this.density = 0;
        }else{
            this.weight = weight;
            this.value = value;
            this.density = (double)value/weight;
        }
    }

    // Greedy function to solve problem
    public double fractionalKnapsack(int W, Knapsack arr[], int n) {
        //    sorting Item on basis of ration
        Arrays.sort(arr);

    for (int i = 0; i < n; i++) {
        if (i == 0)
            System.out.println("V\t\tW\t\tr");
        System.out.println(arr[i].value+"\t\t"+arr[i].weight+"\t\t"+((double)arr[i].value / arr[i].weight));
    }

        int curWeight = 0;  // Current weight in knapsack
        double finalvalue = 0.0; // Result (value in Knapsack)

        // Looping through all Items
        for (int i = 0; i < n; i++) {
            // If adding Item won't overflow, add it completely
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
            // If we can't add current Item, add fractional part of it
            else {
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double) remain / arr[i].weight);
                break;
            }
        }

        // Returning final value
        return finalvalue;
    }


    // Dinamic Programming
    public static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W --- DINAMIC PROGRAMMING
    public static int knapSack(int W, int weights[], int values[], int n) {
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


    @Override
    public int compareTo(Knapsack o) {
        if(o.density - this.density == 0)
            return 0;
        else if(o.density - this.density > 0)
            return 1;
        else
            return -1;
    }
}
