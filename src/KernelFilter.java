import java.awt.*;

public class KernelFilter {
  // Returns a new picture that applies the identity filter to the given picture.
  public static Picture identity(Picture picture) {
    int[][] kernel = new int[3][3];
    kernel[1][1] = 1;

    int width = picture.width();
    int height = picture.height();
    Picture copy = new Picture(width, height);
    int red = 0;
    int green = 0;
    int blue = 0;
    Color color;

    for (int col = 0; col < width; col++) {
      for (int row = 0; row < height; row++) {
        color = picture.get(col, row);
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        Color identityColor = new Color(red, green, blue);
        copy.set(col, row, identityColor);
        //        System.out.println(picture.get(col, row));
      }
    }

    return copy;
  }

  // Returns a new picture that applies a Gaussian blur filter to the given picture.
  public static Picture gaussian(Picture picture) {
    Picture copy = new Picture("pipe.png");
    return copy;
  }

  // Returns a new picture that applies a sharpen filter to the given picture.
  public static Picture sharpen(Picture picture) {
    double[][] kernel = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
    Picture sharpened = kernel(picture, kernel);
    return sharpened;
  }

  // Returns a new picture that applies an Laplacian filter to the given picture.
  public static Picture laplacian(Picture picture) {
    Picture copy = new Picture("pipe.png");
    return copy;
  }

  // Returns a new picture that applies an emboss filter to the given picture.
  public static Picture emboss(Picture picture) {
    double[][] kernel = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
    Picture emposs = kernel(picture, kernel);
    return emposs;
  }

  // Returns a new picture that applies a motion blur filter to the given picture.
  public static Picture motionBlur(Picture picture) {
    double[][] kernel = {{1.0 / 3.0, 0, 0}, {0, 1.0 / 3.0, 0}, {0, 0, 1.0 / 3.0}};
    Picture motionBlur = kernel(picture, kernel);
    return motionBlur;
  }

  private static Picture kernel(Picture picture, double[][] weights) {
    int width = picture.width();
    int height = picture.height();
    Picture filteredPic = new Picture(width, height);

    for (int col = 1; col < width - 1; col++) {
      for (int row = 1; row < height - 1; row++) {
        int updatedRed = 0;
        int updatedGreen = 0;
        int updatedBlue = 0;
        for (int i = col - 1; i <= col + 1; i++) {
          for (int j = row - 1; j <= row + 1; j++) {
            updatedRed =
                (int) Math.round(picture.get(i, j).getRed() * weights[i - (col - 1)][j - (row - 1)])
                    + updatedRed;
            updatedGreen =
                (int)
                        Math.round(
                            picture.get(i, j).getGreen() * weights[i - (col - 1)][j - (row - 1)])
                    + updatedGreen;
            updatedBlue =
                (int)
                        Math.round(
                            picture.get(i, j).getBlue() * weights[i - (col - 1)][j - (row - 1)])
                    + updatedBlue;
          }
        }
        if (updatedRed > 255) updatedRed = 255;
        if (updatedRed < 0) updatedRed = 0;
        if (updatedGreen > 255) updatedGreen = 255;
        if (updatedGreen < 0) updatedGreen = 0;
        if (updatedBlue > 255) updatedBlue = 255;
        if (updatedBlue < 0) updatedBlue = 0;
        filteredPic.set(col, row, new Color(updatedRed, updatedGreen, updatedBlue));
      }
    }
    return filteredPic;
  }

  // Test client (ungraded).
  public static void main(String[] args) {
    Picture image = new Picture("src/pipe.png");
    //    identity(image).show();
    //    sharpen(image).show();
    //    emboss(image).show();
    motionBlur(image).show();
  }
}
