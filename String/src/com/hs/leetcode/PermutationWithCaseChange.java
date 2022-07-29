package com.hs.leetcode;

public class PermutationWithCaseChange {
	private void permuationWithCaseChange(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;

		op1 = op1 + ip.charAt(0);
		op2 = op2 + Character.toUpperCase(ip.charAt(0));
		ip = ip.substring(1);
		permuationWithCaseChange(ip, op1);
		permuationWithCaseChange(ip, op2);
	}

	public static void main(String[] args) {
		String ip = "abc";
		String op = "";
		PermutationWithCaseChange pas = new PermutationWithCaseChange();
		pas.permuationWithCaseChange(ip, op);
	}
}