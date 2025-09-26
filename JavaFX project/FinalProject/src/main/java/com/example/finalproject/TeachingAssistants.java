package com.example.finalproject;
import java.sql.*;

public class TeachingAssistants extends Person implements DataOperationsPersons {
    
    double Salary ;
    String MajorDepartment;
    String Room;
    Courses Courses;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    public TeachingAssistants() {}
    public TeachingAssistants( String Name, String ID, String Email, int Age, String NationalId , double Salary, String MajorDepartment, String Room) {
        super(Name, ID, Email, Age, NationalId);
        SetSalary(Salary);
        SetMajorDepartment(MajorDepartment);
        this.Room = Room;
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
    public void SetRoom(String Room) {
        this.Room = Room;
    }
    public double GetSalary() {
        return Salary;
    }
    public String GetMajorDepartment() {
        return MajorDepartment;
    }
    public String GetRoom() {
        return Room;
    }
    public double CheckSalary(double Salary) {
        if (Salary>=3000 && Salary<=5000)
            return Salary;
        else {
            System.out.println("Invalid Professor Teaching Assistant , Should be in range of (3000 -> 5000)");
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
        return "TeachingAssistants{" + "Salary=" + Salary + ", MajorDepartment='" + MajorDepartment +  '\'' + ", Room='" + Room + '\'' + ", Name='" + Name + '\'' + ", Id=" + Id + ", Email='" + Email + '\'' + ", Age=" + Age + ", NationalId='" + NationalId + '\'' + '}';
    }
    @Override
    public void Add() throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "INSERT INTO teachingassistants (Name, Id, Email, Age, NationalId, Salary ,MajorDepartment,Room) VALUES (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Name);
            stmt.setString(2, Id);
            stmt.setString(3, Email);
            stmt.setString(4, String.valueOf(Age));
            stmt.setString(5, NationalId);
            stmt.setString(6, String.valueOf(Salary));
            stmt.setString(7, MajorDepartment);
            stmt.setString(8, Room);
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
            String sql = "UPDATE teachingassistants SET Name = ?,Email = ?,Age = ?,NationalId = ? WHERE Id = ?";
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
    public void Update(String Id,double Salary,String MajorDepartment,String Room) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "UPDATE teachingassistants SET Salary = ?,MajorDepartment = ?,Room = ?  WHERE Id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(CheckSalary(Salary)));
            stmt.setString(2, CheckMajorDepartment(MajorDepartment));
            stmt.setString(3, Room);
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
            String sql = "DELETE FROM teachingassistants WHERE Id = ?";
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
            String sql = "SELECT * FROM teachingassistants";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println('{' +"Name: " + rs.getString("Name") +" , Id: " + rs.getString("Id") +
                        ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                        "NationalId: " + rs.getString("NationalId") +", Salary: " + rs.getString("Salary")+
                        "MajorDepartment: " + rs.getString("MajorDepartment") +", Room: " + rs.getString("Room")+'}');
            }
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Print(String Id) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM teachingassistants WHERE Id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println('{' + "Name: " + rs.getString("Name") + " , Id: " + rs.getString("Id") +
                        ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                        "NationalId: " + rs.getString("NationalId") + ", Salary: " + rs.getString("Salary") +
                        "MajorDepartment: " + rs.getString("MajorDepartment") + ", Room: " + rs.getString("Room") + '}');
            }
            this.PrintAssistantCourses(Id);
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void AddCourses(String Id , Courses... courses) throws SQLException {
        if (courses.length > 3) {
            throw new IllegalArgumentException("Maximum of 3 courses can be added");
        }
        try {
            con = DataOperationsPersons.DBConnection();
            String sql ="INSERT INTO assistantscourses" + "  (assistant_id, course_id) VALUES " + " (?, ?);";
            stmt = con.prepareStatement(sql);
            for (Courses course  : courses) {
                stmt.setString(1, Id);
                stmt.setString(2, course.getCode());
                stmt.executeUpdate();
            }
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void AddCourse(String Id, Courses course) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String countSql = "SELECT COUNT(*) FROM assistantscourses WHERE assistant_id = ?;";
            PreparedStatement countStmt = con.prepareStatement(countSql);
            countStmt.setString(1, Id);
            ResultSet rs = countStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count >= 3) {
                HelloApplication.AaddCoAs.show();
                throw new IllegalArgumentException("Maximum of 3 courses can be added");
            }
            String sql = "INSERT INTO assistantscourses (assistant_id, course_id) VALUES (?, ?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            stmt.setString(2, course.getCode());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void PrintAssistantCourses(String Id) throws SQLException {
        try {
            Connection con = DataOperationsPersons.DBConnection();
            String sql = "SELECT courses.Code, courses.CreditHours , courses.Name  FROM assistantscourses JOIN courses ON assistantscourses.course_id = courses.Code WHERE assistantscourses.assistant_id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Courses:");
            while (rs.next()) {
                System.out.println("{ Course ID: " + rs.getString("Code") + "  ,  Course CreditHours: " + rs.getInt("CreditHours") + "  ,  Course Name: " + rs.getString("Name")+ " }");
            }
            rs.close();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void DeleteAssistantCourses(String Id , String Code) throws SQLException {
        try {
            Connection con = DataOperationsPersons.DBConnection();
            String sql = "DELETE FROM assistantscourses WHERE assistant_id = ? AND course_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Id);
            stmt.setString(2,Code);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
}
