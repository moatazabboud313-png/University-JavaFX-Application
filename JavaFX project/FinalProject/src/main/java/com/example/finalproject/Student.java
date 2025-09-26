package com.example.finalproject;


import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Student extends Person implements DataOperationsPersons {
    private double Cgpa;
    private String MajorDepartment;
    private String MinorDepartment;
    private int StudyLevel;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Courses Courses;
    public String name;
    public String id;
    public int sl;



    public Student() {}
    public Student(String name,String id,int sl){
        this.name=name;
        this.id=id;
        this.sl=sl;
    }
    public Student(String Name, String Id, String Email, int Age, String NationalId , double Cgpa, String MajorDepartment, String MinorDepartment, int StudyLevel) throws SQLException {
        super(Name, Id, Email, Age, NationalId);
        SetCgpa(Cgpa);
        SetMajorDepartment(MajorDepartment);
        SetMinorDepartment(MinorDepartment);
        SetStudyLevel(StudyLevel);
        try {
            Add();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void SetCgpa(double Cgpa) {
        if (CheckCgpa(Cgpa)!=0)
            this.Cgpa = Cgpa;
    }
    public void SetMajorDepartment(String MJD) {
        if (CheckMajorDepartment(MJD)!= null)
            this.MajorDepartment = MJD;
    }
    public void SetMinorDepartment(String MID) {
        if (CheckMinorDepartment(MID)!= null)
            this.MinorDepartment = MID;
    }
    public void SetStudyLevel(int StudyLevel) {
        if (CheckStudyLevel(StudyLevel)!=0)
            this.StudyLevel = StudyLevel;
    }
    public double GetCgpa() {
        return Cgpa;
    }
    public String GetMajorDepartment() {
        return MajorDepartment;
    }
    public String GetMinorDepartment() {
        return MinorDepartment;
    }
    public int GetStudyLevel() {
        return StudyLevel;
    }
    public double CheckCgpa(double Cgpa) {
        if (Cgpa>=0 && Cgpa<=4)
            return Cgpa;
        else{
            System.out.println("Invalid Cgpa , Should be in range of (0->4)");
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
    public String CheckMinorDepartment(String MID) {
        if (MID.equalsIgnoreCase("cs") || MID.equalsIgnoreCase("physics") ||
                MID.equalsIgnoreCase("chemistry") || MID.equalsIgnoreCase("Mathematics"))
            return MID;
        else {
            System.out.println("Invalid MinorDepartment , Should be [CS , Physics , Chemistry , Mathematics]");
            return null;
        }
    }
    public int CheckStudyLevel(int StudyLevel) {
        if (StudyLevel==1 || StudyLevel==2 || StudyLevel==3 || StudyLevel==4)
            return StudyLevel;
        else {
            System.out.println("Invalid MinorDepartment , Should be [1 , 2 , 3  , 4]");
            return 0;
        }
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getSl() {
        return sl;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setSl(int sl) {
        this.sl = sl;
    }

    @Override
    public String toString() {
        return "Student{" + "Cgpa=" + Cgpa + ", MajorDepartment=" + MajorDepartment + ", MinorDepartment=" + MinorDepartment + ", Year=" + StudyLevel + '}';
    }
    @Override
    public void Add() throws SQLException{
        try {
            con = DataOperationsPersons.DBConnection();
            String sql = "INSERT INTO students (Name, Id, Email, Age, NationalId, Cgpa,MajorDepartment,MinorDepartment,StudyLevel) VALUES (?, ?, ?,?,?,?,?, ?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Name);
            stmt.setString(2, Id);
            stmt.setString(3, Email);
            stmt.setString(4, String.valueOf(Age));
            stmt.setString(5, NationalId);
            stmt.setString(6, String.valueOf(Cgpa));
            stmt.setString(7, MajorDepartment);
            stmt.setString(8, MinorDepartment);
            stmt.setString(9, String.valueOf(StudyLevel));
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    @Override
    public void Update(String Id,String Name, String Email, int Age, String NationalId) throws SQLException {
        try {
        con = DataOperationsPersons.DBConnection();
        String sql = "UPDATE students SET Name = ?,Email = ?,Age = ?,NationalId = ? WHERE Id = ?";
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
    public void Update(String Id,double Cgpa,String MajorDepartment,String MinorDepartment, int StudyLevel) throws SQLException {
        try {
        con = DataOperationsPersons.DBConnection();
        String sql = "UPDATE students SET Cgpa = ?,MajorDepartment = ?,MinorDepartment = ?,StudyLevel = ? WHERE Id = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, String.valueOf(CheckCgpa(Cgpa)));
        stmt.setString(2, CheckMajorDepartment(MajorDepartment));
        stmt.setString(3, CheckMajorDepartment(MinorDepartment));
        stmt.setString(4, String.valueOf(CheckStudyLevel(StudyLevel)));
        stmt.setString(5, Id);
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
        String sql = "DELETE FROM students WHERE Id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.executeUpdate();
        stmt.close();
        con.close();
        HelloApplication.AremoveStEm2.show();}
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void PrintAll() throws SQLException {
        try {
        con = DataOperationsPersons.DBConnection();
        String sql = "SELECT * FROM students";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            System.out.println('{' +"Name: " + rs.getString("Name") +" , Id: " + rs.getString("Id") +
                    ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                    "NationalId: " + rs.getString("NationalId") +", Cgpa: " + rs.getString("Cgpa")+
                    "  MajorDepartment: " + rs.getString("MajorDepartment") +" , MinorDepartment: " + rs.getString("MinorDepartment")+
                    "StudyLevel: " + rs.getString("StudyLevel")+'}');
        }
        con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    @Override
    public void Print(String Id) throws SQLException {
        try {
        con = DataOperationsPersons.DBConnection();
        String sql = "SELECT * FROM students WHERE Id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1,Id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println('{' +"Name: " + rs.getString("Name") +" , Id: " + rs.getString("Id") +
                    ", Email: " + rs.getString("Email") + ", Age: " + rs.getString("Age") +
                    "NationalId: " + rs.getString("NationalId") +", Cgpa: " + rs.getString("Cgpa")+
                    "MajorDepartment: " + rs.getString("MajorDepartment") +", MinorDepartment: " + rs.getString("MinorDepartment")+
                    "StudyLevel: " + rs.getString("StudyLevel")+'}');
        }
        this.PrintStudentCourses(Id);
        stmt.close();
        con.close();    }
        catch (Exception e){
            System.out.println(e.toString());   }
    }
    public void AddCourses(String Id , Courses... courses) throws SQLException {
        if (courses.length > 8) {
            throw new IllegalArgumentException("Too many courses. Maximum is 8.");
        }
        Connection con = null;
        try {
            con = DataOperationsPersons.DBConnection();
            con.setAutoCommit(false);
            String sqladd ="INSERT INTO studentcourses" + "  (student_id, course_id) VALUES " + " (?, ?);";
            String sqlcourse = "SELECT * FROM studentcourses WHERE student_id = ? AND course_id = ?;";
            String sqlhours = "SELECT SUM(CreditHours) as TotalCreditHours FROM courses WHERE Code = ?;";
            PreparedStatement stmtadd = con.prepareStatement(sqladd);
            PreparedStatement stmtcourse = con.prepareStatement(sqlcourse);
            PreparedStatement stmthours = con.prepareStatement(sqlhours);
            int totalhours = 0;
            for (Courses course : courses) {
                stmtcourse.setString(1, Id);
                stmtcourse.setString(2, course.getCode());
                ResultSet rscourse = stmtcourse.executeQuery();
                if (rscourse.next()) {
                    throw new IllegalArgumentException("This course has already been added for this student  " + course.getCode());
                }
                stmthours.setString(1, course.getCode());
                ResultSet rshours = stmthours.executeQuery();
                if (rshours.next()) {
                    totalhours += rshours.getInt("TotalCreditHours");
                }
                rscourse.close();
                rshours.close();
                stmtadd.setString(1, Id);
                stmtadd.setString(2, course.getCode());
                stmtadd.executeUpdate();
            }
            if (totalhours < 15 || totalhours > 17) {
                throw new IllegalArgumentException("Invalid total credit hours , Must be in range (15 -> 17)");
            }
            con.commit();
            stmtcourse.close();
            stmthours.close();
            stmtadd.close();
        } catch (Exception e){
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
            System.out.println(e.toString());
        }
        if (con != null) {
            con.close();
        }
    }
    public void AddCourse(String Id , Courses course) throws SQLException {
        Connection con = null;
        try {
            con = DataOperationsPersons.DBConnection();
            con.setAutoCommit(false);
            String sqladd ="INSERT INTO studentcourses" + "  (student_id, course_id) VALUES " + " (?, ?);";
            String sqlcourse = "SELECT * FROM studentcourses WHERE student_id = ? AND course_id = ?;";
            String sqlhours = "SELECT SUM(CreditHours) as TotalCreditHours FROM courses WHERE Code IN (SELECT course_id FROM studentcourses WHERE student_id = ?);";
            PreparedStatement stmtadd = con.prepareStatement(sqladd);
            PreparedStatement stmtcourse = con.prepareStatement(sqlcourse);
            PreparedStatement stmthours = con.prepareStatement(sqlhours);

            stmtcourse.setString(1, Id);
            stmtcourse.setString(2, course.getCode());
            ResultSet rscourse = stmtcourse.executeQuery();
            if (rscourse.next()) {
                HelloApplication.AaddCoSt.show();
                throw new IllegalArgumentException("This course has already been added for this student  " + course.getCode());
            }
            rscourse.close();

            stmthours.setString(1, Id);
            ResultSet rshours = stmthours.executeQuery();
            int totalhours = 0;
            if (rshours.next()) {
                totalhours = rshours.getInt("TotalCreditHours");
            }
            rshours.close();

            if (totalhours + course.getCreditHours() > 17) {
                HelloApplication.AaddCoSt.show();
                throw new IllegalArgumentException("Adding this course will exceed the maximum allowed credit hours " + course.getCode());
            }

            stmtadd.setString(1, Id);
            stmtadd.setString(2, course.getCode());
            stmtadd.executeUpdate();

            con.commit();
            stmtcourse.close();
            stmthours.close();
            stmtadd.close();
            HelloApplication.AaddCoEm2.show();
        } catch (Exception e){
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException ex) {
                    System.out.println(ex.toString());

                }
            }
            System.out.println(e.toString());
        }
        if (con != null) {
            con.close();
        }
    }


    public void PrintStudentCourses(String Id) throws SQLException {
        try {
        Connection con = DataOperationsPersons.DBConnection();
        String sql = "SELECT courses.Code, courses.CreditHours , courses.Name  FROM studentcourses JOIN courses ON studentcourses.course_id = courses.Code WHERE studentcourses.student_id = ?;";
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
    public void DeleteStudentCourse(String Id , Courses course) throws SQLException {
        Connection con = null;
        try {
            con = DataOperationsPersons.DBConnection();
            con.setAutoCommit(false);
            String sqldelete = "DELETE FROM studentcourses WHERE student_id = ? AND course_id = ?";
            String sqlhours = "SELECT SUM(CreditHours) as TotalCreditHours FROM courses WHERE Code IN (SELECT course_id FROM studentcourses WHERE student_id = ?);";
            PreparedStatement stmtdelete = con.prepareStatement(sqldelete);
            PreparedStatement stmthours = con.prepareStatement(sqlhours);

            stmthours.setString(1, Id);
            ResultSet rshours = stmthours.executeQuery();
            int totalhours = 0;
            if (rshours.next()) {
                totalhours = rshours.getInt("TotalCreditHours");
            }
            rshours.close();

            if (totalhours - course.getCreditHours() < 15) {
                HelloApplication.AremoveCoSt.show();
                throw new IllegalArgumentException("Deleting this course will lower the total credit hours minimum than required.");
            }

            stmtdelete.setString(1, Id);
            stmtdelete.setString(2, course.getCode());
            stmtdelete.executeUpdate();

            con.commit();
            stmthours.close();
            stmtdelete.close();
            HelloApplication.AremoveCoEm2.show();
        } catch (Exception e){
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
            System.out.println(e.toString());
        }
        if (con != null) {
            con.close();
        }
    }

}


