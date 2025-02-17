import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		//Try1. 시간초
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		Integer[] A = new Integer[N];
//		for(int i=0;i<N;i++) {
//			A[i]=Integer.parseInt(br.readLine());
//		}
//		List<Integer> sort_A = new ArrayList<>(Arrays.asList(A));
//		Collections.sort(sort_A);
//		int max = 0;
//		for(int i=0;i<N;i++) {
//			int count = i - sort_A.indexOf(A[i]); => 시간 초과가 발생하는 원인은 sort_A.indexOf(A[i])의 선형 탐색(O(N)) 때문
//			+ 왜냐면 인덱스 찾으면서 O(N)*N(반복문) =  O(N²)이라는 시간초과가 발생한 거
		
//			if(count>max) max = count;
//		}
//		System.out.println(max+1);//완료되고도 한번 더 반복문을 돌릴걸 가정해서 +1한 값을 출력해
		
		//그래서 indexOf(O(N))를 쓰지 말고 배열을 정렬할 때 원래 인덱스도 저장
		//Try2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] A = new int[N][2]; //[값, 원래 인덱스]
		for(int i=0;i<N;i++) {
			A[i][0]=Integer.parseInt(br.readLine());
			A[i][1]=i;//원래 인덱스
		}
		Arrays.sort(A, Comparator.comparingInt(a -> a[0])); //값을 기준으로 정
		int max = 0;
		for(int i=0;i<N;i++) {
			int count =A[i][1] - i; //원래 인덱스에서 정렬 후 인덱스 빼기
			if(count>max) max = count;
		}
		System.out.println(max+1);
	}

}
