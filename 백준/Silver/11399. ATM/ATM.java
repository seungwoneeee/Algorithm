import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] S = new int[N];
		int insert_point =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		//선택정렬 구현해서 풀어보기.
		for(int i=1;i<N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(A[j]<A[i]) {
					insert_point = j+1; //삽입할 인덱스 찾기
					//작은 값이 나오면 그 다음으로 삽입 
					break; 
					//삽입할 곳을 찾으면 더 이상 삽입한 곳을 찾으려고 반복문을 반복할 필요가 없음.
				}
				if(j==0) {
					insert_point = 0;
					//이 조건문을 들어오면 j가 0이 될때까지 기준값보다 작은 값을 못찾았다는 뜻이므로 기준값이 가장작은 값이 됨 => index 0으로 추가해야됨.
					
				}
			}
			int temp = A[i];
			for(int j=i;j>insert_point;j--) {
				A[j]=A[j-1];
			}
			A[insert_point]=temp;
		}
		//합배열 만들기
		int total=0;
		for(int i=0;i<N;i++) {
			if (i == 0) {
                S[i] = A[i];
            } else {
                S[i] = A[i] + S[i - 1]; 
            }
			total+=S[i];
		}
		System.out.println(total);
	}

}
