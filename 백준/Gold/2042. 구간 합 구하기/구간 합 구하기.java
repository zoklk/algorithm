// 1번째 줄: N, M, K
// 숫자 N개 인 배열 생성
// 이후 3개의 정수 (a, b, c)가 M+K개 주어짐
// if (a=1) -> b번째 수를 c로 바꾸기
// if (a=2) -> b부터 c까지 합 구하기
// ---
// 1) numbers.length() -1을 안썼다... 배열 크기 그대로 넣으면 idx초과된다.
// 2) StringBuilder를 써야 I/O덜 할 수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static long[] numbers;
  static long[] tree;
  public static void main(String[] args) throws IOException{
    // 1) 1번째 줄 에서 N, M, K 읽기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 2) N번째 줄까지 숫자 numbers 배열에 넣기
    numbers = new long[N];
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      numbers[i]=Long.parseLong(st.nextToken());
    }

    // 3) N참고해서 tree생성
    tree = new long[4*N];
    MakeTree(0, numbers.length-1, 1);

    // 4) 조건에 맞게 숫자 변경 + 구간합 구하기
    //    segment Tree 메서드 활용하기
    //    StringBuilder로 모아서 출력하기
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<M+K; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      if(a==1){
        int idx = b-1;
        long diff = c - numbers[idx];
        numbers[idx] = c;
        update(0, numbers.length-1, 1, idx, diff);
      }
      if(a==2){
        long left = b-1;
        long right = c-1;
        long result = PrefixSum(0, numbers.length-1, 1, left, right);
        sb.append(result).append("\n");
      }
    }

    System.out.println(sb);
  }



  private static void MakeTree(int start, int end, int index){
    if(start == end){
      tree[index] = numbers[start];
      return;
    }
    int mid = (start+end)/2;
    MakeTree(start, mid, index*2);
    MakeTree(mid+1, end, index*2+1);
    tree[index] = tree[index*2]+tree[index*2+1]; 
  }



  private static long PrefixSum(int start, int end, int index, long left, long right){
    if(left > end || right < start){
      return 0;
    }
    if(left <= start && right >= end){
      return tree[index];
    }

    int mid = (start+end)/2;
    return PrefixSum(start, mid, index*2, left, right) + PrefixSum(mid+1, end, index*2+1, left, right);
  }



  private static void update(int start, int end, int index, long idx, long diff){
    if(idx<start || idx>end){
      return;
    }

    tree[index] += diff;
    if(start==end){
      return;
    }

    int mid = (start+end)/2;
    update(start, mid, index*2, idx, diff);
    update(mid+1, end, index*2+1, idx, diff);
  }
}
