// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;

public class ColorHSB {
  private final int h;
  private final int s;
  private final int b;

  // Creates a color with hue h, saturation s, and brightness b.
  public ColorHSB(int h, int s, int b) {
    this.h = h;
    this.s = s;
    this.b = b;
    if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
      throw new IllegalArgumentException();
    }
  }

  // Returns a string representation of this color, using the format (h, s, b).
  public String toString() {
    return "(" + h + ", " + s + ", " + b + ")";
  }

  // Is this color a shade of gray?
  public boolean isGrayscale() {
    if (s == 0 || b == 0) return true;
    return false;
  }

  // Returns the squared distance between the two colors.
  public int distanceSquaredTo(ColorHSB that) {
    if (that == null) {
      throw new IllegalArgumentException("The arguement is null");
    }
    return Math.min(
            (this.h - that.h) * (this.h - that.h),
            ((360 - Math.abs(this.h - that.h)) * (360 - Math.abs(this.h - that.h))))
        + (this.s - that.s) * (this.s - that.s)
        + (this.b - that.b) * (this.b - that.b);
  }

  // Sample client (see below).
  public static void main(String[] args) {
    int h = Integer.parseInt(args[0]);
    int s = Integer.parseInt(args[1]);
    int b = Integer.parseInt(args[2]);
    ColorHSB colorHSB = new ColorHSB(h, s, b);
    //    StdOut.println(colorHSB);
    //    System.out.println(colorHSB.distanceSquaredTo(new ColorHSB(0, 100, 50)));

    // read standard color file
    String closestColorHSBName = StdIn.readString();
    ColorHSB closestColorHSB = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
    int closest = colorHSB.distanceSquaredTo(closestColorHSB);
    while (!StdIn.isEmpty()) {
      String otherColorHSBName = StdIn.readString();
      ColorHSB otherColorHSB = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
      int distance = colorHSB.distanceSquaredTo(otherColorHSB);
      if (distance < closest) {
        closest = distance;
        closestColorHSBName = otherColorHSBName;
        closestColorHSB = otherColorHSB;
      }
    }
    StdOut.print(closestColorHSBName + " " + closestColorHSB);
  }
}
