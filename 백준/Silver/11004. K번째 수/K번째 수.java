import java.util.*;
import java.io.*;

public class Main{
	//퀵정렬로 구현해서 풀어보기  
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S = 0; //정렬할 배열의 시작
		int E = N-1; //정렬할 배열의 끝 
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i]=Integer.parseInt(st.nextToken());
		}
		quickSort(A, S, E, K-1); 
        System.out.println(A[K-1]);
	}
	public static void quickSort(int[] A, int S, int E, int K) {
		int pivot = partition(A,S,E); //여기서 return 받는 pivot은 index값임 
		if(pivot==K) return; //pivot의 인덱스가 k면 정렬할 필요없음.
		else if(pivot<K) quickSort(A, pivot+1,E,K); //K가 pivot보다 크면 오른쪽 그룹만 정렬 수행하
		else quickSort(A,S,pivot-1,K); //K가 pivot보다 작으면 왼쪽그룹만 정렬수행하
	}
	public static int partition(int[] A, int S, int E) { //pivot 구하는 함수 
		if(S+1==E) { //부분집합의 원소가 두개인 경우 
			if(A[S]>A[E]) {
				swap(A,S,E); //두개의 원소만 비교해서 교체해주면 됨. 
				return E; //기준점의 위치를 반환 : 원소가 두개일 경우에 가장 오른쪽에 있는 값을 return한다. 
			}
		}
		int M = (S+E)/2; //중앙값 
		swap(A,S,M); //시작위치와 배열의 중앙값을 바꿔서 기준점이 맨 앞으로 가도록함. 
		int pivot = A[S]; //여기에서 pivot에 저장되는 값은 원소값 
		//시작값을 정렬의 기준점으로 지정 
		int i = S+1; //pivot을 기준으로 정렬해야할 시작
		int j = E; // pivot을 기준으로 정렬해야할 끝  
		while(i<=j){ //start와 end가 같을 때까지만 동작 
			while(A[i]<pivot&&i<=E) {//start는 pivot보다 큰 값을 찾을 때까지 동작  
				i++;
			}
			while(A[j]>pivot&&j>=S+1) { //end는 pivot보다 작은 값을 찾을 때까지 동작   
				j--;
			}
			if(i<=j) { //while문을 돌면서 i>j가 될 수도 있기 때문에 조건을 한 번 더 넣어줌. 
				swap(A,i++,j--); //start와 end가 둘 다 멈췄을 경우 두개의 원소를 swap
				/* i와 j가 아니라 i++, j--인 이유
				우선 i와 j가 멈췄다는 것은 A[i]는 pivot보다 크거나 같고, A[j]는 pivot보다 작거나 같다는 뜻
				즉, A[i]와 A[j]를 바꿔주면 올바른 정렬을 유지 
				but, swap후엔 다음 요소로 진행을 해야하기 때문에 swap을 하고 i는 오른쪽으로 이동할 수 있도록 i++를,
				j는 swap을 하고 왼쪽으로 이동을 할 수 있도록 j--를 해준다. 
				*/
			}
		}
		//pivot을 제자리에 놓는 과정  
		A[S]=A[j]; //pivot이 있던 자리에 A[j]를 넣어서 피벗 자리를 비운다. 
		/*
		 j는 피벗보다 작은 값을 찾을 때까지 왼쪽으로 이동하고, 
		 swap(A, i++, j--);를 수행하면서 작은 값과 큰 값을 서로 교환한다.
		 따라서 j--가 한 번 더 실행되기 때문에 
		 최종적으로 j는 피벗보다 작은 값 중 가장 오른쪽 값의 위치를 가리키게 됨.   
		 * */
		A[j]=pivot; //피벗을 정확한 위치에 둔다. pivot을 기준으로 왼쪽은 pivot보다 작은 값, 오른쪽은 pivot보다 큰 값이 오게됨.
		return j; //pivot의 위치를 반환하여 분할된 두 부분을 처리할 수 있도록 함. 
		
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i]=A[j];
		A[j]=temp;
	}

}
