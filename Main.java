import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().trim();

        System.out.print("How many subjects? ");
        int subjectCount = scanner.nextInt();

        if (subjectCount <= 0) {
            System.out.println("The number of subjects must be greater than zero.");
            scanner.close();
            return;
        }

        double total = 0.0;
        for (int i = 1; i <= subjectCount; i++) {
            double mark;
            do {
                System.out.printf("Enter mark for subject %d (0-100): ", i);
                mark = scanner.nextDouble();
                if (mark < 0 || mark > 100) {
                    System.out.println("Mark must be between 0 and 100. Try again.");
                }
            } while (mark < 0 || mark > 100);

            total += mark;
        }

        double average = total / subjectCount;
        String grade;
        if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nResults for " + (studentName.isEmpty() ? "student" : studentName));
        System.out.printf("Total marks: %.2f%n", total);
        System.out.printf("Average mark: %.2f%%%n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
