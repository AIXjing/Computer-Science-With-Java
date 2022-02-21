package week2;

public class GeneralizedHarmonic {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double r = Double.parseDouble(args[1]);

    double harm = 0.0;
    for (double i = 1.0; i < n + 1; i = i + 1.0) {
      harm = harm + 1.0 / Math.pow(i, r);
    }

    System.out.println(harm);
  }
}
