package com.project.demo;

import java.io.Serializable;

 class AttendanceAndCourse implements Serializable {

    private String studentID;

    private int totalCourse;

    private String course1;
    private String course2;
    private String course3;

    private String faculty1;
    private String faculty2;
    private String faculty3;

    private String section1;
    private String section2;
    private String section3;

    private int classAttendance1;
    private int classAttendance2;
    private int classAttendance3;

    private int missingClass1;
    private int missingClass2;
    private int missingClass3;

    private boolean festats1;
    private boolean festats2;
    private boolean festats3;

     AttendanceAndCourse(){

     }


    AttendanceAndCourse(String studentID, String course1, String course2, String course3,
                        String section1, String section2, String section3,String faculty1,String faculty2,String faculty3){
        this.studentID=studentID;
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.section1=section1;
        this.section2=section2;
        this.section3=section3;
        this.faculty1=faculty1;
        this.faculty2=faculty2;
        this.faculty3=faculty3;
        this.totalCourse=3;
    }

    AttendanceAndCourse(String studentID, String course1, String course2, String section1, String section2,
                        String faculty1,String faculty2){
        this.studentID=studentID;
        this.course1=course1;
        this.course2=course2;
        this.section1=section1;
        this.section2=section2;
        this.faculty1=faculty1;
        this.faculty2=faculty2;
        this.totalCourse=2;
    }

    AttendanceAndCourse(String studentID, String course1, String section1,String faculty1){
        this.studentID=studentID;
        this.course1=course1;
        this.section1=section1;
        this.faculty1=faculty1;
        this.totalCourse=1;
    }
    //get student id
    public String getStudentID() {
        return studentID;
    }
    //get total class
    public int getTotalCourse() {
        return totalCourse;
    }
    //get course list
    public String getCourse1() {
        return course1;
    }

    public String getCourse2() {
        return course2;
    }

    public String getCourse3() {
        return course3;
    }

    //get section list
    public String getSection1() {
        return section1;
    }

    public String getSection2() {
        return section2;
    }

    public String getSection3() {
        return section3;
    }

    //get faculty list

     public String getFaculty1() {
         return faculty1;
     }

     public String getFaculty2() {
         return faculty2;
     }

     public String getFaculty3() {
         return faculty3;
     }

     //get number of class attendance and add plus one to each class attendance
    public int getClassAttendance1() {
        return classAttendance1;
    }

   public void setClassAttendance1(int classAttendance1) {
        this.classAttendance1++;
    }

    public int getClassAttendance2() {
        return classAttendance2;
    }

    public void setClassAttendance2(int classAttendance2) {
        this.classAttendance2++;
    }

    public int getClassAttendance3() {
        return classAttendance3;
    }

    public void setClassAttendance3(int classAttendance3) {
        this.classAttendance3++;
    }

    //get number of class missing and add plus one to each class missing
    public int getMissingClass1() {
        return missingClass1;
    }

    public void setMissingClass1(int missingClass1) {
        this.missingClass1++;
    }

    public int getMissingClass2() {
        return missingClass2;
    }

    public void setMissingClass2(int missingClass2) {
        this.missingClass2++;
    }

    public int getMissingClass3() {
        return missingClass3;
    }

    public void setMissingClass3(int missingClass3) {
        this.missingClass3++;
    }

    //faculty evaution status
     public boolean getfestats1() {
         return festats1;
     }
     public void setFestats1() {
         this.festats1 = true;
     }

     public boolean getfestats2() {
         return festats2;
     }
     public void setFestats2() {
         this.festats2 = true;
     }

     public boolean getfestats3() {
         return festats3;
     }
     public void setFestats3() {
         this.festats3 = true;
     }



 }