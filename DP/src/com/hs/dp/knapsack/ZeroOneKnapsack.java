package com.hs.dp.knapsack;

import java.util.Arrays;

public class ZeroOneKnapsack {
	public int knapsack(int[] wt, int[] val, int W) {
		int n = wt.length;
		int[][] dp = new int[n][W + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solveMemo(n - 1, wt, val, W, dp);
	}

	private int solveMemo(int n, int[] wt, int[] val, int W, int[][] dp) {
		if (n < 0 || W <= 0) {
			return 0;
		}

		if (dp[n][W] != -1)
			return dp[n][W];

		int notTaken = solveMemo(n - 1, wt, val, W, dp);

		int taken = Integer.MIN_VALUE;
		if (W >= wt[n]) {
			taken = val[n] + solveMemo(n - 1, wt, val, W - wt[n], dp);
		}

		dp[n][W] = Math.max(notTaken, taken);
		return dp[n][W];
	}

	public static void main(String[] args) {
		ZeroOneKnapsack obj = new ZeroOneKnapsack();
		int[] wt = { 1, 2, 4, 5 };
		int[] val = { 5, 4, 8, 6 };
		int W = 5;

		int result = obj.knapsack(wt, val, W);
		System.out.println(result);
	}
}