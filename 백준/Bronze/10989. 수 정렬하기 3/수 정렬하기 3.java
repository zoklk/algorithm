import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // 1. N을 입력받아서 testcase의 크기 확보
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());

    // 2. 숫자 범위가 1 ~ 10000이므로 크기 10001
    int[] count = new int[10001];

    // 3. 입력 받은 숫자 개수 카운트
    for (int i = 0; i < N; i++) {
        count[Integer.parseInt(br.readLine())]++;
    }

    // 4. 출력 최적화
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < 10001; i++) {
        while (count[i]-- > 0) {
            sb.append(i).append("\n");
        }
    }

    System.out.print(sb);
  }
}