package sse;

import java.util.Arrays;
import java.util.Scanner;

public class E7 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[][] array;
	int min = Integer.MAX_VALUE;
	int[] check;
	int[] instance;
	int[] final_order;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E7 obj = new E7();
		obj.getInput();
		obj.dfs(0,0);
		System.out.println(obj.min);
		for(int i: obj.final_order)
		System.out.print((i+1)+" ");
	}
	public void getInput() {
		size = scan.nextInt();
		array = new int[size][size];
		check = new int[size];
		instance = new int[size];
		final_order = new int[size];
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
				final_order = Arrays.copyOf(instance, size);
			}
			return;
		}
		
		for(int i=0; i<size; i++) {
			if(check[i]==1) continue;
			check[i] = 1;
			instance[n] = i;
			dfs(n+1, sum+array[n][i]);
			check[i] = 0;
			instance[n] = 0;
		}
	}
}
