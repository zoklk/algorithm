// 조건
// N: 수의 개수
// M: 합을 구해야 하는 횟수
// 수는 1 <= x <= 1000인 자연수
// 3번째 줄부터 합을 구하는 범위 i, j

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] numbers;
  public static void main(String[] args) throws IOException{
    // 1번째 줄을 읽고, N 과 M에 값 할당하기기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 2번째 줄을 읽고, 배열에 누적합의 형태로 저장하기기
    numbers = new int[n+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=n; i++){
      numbers[i] = numbers[i-1] + Integer.parseInt(st.nextToken());
    }

    // i, j 범위에 따른 합 구하기
    StringBuilder sb = new StringBuilder();
    for (int x=1; x<=m; x++){
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int result = numbers[j] - numbers[i-1];
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }
}
