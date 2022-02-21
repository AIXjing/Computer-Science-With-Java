package week2;

public class RandomWalker {
  public static void main(String[] args) {
    int md = Integer.parseInt(args[0]);

    int x = 0;
    int y = 0;
    int steps = 0;
    while (Math.abs(x) + Math.abs(y) < md) {
      double rand = Math.random();
      if (rand < 0.25) x++;
      else if (rand < 0.5) x--;
      else if (rand < 0.75) y++;
      else y--;
      steps++;
      System.out.println("(" + x + ", " + y + ")");
    }
    System.out.print("steps=" + steps);
  }
}
