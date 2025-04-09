import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException{
    // 1. 첫째 줄에서 N을 입력받는다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 2. loop 이용하여 N개의 숫자를 배열에 넣는다.
    int[] arr = new int[N];
    for(int i=0; i<N; i++){
      arr[i]=Integer.parseInt(br.readLine());
    }

    // 3. mergesort
    mergeSort(arr);

    // 4. 출력하기
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<N; i++){
      sb.append(arr[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static void mergeSort(int[] arr){
    int[] temp = new int[arr.length];

    sort(arr, 0, arr.length, temp);
  }

  private static void sort(int[] arr, int low, int high, int[] temp){
    if((high-low) < 2) return;

    int mid = (low+high)/2;
    sort(arr, low, mid, temp);
    sort(arr, mid, high, temp);
    merge(arr, low, mid, high, temp);
  }

  private static void merge(int[] arr, int low, int mid, int high, int[] temp){
    int t=low, l=low, r=mid;

    while(l<mid && r<high) temp[t++] = (arr[l] <= arr[r]) ? arr[l++] : arr[r++];
    while(l<mid) temp[t++] = arr[l++];
    while(r<high) temp[t++] = arr[r++];

    for(int i=low; i<high; i++){
      arr[i]=temp[i];
    }
  }
}