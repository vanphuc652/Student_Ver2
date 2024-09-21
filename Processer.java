
package Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Processer  {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Display students with scholarships: ");
            System.out.println("7. Display total tuition of all students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Student newStudent = new Student();
                    newStudent.addStudent();
                    studentList.addStudent(newStudent);
                    break;

                case 2:
                    String updateId = scanner.nextLine();
                    studentList.updateStudentById(updateId);
                    break;

                case 3:
                    System.out.println("Enter ID of student to remove: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 4:
                    studentList.displayAllStudent();               
                    break;

                case 5:
                    System.out.println("Enter ID of student to the highest GPA: ");
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                
                case 6:
                    System.out.println("Scholarship Students:");
                    for (Student scholarshipStudent : studentList.findSchoolarshipStudent()) {
                        scholarshipStudent.displayInfo();
                    }            
                    break;
                    
                case 7:
                    double totalTuition = studentList.caculateTuiitionOfAllStudent();
                    System.out.println("Total Tuition: " + totalTuition);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }      
}
    
