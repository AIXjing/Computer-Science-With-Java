public class MaximumSquareSubmatrix {
  // Returns the size of the largest contiguous square submatrix
  // of a[][] containing only 1s.
  public static int size(int[][] a) {
    int largest = 0;
    int[][] dp = new int[a.length + 1][a.length + 1];
    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= a.length; j++) {
        if (a[i - 1][j - 1] == 1) {
          int min1 = Math.min(dp[i][j - 1], dp[i - 1][j]);
          dp[i][j] = Math.min(min1, dp[i - 1][j - 1]) + 1;
        }
        if (dp[i][j] > largest) largest = dp[i][j];
      }
    }
    return largest;
  }

  // Reads an n-by-n matrix of 0s and 1s from standard input
  // and prints the size of the largest contiguous square submatrix
  // containing only 1s.
  public static void main(String[] args) {
    int size = StdIn.readInt();
    int[][] matrix = new int[size][size];
    int index = 0;
    while (!StdIn.isEmpty()) {
      for (int i = 0; i < size; i++) {
        matrix[index][i] = StdIn.readInt();
      }
      index++;
    }
    System.out.println(size(matrix));
    //
    //    for (int i = 0; i < size; i++) {
    //      for (int j = 0; j < size; j++) {
    //        System.out.print(matrix[i][j] + "  ");
    //      }
    //      System.out.println();
    //    }
  }
}
