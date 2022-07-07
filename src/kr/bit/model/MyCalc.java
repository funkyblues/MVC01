package kr.bit.model;

public class MyCalc {
	public int hap(int su1, int su2) {
		int sum = 0;
		for (int i = 0; i <= su2; i++) {
			sum += i;
		}
		return sum;
	}
}
