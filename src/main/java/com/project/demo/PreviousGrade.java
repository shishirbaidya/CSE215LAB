package com.project.demo;

import java.io.Serializable;

public class PreviousGrade implements Serializable {
    String semester;
    String course1;
    String course2;
    String course3;
    String course1grade;
    String course2grade;
    String cours3grade;
    int numberofcourse;
    double CGPA;

    public PreviousGrade(String semester,String course1,String course2,String course3,String course1grade,String course2grade,String cours3grade,int numberofcourse,double CGPA) {
        this.semester=semester;
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.course1grade=course1grade;
        this.course2grade=course2grade;
        this.cours3grade=cours3grade;
        this.numberofcourse=numberofcourse;
        this.CGPA=CGPA;

    }
    public PreviousGrade(String semester,String course1,String course2,String course1grade,String course2grade,int numberofcourse,double CGPA) {
        this.semester=semester;
        this.course1=course1;
        this.course2=course2;

        this.course1grade=course1grade;
        this.course2grade=course2grade;
        this.numberofcourse=numberofcourse;
        this.CGPA=CGPA;


    }
    public PreviousGrade(String semester,String course1,String course1grade,int numberofcourse,double CGPA) {
        this.semester=semester;
        this.course1=course1;
        this.course1grade=course1grade;
        this.numberofcourse=numberofcourse;
        this.CGPA=CGPA;

    }

    public double getCGPA() {
        return CGPA;
    }


    public String getSemester() {
        return semester;
    }
    public String getCourse1() {
        return course1;
    }

    public String getCourse2() {
        return course2;
    }

    public String getCourse3() {
        return course3;
    }
    public String getCourse1grade() {
        return course1grade;
    }
    public String getCourse2grade() {
        return course2grade;
    }
    public String getCours3grade() {
        return cours3grade;
    }

    public int getNumberofcourse() {
        return numberofcourse;
    }
}

