import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		for(int i=0;i<cNum.length; i++) {
			sum +=cNum[i]-'0'; //문자'1'에서 숫자1로 바꾸려면 48을 빼거나 문자 '0'을 빼주면 됨.
		}
		System.out.println(sum);
	}

}
