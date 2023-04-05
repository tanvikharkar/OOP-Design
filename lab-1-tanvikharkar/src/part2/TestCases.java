package part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import part1.CourseGrade;
import part1.SimpleIf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCases
{
   /*
    * This test is just to get you started.
    */
   @Test
   public void testgetName() {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
      new CourseGrade("Intro to CS", 100),
      new CourseGrade("Data Structures", 95),
      new CourseGrade("Algorithms", 91),
      new CourseGrade("Computer Organization", 91),
      new CourseGrade("Operating Systems", 75),
      new CourseGrade("Non-CS", 83));

      // Set two sample applicants
      Applicant testApplicant = new Applicant("Aakash", grades, 'N');
      Applicant testApplicant2 = new Applicant("Yu", grades, 'Y');

      // test getName()
      assertEquals("Aakash", testApplicant.getName());
      assertEquals("Yu", testApplicant2.getName());
   }

   @Test
   public void testgetGrades() {
      List<CourseGrade> grades = Arrays.asList(
      new CourseGrade("Intro to CS", 100),
      new CourseGrade("Data Structures", 95),
      new CourseGrade("Algorithms", 91),
      new CourseGrade("Computer Organization", 91),
      new CourseGrade("Operating Systems", 75),
      new CourseGrade("Non-CS", 83));

      // Set sample applicant
      Applicant testApplicant = new Applicant("Aakash", grades, 'N');

      // test getGrades()
      assertEquals(grades, testApplicant.getGrades());
   }

   @Test
   public void testgetGradeFor() {
      List<CourseGrade> grades = Arrays.asList(
      new CourseGrade("Intro to CS", 100),
      new CourseGrade("Data Structures", 95),
      new CourseGrade("Algorithms", 91),
      new CourseGrade("Computer Organization", 91),
      new CourseGrade("Operating Systems", 75),
      new CourseGrade("Non-CS", 83));

      // Set sample applicant
      Applicant testApplicant = new Applicant("Yu", grades, 'Y');

      // test getGradeFor()
      assertEquals(grades.get(0), testApplicant.getGradeFor("Intro to CS"));
      assertEquals(grades.get(2), testApplicant.getGradeFor("Algorithms"));
   }

   @Test
   public void testgetPriorWork() {
      List<CourseGrade> grades = Arrays.asList(
      new CourseGrade("Intro to CS", 100),
      new CourseGrade("Data Structures", 95),
      new CourseGrade("Algorithms", 91),
      new CourseGrade("Computer Organization", 91),
      new CourseGrade("Operating Systems", 75),
      new CourseGrade("Non-CS", 83));

      // Set two sample applicants
      Applicant testApplicant = new Applicant("Aakash", grades, 'N');
      Applicant testApplicant2 = new Applicant("Yu", grades, 'Y');

      // test new function, getPriorWork()
      assertFalse(SimpleIf.analyzeApplicant2(testApplicant));
      assertTrue(SimpleIf.analyzeApplicant2(testApplicant2));
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */
   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getName",
         "getGrades",
         "getGradeFor"
      );

      final List<Class> expectedMethodReturns = Arrays.asList(
         String.class,
         List.class,
         CourseGrade.class
      );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[] { String.class }
         );

      verifyImplSpecifics(Applicant.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals(0, Applicant.class.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue(expectedMethodNames.size()+1 >= publicMethods.size(),
              "Unexpected number of public methods");

      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
