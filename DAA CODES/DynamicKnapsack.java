import java.util.Scanner;

public class DynamicKnapsack {

    // Method to solve 0/1 Knapsack using DP
    static int knapsack(int W, int[] value, int[] weight, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;  // Base case
                } else if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        value[i - 1] + dp[i - 1][w - weight[i - 1]],  // take item
                        dp[i - 1][w]                                   // don't take
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];  // can't take item
                }
            }
        }

        return dp[n][W];  // Maximum value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int maxValue = knapsack(W, value, weight, n);
        System.out.println("Maximum value in 0/1 Knapsack = " + maxValue);
    }
}
