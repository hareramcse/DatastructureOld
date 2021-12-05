package com.hs.array.arrangement;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumWithNegativeNumber {

	private void subArraySum(int[] arr, int value) {
		int n = arr.length;
		// cur_sum to keep track of cumulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0, so stop
			if (cur_sum - value == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum - so stop
			if (hashMap.containsKey(cur_sum - value)) {
				start = hashMap.get(cur_sum - value) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			hashMap.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		} else {
			System.out.println("Sum found between indexes " + start + " to " + end);
		}

	}

	public static void main(String[] args) {
		SubArraySumWithNegativeNumber array = new SubArraySumWithNegativeNumber();
		int[] arr = { 10, 2, -2, -20, 10 };
		int sum = 0;
		array.subArraySum(arr, sum);
	}
}
