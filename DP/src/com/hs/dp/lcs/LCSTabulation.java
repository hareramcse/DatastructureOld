package com.hs.dp.lcs;

// 1143. Longest Common Subsequence Leetcode
public class LCSTabulation {

	private int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		LCSTabulation lcsrm = new LCSTabulation();
		String x = "abcdgh";
		String y = "abedfhr";

		int count = lcsrm.longestCommonSubsequence(x, y);
		System.out.println(count);
	}
}