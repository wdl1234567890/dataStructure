package com.wdl.digui;

public class Queen8 {
	private int[] queens = new int[8];
	private int amount = 0;

	private boolean isOk(int n) {
		for (int i = 0; i < n; i++) {
			if (queens[i] == queens[n] || Math.abs(queens[n] - queens[i]) == Math.abs(n - i))
				return false;
		}
		return true;
	}

	public void install(int n) {
		if (n == 8) {
			printQueens();
			return;
		}
		for (int i = 0; i < 8; i++) {
			queens[n] = i;
			if (isOk(n)) {
				install(n + 1);
			}
		}
	}
	
	public int getAmount() {
		return amount;
	}

	private void printQueens() {
		amount++;
		for (int j = 0; j < 8; j++) {
			System.out.print(queens[j] + " ");
		}
		System.out.println();

	}
}
