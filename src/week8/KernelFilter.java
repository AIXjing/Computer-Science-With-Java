package week8;

import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class KernelFilter {
  // Returns a new picture that applies the identity filter to the given picture.
  public static Picture identity(Picture picture) {
    double[][] kernel = new double[3][3];
    kernel[1][1] = 1;

    Picture identity = kernel(picture, kernel);
    return identity;
  }

  // Returns a new picture that applies a Gaussian blur filter to the given picture.
  public static Picture gaussian(Picture picture) {
    double[][] kernel = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        kernel[i][j] = kernel[i][j] * (1.0 / 16);
      }
    }
    Picture gaussian = kernel(picture, kernel);
    return gaussian;
  }

  // Returns a new picture that applies a sharpen filter to the given picture.
  public static Picture sharpen(Picture picture) {
    double[][] kernel = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
    Picture sharpened = kernel(picture, kernel);
    return sharpened;
  }

  // Returns a new picture that applies an Laplacian filter to the given picture.
  public static Picture laplacian(Picture picture) {
    double[][] kernel = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
    Picture lap = kernel(picture, kernel);
    return lap;
  }

  // Returns a new picture that applies an emboss filter to the given picture.
  public static Picture emboss(Picture picture) {
    double[][] kernel = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
    Picture emposs = kernel(picture, kernel);
    return emposs;
  }

  // Returns a new picture that applies a motion blur filter to the given picture.
  public static Picture motionBlur(Picture picture) {
    double[][] kernel = new double[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (i == j) kernel[i][j] = 1.0 / 9.0;
      }
    }
    Picture motionBlur = kernel(picture, kernel);
    return motionBlur;
  }

  private static Picture kernel(Picture picture, double[][] weights) {
    int width = picture.width();
    int height = picture.height();
    Picture filteredPic = new Picture(width, height);

    // for pixel in the inside
    for (int col = 0; col < width; col++) {
      for (int row = 0; row < height; row++) {
        double updatedRed = 0.0;
        double updatedGreen = 0.0;
        double updatedBlue = 0.0;

        // for kernel = 3x3
        if (weights.length == 3) {
          for (int i = col - 1; i <= col + 1; i++) {
            for (int j = row - 1; j <= row + 1; j++) {
              updatedRed =
                  picture.get((i + width) % width, (j + height) % height).getRed()
                          * weights[i - (col - 1)][j - (row - 1)]
                      + updatedRed;
              updatedGreen =
                  picture.get((i + width) % width, (j + height) % height).getGreen()
                          * weights[i - (col - 1)][j - (row - 1)]
                      + updatedGreen;
              updatedBlue =
                  picture.get((i + width) % width, (j + height) % height).getBlue()
                          * weights[i - (col - 1)][j - (row - 1)]
                      + updatedBlue;
            }
          }
        } else if (weights.length == 9) {
          for (int i = col - 4; i <= col + 4; i++) {
            for (int j = row - 4; j <= row + 4; j++) {
              updatedRed =
                  picture.get((i + width) % width, (j + height) % height).getRed()
                          * weights[i - (col - 4)][j - (row - 4)]
                      + updatedRed;
              updatedGreen =
                  picture.get((i + width) % width, (j + height) % height).getGreen()
                          * weights[i - (col - 4)][j - (row - 4)]
                      + updatedGreen;
              updatedBlue =
                  picture.get((i + width) % width, (j + height) % height).getBlue()
                          * weights[i - (col - 4)][j - (row - 4)]
                      + updatedBlue;
            }
          }
        }

        if (updatedRed > 255) updatedRed = 255;
        if (updatedRed < 0) updatedRed = 0;
        if (updatedGreen > 255) updatedGreen = 255;
        if (updatedGreen < 0) updatedGreen = 0;
        if (updatedBlue > 255) updatedBlue = 255;
        if (updatedBlue < 0) updatedBlue = 0;
        filteredPic.set(
            col,
            row,
            new Color(
                (int) Math.round(updatedRed),
                (int) Math.round(updatedGreen),
                (int) Math.round(updatedBlue)));
      }
    }
    return filteredPic;
  }

  // Test client (ungraded).
  public static void main(String[] args) {
    Picture image = new Picture("resources/DataType/image/6-by-5.png");
    identity(image).show();
    sharpen(image).show();
    emboss(image).show();
    gaussian(image).show();
    laplacian(image).show();
    motionBlur(image).show();
  }
}
