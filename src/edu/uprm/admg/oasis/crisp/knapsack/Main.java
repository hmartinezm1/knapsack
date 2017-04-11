package edu.uprm.admg.oasis.crisp.knapsack;

public class Main {

    public static void main(String[] args) {
        // Implementation with Dinamic Programming
        //int values[] = new int[]{60, 100, 120};
        //int weights[] = new int[]{10, 20, 30};
        //int  W = 50;
        //int n = values.length;
        //System.out.println("The max value you can get is: "+Knapsack.knapSack(W, weights, values, n));

        // Implementation with Greedy
        int W = 50;
        Knapsack test = new Knapsack();
        Knapsack arr[] = {new Knapsack(20, 100), new Knapsack(30, 120), new Knapsack(10, 60)};
        int n = arr.length;
        System.out.println("The max value you can get is: "+test.fractionalKnapsack(W, arr, n));
    }
}
