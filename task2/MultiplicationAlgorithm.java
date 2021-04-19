/*
 * The given code is provided to assist you to complete the required tasks. But the given code is
 * often incomplete. You have to read and understand the given code carefully, before you can apply
 * the code properly.
 */


/*
 * Please review Lecture 5 Algorithms Part I, slide 49 to complete this task.
 */

public class MultiplicationAlgorithm {

  /**
   * Using divide-and-conquer to implement the Karatsuba multiplication to compute the product x
   * times y. x and y are two n-digit input numbers.
   *
   * @param input x
   * @param input y
   */
  public static long KMultiply(long x, long y) {
    // TODO: Complete this method
    tracker.calltracking(x, y); // Do not modify this method. Otherwise, you will be penalized for
                                // violation.
    // START YOUR CODE
    if (x < 10 || y < 10)
      return x * y;

    int x_size = String.valueOf(x).length();
    int y_size = String.valueOf(y).length();
    int halfn = Math.max(x_size, y_size) / 2;

    long a = Long.parseLong(String.valueOf(x).substring(0, x_size - halfn));
    long b = Long.parseLong(String.valueOf(x).substring(x_size - halfn));
    long c = Long.parseLong(String.valueOf(y).substring(0, y_size - halfn));
    long d = Long.parseLong(String.valueOf(y).substring(y_size - halfn));

    long e = KMultiply(a, c);
    long f = KMultiply(b, d);
    long g = KMultiply((a + b), (c + d)) - f - e;
    return (long) (e * Math.pow(10, (2 * halfn)) + g * Math.pow(10, halfn) + f);

    // END YOUR CODE
  }
}
