package com.example.qlsv;

public class Student {
    int ID, Yearob;
    String Name;

    public Student(int ID, int yearob, String name) {
        this.ID = ID;
        Yearob = yearob;
        Name = name;
    }

    public Student() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYearob() {
        return Yearob;
    }

    public void setYearob(int yearob) {
        Yearob = yearob;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
