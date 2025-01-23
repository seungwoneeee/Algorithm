import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] A = new long[N];
		long result = 0;
		for(int i=0;i<N;i++) {
			A[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		for(int i=0;i<N;i++) {
			int start = 0;
			int end = N-1;
			while(start<end) {
				if(A[start]+A[end]==A[i]) {
					if(start!=i && end!=i) {
						result++;
						break; 
						}else if(start==i) {
							start++;
						}else end--;
					}
				else if(A[start]+A[end]<A[i]) start++;
				else end--;
			}
		}
		System.out.println(result);
	}

}
