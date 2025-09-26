package com.example.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract interface DataOperationsPersons {

    public static Connection DBConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }
    public void Add() throws SQLException;
    public void Update(String Id,String Name, String Email, int Age, String NationalId) throws SQLException;
    public  void Delete(String Id) throws SQLException;
    public void PrintAll() throws SQLException ;
    public void Print(String Id) throws SQLException ;

}
