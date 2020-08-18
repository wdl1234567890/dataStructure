package com.wdl.digui;

public class MiGong {
	private int[][] miGong;
	private int row;
	private int col;
	
	public MiGong(int row, int col) {
		init(row, col);
	}
	
	private void init(int row, int col) {
		if(row <= 0 || col <= 0)throw new RuntimeException("参数有误，初始化迷宫失败!");
		miGong = new int[row][col];
		this.row = row;
		this.col = col;
		for(int i = 0; i < col; i++) {
			miGong[0][i] = 1;
			miGong[row-1][i] = 1;
		}
		for(int j = 0; j < row; j++) {
			miGong[j][0] = 1;
			miGong[j][col-1] = 1;
		}
		int rowRandom = 1 + (int)(Math.random() * (row - 2));
		int colRandom = 1 + (int)(Math.random() * (col - 2));
		int rowRandom1 = 1 + (int)(Math.random() * (row - 2));
		int colRandom1 = 1 + (int)(Math.random() * (col - 2));
		int rowRandom2 = 1 + (int)(Math.random() * (row - 2));
		int colRandom2 = 1 + (int)(Math.random() * (col - 2));
		miGong[rowRandom][colRandom] = 1;
		miGong[rowRandom1][colRandom1] = 1;
		miGong[rowRandom2][colRandom2] = 1;
		System.out.println("初始化后");
		printTrace();
	}
	
	public boolean go(int i, int j) {
		if(miGong[row - 2][col - 2] == 2) {
			System.out.println("找到通路！");
			printTrace();
			return true;
		}
		if(miGong[i][j] == 0) {
			miGong[i][j] = 2;
			if(go(i - 1, j)) {
				return true;
			}else if(go(i, j + 1)) {
				return true;
			}else if(go(i + 1, j)) {
				return true;
			}else if(go(i, j - 1)) {
				return true;
			}
			miGong[i][j] = 3;
			return false;
		}else {
			return false;
		}
	}

	private void printTrace() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(miGong[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
