package part1;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant()
   {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()
   {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3() {
      assertFalse(SimpleIf.analyzeApplicant(20, 20));
   }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      assertEquals(SimpleIf.maxAverage(15, 15), 15, DELTA);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3() {
      assertEquals(14, SimpleLoop.sum(2, 5));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85));
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      assertArrayEquals(
         new boolean[] {true, false},
         SimpleArray.applicantAcceptable(new int[] {75, 65}, 70));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<Integer>(Arrays.asList(new Integer[] {80, 85, 89, 92, 76, 81}));
      List<Boolean> expected =
         new ArrayList<Boolean>(Arrays.asList(new Boolean[] {false, false, true, true, false, false}));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Integer> input =
              new LinkedList<Integer>(Arrays.asList(new Integer[] {80, 65, 70, 75, 85}));
      List<Boolean> expected =
              new ArrayList<Boolean>(Arrays.asList(new Boolean[] {true, false, false, false, true}));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 75));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {86, 87, 90, 82, 83, 90}));
   }

   @Test
   public void testFourOver85_3() {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {0, 5, 10, 15, 90, 50}));
   }

   @Test
   public void testAverage()
   {
      assertEquals(3.0, BetterLoop.average(new int[] {1, 2, 3, 4, 5, 6}));
   }

   @Test
   public void testAverage_2()
   {
      assertEquals(22.0, BetterLoop.average(new int[] {10, 15, 20, 30, 35, 22}));
   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test // Income parameter added based on part 2 of lab 1
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
         Arrays.asList(
            new CourseGrade("CPE 123", 89),
            new CourseGrade("CPE 101", 90),
            new CourseGrade("CPE 202", 99),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Zoe",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86),
            new CourseGrade("CPE 473", 90),
            new CourseGrade("CPE 476", 99),
            new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Kim",
        Arrays.asList(
          new CourseGrade("CPE 123", 50),
          new CourseGrade("CPE 101", 90),
          new CourseGrade("CPE 202", 99),
          new CourseGrade("CPE 203", 100),
          new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Lily",
         Arrays.asList(
          new CourseGrade("CPE 101", 86),
          new CourseGrade("CPE 202", 80),
          new CourseGrade("CPE 203", 40),
          new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Sam",
         Arrays.asList(
          new CourseGrade("CPE 123", 99),
          new CourseGrade("CPE 203", 91),
          new CourseGrade("CPE 471", 86),
          new CourseGrade("CPE 473", 90),
          new CourseGrade("CPE 476", 99),
          new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Sam");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 60)));
   }
}
