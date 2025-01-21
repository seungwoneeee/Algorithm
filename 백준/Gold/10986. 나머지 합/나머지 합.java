import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long S[]=new long[N+1];
		long C[]=new long[M];
		st = new StringTokenizer(br.readLine());
		long result=0;
		
		for(int i=1;i<=N;i++) {
			S[i]= S[i-1]+Integer.parseInt(st.nextToken());
			int mod = (int)(S[i]%M);
			if (mod==0)result++;
			C[mod]++;
		}
		for(int i=0;i<M;i++) {
			if(C[i]>1) {
				result+=C[i]*(C[i]-1)/2;
			}
		}
		System.out.println(result);
	}

}
