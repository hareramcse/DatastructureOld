package com.hs.dp.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
	// Time Complexity O(n)
	// Space Complexity O(n)
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solveMemo(prices, 0, 0, fee, dp);
	}

	private int solveMemo(int[] prices, int i, int buy, int fee, int[][] dp) {
		if (i == prices.length)
			return 0;

		if (dp[i][buy] != -1)
			return dp[i][buy];

		if (buy == 0) {
			int buyStock = -prices[i] + solveMemo(prices, i + 1, 1, fee, dp);
			int notBuyStock = solveMemo(prices, i + 1, 0, fee, dp);
			dp[i][buy] = Math.max(buyStock, notBuyStock);
		} else {
			int sale = prices[i] - fee + solveMemo(prices, i + 1, 0, fee, dp);
			int notSale = solveMemo(prices, i + 1, 1, fee, dp);
			dp[i][buy] = Math.max(sale, notSale);
		}
		return dp[i][buy];
	}

	private int solveTab(int[] prices, int fee) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		// base condition
		dp[n][0] = dp[n][1] = 0;

		int profit = 0;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				if (j == 0) {// We can buy the stock
					int buy = -prices[i] + dp[i + 1][1];
					int notBuy = dp[i + 1][0];
					profit = Math.max(buy, notBuy);
				}

				if (j == 1) {// We can sell the stock
					int sale = prices[i] - fee + dp[i + 1][0];
					int notSale = dp[i + 1][1];
					profit = Math.max(sale, notSale);
				}

				dp[i][j] = profit;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int result = obj.maxProfit(prices, 2);
		System.out.println(result);
		result = obj.solveTab(prices, 2);
		System.out.println(result);
	}
}
