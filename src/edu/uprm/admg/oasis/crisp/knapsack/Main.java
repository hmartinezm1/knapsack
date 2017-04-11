package edu.uprm.admg.oasis.crisp.knapsack;

public class Main {

    public static void main(String[] args) {
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = values.length;
        System.out.println("Dinamic Programming - 0/1 Knapsack");
        System.out.println("Maximum value in Knapsack = "+Knapsack.knapSack(W, weights, values, n));

        //int W = 50;
        Knapsack test = new Knapsack();
        Knapsack arr[] = {new Knapsack(20, 100), new Knapsack(30, 120), new Knapsack(10, 60)};
        int N  = arr.length;
        System.out.println("\n\nGreedy Approach - Fractional Knapsack");
        System.out.println("Maximun value in Knapsack = "+test.fractionalKnapsack(W, arr, N));
    }
}
