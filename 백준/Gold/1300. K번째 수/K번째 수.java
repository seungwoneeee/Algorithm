import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		//메모리:128mb => 배열 만들면 무조건 초과
		//A배열을 생각하면 각 열이 i의 배수로 1xi부터 Nxi까지 있음
		//만약 A배열이 3x3이고 m=6이면
		/*A[1]=1,2,3 =>m보다 작은게 1,2,3(3개)
		 * A[2]=2,4,6 =>m보다 작은게 2,4,6(3개)
		 * A[3]=3,6,9=> m보다 작은게 3,6(2개)*/
		//=> m을 각 Index로 나눴을 떄 각 행에서 m보다 작은 값이 몇개 있는지가 나옴. 이때, 최대 n까지만 가능하므로 n을 초과하면 그 행에선 n개까지만 가질 수 있음
		
		long answer = 0;
		long start = 1;
		long end = M;
		
		while(start<=end) {
			long count=0;
			long mid = (start+end)/2;
			for(int i=1;i<=N;i++) {
				count+=Math.min(mid/i, N);
			}
			if(count<M) {
				start=mid+1;
			}else {
				answer=mid;
				end = mid-1;
			}
		}
		System.out.println(answer);
	}
}

