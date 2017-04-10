package edu.uprm.admg.oasis.crisp.knapsack;

public class Main {

    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = values.length;
        System.out.println("The max value you can get is: "+k.knapSack(W, weights, values, n));
    }
}
