package week2;

public class BandMatrix {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int distance = Integer.parseInt(args[1]);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j || Math.abs(i - j) <= distance) System.out.print("*  ");
        else {
          System.out.print("0  ");
        }
      }
      System.out.println();
    }
  }
}