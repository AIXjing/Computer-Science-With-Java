package week6;

import java.util.HashMap;
import java.util.Map;

// different method to solve fibonacci problem
public class Fibonacci {

  // loop method: get the fibonacci value from the bottom
  public static long fabLoop(int n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    long f1 = 0;
    long f2 = 1;
    for (int i = 2; i <= n; i++) {
      long tmp = f2;
      f2 = f2 + f1;
      f1 = tmp;
      //      long tmp = f1;
      //      f1 = f2;
      //      f2 = f2 + tmp;
    }
    return f2;
  }

  // normal recursion method, which can cause exponential waste
  public static long fab(int n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    return fab(n - 1) + fab(n - 2);
  }

  // recursion method avoid exponential waste with an array

  public static long fabArray(int n) {
    long[] cache = new long[n + 1];
    return fabInner(n, cache);
  }

  public static long fabInner(int n, long[] cache) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    if (cache[n] == 0) cache[n] = fabInner(n - 1, cache) + fabInner(n - 2, cache);
    return cache[n];
  }

  // recursion method using HashMap
  private static Map<Integer, Long> cache = new HashMap<>();

  public static long fabHashMap(int n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    if (!cache.containsKey(n)) cache.put(n, fabHashMap(n - 1) + fabHashMap(n - 2));
    return cache.get(n);
  }

  public static void main(String[] args) {
    int n = 50;
    System.out.println("Using loop method: " + fabLoop(n));
    System.out.println("Using Array in recursion: " + fabArray(n));
    System.out.println("Using HashMap in recursion: " + fabHashMap(n));
    System.out.println("Using normal recursion: " + fab(n));
  }
}
