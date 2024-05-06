import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();

        int menu = 1;
        for (; 6 != menu; ) {
            System.out.println("(1) Add");
            System.out.println("(2) Delete");
            System.out.println("(3) Update");
            System.out.println("(4) Print");
            System.out.println("(5) Search");
            System.out.println("(6) Exit");
            System.out.print("Choice your Option : ");
            menu = sc.nextInt();

            // Add Option
            if (menu == 1) {
                System.out.println("(1) Add a Student ");
                System.out.println("(2) Add a Course ");
                System.out.println("(3) Add a Faculty ");
                System.out.println("(4) Add Student in Course");
                System.out.println("(5) Add Faculty in Course");
                System.out.print("Choice your option : ");
                int menu1 = sc.nextInt();

                // Student
                if (menu1 == 1) {
                    System.out.println("Enter the Student Detail : ");
                    sc.nextLine();
                    System.out.print("Student Name : ");
                    String name = sc.nextLine();
                    System.out.print("Student ID : ");
                    int id = sc.nextInt();
                    System.out.print("Student CGPA : ");
                    double cg = sc.nextDouble();

                    Student student = new Student(id, name, cg);
                    students.add(student);
                    System.out.println("Successfully Added Student.");
                }

                // Course
                else if (menu1 == 2) {
                    System.out.println("Enter the Course Detail : ");
                    sc.nextLine();
                    System.out.print("Course Title : ");
                    String title = sc.nextLine();
                    System.out.print("Course ID : ");
                    String id = sc.nextLine();
                    System.out.print("Course Credit : ");
                    double credit = sc.nextDouble();

                    Course course = new Course(id, title, credit);
                    courses.add(course);
                    System.out.println("Successfully Added Course.");
                }

                // Faculty
                else if (menu1 == 3) {
                    sc.nextLine();
                    System.out.println("Enter the Faculty Detail : ");
                    System.out.print("Faculty Name : ");
                    String name = sc.nextLine();
                    System.out.print("Faculty ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Faculty Position : ");
                    String position = sc.nextLine();
                    Faculty faculty = new Faculty(id, name, position);
                    faculties.add(faculty);
                    System.out.println("Successfully Added Faculty.");
                }

                else if(menu1 == 4) {
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String Id = sc.nextLine();
                    for (Course course : courses) {
                        if(Id.equals(course.getCourseId())) {
                            System.out.print("Enter the Student ID : ");
                            int id = sc.nextInt();
                            for(Student student : students) {
                                if (id == student.getStudentId()) {
                                    course.addStudent(student);
                                    break;
                                }
                            }
                        }
                    }
                }

                else if(menu1 == 5) {
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String Id = sc.nextLine();
                    for (Course course : courses) {
                        if(Id.equals(course.getCourseId())) {
                            System.out.print("Enter the Faculty ID : ");
                            int id = sc.nextInt();
                            for(Faculty faculty : faculties) {
                                if (id == faculty.getFacultyId()) {
                                    course.addFaculty(faculty);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            // Add option end


            // Delete Option start
            else if (menu == 2) {
                System.out.println("(1) Delete Student ");
                System.out.println("(2) Delete Course ");
                System.out.println("(3) Delete Faculty ");
                System.out.println("(4) Drop Course");
                System.out.print("Choice your option : ");
                int menu2 = sc.nextInt();

                // Student
                if (menu2 == 1) {
                    System.out.print("Enter the Student ID : ");
                    int id = sc.nextInt();
                    for (int i = 0; i < students.size(); i++) {
                        if (id == students.get(i).getStudentId()) {
                            students.remove(i);
                            System.out.println("Successfully Removed.");
                        }
                    }
                }

                // Course
                else if (menu2 == 2) {
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String id = sc.nextLine();
                    for (int i = 0; i < courses.size(); i++) {
                        if (id.equals(courses.get(i).getCourseId())) {
                            courses.remove(i);
                            System.out.println("Successfully Removed.");
                        }
                    }
                }

                // Faculty
                else if (menu2 == 3) {
                    System.out.print("Enter the Faculty ID : ");
                    int id = sc.nextInt();
                    for (int i = 0; i < faculties.size(); i++) {
                        if (id == faculties.get(i).getFacultyId()) {
                            faculties.remove(i);
                            System.out.println("Successfully Removed.");
                        }
                    }
                }

                else if(menu2 == 4) {
                    System.out.print("Enter the Drop Course ID : ");
                    String Id = sc.nextLine();
                    for(Course course : courses) {
                        if(Id.equals(course.getCourseId())) {
                            System.out.print("Enter the Student ID : ");
                            int id = sc.nextInt();
                            for(Student student : students) {
                                if (id == student.getStudentId()) {
                                    course.dropStudent(student);
                                }
                            }
                        }
                    }
                }

            }
            // Delete Option end


            // Update Option start
            else if (menu == 3) {
                System.out.println("(1) Update Student ");
                System.out.println("(2) Update Course ");
                System.out.println("(3) Update Faculty ");
                System.out.print("Choice your option : ");
                int menu3 = sc.nextInt();

                // Student
                if (menu3 == 1) {
                    System.out.print("Enter the Student ID : ");
                    int id = sc.nextInt();
                    for (int i = 0; i < students.size(); i++) {
                        if (id == students.get(i).getStudentId()) {
                            System.out.print("Enter Update CGPA : ");
                            double cg = sc.nextDouble();
                            students.get(i).setStudentCGPA(cg);
                            students.get(i).display();
                            System.out.println("Successfully Updated.");
                        }
                    }
                }

                // Course
                else if (menu3 == 2) {
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String id = sc.nextLine();
                    for (int i = 0; i < courses.size(); i++) {
                        if (id.equals(courses.get(i).getCourseId())) {
                            System.out.print("Enter Update credit : ");
                            double cr = sc.nextDouble();
                            courses.get(i).setCredit(cr);
                            courses.get(i).toString();
                            System.out.println("Successfully Updated.");
                        }
                    }
                }

                // Faculty
                else if (menu3 == 3) {
                    System.out.print("Enter the Faculty ID : ");
                    int id = sc.nextInt();
                    for (int i = 0; i < faculties.size(); i++) {
                        if (id == faculties.get(i).getFacultyId()) {
                            System.out.print("Enter Update Position : ");
                            sc.nextLine();
                            String position = sc.nextLine();
                            faculties.get(i).setFacultyPosition(position);
                            faculties.get(i).display();
                            System.out.println("Successfully Updated.");
                        }
                    }
                }
            }
            // Update option end


            // Print option start
            else if (menu == 4) {
                System.out.println("(1) Print all Students ");
                System.out.println("(2) Print all Course ");
                System.out.println("(3) Print all Faculties");
                System.out.println("(4) Print information of Student");
                System.out.println("(5) Print information of Course ");
                System.out.println("(6) Print information of Faculties ");
                System.out.println("(7) Print Student list and faulty information of a Course ");
                System.out.println("(8) Print Course taken by a student ");
                System.out.print("Choice your option : ");
                int menu4 = sc.nextInt();

                if (menu4 == 1) {
                    for (Student student : students) {
                        System.out.println("\n" + student.display() + "\n");
                    }
                }

                else if (menu4 == 2) {
                    for (Course course : courses) {
                        System.out.println("\n" + course.toString() + "\n");
                    }
                }

                else if (menu4 == 3) {
                    for (Faculty faculty : faculties) {
                        System.out.println("\n" + faculty.display() + "\n");
                    }
                }

                else if(menu4 == 4) {
                    System.out.println("Information of Student");
                    System.out.print("Enter the Student ID : ");
                    int id = sc.nextInt();
                    for(Student student : students) {
                        if(id == student.getStudentId()) {
                            System.out.println(student.display());
                        }
                    }
                    Taken(students, courses, id);
                }

                else if(menu4 == 5) {
                    System.out.println("Information of Course");
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String id = sc.nextLine();
                    for(Course course : courses) {
                        if(id.equals(course.getCourseId())) {
                            System.out.println(course.toString());
                            course.printStudentList();
                        }
                    }
                }

                else if(menu4 == 6) {
                    System.out.println("Information of Faculty");
                    System.out.print("Enter the Faculty ID : ");
                    sc.nextLine();
                    int id = sc.nextInt();
                    for(Faculty faculty : faculties) {
                        if(id == faculty.getFacultyId()) {
                            System.out.println(faculty.display());
                        }
                    }
                    for(Course course : courses) {
                        course.dropFaculty();
                    }
                }

                else if(menu4 == 7) {
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String id = sc.nextLine();
                    for(Course course : courses) {
                        if(id.equals(course.getCourseId())) {
                            course.printCourseInfo();
                        }
                    }
                }

                else if(menu4 == 8) {
                        System.out.print("Enter the Student ID: ");
                        int studentId = sc.nextInt();
                        Taken(students,courses ,studentId);
                    }


            }
            // Print option end


            // Search option start
            else if (menu == 5) {
                System.out.println("(1) Search a Student ");
                System.out.println("(2) Search a Course ");
                System.out.println("(3) Search a Faculty ");
                System.out.println("(4) Search whether a student takes a course ");
                System.out.println("(5) Search whether a faculty teaches a course ");
                System.out.println("(6) Search courses taken by a student ");
                System.out.println("(7) Search courses taught by a faculty ");
                System.out.print("Choice your option : ");
                int menu5 = sc.nextInt();

                if (menu5 == 1) {
                    System.out.print("Enter the Student ID : ");
                    int id = sc.nextInt();
                    for (int i = 0; i < students.size(); i++) {
                        if (id == students.get(i).getStudentId()) {
                            System.out.println("Find the Student.");
                            System.out.println("(1) Show the Student Name");
                            System.out.println("(2) Show the Student CGPA");
                            System.out.print("Choice the option : ");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Student Name : " + students.get(i).getStudentName());
                                    break;
                                case 2:
                                    System.out.println("Student CGPA : " + students.get(i).getStudentCGPA());
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                            }
                        }
                    }
                }

                else if (menu5 == 2) {
                    System.out.print("Enter the Course ID : ");
                    String id = sc.nextLine();
                    for (int i = 0; i < courses.size(); i++) {
                        if (id.equals(courses.get(i).getCourseId())) {
                            System.out.println("Find the Course.");
                            System.out.println("(1) Show the Course Name");
                            System.out.println("(2) Show the Course Credit");
                            System.out.print("Choice the option : ");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Student Name : " + courses.get(i).getCourseTitle());
                                    break;
                                case 2:
                                    System.out.println("Student CGPA : " + courses.get(i).getCredit());
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                            }
                        }
                    }
                } else if (menu5 == 3) {
                    System.out.print("Enter the Faculty ID : ");
                    int id = sc.nextInt();
                    for (int i = 0; i < faculties.size(); i++) {
                        if (id == faculties.get(i).getFacultyId()) {
                            System.out.println("Find the Faculty.");
                            System.out.println("(1) Show the Faculty Name");
                            System.out.println("(2) Show the Faculty Position");
                            System.out.print("Choice the option : ");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Faculty Name : " + courses.get(i).getCourseTitle());
                                    break;
                                case 2:
                                    System.out.println("Faculty Position : " + courses.get(i).getCredit());
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                            }
                        }
                    }
                }

                else if(menu5 == 4) {
                    System.out.print("Enter the Student ID: ");
                    int studentId = sc.nextInt();
                    System.out.print("Enter the Course ID: ");
                    sc.nextLine(); // Consume newline character
                    String courseId = sc.nextLine();
                    searchStudentTakesCourse(students, courses, studentId, courseId);
                }

                else if(menu5 == 5) {
                    System.out.print("Enter the Faculty ID : ");
                    int facultyId = sc.nextInt();
                    System.out.print("Enter the Course ID : ");
                    sc.nextLine();
                    String courseId = sc.nextLine();

                    searchFacultyTeachesCourse(courses, facultyId, courseId);
                }

                else if(menu5 == 6) {
                    System.out.print("Enter the Student ID: ");
                    int studentId = sc.nextInt();
                    Taken(students,courses ,studentId);
                }

                else if(menu5 == 7) {
                    System.out.print("Enter the Faculty ID : ");
                    int facultyId = sc.nextInt();
                    searchCoursesTaughtByFaculty(courses, facultyId);
                }
            }
            //Search option end

            else if(menu > 6) {
                System.out.println("Invalid option");
            }
        }
        System.out.println("Exit!");
    }


    public static void Taken(ArrayList<Student> students, ArrayList<Course> courses, int studentId) {
        boolean studentFound = false;

        // Find the student
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                studentFound = true;
                System.out.println("Courses taken by Student " + student.getStudentName() + ":");

                // Iterate over courses to check enrollment
                for (Course course : courses) {
                    if (course.isStudentEnrolled(student)) {
                        System.out.println(course.getCourseTitle());
                    }
                }
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student not found.");
        }
    }

    public static void searchStudentTakesCourse(ArrayList<Student> students, ArrayList<Course> courses, int studentId, String courseId) {
        boolean studentFound = false;

        // Find the student
        for (Student student : students) {
            if (student.getStudentId() == studentId) {

                // Find the course
                for (Course course : courses) {
                    if (course.getCourseId().equals(courseId)) {

                        // Check if the student takes the course
                        if (course.isStudentEnrolled(student)) {
                            System.out.println("Yes, the student takes the course.");
                        } else {
                            System.out.println("No, the student does not take the course.");
                        }

                        break;
                    }
                }
            }
        }
    }

    public static void searchFacultyTeachesCourse(ArrayList<Course> courses, int facultyId, String courseId) {

        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                Faculty faculty = course.getFaculty();
                if (faculty != null && faculty.getFacultyId() == facultyId) {
                    System.out.println("Yes, the faculty teaches the course.");
                } else {
                    System.out.println("No, the faculty does not teach the course.");
                }
            }
        }
    }

    public static void searchCoursesTaughtByFaculty(ArrayList<Course> courses, int facultyId) {

        for (Course course : courses) {
            if (course.getFaculty() != null && course.getFaculty().getFacultyId() == facultyId) {
                System.out.println("Courses taught by Faculty " + course.getFaculty().getFacultyName() + ":");
                System.out.println(course.getCourseTitle());
            }
        }
    }
}

