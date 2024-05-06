import org.w3c.dom.ls.LSOutput;

public class Course {
    private String courseId;
    private String courseTitle;
    private double credit;
    Student [] studentList;
    private int numberOfStudent;
    private Faculty faculty;

    public Course() {

    }

    public Course(String courseId, String courseTitle, double credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.numberOfStudent = 0;
        studentList = new Student[40];
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String toString() {
        return  "Course ID : "+ courseId +"\nCourse Title : "+ courseTitle +
                "\nCourse Credit : "+ credit;
    }

    public void addStudent(Student student) {
        if(numberOfStudent <= 40) {
            if(studentList[numberOfStudent] == null) {
                studentList[numberOfStudent] = student;
                numberOfStudent++;
                System.out.println("Student added to the course : "+ student.getStudentName());
            }
            else {
                System.out.println("This Course is Full!");
            }
        }
        else {
            if (numberOfStudent < 8) {
                System.out.println("Course hasn't started yet. At least 8 Student");
            }
            else {
                System.out.println("Course is already full!");
            }
        }
    }

    public void dropStudent (Student student) {
        for(int i = 0; i < numberOfStudent; i++) {
            if(studentList[i].equals(student)) {
                for(int j = i; j < numberOfStudent - 1; j++) {
                    studentList[j] = studentList[j + 1];
                }
                studentList[numberOfStudent - 1] = null;
                numberOfStudent--;
                System.out.println("Student dropped from the course : "+ student.getStudentId());
            }
        }
    }

    public void addFaculty(Faculty faculty) {
        if (this.faculty == null) {
            this.faculty = faculty;
            System.out.println("Faculty added to the course: " + faculty.getFacultyName());
        } else {
            System.out.println("This course already has a faculty assigned.");
        }
    }

    public void dropFaculty() {
        if (numberOfStudent < 8) {
            System.out.println("Faculty cannot be dropped. The course must have at least 8 students.");
        } else {
            if (faculty != null) {
                System.out.println("Faculty dropped from the course: " + faculty.getFacultyName());
                this.faculty = null;
            } else {
                System.out.println("No faculty is currently assigned to this course.");
            }
        }
    }


    public void printStudentList() {
        System.out.println("Student Enrolled in "+ getCourseTitle() +" : ");
        for(int i = 0; i < numberOfStudent; i++) {
            System.out.println(studentList[i].getStudentName());
        }
    }

    public boolean isStudentEnrolled(Student student) {
        for(int i = 0; i < numberOfStudent; i++) {
            if(studentList[i].equals(student)) {
                return true;
            }
        }
        return false;
    }

    public void printCourseInfo() {
        System.out.println("Course Information:");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Credit: " + credit);

        System.out.println("Enrolled Students:");
        if (numberOfStudent == 0) {
            System.out.println("No students enrolled yet.");
        } else {
            for (int i = 0; i < numberOfStudent; i++) {
                System.out.println(studentList[i].getStudentName());
            }
        }

        if (faculty != null) {
            System.out.println("Faculty Information:");
            System.out.println("Faculty Name: " + faculty.getFacultyName());
            System.out.println("Faculty ID: " + faculty.getFacultyId());
            System.out.println("Faculty Position: " + faculty.getFacultyPosition());
        } else {
            System.out.println("No faculty assigned to this course yet.");
        }
    }



}