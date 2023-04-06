package assetmanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccslearner
 */
import java.util.*;
import java.sql.*;
public class assetactivity {
    
    // Fields of Asset Activity
    public int asset_activityid;
    public int assetid;
    public String description;
    public int hoa_officer;
    public java.sql.Date tent_start;
    public java.sql.Date tent_end;
    public java.sql.Date actual_start;
    public java.sql.Date actual_end;
    public int orno; 
    public String status;
    
    // list of asset activity
    public ArrayList<Integer> asset_activityidList = new ArrayList<> ();
    public ArrayList<Integer> assetidList = new ArrayList<> ();
    public ArrayList<String> descriptionList = new ArrayList<>();
    public ArrayList<Integer> hoa_officerList = new ArrayList<> ();
    public ArrayList<java.sql.Date> tent_startList = new ArrayList<> ();
    public ArrayList<java.sql.Date> tent_endList = new ArrayList<>();
    public ArrayList<java.sql.Date> actual_startList = new ArrayList<> ();
    public ArrayList<java.sql.Date> actual_endList = new ArrayList<>();
    public ArrayList<Integer> ornoList = new ArrayList<> ();
    public ArrayList<String> statusList = new ArrayList<> ();

    
    public assetactivity(){
        
    }

    public int complete_assetactivity(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE FROM asset_activity SET status = 'C' WHERE asset_activityid	= ?'");
            pstmt.setString(1, status);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
     
    public int assetactivity_for_completion(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_activity;");
            ResultSet rst = pstmt.executeQuery();
            asset_activityidList.clear();
            assetidList.clear();
            descriptionList.clear();
            hoa_officerList.clear();
            tent_startList.clear();
            tent_endList.clear();
            actual_startList.clear();
            actual_endList.clear();
            ornoList.clear();
            statusList.clear();
            
            while(rst.next()){
                asset_activityid = rst.getInt("asset_activityid");
                assetid = rst.getInt("assetid");
                description = rst.getString("description");
                hoa_officer = rst.getInt("hoa_officer");
                tent_start = rst.getDate("tent_start");
                tent_end = rst.getDate("tent_end");
                actual_start = rst.getDate("actual_start");
                actual_end = rst.getDate("actual_end");
                orno = rst.getInt("orno");
                status = rst.getString("status");
            
                asset_activityidList.add(asset_activityid);
                assetidList.add(assetid);
                descriptionList.add(description);
                hoa_officerList.add(hoa_officer);
                tent_startList.add(tent_start);
                tent_endList.add(tent_end);
                actual_startList.add(actual_start);
                actual_endList.add(actual_end);
                ornoList.add(orno);
                statusList.add(status);
            }
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int delete_assetactivity(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM asset_activity WHERE asset_activityid = ?");
            pstmt.setInt(1, asset_activityid);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int assetactivity_for_deletion(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_activity;");
            ResultSet rst = pstmt.executeQuery();
            asset_activityidList.clear();
            assetidList.clear();
            descriptionList.clear();
            hoa_officerList.clear();
            tent_startList.clear();
            tent_endList.clear();
            actual_startList.clear();
            actual_endList.clear();
            ornoList.clear();
            statusList.clear();
            
            while(rst.next()){
                asset_activityid = rst.getInt("asset_activityid");
                assetid = rst.getInt("assetid");
                description = rst.getString("description");
                hoa_officer = rst.getInt("hoa_officer");
                tent_start = rst.getDate("tent_start");
                tent_end = rst.getDate("tent_end");
                actual_start = rst.getDate("actual_start");
                actual_end = rst.getDate("actual_end");
                orno = rst.getInt("orno");
                status = rst.getString("status");
            
                asset_activityidList.add(asset_activityid);
                assetidList.add(assetid);
                descriptionList.add(description);
                hoa_officerList.add(hoa_officer);
                tent_startList.add(tent_start);
                tent_endList.add(tent_end);
                actual_startList.add(actual_start);
                actual_endList.add(actual_end);
                ornoList.add(orno);
                statusList.add(status);
            }
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int update_activity(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE assetactivity SET assetid = ?, description = ?, hoa_officer = ?, tent_start = ?, tent_end = ?, actual_start = ?, actual_end = ?, orno = ?, status = ?  WHERE description = ?");
            pstmt.setInt(1, asset_activityid);
            pstmt.setInt(2, assetid);
            pstmt.setString(3, description);
            pstmt.setInt(4, hoa_officer);
            pstmt.setDate(5, tent_start);
            pstmt.setDate(6, tent_end);
            pstmt.setDate(7, actual_start);
            pstmt.setDate(8, actual_end);
            pstmt.setInt(9, orno);
            pstmt.setString(10, status);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int activity_for_update(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_activity");
            ResultSet rst = pstmt.executeQuery();
            asset_activityidList.clear();
            assetidList.clear();
            descriptionList.clear();
            hoa_officerList.clear();
            tent_startList.clear();
            tent_endList.clear();
            actual_startList.clear();
            actual_endList.clear();
            ornoList.clear();
            statusList.clear();
          
            
            while(rst.next()) { 
                   
                asset_activityid = rst.getInt("asset_activityid");
                assetid = rst.getInt("assetid");
                description = rst.getString("description");
                hoa_officer = rst.getInt("hoa_officer");
                tent_start = rst.getDate("tent_start");
                tent_end = rst.getDate("tent_end");
                actual_start = rst.getDate("actual_start");
                actual_end = rst.getDate("actual_end");
                orno = rst.getInt("orno");;
                status = rst.getString("status");
                  
                asset_activityidList.add(asset_activityid);
                assetidList.add(assetid);
                descriptionList.add(description);
                hoa_officerList.add(hoa_officer);
                tent_startList.add(tent_start);
                tent_endList.add(tent_end);
                actual_startList.add(actual_start);
                actual_endList.add(actual_start);
                ornoList.add(orno);
                statusList.add(status);      
            }
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int record_assetactivity(){
        try{
            // this is where we will put codes that will interact with database
            // 1: Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2: Prepare our SQL Statement
            // 2.1 To get the next Asset Activity ID
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_activityid) + 1 AS newID FROM asset_activity");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()) { 
                asset_activityid = rst.getInt("newID");
            }
            
            // 2.2 Save the new asset 
            pstmt = conn.prepareStatement ("INSERT INTO asset_activity (asset_activityid, assetid, description, hoa_officer, tent_start, tent_end, actual_start, actual_end, orno, status) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, asset_activityid);
            pstmt.setInt(2, assetid);
            pstmt.setString(3, description);
            pstmt.setInt(4, hoa_officer);
            pstmt.setDate(5, tent_start);
            pstmt.setDate(6, tent_end);
            pstmt.setDate(7, actual_start);
            pstmt.setDate(8, actual_end);
            pstmt.setInt(9, orno);
            pstmt.setString(10, status);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
                    
            
                
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
            
    }
    
    public static void main (String args[]){
        assetactivity A = new assetactivity();
        A.assetid = 1;
        A.description = "Basketballx2 ang sarapx2 mag basketball";
        A.hoa_officer = 3;
        A.tent_start = java.sql.Date.valueOf("2023-05-04");
        A.tent_end = java.sql.Date.valueOf("2023-05-05");
        A.actual_start = java.sql.Date.valueOf("2023-05-06");
        A.tent_end = java.sql.Date.valueOf("2023-10-06");
        A.orno = 1;
        A.status = "S";
        
        System.out.println(A.record_assetactivity());
        
        
    }
}