import java.util.*;
import java.io.*;

public class Main{
	public static int[] A, tmp;
	public static long result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int	N = Integer.parseInt(br.readLine());
		result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		for(int i=1;i<=N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		mergetSort(1,N);
		System.out.println(result);
	}
	private static void mergetSort(int s, int e) {
		if(e-s<1)
			return;
		int m = s+(e-s)/2;
		mergetSort(s,m);
		mergetSort(m+1,e);
		for(int i=s;i<=e;i++) {
			tmp[i]=A[i];
		}
		int k=s;
		int index1 = s;
		int index2 = m+1;
		while(index1<=m&&index2<=e) {
			if(tmp[index1]>tmp[index2]) {
				A[k]=tmp[index2];
				result = result+index2-k; //뒤쪽 데이터 값이 더 작아 선택될 때
				//swap이 일어났다고 가정하고, 현재 남아 있는 앞 쪽 데이터 개수만큼 결괏값을 더함  
				index2++;
				k++;
			}
			else {
				A[k]=tmp[index1];
				index1++;
				k++;
			}
		}
		while(index2<=e) {
			A[k]=tmp[index2];
			index2++;
			k++;
		}
		while(index1<=m) {
			A[k]=tmp[index1];
			index1++;
			k++;
		}
	}
}
