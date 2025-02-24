import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1]; //정렬 시 사용할 임시 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        result =0;
        mergetSort(1,N);
        System.out.println(result);
    }
    public static void mergetSort(int s, int e) {
        if (e - s < 1) //재귀함수를 종료하는 조건, 만약 배열의 원소가 하나라면 재귀함수를 종료하도록 한다.
            return;
        int m = s + (e - s) / 2; //집합을 여러개로 나누는 기준점이 된다.
        //오버플로우 방지를 위해 (s+e)/2보다 s+(e-s)/2와 같은 식을 쓴다.
        //재귀함수 형태로 구현
        mergetSort(s, m);
        mergetSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) { //두 그룹을 병합
            //양쪽 그룹의 index가 가리키는 값을 비교, 더 작은 수를 선택해서 배열에 저장하고 선택된 데이터의 index값을 오른 쪽으로 한 칸 이동하기
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                result = result + index2 - k; //뒤쪽 데이터 값이 더 작은 경우 result 업데이트
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) { //한쪽 그룹이 모두 선택된 경우 나머지 값 정리하기
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
