package part1;

public class SimpleLoop {
  /**
   * Computes the sum of integers between low and high (inclusive). Yes, this can
   * be done without a loop, but the point is to practice the syntax for a loop.
   * 
   * @param low
   * @param high
   * @return An integer that is the sum of numbers between low and high
   */
  public static int sum(int low, int high) {
    int inc_sum = 0;
    for (int i = low; i < high + 1; i++) {
      inc_sum += i;
    }
    return inc_sum;
    //return 0; // Clearly not correct
  }
}
