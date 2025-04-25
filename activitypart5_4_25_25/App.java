// WORK BY WYATT MARCUS BAUTISTA

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum StudentGradeLevels {
    ELEMENTARY,
    JUNIOR,
    SENIOR
}


// Create a class for student
class StudentInfo {
    private String name;
    private StudentGradeLevels gradeLevel;

    public StudentInfo(String name, StudentGradeLevels gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;

        // Validate grade level
        if (gradeLevel == null) {
            throw new IllegalArgumentException("Invalid grade level");
        }
    }

    public String getName() {
        return name;
    }

    public StudentGradeLevels getGradeLevel() {
        return gradeLevel;
    }
}

// Create an interface for student operations
interface Tools {
    void addStudent(Scanner scanner);
    void displayStudents();
    void updateStudent(Scanner scanner);
    void deleteStudent(String name);
}

// Implement the interface
class StudentMgmt implements Tools {
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    private List<StudentInfo> students = new ArrayList<>();

    @Override
    public void addStudent(Scanner scanner) {
        // Ask for student name
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        // Ask for student grade level
        System.out.println("Enter student grade level");
        System.out.print("Choices [ELEMENTARY, JUNIOR, SENIOR]: ");
        String gradeLevelInput = scanner.nextLine();

        StudentGradeLevels gradeLevel;

        // Validate grade level from enum
        // Throws IllegalArgumentException if invalid
        gradeLevel = StudentGradeLevels.valueOf(gradeLevelInput.toUpperCase());
        students.add(new StudentInfo(name, gradeLevel));

        System.out.println(GREEN + "Student added successfully!" + RESET);
    }

    @Override
    public void displayStudents() {
        for (StudentInfo student : students) {
            System.out.println(YELLOW + "==========================" + RESET);
            System.out.println("Name: " + CYAN + student.getName() + RESET + ", Grade Level: " + CYAN + student.getGradeLevel() + RESET);
            System.out.println(YELLOW + "==========================" + RESET);
        }
        if (students.isEmpty()) {
            System.out.println(RED + "No students found!" + RESET);
        }
    }

    // Update a student
    @Override
    public void updateStudent(Scanner scanner) {
        // Ask for student name to update
        System.out.print("Enter student name to update: ");
        String nameToUpdate = scanner.nextLine();

        // Ask for new student name
        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine();

        // Ask for new student grade level
        System.out.println("Enter new student grade level");
        System.out.print("Choices [ELEMENTARY, JUNIOR, SENIOR]: ");
        String gradeLevelInput = scanner.nextLine();

        StudentGradeLevels newGradeLevel;

        // Validate grade level from enum
        // Throws IllegalArgumentException if invalid
        newGradeLevel = StudentGradeLevels.valueOf(gradeLevelInput.toUpperCase());

        // Find and update the student
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(nameToUpdate)) {
                students.set(i, new StudentInfo(newName, newGradeLevel));
                System.out.println(GREEN + "Student updated successfully!" + RESET);
                return;
            }
        }

        System.out.println(RED + "Student not found and I cannot update!" + RESET);
    }

    // Delete a student by name
    @Override
    public void deleteStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                System.out.println(GREEN + "Student deleted successfully!" + RESET);
                return;
            }
        }
        System.out.println(RED + "Student not found!" + RESET);
    }
}


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentMgmt studentMgmt = new StudentMgmt();
        while (true) {
            // Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("========= Student Management System =========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("=== Brought you by xX_github.com/zavocc_Xx ===");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int ichoice;
            try {
                ichoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(StudentMgmt.RED + "Invalid choice. Please try again." + StudentMgmt.RESET);
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
                continue;
            }

            if (ichoice < 1 || ichoice > 5) {
                System.out.println(StudentMgmt.RED + "Invalid choice. Please try again." + StudentMgmt.RESET);
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
                continue;
            }

            switch (ichoice) {
                case 1:
                    try {
                        studentMgmt.addStudent(scanner);
                        System.out.print("\nPress Enter to continue...");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(StudentMgmt.RED + "Invalid grade level. Please try again." + StudentMgmt.RESET);
                        System.out.print("\nPress Enter to continue...");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    studentMgmt.displayStudents();
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                    break;
                case 3:
                    try {
                        studentMgmt.updateStudent(scanner);
                        System.out.print("\nPress Enter to continue...");
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println(StudentMgmt.RED + "Invalid operation. Please try again." + StudentMgmt.RESET);
                        System.out.print("\nPress Enter to continue...");
                        scanner.nextLine();
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the student to delete: ");
                    String nameToDelete = scanner.nextLine();
                    studentMgmt.deleteStudent(nameToDelete);
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
            }
        }
    }
}
