// PLAN:
// 1. Create a helper functions to add, display, search, sort, and delete student record
// 2. The Activity3 must have 3 attributes for arrays, arraylist edition, and linkedlist edition
// 3. Inside the list, it must have name and student id for search

import java.util.ArrayList;
import java.util.List;

// Student object to store student name and id through iClassStorageXX
class Student {
    private String name;
    private int id;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + " and Student Name: " + name;
    }
    
}

class StudentLinkedNode { 
    String name;
    int id;
    StudentLinkedNode next;

    public StudentLinkedNode(String name, int id) {
        this.name = name;
        this.id = id;
        this.next = null;
    }
}

public class Activity3_ClassBased {
    // 3 attributes becaUSE IT REPLICATES data redundancy across the enterprise
    // Array edition
    private String[] studentName = new String[100000];

    // ArrayList edition
    private ArrayList<Student> studentList = new ArrayList<>();

    // LinkedList edition
    private StudentLinkedNode studentLinkedNode;

    // Helper function to add new students, with arguments such as name, id
    public void addStudent(String name, int id) {
        // Add student and id
        // First, we treat the regular array as the primary storage
        if (studentName[id] != null) {
            throw new IllegalArgumentException("Student ID already exists!");
        }
        studentName[id] = name;

        System.out.println("[*] Ok I will add the student %s with ID %d to the list".formatted(name, id));
        // Add student and id to arraylist
        studentList.add(new Student(name, id));

        // Add student and id to linkedlist
        if (studentLinkedNode == null) {
            studentLinkedNode = new StudentLinkedNode(name, id);
        } else {
            StudentLinkedNode _tempNextTo = studentLinkedNode;
            while (_tempNextTo.next != null) {
                _tempNextTo = _tempNextTo.next;
            }
            _tempNextTo.next = new StudentLinkedNode(name, id);
        }

        System.out.println("[*] Student %s with ID %d has been added to the list".formatted(name, id));

    }

    // Helper function to delete student by id
    public void deleteStudent(int id){
        if (studentName[id] == null) {
            throw new IllegalArgumentException("Student ID does not exist!");
        }
        studentName[id] = null;

        // Delete student by arraylist
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
            }
        }

        // Delete student by linkedlist
        if (studentLinkedNode.id == id) {
            studentLinkedNode = studentLinkedNode.next;
        } else {
            StudentLinkedNode _tempNextTo = studentLinkedNode;
            while (_tempNextTo.next != null) {
                if (_tempNextTo.next.id == id) {
                    _tempNextTo.next = _tempNextTo.next.next;
                    break;
                }
                _tempNextTo = _tempNextTo.next;
            }
        }

        System.out.println("[*] Student with ID %d has been deleted".formatted(id));
    }

    // Helper function to display all students with modes either array, arraylist, or linkedlist
    public void displayStudents(String mode) {
        switch (mode) {
            case "array":
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                for (int i = 0; i < studentName.length; i++) {
                    if (studentName[i] != null) {
                        System.out.println("===============================");
                        System.out.println("Student ID: " + i);
                        System.out.println("Student Name: " + studentName[i]);
                        System.out.println("Mode: " + mode);
                        System.out.println("===============================");
                    }
                }
                break;
            case "arraylist":
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println("===============================");
                    System.out.println("Student ID: " + studentList.get(i).getId());
                    System.out.println("Student Name: " + studentList.get(i).getName());
                    System.out.println("Mode: " + mode);
                    System.out.println("EXCLUSIVE FEATURE, SUMMARIES:");
                    System.out.println(studentList.get(i).toString());
                }
                break;
            case "linkedlist":
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                StudentLinkedNode _tempNextTo = studentLinkedNode;
                while (_tempNextTo != null) {
                    System.out.println("===============================");
                    System.out.println("Student ID: " + _tempNextTo.id);
                    System.out.println("Student Name: " + _tempNextTo.name);
                    System.out.println("Mode: " + mode);
                    System.out.println("===============================");
                    _tempNextTo = _tempNextTo.next;
                }
                break;
            default:
                System.out.println("Mode not found! Valid modes are array, arraylist, and linkedlist");
                break;
        }
    }

    // Function helper to display all students but sort them in alphabetical order
    // Plan for Array and ArrayList: we get the student name and id, sort them, and display them
    // Plan for LinkedList: we get the student name and id, sort them, and display them
    // We usually only need to use the arr
    public void displayStudentsAlphaSorted() {
        System.out.println("bought you by xX_StudentRecordKiller69_Xx");
        System.out.println("Displaying students in alphabetical order by name (Array mode)");
        
        // Step 1: Collect IDs with non-null names
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < studentName.length; i++) {
            if (studentName[i] != null) {
                idList.add(i);
            }
        }
        
        // Step 2: Sort IDs based on names
        idList.sort((id1, id2) -> studentName[id1].compareToIgnoreCase(studentName[id2]));
        
        // Step 3: Display sorted students
        for (int id : idList) {
            System.out.println("===============================");
            System.out.println("Student ID: " + id);
            System.out.println("Student Name: " + studentName[id]);
            System.out.println("Mode: array");
            System.out.println("===============================");
        }
    }

    // Helper function to perform search by student id
    public void searchStudent(String modes, int id) {
        // Search student by id
        if (studentName[id] == null) {
            throw new IllegalArgumentException("Student ID does not exist!");
        }
        
        switch (modes) {
            case "array":
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                System.out.println("===============================");
                System.out.println("Student ID: " + id);
                System.out.println("Student Name: " + studentName[id]);
                System.out.println("Search mode: " + modes);
                System.out.println("===============================");
                break;
            case "arraylist":
                System.out.println("[*] Searching student with ID %d".formatted(id));
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getId() == id) {
                        System.out.println("===============================");
                        System.out.println("Student ID: " + studentList.get(i).getId());
                        System.out.println("Student Name: " + studentList.get(i).getName());
                        System.out.println("Search mode: " + modes);
                        System.out.println("===============================");
                    }
                }
                break;
            case "linkedlist":
                System.out.println("[*] Searching student with ID %d".formatted(id));
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                StudentLinkedNode _tempNextTo = studentLinkedNode;
                // Search student by id
                while (_tempNextTo != null) {
                    if (_tempNextTo.id == id) {
                        System.out.println("===============================");
                        System.out.println("Student ID: " + _tempNextTo.id);
                        System.out.println("Student Name: " + _tempNextTo.name);
                        System.out.println("Search mode: " + modes);
                        System.out.println("===============================");
                    }
                    _tempNextTo = _tempNextTo.next;
                }
                break;
            default:
                System.out.println("Mode not found! Valid modes are array, arraylist, and linkedlist");
                break;
        }
    }

    // Creating a student management system
    public static void main(String[] args) {
        Activity3_ClassBased activity = new Activity3_ClassBased();

        // Colors for better readability
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_BOLD = "\u001B[1m";
        String ANSI_RESET = "\u001B[0m";

        // parse args
        String name = args[0];
        int id = Integer.parseInt(args[1]);

        System.out.println(ANSI_BLUE + ANSI_BOLD + "Adding student named " + args[0] + " with ID" + args[1] + " based on user arguments and displaying it per mode" + ANSI_RESET);
        activity.addStudent(name, id);

        System.out.println("\n\n");

        activity.displayStudents("array");
        activity.displayStudents("arraylist");
        activity.displayStudents("linkedlist");

        System.out.println("\n\n");

        System.out.println(ANSI_BLUE + ANSI_BOLD + "Adding automated sample student named Microsoft Search with ID 4421 for testing storage and persistence" + ANSI_RESET);
        activity.addStudent("Microsoft Search", 4421);
        // Search test
        activity.searchStudent("array", 4421);
        activity.searchStudent("arraylist", 4421);
        activity.searchStudent("linkedlist", 4421);

        System.out.println("\n\n");

        System.out.println(ANSI_BLUE + ANSI_BOLD + "Adding automated sample student named Kat Sherman with ID 9555 for testing unsorted list for comparison" + ANSI_RESET);
        activity.addStudent("Kat Sherman", 9555);
        activity.searchStudent("array", 9555);
        activity.searchStudent("arraylist", 9555);
        activity.searchStudent("linkedlist", 9555);

        // Display test
        System.out.println("\n\n");
        activity.displayStudents("array");

        System.out.println("\n\n");
        
        // Sort test
        System.out.println(ANSI_BLUE + ANSI_BOLD + "Sorted student before and after" + ANSI_RESET);
        activity.displayStudentsAlphaSorted();
    }
}
