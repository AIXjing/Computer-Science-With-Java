public class TrinomialDP {
  // using dynamic programming

  public static long trinomial(int n, int k) {
    long[] cacheOld = new long[2 * n + 2];
    long[] cacheCurr = new long[2 * n + 2];
    cacheOld[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= i; j++) {
        cacheCurr[j] = cacheOld[Math.abs(j - 1)] + cacheOld[j] + cacheOld[j + 1];
      }
      long[] tmp = cacheOld;
      cacheOld = cacheCurr;
      cacheCurr = tmp;
      // empty cacheCurr
      for (int j = 0; j <= i; j++) {
        cacheCurr[j] = 0;
      }
    }
    return cacheOld[Math.abs(k)];
  }

  // Takes two integer command-line arguments n and k and prints T(n, k).
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    System.out.println(trinomial(n, k));
  }
}
