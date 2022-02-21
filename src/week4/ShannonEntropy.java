package week4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShannonEntropy {

  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);

    double[] countNum = new double[m + 1];

    int tot = 0;
    while (!StdIn.isEmpty()) {
      int x = StdIn.readInt();
      countNum[x]++;
      tot++;
    }

    double sum = 0.0;
    for (int i = 1; i <= m; i++) {
      double term;
      if (countNum[i] == 0) {
        term = 0;
      } else {
        double prob = countNum[i] / (double) tot;
        term = -prob * ((Math.log(prob) / Math.log(2.0)));
      }
      sum = sum + term;
    }
    StdOut.printf("%.4f\n", sum);
  }
}
