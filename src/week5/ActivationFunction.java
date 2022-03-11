package week5;

public class ActivationFunction {
  // Returns the Heaviside function of x.
  public static double heaviside(double x) {
    if (x < 0) return 0.0;
    else if (x == 0) return 0.5;
    return 1.0;
  }

  // Returns the sigmoid function of x.
  public static double sigmoid(double x) {
    return 1 / (1 + Math.exp(-x));
  }

  // Returns the hyperbolic tangent of x.
  public static double tanh(double x) {
    //    if (x > 750) return 1.0;
    //    else if (x < -750) return -1.0;
    return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
  }

  // Returns the softsign function of x.
  public static double softsign(double x) {
    return x / (1 + Math.abs(x));
  }

  // Returns the square nonlinearity function of x.
  public static double sqnl(double x) {
    if (x <= -2) return -1.0;
    else if (x < 0) return x + x * x / 4;
    else if (x < 2) return x - x * x / 4;
    else return 1.0;
  }

  // Takes a double command-line argument x and prints each activation
  // function, evaluated, in the format (and order) given below.
  public static void main(String[] args) {
    double n;
    try {
      n = Double.parseDouble(args[0]);
    } catch (NumberFormatException ignored) {
      n = Double.NaN;
    }

    double yHeaviside;
    double ySigmoid;
    double yTanh;
    double ySoftsign;
    double ySqnl;

    if (Double.isNaN(n)) {
      System.out.println("heaviside(" + args[0] + ") = NaN");
      System.out.println("sigmoid(" + args[0] + ") = NaN");
      System.out.println("tanh(" + args[0] + ") = NaN");
      System.out.println("softsign(" + args[0] + ") = NaN");
      System.out.println("sqnl(" + args[0] + ") = NaN");
    } else {
      if (n == Double.NEGATIVE_INFINITY) {
        yHeaviside = 0.0;
        ySigmoid = 0.0;
        yTanh = -1.0;
        ySoftsign = -1.0;
        ySqnl = -1.0;
      } else if (n == Double.MIN_NORMAL || n == Double.MIN_VALUE) {
        yHeaviside = 0.5;
        ySigmoid = 0.5;
        yTanh = 0.0;
        ySoftsign = 0.0;
        ySqnl = 0.0;
      } else if (n == -Double.MIN_NORMAL || n == -Double.MIN_VALUE) {
        yHeaviside = 0.5;
        ySigmoid = 0.5;
        yTanh = 0.0;
        ySoftsign = 0.0;
        ySqnl = 0.0;
      } else if (n == Double.POSITIVE_INFINITY || n == Double.MAX_VALUE) {
        yHeaviside = 1.0;
        ySigmoid = 1.0;
        yTanh = 1.0;
        ySoftsign = 1.0;
        ySqnl = 1.0;
      } else {
        yHeaviside = heaviside(n);
        ySigmoid = sigmoid(n);
        yTanh = tanh(n);
        ySoftsign = softsign(n);
        ySqnl = sqnl(n);
      }
      System.out.println("heaviside(" + args[0] + ") = " + yHeaviside);
      System.out.println("sigmoid(" + args[0] + ") = " + ySigmoid);
      System.out.println("tanh(" + args[0] + ") = " + yTanh);
      System.out.println("softsign(" + args[0] + ") = " + ySoftsign);
      System.out.println("sqnl(" + args[0] + ") = " + ySqnl);
    }
  }
}
