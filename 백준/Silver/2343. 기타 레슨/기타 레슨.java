import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		
		int sum = 0;
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if(start<A[i]) start = A[i];
			end+=A[i];
		}

	
		
		while(start<=end) {
			int mid = (start+end)/2;
			int total = 0;
			int count = 0;
			for(int i=0;i<N;i++) {
				if(total+A[i]>mid) {
					count++;
					total = 0;
				}
				total+=A[i];
			}
			if(total!=0) count++;
			if(count>M)start=mid+1;
			else end=mid-1;
		}
		System.out.println(start);
		
	}

}
