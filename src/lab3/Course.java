package lab3;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Student> students;
    private ArrayList<StudentScore> studentsScore;

    public Course(String courseName){
        this.courseName = courseName;
        this.students = new ArrayList<Student>();
        this.studentsScore = new ArrayList<StudentScore>();
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.addCourse(this);
        StudentScore studentScore = new StudentScore(student, 0);
        this.studentsScore.add(studentScore);
    }

    public void addPoints(double points, String name){
        Student targetStudent = new Student("");
        for (int i = 0;i < this.students.size(); i++){
            if (this.students.get(i).getName() == name){
                targetStudent = this.students.get(i);
                break;
            }
        }
        if (targetStudent.getName() != ""){
            for (int j = 0; j < this.studentsScore.size(); j++){
                if (this.studentsScore.get(j).getStudent() == targetStudent){
                    this.studentsScore.get(j).setScore(points);
                }
            }
        } else {
            System.out.println("No student in this course");
        }

    }

    public double averageAll(){
        double sum = 0;
        for (StudentScore studentScore : this.studentsScore){
            sum += studentScore.getScore();
        }
        return sum / this.studentsScore.size();
    }

    public void report(){
        System.out.println(this.courseName);
        for (Student student: this.students){
            for (StudentScore studentScore : this.studentsScore){
                if (studentScore.getStudent() == student){
                    double score = studentScore.getScore();
                    String studentName = studentScore.getStudent().getName();
                    String status = this.calculateStudentStatus(score);
                    System.out.println(studentName + ": " + status);
                }
            }
        }
        System.out.println();
    }

    public double getPoints(String studentName){
        for (StudentScore studentScore: this.studentsScore){
            if (studentScore.getStudent().getName() == studentName){
                return studentScore.getScore();
            }
        }
        System.out.println("No student in the course");
        return 0;
    }

    public String getStudentStatus(String name){
        for (StudentScore studentScore : this.studentsScore){
            if (studentScore.getStudent().getName() == name){
                return this.calculateStudentStatus(studentScore.getScore());
            }
        }
        return "No lab3.Student in the course";
    }

    private String calculateStudentStatus(double score){
        return score > this.averageAll() ? "Pass" : "Fail";
    }
}
