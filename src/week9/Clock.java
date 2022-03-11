// import edu.princeton.cs.algs4.StdOut;

public class Clock {
  private static final int HOURS_PER_DAY = 24;
  private static final int MINUTES_PER_HOUR = 60;
  private int h;
  private int m;

  // Creates a clock whose initial time is h hours and m minutes.
  public Clock(int h, int m) {
    if (h < 0 || h >= HOURS_PER_DAY || m < 0 || m >= MINUTES_PER_HOUR) {
      throw new IllegalArgumentException();
    }
    this.h = h;
    this.m = m;
  }

  // Creates a clock whose initial time is specified as a string, using the format HH:MM.
  public Clock(String s) {
    if (!s.matches("\\d{2}:\\d{2}")) {
      throw new IllegalArgumentException();
    }
    int inputH = Integer.parseInt(s.substring(0, 2));
    int inputM = Integer.parseInt(s.substring(3));
    if (inputH < 0 || inputH >= HOURS_PER_DAY || inputM < 0 || inputM >= MINUTES_PER_HOUR) {
      throw new IllegalArgumentException();
    }
    this.h = inputH;
    this.m = inputM;
  }

  // Returns a string representation of this clock, using the format HH:MM.
  public String toString() {
    return String.format("%02d", this.h) + ":" + String.format("%02d", this.m);
  }

  // Is the time on this clock earlier than the time on that one?
  public boolean isEarlierThan(Clock that) {
    return this.h < that.h || (this.h == that.h && this.m < that.m);
  }

  // Adds 1 minute to the time on this clock.
  public void tic() {
    if (this.m != MINUTES_PER_HOUR - 1) {
      this.m = this.m + 1;
    } else {
      if (this.h != HOURS_PER_DAY - 1) {
        this.h = this.h + 1;
      } else {
        this.h = 0;
      }
      this.m = 0;
    }
  }

  // Adds Δ minutes to the time on this clock.
  public void toc(int delta) {
    if (delta < 0) throw new IllegalArgumentException("Delta cannot be negative");
    int deltaHour = delta / HOURS_PER_DAY;
    int deltaMin = delta % HOURS_PER_DAY;

    if (this.m + deltaMin < MINUTES_PER_HOUR && this.h + deltaHour < HOURS_PER_DAY) {
      this.m = this.m + deltaMin;
      this.h = this.h + deltaHour;
    } else if (this.m + deltaMin < MINUTES_PER_HOUR && this.h + deltaHour >= HOURS_PER_DAY) {
      this.m = this.m + deltaMin;
      this.h = (this.h + deltaHour) % HOURS_PER_DAY;
    } else {
      this.m = (this.m + deltaMin) % MINUTES_PER_HOUR;
      this.h = (this.h + deltaHour + 1) % HOURS_PER_DAY;
    }
  }

  // Test client (see below).
  public static void main(String[] args) {
    if (args.length == 1) {
      Clock clock = new Clock(args[0]);
      StdOut.println(clock);
      clock.toc(80);
      StdOut.println(clock);
      clock.tic();
      StdOut.println(clock);
      StdOut.println(clock.isEarlierThan(new Clock("01:30")));
      return;
    }
    int h = Integer.parseInt(args[0]);
    int m = Integer.parseInt(args[1]);
    Clock clock = new Clock(h, m);
    StdOut.println(clock);
    clock.toc(55);
    StdOut.println(clock);
    clock.tic();
    StdOut.println(clock);
    StdOut.println(clock.isEarlierThan(new Clock("01:30")));
  }
}
