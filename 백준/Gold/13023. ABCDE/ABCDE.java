import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static boolean arrive;
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arrive = false;
		A = new ArrayList[N];
		visited = new boolean[N];
		//인접 리스트 만들기 
		for(int i=0;i<N;i++) {
			A[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		for(int i=0;i<N;i++) {
			visited[i] = true;
			DFS(i,1); //모든 친구들을 다 돌아보기 
			visited[i] = false;
			if(arrive) break; //이미 그런 친구들이 존재하면 더이상 탐색할 필요가 없
 		}
		if(arrive) System.out.println("1");
		else System.out.print("0"); //M만큼의 깊이가 없다면 0출력 
	}
	private static void DFS(int i, int depth) {
		// TODO Auto-generated method stub
		//재귀함수 종료 조건
		if(depth==5) { //depth가 5가 되면 종료 
			arrive=true;
			return;
		}
		//visited==true로 만들어주기
		for(int s:A[i]) {
			if(!visited[s]) {
				visited[s] = true;
				DFS(s, depth+1); //재귀함수가 호출될 때마다 depth를 1씩 증가 
				visited[s] = false;
			}
		}
	}
}
