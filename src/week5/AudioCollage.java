public class AudioCollage {

  // Returns a new array that rescales a[] by a multiplicative factor of alpha.
  public static double[] amplify(double[] a, double alpha) {
    double[] amplified = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      amplified[i] = a[i] * alpha;
    }
    return amplified;
  }

  // Returns a new array that is the reverse of a[].
  public static double[] reverse(double[] a) {
    double[] reversed = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      reversed[i] = a[a.length - i - 1];
    }
    return reversed;
  }

  // Returns a new array that is the concatenation of a[] and b[].
  public static double[] merge(double[] a, double[] b) {
    double[] merge = new double[a.length + b.length];
    for (int i = 0; i < a.length; i++) {
      merge[i] = a[i];
    }
    for (int j = a.length; j < merge.length; j++) {
      merge[j] = b[j - a.length];
    }
    return merge;
  }

  // Returns a new array that is the sum of a[] and b[],
  // padding the shorter arrays with trailing 0s if necessary.
  public static double[] mix(double[] a, double[] b) {
    double[] mixed = new double[Math.max(a.length, b.length)];
    if (a.length >= b.length) {
      for (int i = 0; i < mixed.length; i++) {
        if (i < b.length) {
          mixed[i] = a[i] + b[i];
        } else {
          mixed[i] = a[i] + 0;
        }
      }
    } else {
      for (int i = 0; i < mixed.length; i++) {
        if (i < a.length) {
          mixed[i] = a[i] + b[i];
        } else {
          mixed[i] = b[i] + 0;
        }
      }
    }
    return mixed;
  }

  // Returns a new array that changes the speed by the given factor.
  public static double[] changeSpeed(double[] a, double alpha) {
    int length = (int) (a.length / alpha);
    double[] changeSpeed = new double[length];
    for (int i = 0; i < length; i++) {
      changeSpeed[i] = a[(int) (i * alpha)];
    }
    return changeSpeed;
  }

  // Returns a trimmed array between ath second and bth second
  private static double[] trim(double[] a, int x, int y) {
    int start = 44100 * x;
    int end = 44100 * y;
    double[] trim = new double[44100 * (y - x)];
    for (int i = 0; i < end - start; i++) {
      trim[i] = a[i + start];
    }
    return trim;
  }

  // Creates an audio collage and plays it on standard audio.
  // See below for the requirements.
  public static void main(String[] args) {
    double[] cow = StdAudio.read("cow.wav");
    //    double[] cowEdited =
    //        changeSpeed(merge(merge(trim(cow, 1, 2), trim(cow, 1, 2)), trim(cow, 1, 4)), 1.2);
    //        StdAudio.play(cowEdited);
    //
    double[] exposure = StdAudio.read("exposure.wav");
    //
    double[] piano = StdAudio.read("piano.wav");
    //    double[] pianoEdited = changeSpeed(merge(piano, reverse(piano)), 0.8);

    double[] beatBox = StdAudio.read("beatbox.wav");
    double[] beatBoxRep2 = merge(beatBox, beatBox);
    double[] dialup = StdAudio.read("dialup.wav");
    StdAudio.play(merge(changeSpeed(trim(cow, 1, 4), 1.2), beatBox));
    StdAudio.play(mix(mix(amplify(beatBoxRep2, 1.2), changeSpeed(piano, 0.8)), trim(dialup, 0, 4)));
    StdAudio.play(mix(changeSpeed(reverse(piano), 0.7), trim(exposure, 2, 10)));
  }
}
