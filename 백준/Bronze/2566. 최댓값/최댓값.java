// 2566번: 최댓값

// N도 해봐야 9X9인데 그냥 반복문으로 하면 안되나?
// 1. 9X9 정수 입력받기
// 2. 2차원 배열로 파싱
// 3. 첫번째부터 비교하면서 끝까지 돌기기

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    // 1. 9X9 정수 입력받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 2. 2차원 배열로 파싱
    String[] token;
    int[][] arr = new int[9][9];
    for(int i=0; i<9; i++){
      token = br.readLine().split(" ");
      for(int j=0; j<9; j++){
        arr[i][j] = Integer.parseInt(token[j]);
      }
    }

    // 3. 첫번째부터 비교하면서 끝까지 돌기기
    int max = arr[0][0];
    int max_i = 0;
    int max_j = 0;
    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        if(arr[i][j] > max){
          max = arr[i][j];
          max_i = i;
          max_j = j;
        }
      }
    }

    // 4. 출력하기
    StringBuilder sb = new StringBuilder();
    sb.append(max).append("\n").append(max_i+1).append(" ").append(max_j+1);
    System.out.println(sb);
  }
}
