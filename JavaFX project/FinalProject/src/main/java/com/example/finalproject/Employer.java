package com.example.finalproject;
import java.sql.*;

public class Employer extends Person implements DataOperationsPersons {
    
    double Salary;
    double WorkingHours;
    String Position;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public Employer() {
    }
    public Employer( String Name, String ID, String Email, int Age, String NationalId , double Salary, double WorkingHours, String Position) {
        super(Name, ID, Email, Age, NationalId);
        SetSalary(Salary);
        SetWorkingHours(WorkingHours);
        this.Position = Position;
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
    public void SetWorkingHours(double WorkingHours) {
        if (CheckWorkingHours(WorkingHours) !=0)
            this.WorkingHours = WorkingHours;
    }
    public void SetPosition(String Position) {
        this.Position = Position;
    }
    public double GetSalary() {
        return Salary;
    }
    public double GetWorkingHours() {
        return WorkingHours;
    }
    public String GetPosition() {
        return Position;
    }
    public double CheckSalary(double Salary) {
        if (Salary>=6000 && Salary<=9000)
            return Salary;
        else {
            System.out.println("Invalid Employer Salary , Should be above 10000");
            return 0;
        }
    }
    public double CheckWorkingHours(double WH) {
        if (WH>=4 && WH<=8)
            return WH;
        else {
            System.out.println("Invalid Working Hours , Should be in range of (4 -> 8))");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Employer{" + "Salary=" + Salary + ", WorkingHours=" + WorkingHours + ", Position='" + Position + '\'' + ", Name='" + Name + '\'' + ", Id=" + Id + ", Email='" + Email + '\'' + ", Age=" + Age + ", NationalId='" + NationalId + '\'' + '}';
    }
    @Override
    public void Add() throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "INSERT INTO employers (Name, Id, Email, Age, NationalId, Salary ,WorkingHours,Position) VALUES (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Name);
            stmt.setString(2, Id);
            stmt.setString(3, Email);
            stmt.setString(4, String.valueOf(Age));
            stmt.setString(5, NationalId);
            stmt.setString(6, String.valueOf(Salary));
            stmt.setString(7, String.valueOf(WorkingHours));
            stmt.setString(8, Position);
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
            String sql = "UPDATE employers SET Name = ?,Email = ?,Age = ?,NationalId = ? WHERE Id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CheckName(Name));
            stmt.setString(2, Email);
            stmt.setString(3, String.valueOf(CheckAge(Age)));
            stmt.setString(4, CheckNationalId(NationalId));
            stmt.setString(5, Id);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void Update(String Id,double Salary,int WorkingHours,String Position) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "UPDATE employers SET Salary = ?,WorkingHours = ?,Position = ?  WHERE Id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(CheckSalary(Salary)));
            stmt.setString(2, String.valueOf(CheckWorkingHours(WorkingHours)));
            stmt.setString(3, Position);
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
            String sql = "DELETE FROM employers WHERE Id = ?";
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
            String sql = "SELECT * FROM employers";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println('{' +"Name: " + rs.getString("Name") +" , Id: " + rs.getString("Id") +
                        ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                        "NationalId: " + rs.getString("NationalId") +", Salary: " + rs.getString("Salary")+
                        "WorkingHours: " + rs.getString("WorkingHours") +", Position: " + rs.getString("Position")+'}');
            }
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Print(String Id) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM employers WHERE Id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println('{' + "Name: " + rs.getString("Name") + " , Id: " + rs.getString("Id") +
                        ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                        "NationalId: " + rs.getString("NationalId") + ", Salary: " + rs.getString("Salary") +
                        "WorkingHours: " + rs.getString("WorkingHours") + ", Position: " + rs.getString("Position") + '}');
            }
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void DeleteStudentCourse(String Id , Courses course) throws SQLException {
        try {
            Connection con = DataOperationsPersons.DBConnection();
            String sql = "DELETE FROM studentcourses WHERE student_id = ? AND course_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            stmt.setString(2,course.getCode());
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }

}
