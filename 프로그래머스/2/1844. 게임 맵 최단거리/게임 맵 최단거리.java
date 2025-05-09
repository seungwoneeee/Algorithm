import java.util.*;
import java.io.*;

class Solution {
    static boolean visited[][];
    static int[][] distance;
    static int[] dx = {0,0,-1,+1};
    static int[] dy = {1,-1,0,0};
    static int answer;
    public int solution(int[][] maps) {
        answer = 0;
        distance = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];
        answer = BFS(0,0,maps);
        return answer;
    }
    public int BFS(int x, int y, int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Node> myque = new LinkedList<Node>();
        myque.add(new Node(x,y));
        visited[x][y]=true;
        distance[x][y]=1; //시작 지점 거리 1
        
        while(!myque.isEmpty()){
            Node now = myque.poll();
            int now_x = now.x;
            int now_y = now.y;
            
            for(int i=0;i<4;i++){
                int next_x = now_x+dx[i];
                int next_y = now_y+dy[i];
                if(next_x>=0&&next_y>=0&&next_x<n&&next_y<m){
                   if(!visited[next_x][next_y]&&maps[next_x][next_y]==1){
                        myque.add(new Node(next_x,next_y));
                        distance[next_x][next_y]=distance[now_x][now_y]+1; //원래 길이에 1을 더해서 합거리 계산 
                        visited[next_x][next_y]=true;
                   }
                }
            }
        }
        if(!visited[n-1][m-1]) return -1; //도달 못함
        return distance[n-1][m-1];
    }
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

