package com.example.finalproject;
public abstract class Person {
    protected String Name;
    protected String Id;
    protected String Email;
    protected int Age;
    protected String NationalId;
    public Person() {}
    public Person(String Name, String Id) {
        this.Name=Name;
    this.Id=Id;}
    public Person(String Name, String Id, String Email, int Age, String NationalId) {
        SetName(Name);
        SetId(Id);
        this.Email = Email;
        SetAge(Age);
        SetNationalId(NationalId);
    }
    protected Person(String Name, String Id, int Age, String NationalId) {
        SetName(Name);
        SetId(Id);
        SetAge(Age);
        SetNationalId(NationalId);
    }
    public void SetName(String Name) {
        if (CheckName(Name)!=null)
            this.Name= Name;
    }
    public void SetId(String Id) {
        if (CheckId(Id)!=null)
            this.Id = Id;
    }
    public void SetEmail(String Email) {
        this.Email = Email;
    }
    public void SetAge(int Age) {
        if (CheckAge(Age)!=0)
            this.Age = Age;
    }
    public void SetNationalId(String NationalId) {
        if (CheckNationalId(NationalId)!=null)
            this.NationalId= NationalId;
    }
    public String CheckName(String Name) {
        if (Name.length()>6)
            return Name;
        else{
            System.out.println("Invalid Name , Should consist of your 3 first names  " + Name);
            return null;
        }
    }
    public String CheckId(String Id) {
        if (Id.length()==10) {
            return Id;
        } else {
            System.out.println("Invalid Id , Should consist of 10 numbers  " + Id);
            return null;
        }
    }
    public int CheckAge(int Age) {
        if (Age >= 16)
            return Age;
        else {
            System.out.println("Invalid Age , Should be over 16 years  " +Age);
            return 0;
        }
    }
    public String CheckNationalId(String NationalId) {
        if (NationalId.length()==14)
            return NationalId;
        else {
            System.out.println("Invalid NationalId , Check your national id of 14 numbers  " +NationalId);
            return null;
        }
    }
    public String GetName() {
        return Name;
    }
    public String GetId() {
        return Id;
    }
    public String GetEmail() {
        return Email;
    }
    public double GetAge() {
        return Age;
    }
    public String GetNationalId() {
        return NationalId;
    }
}
