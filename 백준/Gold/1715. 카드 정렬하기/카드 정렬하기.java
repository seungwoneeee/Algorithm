import java.util.*;
import java.io.*;


public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			pq.add(sc.nextInt());
		}
		int answer=0;
		while(pq.size()>1) {
			int a=pq.poll();
			int b=pq.poll();
			int temp = a+b;
			pq.add(temp);
			answer+=temp;
		}
		
		System.out.println(answer);
	}

}
