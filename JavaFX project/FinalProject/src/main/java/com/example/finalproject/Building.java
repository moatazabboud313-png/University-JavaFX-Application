package com.example.finalproject;
import java.util.ArrayList;

public class Building {
    String Name;
    ArrayList <String> Laps;
    ArrayList <String> Halls;
    ArrayList <String> Offices;
    ArrayList <String> AssistantsRooms;
    ArrayList<Department> Departments;
    public Building(String Name ,ArrayList<String> Laps, ArrayList<String> Halls, ArrayList<String> Offices, ArrayList<String> AssistantsRooms, ArrayList<Department> Departments) {
        this.Name=Name;
        this.Laps = Laps;
        this.Halls = Halls;
        this.Offices = Offices;
        this.AssistantsRooms = AssistantsRooms;
        this.Departments = Departments;
    }
    public void PrintBuildingDetails() {
        System.out.println(Name +": {" + "Laps=" + Laps + ", Halls=" + Halls + "\n, Offices=" + Offices + ", AssistantsRooms=" + AssistantsRooms +'}'+"\n");
        System.out.println(Departments);
    }
}
