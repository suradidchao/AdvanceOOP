package lab3;

public class StudentScore {
    private Student student;
    private double score;

    public StudentScore(Student student, double score){
        this.student = student;
        this.score = score;
    }

    public void setScore(double score){
        this.score += score;
    }

    public double getScore(){
        return this.score;
    }

    public Student getStudent(){
        return this.student;
    }
}
