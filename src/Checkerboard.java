public class Checkerboard {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    StdDraw.setScale(0, n);
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledSquare(n, n, n);

    StdDraw.setPenColor(StdDraw.BLUE);
    for (int i = 0; i < n; i = i + 2) {
      for (int j = 0; j < n; j = j + 2) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
      }
    }

    for (int i = 1; i < n; i = i + 2) {
      for (int j = 1; j < n; j = j + 2) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
      }
    }
  }
}
