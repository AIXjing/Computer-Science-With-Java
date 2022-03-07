public class Huntingtons {
  // Returns the maximum number of consecutive repeats of CAG in the DNA string.
  public static int maxRepeats(String dna) {
    int index = 0;
    int counter = 0;
    int max = 0;
    int size = dna.length();
    int updatedIndex = 0;
    while (index != -1 && updatedIndex < size) {
      index = dna.indexOf("CAG", updatedIndex);
      if (index == updatedIndex || updatedIndex == 0) {
        counter++;
        if (counter > max) max = counter;
      } else {
        counter = 0;
      }
      updatedIndex = index + 3;
    }
    return max;
  }

  // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
  public static String removeWhitespace(String s) {
    String s1 = s.replace("\n", "");
    String s2 = s1.replace("\t", "");
    String sClean = s2.replace(" ", "");
    return sClean;
  }

  // Returns one of these diagnoses corresponding to the maximum number of repeats:
  // "not human", "normal", "high risk", or "Huntington's".
  public static String diagnose(int maxRepeats) {
    if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
    if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
    if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington’s";
    return "not human";
  }

  // Sample client (see below).
  public static void main(String[] args) {
    In datafile = new In(args[0]);
    String text = datafile.readAll();
    String dna = removeWhitespace(text);
    int repeat = maxRepeats(dna);
    System.out.println("max repeat = " + repeat);
    System.out.println(diagnose(repeat));
  }
}