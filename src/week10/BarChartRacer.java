import java.util.Arrays;

/**
 * The {@code BarChart} class represents a library for drawing static bar chart. It supports adding
 * a bar (with a specified name, value, and category) and drawing all of the bars to the screen
 * using standard draw. The bars are drawn horizontally (in the order in which they are added from
 * top to bottom) and colored according to the category. The name and value of the bar and drawn
 * with the bar.
 *
 * @author Kevin Wayne
 */
public class BarChartRacer {
  public static void main(String[] args) {

    // step 1: read file
    String filename = args[0];
    In in = new In(filename);
    int k = Integer.parseInt(args[1]);

    StdDraw.setCanvasSize(1000, 700);
    StdDraw.enableDoubleBuffering();

    String title = in.readLine();
    String xAxis = in.readLine();
    String source = in.readLine();
    BarChart chart = new BarChart(title, xAxis, source);
    // step 1: read data
    while (in.hasNextLine()) {
      // create a bar char
      // read and store data in a bar array for reach year
      in.readLine();
      int n = Integer.parseInt(in.readLine());
      Bar[] bars = new Bar[n];
      String year = ""; // year in the data file
      for (int i = 0; i < n; i++) {
        // parse parameters to create a new bar object
        String record = in.readLine();
        String[] records = record.split(",");
        year = records[0];
        String city = records[1];
        int value = Integer.parseInt(records[3]);
        String category = records[4];
        bars[i] = new Bar(city, value, category);
      }
      Arrays.sort(bars);
      chart.setCaption(year);
      for (int i = bars.length - 1; i > bars.length - k - 1; i--) {
        chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
      }

      // draw the bar chart
      StdDraw.clear();
      chart.draw();
      StdDraw.show();
      StdDraw.pause(2);
      chart.reset();
    }
    chart.reset();
  }
}
