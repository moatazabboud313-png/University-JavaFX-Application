package com.example.finalproject;
import java.util.ArrayList;

public class Department {
    String Name;
    ArrayList <String> ProfessorsNames;
    ArrayList <String> TeachingAssistantsNames;
    ArrayList <String>  CoursesCodes;
    String BuildingPlace;
    public Department(String Name, ArrayList<String> ProfessorsNames, ArrayList<String> TeachingAssistantsNames, ArrayList<String> CoursesCodes, String BuildingPlace) {
        this.Name = Name;
        this.ProfessorsNames = ProfessorsNames;
        this.TeachingAssistantsNames = TeachingAssistantsNames;
        this.CoursesCodes = CoursesCodes;
        this.BuildingPlace = BuildingPlace;
    }
    @Override
    public String toString() {
        return "Department{" + "Name='" + Name + '\'' + ", ProfessorsNames=" + ProfessorsNames +
                "\n, TeachingAssistantsNames=" + TeachingAssistantsNames + "\n, CoursesCodes=" + CoursesCodes +
                ", BuildingPlace='" + BuildingPlace + '\'' + '}' + "\n\n";
    }
}
