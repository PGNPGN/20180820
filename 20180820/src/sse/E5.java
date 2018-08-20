package sse;

import java.util.Scanner;

public class E5 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[][] array;
	int min = Integer.MAX_VALUE;
	int[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E5 obj = new E5();
		obj.getInput();
		obj.dfs(0, 0);
		System.out.println(obj.min);
		obj.min = Integer.MAX_VALUE;
		System.out.println(obj.min);
		obj.dfs_check(0, 0);
		System.out.println(obj.min);
	}

	private void dfs_check(int n, int sum) {
		if(n==size) {
			if(min>sum) {
				min = sum;
//				System.out.print("= "+sum);
//				System.out.println();
			}
			return;

		}

		for(int i=0; i<size; i++) {
			if(check[i]==1) continue;
			check[i] = 1;
//			System.out.println(n+" "+i);
//			System.out.print(array[n][i]+" ");
			dfs_check(n+1, sum + array[n][i]);
			check[i] = 0;
		}

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

	public void print() {

	}

	public void dfs(int n, int sum) {
		if(n==size) {
			if(min>sum) {
				min = sum;
			}
			return;

		}

		for(int i=0; i<size; i++) {
			dfs(n+1, sum + array[n][i]);
		}

	}
}
