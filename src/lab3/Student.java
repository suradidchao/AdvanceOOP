package lab3;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name){
        this.name = name;
        this.courses = new ArrayList<Course>();
    }

    public void addPoints(double newPoints, Course course){
        course.addPoints(newPoints, this.name);
    }

    public double getPoints(Course course){
        return course.getPoints(this.name);
    }


    public String getName(){
        return this.name;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public String toString(){
        String courseAndStatus = "";
        for (Course course: this.courses){
            courseAndStatus += course.getCourseName() + ": " + course.getStudentStatus(this.name) + "\n";
        }
        return "lab3.Student name: " + this.name + "\n" + courseAndStatus;
    }

}
