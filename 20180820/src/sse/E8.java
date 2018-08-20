package sse;

import java.util.Scanner;

public class E8 {
	Scanner scan = new Scanner(System.in);
	int size;
	int[][] map;
	int cnt;
	int[] di= {0, 1, 1, 1}, dj= {1, 0, 1, -1};
	int dummy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E8 obj = new E8();
		obj.getInput();
		obj.dfs(0);
		System.out.println(obj.cnt);
		
		
	}
	
	public void dfs(int n) {
		dummy = 1;
		if(n==size) {
			cnt++;
			return;
		}
		
		for(int i=0; i<size; i++) {
			dummy *= map[n][i];
		}
		
		if(dummy !=0) {
			return;
		}
		
		
		for(int i=0; i<size; i++) {
			if(map[n][i] > 0) continue;
			check_map(n,i);
			print();
			dfs(n+1);
			uncheck_map(n,i);
		}
	}
	public void getInput() {
		size = scan.nextInt();
		map = new int[size][size];
		
	}
	
	public void check_map(int a, int b) {
		for(int i=0; i<4; i++) {
			for(int j=-size; j<=size; j++) {
				try {
					map[a+j*di[i]][b+j*dj[i]] += 1;
				}catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		map[a][b] -= 3;
	}
	
	public void uncheck_map(int a, int b) {
		for(int i=0; i<4; i++) {
			for(int j=-size; j<=size; j++) {
				try {
					map[a+j*di[i]][b+j*dj[i]] -= 1;
				}catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		map[a][b] += 3;
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
