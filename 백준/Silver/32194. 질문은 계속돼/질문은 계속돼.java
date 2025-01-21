import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S[] = new long[(int) (N+2)];
		long T[] = new long[(int)(N+2)];
		S[1]= 1;
		T[1]= 1;
		for(int i=2;i<=N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(T[end]-T[start-1]==q*(end-start+1)) {
				S[i]=1;
				System.out.println("Yes");
			} else {
				S[i]=2;
				System.out.println("No");
			}
			T[i]=T[i-1]+S[i];
		}
	}

}
