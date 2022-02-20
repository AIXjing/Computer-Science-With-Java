package week1;

public class RightTriangle {

  public static void main(String[] args) {
    // boolean isRightTriangle = false;

    int num1 = Integer.parseInt(args[0]);
    int num2 = Integer.parseInt(args[1]);
    int num3 = Integer.parseInt(args[2]);

    int min = Math.min(num1, Math.min(num2, num3));
    int max = Math.max(num1, Math.max(num2, num3));
    int median = num1 + num2 + num3 - min - max;

    boolean isRightTriangle =
        ((min * min + median * median) == max * max) && (num1 > 0) && (num2 > 0) && (num3 > 0);

    System.out.println(isRightTriangle);
  }
}
