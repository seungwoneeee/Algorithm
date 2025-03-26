import java.util.*;

public class Main{
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DFS(2,1); //어차피 혼자 있을 때 소수인 거는 4개뿐이니까 출발점을 4개만 하면 됨. 
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	private static void DFS(int n, int jarisu) {
		// TODO Auto-generated method stub
		if(jarisu==N) {
			if(isPrime(n))System.out.println(n); //재귀함수 종료 조건
			else return;
		}
		for(int i=1;i<=9;i=i+2) {
			int number = ((n*10)+i);
			if(isPrime(number)) {
				DFS(number,jarisu+1);
				}
			}
		}
	private static boolean isPrime(int n) {
		for(int j=2;j*j<=n;j++) {
			if((n%j)==0) return false;
		}
		return true;
	}
}
