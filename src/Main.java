import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        School school = new School();

        File studentFile = new File("C:\\Users\\Расул\\IdeaProjects\\Assignment1\\src\\students.txt");
        Scanner studentScanner = new Scanner(studentFile);

        while (studentScanner.hasNextLine()) {
            String[] studentData = studentScanner.nextLine().split(" ");
            String name = studentData[0];
            String surname = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            boolean gender = studentData[3].equals("Male");
            Student student = new Student(name, surname, age, gender);

            for (int i = 4; i < studentData.length; i++) {
                student.addGrade(Integer.parseInt(studentData[i]));
            }

            students.add(student);
            school.addMember(student);
        }

        File teacherFile = new File("C:\\Users\\Расул\\IdeaProjects\\Assignment1\\src\\teachers.txt");
        Scanner teacherScanner = new Scanner(teacherFile);

        while (teacherScanner.hasNextLine()) {
            String[] teacherData = teacherScanner.nextLine().split(" ");
            String name = teacherData[0];
            String surname = teacherData[1];
            int age = Integer.parseInt(teacherData[2]);
            boolean gender = teacherData[3].equals("Male");
            String subject = teacherData[4];
            int yearsOfExperience = Integer.parseInt(teacherData[5]);
            int salary = Integer.parseInt(teacherData[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            teachers.add(teacher);
            school.addMember(teacher);
        }

        System.out.println("\nSchool Members:");
        System.out.println(school);

        for (Student student : students) {
            System.out.printf("%s's GPA: %.2f\n", student.name, student.calculateGPA());
        }
        System.out.println();
        for (Teacher teacher : teachers) {
            if (teacher.yearsOfExperience > 10) {
                teacher.giveRaise(10);
                System.out.printf("%s's Raise: %s\n", teacher.name, teacher.salary);
            }
        }
    }
}