import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static boolean[] visited;
	static int[] distance;
	static ArrayList<Node>[] A;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			A[i]=new ArrayList<Node>();
		}

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			while(true) {
				int s = Integer.parseInt(st.nextToken());
				if(s==-1) break;
				else {
					int e = Integer.parseInt(st.nextToken());
					A[v].add(new Node(s,e));
				}
			}
		}
		BFS(1); //임의의 수에서 출발하여 거리 계산   
		int max = 1;
		for(int i=2;i<=N;i++) {
			if(distance[max]<distance[i]) {
				max=i; //트리의 하나의 종점을 찾음 
			}
		}
		visited = new boolean[N+1]; 
		distance = new int[N+1]; //이제 진짜로 거리를 재야하므로 초기화 (방문 여부 & 거리 배열) 
		
		BFS(max);
		Arrays.sort(distance); //오름차순 정렬  
		System.out.println(distance[N]); //가장 큰 수 = 지름 출력  
		
	}
	private static void BFS(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> myque = new LinkedList<Integer>(); //bfs를 구현할 큐 선언
		myque.add(i);
		visited[i]=true;
		while(!myque.isEmpty()) {
			int now_node = myque.poll();
			for(Node j:A[now_node]) {
				int key = j.key;
				int value = j.value;
				if(!visited[key]) { //방문하지 않은 곳이라면 이동  
					visited[key]=true;
					myque.add(key);
					distance[key]=distance[now_node]+value;
				}
			}
		}
	}
	static class Node{
		public int key;
		public int value;
		Node(int key, int value) {
			this.key=key;
			this.value=value;
		}
	}
}
