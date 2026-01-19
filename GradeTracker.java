import java.util.Scanner;
import java.util.ArrayList;

public class GradeTracker {
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();

    System.out.println("---- Student Grade Tracker ----");
    System.out.println("Type 'exit' as the name to finish entering students.");

    while(true){
      System.out.println("\nEnter Student Name: ");
      String name = sc.next();

      if(name.equalsIgnoreCase("exit")){
        break;
      }

      System.out.println("Enter Score for " + name + ": ");

      if(sc.hasNextDouble()){
        double marks = sc.nextDouble();

        Student newStudent = new Student(name , marks);
        students.add(newStudent);

      }

      else{
        System.out.println("Invalid number! Invalid Student.");
        sc.next();

      }
    }

    if(students.isEmpty()){
      System.out.println("No students were added.");
    }
    else{
      double totalScore = 0;
      double highestScore = students.get(0).getMarks();
      double lowestScore = students.get(0).getMarks();

      System.out.println("\n---- Class Summary ----");

      for(Student s : students){
        System.out.println("Student: " + s.getName() + " Score: " + s.getMarks());
        totalScore += s.getMarks();

        if(s.getMarks() > highestScore){
          highestScore = s.getMarks();
        }

        if(s.getMarks() < lowestScore){
          lowestScore = s.getMarks();
        }
      }

      double avg = totalScore / students.size();


      System.out.println("--------------------------");
      System.out.println("Total Students: " + students.size());
      System.out.println("Average Score: " + avg);
      System.out.println("Highest Score: " + highestScore);
      System.out.println("Lowest Score:   " + lowestScore);
    }

    sc.close();
  }
  
}
