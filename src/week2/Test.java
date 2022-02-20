package week2;

public class Test {

  public static void main(String[] args) {
    int[] a = new int[10];

    System.out.println("a1");
    for (int i = 0; i < 10; i++) {
      a[i] = 9 - i;
      System.out.println(a[i]);
    }

    System.out.println("a2");
    for (int i = 0; i < 10; i++) {
      a[i] = a[a[i]];
      System.out.println("a[" + i + "]" + a[i]);
    }

    System.out.println(a[5]);
  }
}
