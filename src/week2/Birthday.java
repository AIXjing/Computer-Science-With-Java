package week2;

public class Birthday {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]); // number of possible birthdays
    int trials = Integer.parseInt(args[1]);

    // create an array to record birthday of peoples who have entered room
    int[] countNthEnter = new int[n];

    for (int k = 0; k < trials; k++) {
      int[] birthDateInRoom = new int[n]; // the worse case is n different birthday in room

      for (int i = 0; i < n; i++) {
        birthDateInRoom[i] = (int) (Math.random() * (n - 1));
        // check whether the newly coming person has the same birthday to those already in the room
        boolean isNotExisted = true;
        int j = 0;
        while (isNotExisted && (j < i)) {
          isNotExisted = birthDateInRoom[j] != birthDateInRoom[i];
          j++;
        }
        // if there is the same birthday, count the number of this person and repeat
        if (!isNotExisted) {
          countNthEnter[i]++;
          break;
        }
      }
    }

    // calculate probability of nth people entering the room encounters the same birthday.
    double[] fraction = new double[n];
    double[] accumCount = new double[n];
    for (int i = 1; i < n; i++) {
      accumCount[i] = countNthEnter[i] + accumCount[i - 1];
      fraction[i] = accumCount[i] / (double) trials;
    }

    // print out until the probability over 0.5.
    boolean isOverHalf = true;
    int i = 0;
    while (isOverHalf && (i < (countNthEnter.length))) {
      System.out.println((i + 1) + " " + countNthEnter[i] + " " + fraction[i]);
      isOverHalf = (fraction[i] < 0.5);
      i++;
    }
  }
}
