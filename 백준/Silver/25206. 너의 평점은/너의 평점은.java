// 1. 20줄 입력받아서 학점, 평점 토큰 나누기
// 2. 평점 파싱하기
// 3. 학점 X 평점 과 학점 합 구하기
//    +. 평점이 P인경우 제외하기
// 4. 평균 평점 구하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  static double time;       //학점
  static double rating;     //평점
  static double temp_t = 0; //학점 임시합
  static double temp_r = 0; //평점 임시합합

  private static final Map<String, Double> gradeMap = new HashMap<>();
  static {
    gradeMap.put("A+", 4.5);
    gradeMap.put("A0", 4.0);
    gradeMap.put("B+", 3.5);
    gradeMap.put("B0", 3.0);
    gradeMap.put("C+", 2.5);
    gradeMap.put("C0", 2.0);
    gradeMap.put("D+", 1.5);
    gradeMap.put("D0", 1.0);
    gradeMap.put("F", 0.0);
    gradeMap.put("P", -1.0);
  }

  public static void main(String[] args) throws IOException{
    for(int i=0; i<20; i++){
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      time = Double.parseDouble(st.nextToken());
      rating = gradeMap.get(st.nextToken());
      if(rating >= 0){
        temp_t += time;
        temp_r += time*rating; 
      }
    }
    System.out.println(temp_r/temp_t);  //printf와 println은 8ms정도의 차이가 발생
  }
}
