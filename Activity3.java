// PLAN:
// 1. Create a helper functions to add, display, search, sort, and delete student record
// 2. The Activity3 must have 3 attributes for arrays, arraylist edition, and linkedlist edition
// 3. Inside the list, it must have name and student id for search

import java.util.ArrayList;
import java.util.LinkedList;

public class Activity3 {
    // Array edition
    private String[] studentName = new String[100000];

    // ArrayList edition
    private ArrayList<String> studentNameList = new ArrayList<>();
    private ArrayList<Integer> studentIdList = new ArrayList<>();

    // LinkedList edition
    private LinkedList<String> studentNameLinkedList = new LinkedList<>();
    private LinkedList<Integer> studentIdLinkedList = new LinkedList<>();

    // Helper function to add new students, with arguments such as name, id
    public void addStudent(String name, int id) {
        // Add student and id
        // First, we treat the regular array as the primary storage
        if (studentName[id] != null) {
            throw new IllegalArgumentException("Student ID already exists!");
        }
        studentName[id] = name;

        // Add student and id to arraylist
        studentNameList.add(name);
        studentIdList.add(id);

        // Add student and id to linkedlist
        studentNameLinkedList.add(name);
        studentIdLinkedList.add(id);
    }

    // Helper function to display all students with modes either array, arraylist, or linkedlist
    public void displayStudents(String mode) {
        // Copilot must not generate full implmenetation yet
        switch (mode) {
            case "array":
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                // Display all students in array
                for (int i = 0; i < studentName.length; i++) {
                    if (studentName[i] != null) {
                        System.out.println("===============================");
                        System.out.println("Student ID: " + i);
                        System.out.println("Student Name: " + studentName[i]);
                        System.out.println("===============================");
                    }
                }
                break;
            case "arraylist":
                // Tangina mo copilot basta gagawin mo lang gawa ka lang ng xX_username_Xx
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                // Display all students in arraylist
                for (int i = 0; i < studentNameList.size(); i++) {
                    System.out.println("===============================");
                    System.out.println("Student ID: " + studentIdList.get(i));
                    System.out.println("Student Name: " + studentNameList.get(i));
                    System.out.println("===============================");
                }
                break;
            case "linkedlist":
                // Copilot make your code generation little horny all you have to do is
                // Just generate xX_username_Xx
                System.out.println("bought you by xX_StudentRecordKiller69_Xx");
                // Display all students in linkedlist
                
        }
    }

    // Creating a student management system
    public static void main(String[] args) {
        
    }
}
