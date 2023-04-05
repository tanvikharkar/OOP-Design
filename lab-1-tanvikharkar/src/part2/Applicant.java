package part2;
import part1.CourseGrade;
import java.util.*;

public class Applicant {

    private String appl_name;
    private List<CourseGrade> scores;
    private char appl_work;

    public Applicant(String name, List<CourseGrade> grades, char work) {
        this.appl_name = name;
        this.scores = grades;
        this.appl_work = work;
    }

    public String getName() {
        return this.appl_name;
    }

    public List<CourseGrade> getGrades() {
        return this.scores;
    }

    public char getPriorWork() {
        return this.appl_work;
    }

    public CourseGrade getGradeFor(String course) {
        for (CourseGrade c : scores) {
            if (c.getCourseName() == course) {
                return c;
            }
        }
        return null;
    }
}
