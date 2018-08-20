package sse;

import java.util.Scanner;

public class E9 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[][] map;
	int[] check;
	int quotient, remainder, max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E9 obj = new E9();
		obj.getInput();
//		obj.print();
		obj.dfs(0,0);
		System.out.println(obj.max);
	}
	
	public void dfs(int n, int sum) {
		if(n==size) {
			calculate(sum);
			return;
		}
		
		for(int i=0; i<size; i++) {
			if(check[i] == 1) continue;
			check[i] = 1;
			dfs(n+1, sum * 10 + map[n][i]);
			check[i] = 0;
		}
	}
	
	
	private void calculate(int sum) {
		for(int i=1; i<size/2 +1; i++) {
			quotient = sum / (int)Math.pow(10, i);
			remainder = sum % (int)Math.pow(10, i);
			
			if(quotient*remainder > max)
				max = quotient*remainder;
		}
	}

	public void getInput() {
		size = scan.nextInt();
		map = new int[size][size];
		check = new int[size];
		
		for(int i=0; i<size; i++) {
			map[0][i] = scan.nextInt();
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				map[j][i] = map[0][i];
			}
		}
	}
	public void print() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}
}
