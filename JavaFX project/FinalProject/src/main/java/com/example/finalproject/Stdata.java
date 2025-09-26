package com.example.finalproject;

public class Stdata {
    public String Name;
    public String Id;
    public String Email;
    public int Age;
    public String NationalId;
    public double Cgpa;
    public String MajorDepartment;
    public String MinorDepartment;
    public int StudyLevel;

    public Stdata(String name, String id, String email, int age, String nationalId, double cgpa, String majorDepartment, String minorDepartment, int studyLevel) {
        Name = name;
        Id = id;
        Email = email;
        Age = age;
        NationalId = nationalId;
        Cgpa = cgpa;
        MajorDepartment = majorDepartment;
        MinorDepartment = minorDepartment;
        StudyLevel = studyLevel;
    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public int getAge() {
        return Age;
    }

    public String getNationalId() {
        return NationalId;
    }

    public double getCgpa() {
        return Cgpa;
    }

    public String getMajorDepartment() {
        return MajorDepartment;
    }

    public String getMinorDepartment() {
        return MinorDepartment;
    }

    public int getStudyLevel() {
        return StudyLevel;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public void setCgpa(double cgpa) {
        Cgpa = cgpa;
    }

    public void setMajorDepartment(String majorDepartment) {
        MajorDepartment = majorDepartment;
    }

    public void setMinorDepartment(String minorDepartment) {
        MinorDepartment = minorDepartment;
    }

    public void setStudyLevel(int studyLevel) {
        StudyLevel = studyLevel;
    }

}
