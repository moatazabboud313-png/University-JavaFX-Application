package com.example.finalproject;
import java.sql.*;

public class Staff extends Person implements DataOperationsPersons {
    double Salary;
    int WorkingHours;
    String Type;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    public Staff() {
    }
    public Staff(String Name, String ID, int Age, String NationalId ,double Salary, int WorkingHours, String Type) {
        super(Name, ID,Age, NationalId);
        this.Salary = Salary;
        this.WorkingHours = WorkingHours;
        this.Type = Type;
        try {
            Add();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void SetSalary(double Salary) {
        if(CheckSalary(Salary) != 0)
            this.Salary=Salary;
    }
    public void SetWorkingHours(int WorkingHours) {
        if (CheckWorkingHours(WorkingHours) != 0)
            this.WorkingHours = WorkingHours;
    }
    public void SetType(String type) {
        Type = type;
    }
    public double GetSalary() {
        return Salary;
    }
    public int GetWorkingHours() {
        return WorkingHours;
    }
    public String GetType() {
        return Type;
    }
    public double CheckSalary(double Salary) {
        if (Salary>=1000 && Salary<=2000)
            return Salary;
        else {
            System.out.println("Invalid Employer Staff , Should be in range of (1000 -> 2000)");
            return 0;
        }
    }
    public double CheckWorkingHours(double WH) {
        if (WH>=7 && WH<=9)
            return WH;
        else {
            System.out.println("Invalid Working Hours , Should be in range of (7 -> 9))");
            return 0;
        }
    }
    @Override
    public String toString() {
        return "Staff{" + "Salary=" + Salary + ", WorkingHours=" + WorkingHours + ", Type='" + Type + '\'' + ", Name='" + Name + '\'' + ", Id=" + Id + ", Email='" + Email + '\'' + ", Age=" + Age + ", NationalId='" + NationalId + '\'' + '}';
    }
    @Override
    public void Add() throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "INSERT INTO staff (Name, Id, Age, NationalId, Salary ,WorkingHours,Type) VALUES (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Name);
            stmt.setString(2, String.valueOf(Id));
            stmt.setString(3, String.valueOf(Age));
            stmt.setString(4, NationalId);
            stmt.setString(5, String.valueOf(Salary));
            stmt.setString(6, String.valueOf(WorkingHours));
            stmt.setString(7, Type);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Update(String Id,String Name, String Email, int Age, String NationalId) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "UPDATE staff SET Name = ?,Age = ?,NationalId = ? WHERE Id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CheckName(Name));
            stmt.setString(2, String.valueOf(CheckAge(Age)));
            stmt.setString(3, CheckNationalId(NationalId));
            stmt.setString(4, Id);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void Update(String Id,double Salary,int WorkingHours,String Position) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "UPDATE staff SET Salary = ?,WorkingHours = ?,Type = ?  WHERE Id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(CheckSalary(Salary)));
            stmt.setString(2, String.valueOf(CheckWorkingHours(WorkingHours)));
            stmt.setString(3, Type);
            stmt.setString(4, Id);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Delete(String id) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "DELETE FROM staff WHERE Id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void PrintAll() throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM staff";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println('{' +"Name: " + rs.getString("Name") +" , Id: " + rs.getString("Id") +
                        ", Age: " + rs.getString("Age") + "NationalId: " + rs.getString("NationalId")
                        +", Salary: " + rs.getString("Salary")+ "WorkingHours: " + rs.getString("WorkingHours") +
                        ", Room: " + rs.getString("Room")+'}');
            }
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Print(String Id) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM staff WHERE Id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println('{' + "Name: " + rs.getString("Name") + " , Id: " + rs.getString("Id") +
                         ", Age: " + rs.getString("Age") + "NationalId: " + rs.getString("NationalId") + ", Salary: "
                        + rs.getString("Salary") + "WorkingHours: " + rs.getString("WorkingHours") +
                        ", Type: " + rs.getString("Type") + '}');
            }
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
}
