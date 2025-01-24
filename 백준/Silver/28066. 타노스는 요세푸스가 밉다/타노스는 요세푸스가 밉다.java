import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> myque = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			myque.add(i);
		}
		while(myque.size()>1) {
			if(myque.size()<K) {
				//myque.add(myque.poll());
				break;
			}else {
				myque.add(myque.poll());
				for(int i=1;i<K;i++) {
					myque.poll();
				}
			}
		}
		System.out.println(myque.poll());
	}
}
	
