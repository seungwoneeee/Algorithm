import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] result = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> mystack = new Stack<>();
		mystack.push(0);
		for(int i=1;i<N;i++) {
			while(!mystack.isEmpty()&&A[i]>A[mystack.peek()]) {
				result[mystack.pop()]=A[i];
			}
			mystack.push(i);
		}
		while(!mystack.isEmpty()) {
			result[mystack.pop()]=-1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			sb.append(result[i]+" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
