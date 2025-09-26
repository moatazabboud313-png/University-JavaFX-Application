package com.example.finalproject;
import java.sql.*;

public class Professor extends Person implements DataOperationsPersons {
    private double Salary;
    private String MajorDepartment;
    private String Office;
    private String Lecture;
    private String Course;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    public Professor() {
    }
    public Professor(String Name, String ID, String Email, int Age, String NationalId , double Salary, String MajorDepartment, String Office, String Lecture, String Course) {
        super(Name, ID, Email, Age, NationalId);
        SetSalary(Salary);
        SetMajorDepartment(MajorDepartment);
        this.Office = Office;
        this.Lecture = Lecture;
        this.Course = Course;
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
    public void SetMajorDepartment(String MJD) {
        if (CheckMajorDepartment(MJD)!= null)
            this.MajorDepartment = MJD;
    }
    public void SetOffice(String office) {
        this.Office = office;
    }
    public void SetLecture(String Lectures) {
        this.Lecture = Lectures;
    }
    public void SetCourse(String Course) {
        this.Course = Course;
    }
    public double GetSalary() {
        return Salary;
    }
    public String GetMajorDepartment() {
        return MajorDepartment;
    }
    public String GetOffice() {
        return Office;
    }
    public String GetLecture() {
        return Lecture;
    }
    public String GetCourse() {
        return Course;
    }
    public double CheckSalary(double Salary) {
        if (Salary>=10000)
            return Salary;
        else {
            System.out.println("Invalid Professor Salary , Should be above 10000");
            return 0;
        }
    }
    public String CheckMajorDepartment(String MJD) {
        if (MJD.equalsIgnoreCase("cs") || MJD.equalsIgnoreCase("physics") ||
                MJD.equalsIgnoreCase("chemistry") || MJD.equalsIgnoreCase("Mathematics"))
            return MJD;
        else{
            System.out.println("Invalid MajorDepartment , Should be [CS , Physics , Chemistry , Mathematics]");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Professor{" + "Slary=" + Salary + ", Major=" + MajorDepartment + ", office=" + Office + ", Lectures=" + Lecture + ", Courses=" + Course + '}';
    }
    @Override
    public void Add() throws SQLException {
        try {
        con = DataOperationsPersons.DBConnection();
        String sql = "INSERT INTO professors (Name, Id, Email, Age, NationalId, Salary ,MajorDepartment,Office,Course,Lecture) VALUES (?,?,?,?,?,?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, Name);
        stmt.setString(2, Id);
        stmt.setString(3, Email);
        stmt.setString(4, String.valueOf(Age));
        stmt.setString(5, NationalId);
        stmt.setString(6, String.valueOf(Salary));
        stmt.setString(7, MajorDepartment);
        stmt.setString(8, Office);
        stmt.setString(9, Course);
        stmt.setString(10, Lecture);
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
        String sql = "UPDATE professors SET Name = ?,Email = ?,Age = ?,NationalId = ? WHERE Id = ?";
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
    public void Update(String Id,double Salary,String MajorDepartment,String Office, String Course,String Lecture) throws SQLException {
        try {
        con = DataOperationsPersons.DBConnection();
        String sql = "UPDATE professors SET Salary = ?,MajorDepartment = ?,Office = ?,Course = ? , Lecture =?  WHERE Id = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, String.valueOf(CheckSalary(Salary)));
        stmt.setString(2, CheckMajorDepartment(MajorDepartment));
        stmt.setString(3, Office);
        stmt.setString(4, Course);
        stmt.setString(5, Lecture);
        stmt.setString(6, Id);
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
        String sql = "DELETE FROM professors WHERE Id = ?";
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
        String sql = "SELECT * FROM professors";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            System.out.println('{' +"Name: " + rs.getString("Name") +" , Id: " + rs.getString("Id") +
                    ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                    "NationalId: " + rs.getString("NationalId") +", Salary: " + rs.getString("Salary")+
                    "MajorDepartment: " + rs.getString("MajorDepartment") +", Office: " + rs.getString("Office")+
                    "Course: " + rs.getString("Course")+ "Lecture: " + rs.getString("Lecture")+'}');
        }
        con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Print(String Id) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM professors WHERE Id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println('{' + "Name: " + rs.getString("Name") + " , Id: " + rs.getString("Id") +
                        ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                        "NationalId: " + rs.getString("NationalId") + ", Salary: " + rs.getString("Salary") +
                        "MajorDepartment: " + rs.getString("MajorDepartment") + ", Office: " + rs.getString("Office") +
                        "Course: " + rs.getString("Course") + "Lecture: " + rs.getString("Lecture") + '}');
            }
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void DeleteMyStudentCourse(String Id , Courses course) throws SQLException {
        if (!Id.startsWith("111") && Id.length()!=10){HelloApplication.AremoveCoP.show();}
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

