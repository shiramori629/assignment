/*
 * The given code is provided to assist you to complete the required tasks. But the given code is
 * often incomplete. You have to read and understand the given code carefully, before you can apply
 * the code properly.
 */


/*
 * Please review Lecture 7 Algorithms Part III, slides 10-14 to complete this task.
 */

/*
 * EditCost defines three character edit costs. INSERT and DELETE will cost 1, and REPLACE will cost
 * 2. Do not modify the character edit costs. Otherwise, your answers will not be marked correctly.
 */
enum EditCost {
  INSERT(1), DELETE(1), REPLACE(2);

  private final int costValue;

  EditCost(int value) {
    this.costValue = value;
  }

  public int getEditCost() {
    return this.costValue;
  }
}


public class EditDistance {


  /*
   * This method computes the minimal total cost of a sequence of character edits between two
   * strings. The costs of character edits are defined in EditCost enum
   * 
   * @param seq1 the original string.
   * 
   * @param seq2 the target string.
   * 
   * @return the minimal cost of the character edits.
   */
  public static int minDistance(String seq1, String seq2) {
    // TODO: Complete this method
    // START YOUR CODE
    if (seq1.equals(seq2)) {
      return 0;
    }
    int cost;
    int size1 = seq1.length();
    int size2 = seq2.length();
    int[][] array = new int[size1 + 1][size2 + 1];
    array[0][0] = 0;

    for (int i = 1; i < size1 + 1; i++) {
      array[i][0] = i;
    }

    for (int j = 1; j < size2 + 1; j++) {
      array[0][j] = j;
    }

    for (int i = 1; i < size1 + 1; i++) {
      for (int j = 1; j < size2 + 1; j++) {
        if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
          cost = 0;
        } else {
          cost = EditCost.REPLACE.getEditCost();
        }
        int a = array[i - 1][j] + EditCost.INSERT.getEditCost();
        int b = array[i][j - 1] + EditCost.DELETE.getEditCost();
        int c = array[i - 1][j - 1] + cost;
        int min = a;
        if (a < b) {
          if (c < a)
            min = c;
        } else {
          min = b;
          if (c < b)
            min = c;
        }
        array[i][j] = min;
      }
    }
    return array[size1][size2];
    // END YOUR CODE

  }
}
