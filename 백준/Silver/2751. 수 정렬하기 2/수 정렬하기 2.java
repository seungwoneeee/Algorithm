import java.util.*;
import java.io.*;

public class Main{
	public static int[] A,tmp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		for(int i=1;i<=N;i++) {
			A[i]=Integer.parseInt(br.readLine());
		}
		mergetSort(1,N); //재귀함
		for(int i=1;i<=N;i++) {
			bw.write(A[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void mergetSort(int s, int e) {
		if(e-s<1) //재귀 호출의 종료 조건 역
			return; //e==s가 되면 해당 구간에 원소가 하나만 있으므로 이미 정렬된 상태->분할 필요 x
		int m = s+(e-s)/2; //전체 길이의 절반에 해당하는 위치를 계산  
		mergetSort(s,m); //배열의 왼쪽 부분을 정렬  
		mergetSort(m+1,e); //배열의 오른쪽 부분을 정렬    
		for(int i=s;i<=e;i++) { //현재 구간 복사 
			tmp[i]=A[i];
		}
		int k=s; //두 부분 배열을 비교하면서 작은 값을 A[k]에 삽입하고자 함 
		int index1=s; //왼쪽 배열의 시작 위치 
		int index2=m+1; //오른쪽 배열의 시작 위치 
		while(index1<=m&&index2<=e) {
			// index1이 m을 초과하거나 index2가 e를 초과하면 종료
			//두 개의 부분 배열 중 하나가 먼저 소진되면 종료
			//즉, 반대쪽 배열의 원소가 남아 있을 가능성이 있음. 
			if(tmp[index1]>tmp[index2]) { //왼쪽 배열과 오른쪽 배열의 원소를 비교했을 때 
				A[k]=tmp[index2]; //더 작은 걸 A[k]에 삽입 
				k++; //그리고 k에 정렬 값이 들어갔으므로 k++
				index2++; //그리고 오른쪽의 가장 왼쪽의 값이 배열에 들어갔으므로 인덱스를 ++
			}else { //반대의 경우 
				A[k]=tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1<=m) { //첫번째 while문을 돌리고 나서, 오른쪽 배열은 정렬이 끝났지만, 왼쪽 배열의 정렬이 끝나지 않았을 경우 이 while문을 수행  
			A[k]=tmp[index1];
			k++;
			index1++;
		}
		while(index2<=e) { //첫번째 while문을 돌리고 나서, 왼쪽  배열은 정렬이 끝났지만, 오른 쪽 배열의 정렬이 끝나지 않았을 경우 이 while문을 수행 
			A[k]=tmp[index2];
			k++;
			index2++;
		}
	}
}
