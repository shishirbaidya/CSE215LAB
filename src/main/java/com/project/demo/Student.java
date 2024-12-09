package com.project.demo;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String id;
    private String Dept;
    private String Sem;
    private  String Gen;


    Student(String name, String id, String Dept,String Sem,String Gen) {
        this.name = name;
        this.Dept = Dept;
        this.id = id;
        this.Sem=Sem;
        this.Gen=Gen;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getDept() {
        return this.Dept;
    }

    public String getSem() {
        return this.Sem;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    public void setId(String var1) {
        this.id = var1;
    }

    public void setDept(String var1) {
        this.Dept = var1;
    }

    public void setSem(String var1) {
        this.Sem = var1;
    }

    public String getGen() {return Gen;}

    public void setGen(String gen) {Gen = gen;}
}

