import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		long sum = 0;
		long max = 0;
		for(int i=0;i<N; i++) {
			A[i]=sc.nextInt();
			if(A[i]>max) max=A[i];
			sum+=A[i];
		}
		System.out.println(sum*100.0/max/N);
	}

}
