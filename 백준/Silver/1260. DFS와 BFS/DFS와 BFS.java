import java.util.*;
import java.io.*;

public class Main{
	static int N,M,V;
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			A[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		for(int i=1;i<=N;i++) {
			A[i].sort((a, b)->a-b);
		}
		DFS(V);
		System.out.println();
		visited=new boolean[N+1];
		BFS(V);
	}
	private static void DFS(int v) {
		// TODO Auto-generated method stub
		//재귀함수 종료 조건
		if(visited[v]) {
			return;
		}
		visited[v]=true;
		System.out.print(v+" ");
		for(int s:A[v]) {
			if(!visited[s]) {
				DFS(s);
			}
		}
	}
	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v]=true;
		queue.add(v);
		while(!queue.isEmpty()) {
			int num=queue.poll();
			System.out.print(num+" ");
			for(int s:A[num]) {
				if(!visited[s]) {
					visited[s]=true;
					queue.add(s);
				}
			}
		}
		return;
	}

}
