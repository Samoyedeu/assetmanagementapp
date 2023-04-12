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
    public int asset_id;
    public java.sql.Date activity_date;
    public String activity_description;
    public java.sql.Date tent_start;
    public java.sql.Date tent_end;
    public java.sql.Date act_start;
    public java.sql.Date act_end;
    public String cost; 
    public String status;
    
    // list of asset activity
    public ArrayList<Integer> asset_idList = new ArrayList<> ();
    public ArrayList<java.sql.Date> activity_dateList = new ArrayList<> ();
    public ArrayList<String> activity_descriptionList = new ArrayList<>();
    public ArrayList<Integer> hoa_officerList = new ArrayList<> ();
    public ArrayList<java.sql.Date> tent_startList = new ArrayList<> ();
    public ArrayList<java.sql.Date> tent_endList = new ArrayList<> ();
    public ArrayList<java.sql.Date> act_startList = new ArrayList<> ();
    public ArrayList<java.sql.Date> act_endList = new ArrayList<>();
    public ArrayList<String> costList = new ArrayList<> ();
    public ArrayList<String> statusList = new ArrayList<> ();

    
    public assetactivity(){
        
    }

    public int complete_assetactivity(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_activity SET status = 'C' WHERE asset_id = ? AND activity_date = ?");
            pstmt.setInt(1, asset_id);
            pstmt.setDate(2, activity_date);
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
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_activity WHERE activity_date = ? AND status != 'C'");
            pstmt.setDate(1, activity_date);
            ResultSet rst = pstmt.executeQuery();
            asset_idList.clear();
            activity_dateList.clear();
            activity_descriptionList.clear();
            tent_startList.clear();
            tent_endList.clear();
            act_startList.clear();
            act_endList.clear();
            costList.clear();
            statusList.clear();
          
            
            while(rst.next()) { 
                   
                asset_id = rst.getInt("asset_id");
                activity_date = rst.getDate("activity_date");
                activity_description = rst.getString("activity_description");
                tent_start = rst.getDate("tent_start");
                tent_end = rst.getDate("tent_end");
                act_start = rst.getDate("act_start");
                act_end = rst.getDate("act_end");
                cost = rst.getString("cost");
                status = rst.getString("status");
            
                asset_idList.add(asset_id);
                activity_dateList.add(activity_date);
                activity_descriptionList.add(activity_description);
                tent_startList.add(tent_start);
                tent_endList.add(tent_end);
                act_startList.add(act_start);
                act_endList.add(act_end);
                costList.add(cost);
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM asset_activity WHERE asset_id = ? AND activity_date = ?");
            pstmt.setInt(1, asset_id);
            pstmt.setDate(2, activity_date);
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_activity WHERE activity_date = ?;");
            pstmt.setDate(1, activity_date);
            ResultSet rst = pstmt.executeQuery();
            asset_idList.clear();
            activity_dateList.clear();
            activity_descriptionList.clear();
            tent_startList.clear();
            tent_endList.clear();
            act_startList.clear();
            act_endList.clear();
            costList.clear();
            statusList.clear();
            
            while(rst.next()){
                asset_id = rst.getInt("asset_id");
                activity_date = rst.getDate("activity_date");
                activity_description = rst.getString("activity_description");
                tent_start = rst.getDate("tent_start");
                tent_end = rst.getDate("tent_end");
                act_start = rst.getDate("act_start");
                act_end = rst.getDate("act_end");
                cost = rst.getString("cost");
                status = rst.getString("status");
            
                asset_idList.add(asset_id);
                activity_dateList.add(activity_date);
                activity_descriptionList.add(activity_description);
                tent_startList.add(tent_start);
                tent_endList.add(tent_end);
                act_startList.add(act_start);
                act_endList.add(act_end);
                costList.add(cost);
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_activity SET activity_description = ?, tent_start = ?, tent_end = ?, act_start = ?, act_end = ?, cost = ?, status = ?  WHERE asset_id = ? AND activity_date = ?");
            pstmt.setString(1, activity_description);
            pstmt.setDate(2, tent_start);
            pstmt.setDate(3, tent_end);
            pstmt.setDate(4, act_start);
            pstmt.setDate(5, act_end);
            pstmt.setString(6, cost);
            pstmt.setString(7, status);
            pstmt.setInt(8, asset_id);
            pstmt.setDate(9, activity_date);
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
    
    public int activity_for_update2(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_activity WHERE activity_date = ?");
            pstmt.setDate(1, activity_date);
            ResultSet rst = pstmt.executeQuery();
            asset_idList.clear();
            activity_dateList.clear();
            activity_descriptionList.clear();
            tent_startList.clear();
            tent_endList.clear();
            act_startList.clear();
            act_endList.clear();
            costList.clear();
            statusList.clear();
          
            
            while(rst.next()) { 
                   
                asset_id = rst.getInt("asset_id");
                activity_date = rst.getDate("activity_date");
                activity_description = rst.getString("activity_description");
                tent_start = rst.getDate("tent_start");
                tent_end = rst.getDate("tent_end");
                act_start = rst.getDate("act_start");
                act_end = rst.getDate("act_end");
                cost = rst.getString("cost");
                status = rst.getString("status");
            
                asset_idList.add(asset_id);
                activity_dateList.add(activity_date);
                activity_descriptionList.add(activity_description);
                tent_startList.add(tent_start);
                tent_endList.add(tent_end);
                act_startList.add(act_start);
                act_endList.add(act_end);
                costList.add(cost);
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
    
    public int asset_activity_dropdown(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT activity_date FROM asset_activity");
            ResultSet rst = pstmt.executeQuery();
            activity_dateList.clear();
          
            
            while(rst.next()) { 
                  
                activity_date = rst.getDate("activity_date");
                activity_dateList.add(activity_date);
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
    
    public int asset_id_dropdown(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id FROM assets");
            ResultSet rst = pstmt.executeQuery();
            asset_idList.clear();
          
            
            while(rst.next()) { 
                  
                asset_id = rst.getInt("asset_id");
                asset_idList.add(asset_id);
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2: Prepare our SQL Statement
            // 2.1 To get the next Asset Activity ID
            

            PreparedStatement pstmt;
            // 2.2 Save the new asset 
            pstmt = conn.prepareStatement ("INSERT INTO asset_activity (asset_id, activity_date, status) VALUE (?, ?, ?)");
            pstmt.setInt(1, asset_id);
            pstmt.setDate(2, activity_date);
            pstmt.setString(3, status);
            
            if(activity_description != null){
                pstmt = conn.prepareStatement ("INSERT INTO asset_activity (activity_description) VALUE (?)");
                pstmt.setString(1, activity_description);
            }
            
            if(tent_start != null){
                pstmt = conn.prepareStatement ("INSERT INTO asset_activity (tent_start) VALUE (?)");
                pstmt.setDate(1, tent_start);
            }
            
            if(tent_end != null){
                pstmt = conn.prepareStatement ("INSERT INTO asset_activity (tent_end) VALUE (?)");
                pstmt.setDate(1, tent_end);
            }
            
            if(act_start != null){
                pstmt = conn.prepareStatement ("INSERT INTO asset_activity (act_start) VALUE (?)");
                pstmt.setDate(1, act_start);
            }
            
            if(act_end != null){
                pstmt = conn.prepareStatement ("INSERT INTO asset_activity (act_end) VALUE (?)");
                pstmt.setDate(1, act_end);
            }
            
            if(cost != null){
                pstmt = conn.prepareStatement ("INSERT INTO asset_activity (cost) VALUE (?)");
                pstmt.setString(1, cost);
            }
            System.out.println("Successful");
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
        /*
        A.activity_date = java.sql.Date.valueOf("2022-12-21");
        System.out.println(A.asset_activity_dropdown());
        for(int i = 0; i < A.activity_dateList.size(); i++){
            System.out.println(A.activity_dateList.get(i));
        }*/
        A.activity_date = java.sql.Date.valueOf("2022-12-23");
        A.asset_id = 5003;
        A.activity_description = "LOL";
        A.tent_start = java.sql.Date.valueOf("2023-12-23");
        A.tent_end = java.sql.Date.valueOf("2023-12-23");
        A.act_end = java.sql.Date.valueOf("2023-12-23");
        A.act_start = java.sql.Date.valueOf("2023-12-23");
        A.cost = "12222.22";
        A.status = "S";
         A.record_assetactivity();
        
        
    }
}