public class Divisors {

  // Returns the greatest common divisor of a and b.
  public static int gcd(int a, int b) {
    if (a == 0 && b == 0) return 0;
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      int tmp = a;
      a = b;
      b = tmp % a;
    }
    return a;
  }

  // Returns the least common multiple of a and b.
  public static int lcm(int a, int b) {
    if (a == 0 || b == 0) {
      return 0;
    } else {
      int gcd = gcd(a, b);
      return Math.abs(a) * Math.abs(b) / gcd;
    }
  }

  // Returns true if a and b are relatively prime; false otherwise.
  public static boolean areRelativelyPrime(int a, int b) {
    if (gcd(a, b) == 1) return true;
    return false;
  }

  // Returns the number of integers between 1 and n that are
  // relatively prime with n.
  public static int totient(int n) {
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (areRelativelyPrime(i, n)) count++;
    }
    return count;
  }

  // Takes two integer command-line arguments a and b and prints
  // each function, evaluated in the format (and order) given below.
  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int gcd = gcd(a, b);
    System.out.println("gcd(" + a + ", " + b + ") = " + gcd);
    int lcm = lcm(a, b);
    System.out.println("lcm(" + a + ", " + b + ") = " + lcm);
    boolean areRelativelyPrime = areRelativelyPrime(a, b);
    System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime);

    int totientA = totient(a);
    System.out.println("totient(" + a + ") = " + totientA);
    int totientB = totient(b);
    System.out.println("totient(" + b + ") = " + totientB);
    //        lcm(a,b);
    //        areRelativelyPrime(a,b);
    //        totient(a);
    //        totient(b);
  }
}
