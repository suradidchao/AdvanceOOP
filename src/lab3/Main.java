package lab3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<Student>();
        Student thun = new Student("Thun");
        Student theerut = new Student("Theerut");
        Student dujruthai = new Student("Dujruthai");
        students.add(thun);
        students.add(theerut);
        students.add(dujruthai);

        Course accounting = new Course("Accounting");
        Course systemAnalysisAndDesign = new Course("System analysis and design");
        Course informationSystem = new Course("Information systems");
        Course economics = new Course("Economics");

        accounting.addStudent(thun);
        accounting.addStudent(theerut);
        accounting.addStudent(dujruthai);
        systemAnalysisAndDesign.addStudent(theerut);
        systemAnalysisAndDesign.addStudent(thun);
        systemAnalysisAndDesign.addStudent(dujruthai);
        informationSystem.addStudent(dujruthai);
        informationSystem.addStudent(theerut);
        economics.addStudent(thun);

        thun.addPoints(20, accounting);
        thun.addPoints(30, accounting);
        theerut.addPoints(10, accounting);
        dujruthai.addPoints(35, accounting);
        theerut.addPoints(30, systemAnalysisAndDesign);
        theerut.addPoints(40, systemAnalysisAndDesign);
        thun.addPoints(20, systemAnalysisAndDesign);
        dujruthai.addPoints(10, systemAnalysisAndDesign);
        dujruthai.addPoints(40, informationSystem);
        dujruthai.addPoints(50, informationSystem);
        theerut.addPoints(40, informationSystem);

        accounting.report();
        systemAnalysisAndDesign.report();
        informationSystem.report();

        for (Student student: students){
            System.out.println(student);
        }


        dujruthai.addPoints(60, systemAnalysisAndDesign);
        systemAnalysisAndDesign.report();


    }
}
