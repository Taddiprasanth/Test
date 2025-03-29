
public class Knapsack_problem {
	public static int knapsack(int weightLimit, int[] weights, int[] values, int n) {
		int[][] dp = new int[n + 1][weightLimit + 1];
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= weightLimit; w++) {
				if (weights[i - 1] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		return dp[n][weightLimit];
	}

	public static void main(String[] args) {
		int[] values = { 3,4,5,6 };
		int[] weights = { 2,3,4,5 };
		int weightLimit =5;
		int n = values.length;
		int maxValue = knapsack(weightLimit, weights, values, n);
		System.out.println("Maximum value that can be taken in the knapsack: " + maxValue);
	}
}
