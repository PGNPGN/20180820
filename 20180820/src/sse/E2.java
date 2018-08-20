package sse;

import java.util.Scanner;

public class E2 {
	Scanner scan = new Scanner(System.in);
	int a, b;
	int min_x=50, max_x, min_y=50, max_y;
	char[][] map, map2;
	String dummy = "";
	int[] dx= {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	Node[] queue;
	Node data;
	int rp=0, wp=0;
	int nx, ny;
	int cnt, min=2500;
	public class Node{
		int x; int y; int distance;

		Node(int x, int y, int distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E2 obj = new E2();
		obj.getInput();
//		obj.print(obj.map);
		obj.change_Dot();
//		obj.print(obj.map2);
		obj.spread();
	}

	private void spread() {
		wp=0; rp=0;
		queue = new Node[a*b];
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				if(map2[i][j] == '?') {
					bfs_first(i, j);
				}
			}
		}
		min = bfs();
		System.out.println(min);
	}

		private void bfs_first(int i, int j) {
			for(int k=0; k<4; k++) {
				nx = i + dx[k];
				ny = j + dy[k];
				
				if(nx>=min_y && nx<=max_y && ny>=min_x && ny<=max_x) {
					if( map2[nx][ny] == '.') {
						map2[nx][ny] = '*';
						System.out.println("bfs_fisrt");
						print(map2);
						queue[wp] = new Node(nx, ny, 1);
						System.out.println(queue[wp].x);
						wp++;
						System.out.println("wp = "+wp);
					}
				}
			}
	}

		private int bfs() {
//			System.out.println(i+" "+j);
//			System.out.println("rp = "+rp+" wp = "+wp);
			while(rp<wp) {
				data = queue[rp];
				rp++;
//				System.out.println(queue[rp].x);
//				System.out.println("data.x = "+data.x+" data.y = "+ data.y);
				
				for(int k=0; k<4; k++) {
					nx = data.x + dx[k];
					ny = data.y + dy[k];
					
					if(nx>=min_y && nx<=max_y && ny>=min_x && ny<=max_x) {
						if( map2[nx][ny] == '.') {
							map2[nx][ny] = '*';
							print(map2);
							queue[wp] = new Node(nx, ny, data.distance+1);
							wp++;
						}
						if( map2[nx][ny] == 'X') {
//							System.out.println(data.distance);
							return data.distance;
						}
					}
				}
			}
			return 100;
		}

		private void change_Dot() {
			boolean flag = false;

			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) {
					if(map[i][j] == 'X') {
						bfs_change(i, j);
						flag = true;
						break;
					}
				}

				if(flag == true) {
					break;
				}
			}
			
			copy_Map();

		}

		private void copy_Map() {
			map2 = new char[a][b];
			
			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) {
					map2[i][j] = map[i][j];
				}
			}
			
		}

		private void bfs_change(int x, int y) {
			nx=0; ny=0;
			queue[0] = new Node(x, y, 0);
			wp++;

			while(rp<wp) {
				data = queue[rp];
				rp++;
//				map[data.x][data.y] = '?'; 
				for(int i=0; i<4; i++) {
					nx = data.x + dx[i];
					ny = data.y + dy[i];

					if(nx>=min_y && nx<=max_y && ny>=min_x && ny<=max_x) {
						if(map[nx][ny] == 'X') {
							map[nx][ny] = '?';
							queue[wp] = new Node(nx, ny, 0);
							wp++;
//							System.out.println("wp = "+wp);
						}
					}
				}
			}




		}

		public void getInput() {
			a = scan.nextInt();
			b = scan.nextInt();
			scan.nextLine();
			map = new char[a][b];
			queue = new Node[a*b];

			for(int i=0; i<a; i++) {
				dummy = scan.nextLine();
				for(int j=0; j<b; j++) {
					map[i][j] = dummy.charAt(j);
					if(map[i][j] =='X') {
						if(i>max_y)
							max_y = i;
						if(i<min_y)
							min_y = i;
						if(j>max_x)
							max_x = j;
						if(j<min_x)
							min_x = j;
					}
				}
			}
		}

		public void print(char[][] some) {
			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) {
					System.out.print(some[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			//		System.out.println(max_x +" "+min_x+" "+max_y+" "+min_y);
		}
	}
