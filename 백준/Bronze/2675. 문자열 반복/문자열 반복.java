// 문자열 S를 입력받아서 각 문자를 R번 반복하여 출력
// T: 테스트 케이스 (T<=1000)
// S: 문자열
// R: 문자 반복 횟수

// 1. T(테스트 케이스)를 입력받아 반복한다.
// 2. <문자열>을 입력받아서 <R>번 반복한다
// 3. 출력한다.

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 1. T(테스트 케이스)를 입력받아 반복한다.
    int T = Integer.parseInt(br.readLine().trim());
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<T; i++){
      String[] token = br.readLine().split(" ");
      int R = Integer.parseInt(token[0]);
      String S = token[1];

      // 2. <문자열>을 입력받아서 <R>번 반복한다
      for (char c: S.toCharArray()){
        sb.append(String.valueOf(c).repeat(R));
      }
      sb.append("\n");
    }
    // 3. 출력한다.
    System.out.println(sb.toString());
  }
}
