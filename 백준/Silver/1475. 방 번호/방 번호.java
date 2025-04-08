import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    // 1. 방 번호 입력받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String number = br.readLine();

    // 2. 입력받은 번호를 배열로 치환하기
    int[] arr=new int[number.length()];
    for(int i=0; i<number.length(); i++){
      arr[i]=number.charAt(i) - '0';
    }

    // 3. counting sort를 활용하여 숫자열 세트 수 구하기
    int[] count=new int[10];
    for(int i=0; i<arr.length; i++){
      count[arr[i]]++;
    }
    // 3-1. 6과 9처리리
    int sixNine=count[6]+count[9];
    count[6]=count[9]=(sixNine+1)/2;
    // 3-2. 최댓값 구하기
    int max=0;
    for (int c : count){
      if (c>max) max=c;
    }

    System.out.println(max);
  }
}
