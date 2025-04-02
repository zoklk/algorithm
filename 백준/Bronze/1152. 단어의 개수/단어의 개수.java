import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine().trim();
    if (line.isEmpty()){
      System.out.println(0);
    }
    else {
      String[] token = line.split(" ");
      System.out.println(token.length);
    }
  }
}