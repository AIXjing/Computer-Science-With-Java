public class RevesPuzzle {

  private static void revesPuzzle(int n, char poleA, char poleB, char poleC, char poleD) {
    if (n == 1) {
      System.out.println("Move disc " + n + " from " + poleA + " to " + poleD);
      return;
    }
    int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));
    revesPuzzle(k, poleA, poleD, poleC, poleB);
    hanoi(n - k, k, poleA, poleC, poleD);
    revesPuzzle(k, poleB, poleA, poleC, poleD);
  }

  private static void hanoi(int n, int k, char start, char mid, char end) {
    int nPlusK = n + k;
    if (n > 0) {
      hanoi(n - 1, k, start, end, mid);
      System.out.println("Move disc " + nPlusK + " from " + start + " to " + end);
      hanoi(n - 1, k, mid, start, end);
    }
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    revesPuzzle(n, 'A', 'B', 'C', 'D');
  }
}
