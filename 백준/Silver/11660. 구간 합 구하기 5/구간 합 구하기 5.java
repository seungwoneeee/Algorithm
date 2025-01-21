import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//InputStreamReader은 바이트입력 스트리믕ㄹ 문자입력스트림으로 변환하는 
		StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringtokenizer.nextToken());
		int quNo = Integer.parseInt(stringtokenizer.nextToken());
		long a[][] = new long[N+1][N+1];
		long D[][] = new long[N+1][N+1];
		for(int i=1;i<=N;i++) {
			stringtokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=1;j<=N;j++) {
				a[i][j]= Integer.parseInt(stringtokenizer.nextToken());
				if(i==1) D[i][j]=D[i][j-1]+a[i][j];
			}
		}
		for(int i=1;i<=N;i++) {
			D[i][1]=D[i-1][1]+a[i][1];
		}
		for(int i=2;i<=N;i++) {
			for(int j=2;j<=N;j++) {
				D[i][j]=D[i-1][j]+D[i][j-1]-D[i-1][j-1]+a[i][j];
			}
		}
		for(int i=0;i<quNo;i++) {
			stringtokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringtokenizer.nextToken());
			int y1 = Integer.parseInt(stringtokenizer.nextToken());
			int x2 = Integer.parseInt(stringtokenizer.nextToken());
			int y2 = Integer.parseInt(stringtokenizer.nextToken());
			long result = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1];
			System.out.println(result);
		}
	}
}