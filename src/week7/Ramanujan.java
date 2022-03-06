package week7;

import edu.princeton.cs.algs4.StdOut;

public class Ramanujan {
  // Is n a Ramanujan number?
  public static boolean isRamanujan(long n) {
    long num = (long) Math.cbrt(n) + 1;
    int counter = 0;
    double pair = 1.0;
    for (long i = 1; i < num; i++) {
      pair = Math.cbrt(n - i * i * i);
      if (pair % 1 != 0) continue;
      for (long j = i + 1; j < num; j++) {
        if (j == pair) {
          counter++;
          if (counter >= 2) return true;
        }
      }
    }
    return false;
  }

  // Takes a long integer command-line arguments n and prints true if
  // n is a Ramanujan number, and false otherwise.
  public static void main(String[] args) {
    long n = Long.parseLong(args[0]);
    StdOut.println(isRamanujan(n));
  }
}
