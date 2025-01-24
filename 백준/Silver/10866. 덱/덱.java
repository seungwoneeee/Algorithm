import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> mydeque = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int x = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String request = st.nextToken();
			switch(request){
			case "push_front":
				x = Integer.parseInt(st.nextToken());
				mydeque.addFirst(x);
				break;
			case "push_back":
				x = Integer.parseInt(st.nextToken());
				mydeque.addLast(x);
				break;
			case "pop_front":
				if(mydeque.isEmpty()) System.out.println("-1");
				else System.out.println(mydeque.pollFirst());
				break;
			case "pop_back":
				if(mydeque.isEmpty()) System.out.println("-1");
				else System.out.println(mydeque.pollLast());
				break;
			case "size":
				System.out.println(mydeque.size());
				break;
			case "empty":
				System.out.println(mydeque.isEmpty()?1:0);
				break;
			case "front":
				if(mydeque.isEmpty()) System.out.println("-1");
				else System.out.println(mydeque.peekFirst());
				break;
			case "back":
				if(mydeque.isEmpty()) System.out.println("-1");
				else System.out.println(mydeque.peekLast());
				break;
			}
		}
	}

}
