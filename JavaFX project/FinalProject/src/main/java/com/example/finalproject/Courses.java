package com.example.finalproject;
import java.sql.*;

public class Courses  {
    public String Code;
    public int CreditHours;
    public String Name;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    public Courses() {
    }
    public Courses(String code) {
        Code = code;
    }
    public Courses(String Code, int CreditHours, String Name) {
        this.Code = Code;
        this.CreditHours = CreditHours;
        this.Name=Name;
        /*try {
            AddCourse();
        } catch (Exception e) {
            System.out.println(e.toString());
        }*/
    }
    public void setCode(String Code) {
        this.Code = Code;
    }
    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getCode() {
        return Code;
    }
    public int getCreditHours() {
        return CreditHours;
    }
    public String getName() {
        return Name;
    }
    @Override
    public String toString() {
        return "Courses{" + "Code='" + Code + '\'' + ", CreditHours=" + CreditHours + ", Name='" + Name + '\'' + '}';
    }
    public void AddCourse() throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "INSERT INTO courses (Code, CreditHours, Name) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Code);
            stmt.setString(2, String.valueOf(CreditHours));
            stmt.setString(3, Name);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void UpdateCourse(String Code,int CreditHours, String Name) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "UPDATE courses SET CreditHours = ?,Name = ? WHERE Code = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(CreditHours));
            stmt.setString(2, Name);
            stmt.setString(3, Code);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void DeleteCourse(String Code) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "DELETE FROM courses WHERE Code = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Code);
            stmt.executeUpdate();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }

    public void PrintAllCourses() throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM courses";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println('{' +"Code: " + rs.getString("Code") +" , CreditHours: " + rs.getString("CreditHours") +
                        ", Name: " + rs.getString("Name") +'}');
            }
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void PrintCourse(String Code) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM courses WHERE Code=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(Code));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println('{' +"Code: " + rs.getString("Code") +" , CreditHours: " + rs.getString("CreditHours") +
                        ", Name: " + rs.getString("Name") +'}');
            }
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void PrintCourseAllData(String Code) throws SQLException {
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "SELECT * FROM courses WHERE Code=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(Code));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println('{' +"Code: " + rs.getString("Code") +" , CreditHours: " + rs.getString("CreditHours") +
                        ", Name: " + rs.getString("Name") +'}');
            }
            this.PrintCourseAssistants(Code);
            this.PrintCourseStudents(Code);
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void PrintCourseStudents(String Code)throws SQLException{
        try {
            Connection con = DataOperationsPersons.DBConnection();
            //SELECT courses.Code, courses.CreditHours , courses.Name  FROM studentcourses JOIN courses ON studentcourses.course_id = courses.Code WHERE studentcourses.student_id = ?;
            String sql = "SELECT students.Name , students.Id , students.StudyLevel  FROM studentcourses JOIN students ON studentcourses.student_id = students.Id WHERE studentcourses.course_id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Code);
            ResultSet rs = stmt.executeQuery();
            int i =0;
            System.out.println("Student registered:");
            while (rs.next()) { i++;
                System.out.println("{ Student : " + rs.getString("Name") + "  ,  Student Id: " + rs.getInt("Id") + "  ,  StudyLevel: " + rs.getString("StudyLevel")+ " }");
            }
            System.out.println("Number of Student who registered to this course is : "+ i );
            rs.close();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void PrintCourseAssistants(String Code)throws SQLException{
        try {
            Connection con = DataOperationsPersons.DBConnection();
            String sql = "SELECT teachingassistants.Name , teachingassistants.Id , teachingassistants.Room  FROM assistantscourses JOIN teachingassistants ON assistantscourses.assistant_id = teachingassistants.Id WHERE assistantscourses.course_id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Code);
            ResultSet rs = stmt.executeQuery();
            int i =0;
            System.out.println("Teaching Assistant registered:");
            while (rs.next()) { i++;
                System.out.println("{ Teaching Assistant : " + rs.getString("Name") + "  ,  Assistant Id: " + rs.getInt("Id") + "  ,  Room: " + rs.getString("Room")+ " }");
            }
            System.out.println("Number of Teaching Assistants who registered to this course is : "+ i );
            rs.close();
            stmt.close();
            con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }

}
