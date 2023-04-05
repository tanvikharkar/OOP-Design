package part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> highScoringStudents = new LinkedList<>();
    int score = 0;
    int count = 0;
    int tot_score = 0;

    /*
     * Build a list of the names of applicants who have scores strictly greater than
     * the given threshold.
     */
    for (Map.Entry<String, List<CourseGrade>> current : scoresByApplicantName.entrySet()) {
      List<CourseGrade> scores = current.getValue();
      for (CourseGrade course : scores) {
        score = course.getScore();    // Iterate through scores
        if (score < scoreThreshold) {
          count = 0;                 // Reset counter so it doesn't meet condition below, break loop
          break;
        }
        count++;                    // Increment counter to meet condition when valid
      }
      if (count > 1) {
        highScoringStudents.add(current.getKey());    // Add student name to output list
      }
    }
    return highScoringStudents;
  }
}
