package sse;

import java.util.Scanner;

public class E6 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[][] array;
	int min = Integer.MAX_VALUE;
	int[] check;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E6 obj = new E6();
		obj.getInput();
		obj.dfs(0,0);
		System.out.println(obj.min);
	}
	public void getInput() {
		size = scan.nextInt();
		array = new int[size][size];
		check = new int[size];

		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				array[i][j] = scan.nextInt();
			}
		}

	}
	
	public void dfs(int n, int sum) {
		if(sum > min) {
			return;
		}
		if(n==size) {
			if(min>sum) {
				min = sum;
			}
			return;
		}
		
		for(int i=0; i<size; i++) {
			if(check[i]==1) continue;
			check[i] = 1;
			dfs(n+1, sum+array[n][i]);
			check[i] = 0;
		}
	}
}
