package week1;

public class random5 {

  public static void main(String[] args) {
    // write your code here
    double n1 = Math.random();
    double n2 = Math.random();
    double n3 = Math.random();
    double n4 = Math.random();
    double n5 = Math.random();
    System.out.println(n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5);

    double avg = (n1 + n2 + n3 + n4 + n5) / 5;
    System.out.println("mean: " + avg);
    double min = Math.min(n1, Math.min(n2, Math.min(n3, Math.min(n4, n5))));
    System.out.println("min: " + min);
    double max = Math.max(n1, Math.max(n2, Math.max(n3, Math.max(n4, n5))));
    System.out.println("max: " + max);
  }
}
