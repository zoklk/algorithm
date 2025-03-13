// 1) 날짜, 기간을 입력받는다.
// 2) 날짜별 온도를 입력받는다. 
// 3) 기간을 바탕으로 sliding window를 만든다.
// 4) 하나씩 밀면서 새로운 배열에 저장한다.
// 5) for로 최대값을 구한다.
//---

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
  static int[] arr;
  static int[] slide;
  public static void main(String[] args) throws IOException{
    // 1) 날짜, 기간을 입력받는다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 2) 날짜별 온도를 입력받는다. 
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 3) 기간을 바탕으로 sliding window를 만든다.
    slide = new int[N-K+1];
    for(int i=0; i<K; i++){
      slide[0] += arr[i];
    }

    // 4) 하나씩 밀면서 새로운 배열에 저장한다.
    for(int i=0; i<N-K; i++){
      slide[i+1] = slide[i]-arr[i]+arr[i+K];
    }

    // 5) for로 최대값을 구한다.
    StringBuilder sb = new StringBuilder();
    int result = slide[0];
    for(int i=0; i<slide.length; i++){
      if(slide[i]>result){
        result = slide[i];
      }
    }
    sb.append(result).append("\n");
    System.out.println(sb);
  }
}
