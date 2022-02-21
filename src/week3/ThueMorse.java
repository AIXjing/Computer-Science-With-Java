package week3;

public class ThueMorse {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    // create a Thue-Morse Array
    int[] tmArrays = new int[n];
    tmArrays[0] = 0;
    for (int k = 1; k < n; k++) {
      if (k % 2 == 0) tmArrays[k] = tmArrays[k / 2];
      else {
        tmArrays[k] = 1 - tmArrays[(k - 1) / 2];
      }
    }

    // create 2D arrays to print nxn matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (tmArrays[i] == tmArrays[j]) {
          System.out.print("+  ");
        } else System.out.print("-  ");
      }
      System.out.println();
    }
  }
}
