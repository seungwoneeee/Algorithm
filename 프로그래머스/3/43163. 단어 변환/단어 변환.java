import java.io.*;
import java.util.*;

class Solution {
    static int depth;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        depth = 0;
        visited = new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])) break;
            if(i==words.length-1 && !target.equals(words[i])) {
                depth = 0;
                return depth;
            }
        }
        depth = BFS(begin, target, words);
        return depth;
    }
    public int BFS(String begin, String target, String[] words){
        Queue<Node> myque = new LinkedList<Node>();
        myque.add(new Node(depth, begin));
        int now_depth = 0;
        while(!myque.isEmpty()){
            Node now = myque.poll();
            now_depth = now.depth;
            String now_word = now.word;
            if(target.equals(now_word)){
                return now_depth;
            }
            for(int i=0;i<words.length;i++){
                if(isConnect(now_word,words[i])&&!visited[i]){
                    visited[i]=true;
                    myque.add(new Node(now_depth+1, words[i]));
                }
            }
        }
        return 0;
    }
    public boolean isConnect(String now, String next){
        String[] NOW = now.split("");
        String[] NEXT = next.split("");
        int count = 0;
        for(int i=0;i<NOW.length;i++){
            if(!NEXT[i].equals(NOW[i])) count+=1;
        }
        if(count==1) return true;
        else return false;
        /*
        int count = 0;
        for(int i=0;i<now.length();i++){//string인 경우엔 length()로 사용해야함
            if(now.charAt(i)!=next.charAt(i)) count++;
        }
        if(count==1) return true;
        else return false;
        */
    }
    class Node{
        int depth;
        String word;
        Node(int depth, String word){
            this.depth = depth;
            this.word = word;
        }
    }
}