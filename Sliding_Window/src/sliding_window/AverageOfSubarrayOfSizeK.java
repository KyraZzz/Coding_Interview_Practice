package sliding_window;

/*
Given an array, find the **average** of 
all contiguous subarrays of size 'K' in it.
*/

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
	public static double[] findAverageBrute(int[] arr, int K) {
		double[] res = new double[arr.length-K+1];
		for (int i=0;i<=arr.length-K;i++) {
			double total = 0;
			for (int j=i;j<i+K;j++) {
				total += arr[j];
			}
			res[i] = total/K;
		}
		return res;
	}
	
	public static double[] findAverageSliding(int[] arr, int K) {
		double[] res = new double[arr.length-K+1];
		double total = 0;
		int start = 0;
		for (int end=0;end<arr.length;end++) {
			total += arr[end];
			if (end>=K-1) {
				res[start] = total/K;
				total -= arr[start];
				start++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("Using a brute force:");
		double[] output = findAverageBrute(new int[] {1,3,2,6,-1,4,1,8,2},5);
		System.out.println("Averages of subarrays of size K:" + Arrays.toString(output));
		System.out.println("Using a sliding window:");
		output = findAverageSliding(new int[] {1,3,2,6,-1,4,1,8,2},5);
		System.out.println("Averages of subarrays of size K:" + Arrays.toString(output));

	}
}
