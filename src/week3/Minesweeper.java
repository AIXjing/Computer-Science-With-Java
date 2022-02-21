package week3;

public class Minesweeper {
  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    int k = Integer.parseInt(args[2]);

    char[][] matrix = new char[m][n]; // create a mxn matrix
    // generate k mines in the matrix
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = '0';
      }
    }
    int mineLeft = k;
    while (mineLeft > 0) {
      int randRow = (int) (Math.random() * m);
      int randCol = (int) (Math.random() * n);
      if (matrix[randRow][randCol] != '*') {
        matrix[randRow][randCol] = '*';
        mineLeft--;
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '*') {
          for (int row = i - 1; row <= i + 1; row++) {
            for (int col = j - 1; col <= j + 1; col++) {
              if ((row == i && col == j) || row < 0 || col < 0 || row >= m || col >= n) {
                continue;
              }
              if (matrix[row][col] == '*') {
                continue;
              }
              matrix[row][col]++;
            }
          }
        }
      }
    }

    // print out the matrix
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + "  ");
      }
      System.out.println();
    }
  }
}
