// 1) N, M을 입력받기
// 2) N만큼 숫자를 입력받아서 배열 생성하기
// 3) 배열을 min, max 총 2개의 세그먼트 트리로 변환
// 4) M만큼 (a, b)쌍을 입력받아서 최소 최대 구하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
  static long[] arr;
  static long[] minTree;
  static long[] maxTree;
  static public void main(String[] args)throws IOException{
    // 1) N, M을 입력받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 2) N만큼 숫자를 입력받아서 arr 배열 생성하기
    arr = new long[N+1];
    for(int i=1; i<=N; i++){
      st = new StringTokenizer(br.readLine());
      arr[i]=Long.parseLong(st.nextToken());
    }

    // 3) 배열을 min, max 총 2개의 세그먼트 트리로 변환
    minTree = new long[4*N];
    maxTree = new long[4*N];
    init(1, 1, N);

    // 4) M만큼 (a, b)쌍을 입력받아서 최소 최대 구하기
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      Long result = getMin(1, 1, N, a, b);
      sb.append(result).append(" ");
      result = getMax(1, 1, N, a, b);
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }



  private static void init(int node, int start, int end){
    if(start == end){
      minTree[node] = maxTree[node] = arr[start];
      return;
    }
    int mid = (start+end)/2;
    init(node*2, start, mid);
    init(node*2+1, mid+1, end);
    minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);
    maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
  }



  private static long getMin(int node, int start, int end, int left, int right){
    if(start > right || end < left){
      return Long.MAX_VALUE;
    }
    if(left <= start && end <= right){
        return minTree[node];
    }
    int mid = (start+end)/2;
    Long leftMin = getMin(node*2, start, mid, left, right);
    Long rightMin = getMin(node*2+1, mid+1, end, left, right);
    return Math.min(leftMin, rightMin);
  }

  private static long getMax(int node, int start, int end, int left, int right){
    if(start > right || end < left){
      return Long.MIN_VALUE;
    }
    if(left <= start && end <= right){
        return maxTree[node];
    }
    int mid = (start+end)/2;
    Long leftMax = getMax(node*2, start, mid, left, right);
    Long rightMax = getMax(node*2+1, mid+1, end, left, right);
    return Math.max(leftMax, rightMax);
  }
}
