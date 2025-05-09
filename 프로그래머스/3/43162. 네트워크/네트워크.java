import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        A = new ArrayList[n];
        for(int i=0;i<n;i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(computers[i][j]==1) A[i].add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]) answer += BFS(i);
        }
        return answer;
    }
    public int BFS(int index){
        Queue<Integer> myque = new LinkedList<Integer>();
        myque.add(index);
        while(!myque.isEmpty()){
            int a = myque.poll();
            visited[a]=true;
            for(int num : A[a]){
                if(!visited[num]) myque.add(num);
            }
        }
        return 1;
    }
}