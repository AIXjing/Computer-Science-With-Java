package week4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class WorldMap {
  public static void main(String[] args) {
    //    StdDraw.enableDoubleBuffering();
    int width = StdIn.readInt();
    int height = StdIn.readInt();
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);

    while (!StdIn.isEmpty()) {
      StdIn.readString();
      int vertices = StdIn.readInt();
      double[] x = new double[vertices];
      double[] y = new double[vertices];
      for (int i = 0; i < vertices; i++) {
        x[i] = StdIn.readDouble();
        y[i] = StdIn.readDouble();
      }
      StdDraw.polygon(x, y);
    }
  }
}
