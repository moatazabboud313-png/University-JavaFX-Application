package com.example.finalproject;
import java.util.ArrayList;
import java.util.Arrays;

public class AssempleBD {
       public static final Department CS = new Department("CS",
                new ArrayList<String>((Arrays.asList("Ahmed Sameeh","Ail Samy","Khaled El-Sayed"))),
                new ArrayList<String>((Arrays.asList("Bassem Youssef","Amir Mahmoud","Rana Khamis","Eman Ali","Amira Abd-Allah","Sherif Ahmed"))),
                new ArrayList<String>((Arrays.asList("CS101","CS109","CS276","CS50","CS107","CS110","CS161"))),"Building A");
       public static final Department Mathematics  = new Department("Mathematics",
                new ArrayList<String>((Arrays.asList("Mohammed Ibrahim","Ahmed Radi","Nehal Ahmed"))),
                new ArrayList<String>((Arrays.asList("Sayed Hosny","Tamer Ragab","Noran Mahmoud","Samia Hassan","Sali Khalil","Adel Hossam"))),
                new ArrayList<String>((Arrays.asList("MT110","MT102","MT109","MT162","MT103"))),"Building A");
       public static final Department Physics = new Department("Physics",
                new ArrayList<String>((Arrays.asList("Hossam Gaber","Amira Ali","Laila Ahmed"))),
                new ArrayList<String>((Arrays.asList("Mostafa Saad","Alaa Khaled","Samira Khalil","Assmaa Ibrahim","Mahmoud Saied","Talia Sayed"))),
                new ArrayList<String>((Arrays.asList("PH101","PH102","PH0030","PH119","PH0100","PH040","PH030"))),"Building B");
       public static final Department Chemistry = new Department("Chemistry",
                new ArrayList<String>((Arrays.asList("Hani Gamal","Ahmed Zakaria","Salma Emad"))),
                new ArrayList<String>((Arrays.asList("Samir Mohammed","Mohammed Ali","Dalia Ibrahim","Sara Awad","Ahmed Mohammed","Nour Khalid"))),
                new ArrayList<String>((Arrays.asList("CH202D","CH301","CH240","CH106","CH311"))),"Building B");
       public static final Building BuildingA = new Building("BuildingA",
                new ArrayList<String>((Arrays.asList("Lab A CS","Lab B CS","Lab C CS"))),
                new ArrayList<String>((Arrays.asList("Hall 1","Hall 2","Hall 3"))),
                new ArrayList<String>((Arrays.asList("Office 1 CS","Office 2 CS","Office 3 CS","Office 1 MT","Office 2 MT","Office 3 MT"))),
                new ArrayList<String>((Arrays.asList("Room 1","Room 2"))),
                new ArrayList<Department>((Arrays.asList(CS,Mathematics))));
       public static final Building BuildingB = new Building("BuildingB",
                new ArrayList<String>((Arrays.asList("Lab A CM","Lab B CM","Lab C CM","Lab A PH","Lab B PH","Lab C PH"))),
                new ArrayList<String>((Arrays.asList("Hall 4","Hall 5","Hall 6"))),
                new ArrayList<String>((Arrays.asList("Office 1 CM","Office 2 CM","Office 3 CM","Office 1 PH","Office 2 PH","Office 3 PH"))),
                new ArrayList<String>((Arrays.asList("Room 3","Room 4"))),
                new ArrayList<Department>((Arrays.asList(Physics,Chemistry))));

}
