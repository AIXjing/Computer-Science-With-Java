package week2;

public class DiscreteDistribution {
  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);

    // parse args to array a[] start with a[0] = 0
    int n = args.length;
    int[] a = new int[n];
    a[0] = 0;
    for (int i = 1; i < n; i++) {
      a[i] = Integer.parseInt(args[i]);
    }

    // create array S[0]
    int[] accSum = new int[n];
    accSum[0] = 0;
    for (int i = 1; i < n; i++) {
      accSum[i] = accSum[i - 1] + a[i];
    }
    // create an indices array
    int[] indices = new int[m];
    for (int k = 0; k < m; k++) {
      // draw a random number between [0, Sn-1)
      int tmp = (int) (Math.random() * accSum[n - 1]);
      // find its index
      for (int i = 1; i < n; i++) {
        if (tmp < accSum[i] && tmp >= accSum[i - 1]) {
          indices[k] = i;
        }
      }
    }
    for (int index : indices) {
      System.out.print(index + " ");
    }
    System.out.println();
  }
}
