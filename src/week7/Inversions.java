package week7;

import edu.princeton.cs.algs4.StdOut;

public class Inversions {
  // Return the number of inversions in the permutation a[].
  public static long count(int[] a) {
    long counter = 0;
    int arrLen = a.length;
    for (int i = 0; i < arrLen; i++) {
      for (int j = i + 1; j < arrLen; j++) {
        if (i < j && a[i] > a[j]) {
          counter++;
        }
      }
    }
    return counter;
  }

  // Return a permutation of length n with exactly k inversions.
  public static int[] generate(int n, long k) {
    int[] arr = new int[n];
    int counter = 1;
    long newk = k;
    // corner case
    if (k == n * (n - 1) / 2) {
      for (int i = 0; i < n; i++) {
        arr[i] = n - i - 1;
      }
      return arr;
    }
    while (newk >= (n - counter)) {
      arr[counter - 1] = n - counter;
      newk = newk - n + counter;
      counter++;
    }
    int index = n - (int) newk - 1;
    arr[index] = n - counter;
    for (int i = counter - 1; i < index; i++) {
      arr[i] = i - counter + 1;
    }
    for (int i = index + 1; i < n; i++) {
      arr[i] = i - counter;
    }
    return arr;
  }

  // Takes an integer n and a long k as command-line arguments,
  // and prints a permutation of length n with exactly k inversions.
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    long k = Long.parseLong(args[1]);
    int[] arr = generate(n, k);
    for (int i = 0; i < n; i++) {
      StdOut.print(arr[i] + " ");
    }
    StdOut.println();
  }
}
