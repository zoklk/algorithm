// 11005번: 진법 변환 2

// 1. <10진법 수> N과 <B진법> B를 입력받는다.
// 2. 진법 전환 연산을 수행한다.


import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;  ->  레거시 코드
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    // 1. <10진법 수> N과 <B진법> B를 입력받는다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    int N = Integer.parseInt(arr[0]);
    int B = Integer.parseInt(arr[1]);

    // 2. 진법 전환 연산을 수행한다.
    StringBuilder sb = new StringBuilder();
    while(N>0){
      int temp = N % B;
      if (temp >= 10) sb.append((char) (temp-10+'A'));
      else sb.append(temp);

      N = N / B;
    }
    System.out.println(sb.reverse());
  }
}