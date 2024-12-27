import java.util.ArrayList;
class Student extends Person {
    int studentID;
    ArrayList<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = (int) (Math.random() * 9000) + 1000;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        String genderStr = gender ? "Male" : "Female";
        return String.format("%s I am a student with ID %d.", super.toString(), studentID);
    }
}
