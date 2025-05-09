import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        int answer=DFS(0,0,numbers, target);
        return answer;
    }
    public int DFS(int index, int sum, int[] numbers, int target){
            if(index==numbers.length){
                if(sum==target) return 1;
                return 0;
            }
            int plus = DFS(index+1, sum+numbers[index], numbers, target); //+ -> 왼쪽 루트를 탔을 때의 정답 개수
            int minus = DFS(index+1, sum-numbers[index], numbers, target); //- -> 오른쪽 루트를 탔을 때의 정답 개수
            return plus + minus; // 총 정답개수
        }
    }
