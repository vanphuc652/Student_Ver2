
package Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person{

    private float GPA;
    private String major;
    private double tuiition;
    private boolean schoolarship;

    public Student(String id, String fullName, Date dateOfBirth, float GPA, String major, double tuiition, boolean schoolarship) {
        super (id, fullName, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
        this.tuiition = 10000000;
        this.schoolarship = schoolarship;
    }

    public Student() {
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuiition() {
        return schoolarship ? tuiition*0.5 : tuiition;
    }

    public void setTuiition(double tuiition) {
        this.tuiition = tuiition;
    }

    public boolean isSchoolarship() {
        return schoolarship;
    }

    public void setSchoolarship(boolean schoolarship) {
        this.schoolarship = schoolarship;
    }
    
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("ID: ");
            String id = scanner.nextLine();
            setId(id);
            System.out.println("Full name: ");
            String fullName = scanner.nextLine();
            setFullName(fullName);
            System.out.println("Date of birth: ");
            String dateOfBirthString = scanner.nextLine();
            try {
                Date dateOfBirth = sdf.parse(dateOfBirthString);
                setDateOfBirth(dateOfBirth);
            } catch (Exception e) {
                System.out.println("Wrong format");
            }
            System.out.println("GPA: ");
            float GPA = Float.parseFloat(scanner.nextLine());
            setGPA(GPA);
            System.out.println("Major: ");
            String major = scanner.nextLine();
            setMajor(major);
        } catch (Exception e) {
            System.out.println("N/A");
        }
    }
    
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDateOfBirth = sdf.format(getDateOfBirth());
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date Of Birth: " + formatedDateOfBirth);
        System.out.println("GPA: " + getGPA());
        System.out.println("Major: " + getMajor());
        System.out.println("Tuiition: " + caculateTuiition());
        System.out.println("Schoolarship: " + (schoolarship ? "Yes" : "No"));
    }
    
    public double caculateTuiition() {
        if (getGPA() >= 9) {
            schoolarship = true;
            return tuiition * 0.5; 
        } else {
            schoolarship = false;
            return tuiition;
        }
    }
}

