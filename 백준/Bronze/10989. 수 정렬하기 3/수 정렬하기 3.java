import java.io.*;

//기합정렬로 풀기

public class Main{
    public static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(br.readLine());
        }
        br.close();
        RadixSort(A,5);
        for(int i=0;i<N;i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void RadixSort(int[] A, int max_size){
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while(count!=max_size){ //최대 자리수만큼 반복
            int[] bucket = new int[10];
            for(int i=0; i<A.length;i++){
                bucket[(A[i]/jarisu)%10]++; //일의 자리부터 시작
            }
            for(int i=1; i<10;i++){
                bucket[i]+=bucket[i-1]; //합배열 통해서 index 계산
            }
            for(int i=A.length-1; i>=0;i--){ //현재 자릿수를 기준으로 정렬
                output[bucket[(A[i]/jarisu)%10]-1]=A[i];
                bucket[(A[i]/jarisu)%10]--;
            }
            for(int i=0; i<A.length;i++){
                //다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
                A[i]=output[i];
            }
            jarisu=jarisu*10; //자릿수 증가시키기
            count++;
        }
    }
}
