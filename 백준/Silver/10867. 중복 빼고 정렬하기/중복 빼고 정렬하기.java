import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    // 1. N과 배열을 입력받는다.
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    String[] token=br.readLine().trim().split(" ");

    // 2. 숫자를 입력받아서 arr에 int로 파싱
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i]=Integer.parseInt(token[i]);
    }

    // 3. arr를 정렬한다.
    quickSort(arr, 0, n-1);

    // 4. for를 이용하여 중복을 제외하고 출력한다.
    int key=-1001;
    // +) stringBuilder사용
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<n; i++){
      if(key != arr[i]){
        sb.append(arr[i]).append(" ");
        key=arr[i];
      }
    }
    System.out.println(sb);
  }

  // quick sort 구현
  public static void quickSort(int[] arr, int left, int right){
    if(left>=right){
      return;
    }
    int pi=partition(arr, left, right);
    quickSort(arr,left,pi-1);
    quickSort(arr,pi,right);
  }

  public static int partition(int[] arr, int left, int right){
    int pivot=arr[(left+right)/2];
    
    while(left<=right){
      while(arr[left]<pivot) left++;          // arr[left]<=pivot 으로 할 경우 [5, 5, 5, 5, 5]같은 배열에서 idx를 넘을 수 있다.
      while(arr[right]>pivot) right--;
      if(left<=right){
        swap(arr,left,right);
        left++;
        right--;
      }
    }
    return left;
  }

  public static void swap(int[] arr, int left, int right){
    int temp=arr[left];
    arr[left]=arr[right];
    arr[right]=temp;
  }
}