package second;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();

       
        int totalMarks = 0;
        int[] subjectMarks = new int[numSubjects];

    
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + ":");
            subjectMarks[i] = scanner.nextInt();

            
            if (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                return;
            }

        
            totalMarks += subjectMarks[i];
        }

   
        double averagePercentage = (double) totalMarks / numSubjects;

    
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

       
        String grade = calculateGrade(averagePercentage);


        System.out.println("Grade: " + grade);
    }

    private static String calculateGrade(double averagePercentage) {

        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
