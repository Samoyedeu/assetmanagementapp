/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assetmanagement;

/**
 *
 * @author ccslearner
 */
import java.util.*;
import java.sql.*;
public class transaction {
    public int asset_id;
    public java.sql.Date transaction_date;
    public int trans_hoid;
    public String trans_position;
    public java.sql.Date trans_electiondate;
    public int isdeleted;
    public String approval_hoid;
    public String approval_position;
    public java.sql.Date approval_electiondate;
    public String ornum;
    public String transaction_type;
    
    public int homeowner_id;
    public ArrayList<Integer> asset_idList = new ArrayList<>();    
    public ArrayList<Integer> homeowner_idList = new ArrayList<>();
    public ArrayList<String> position_idList = new ArrayList<>();
    public ArrayList<java.sql.Date> electionList = new ArrayList<>();
    
    
    public int electiondate_dropdown(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT election_date FROM officer WHERE ho_id = ? AND position = ?");
            pstmt.setInt(1, trans_hoid);
            pstmt.setString(2, trans_position);
            ResultSet rst = pstmt.executeQuery();
            electionList.clear();
          
            
            while(rst.next()) { 
                  
                trans_electiondate = rst.getDate("election_date");
                electionList.add(trans_electiondate);
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

    
    public int position_dropdown(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT position FROM officer WHERE ho_id = ?");
            pstmt.setInt(1, trans_hoid);
            ResultSet rst = pstmt.executeQuery();
            position_idList.clear();
          
            
            while(rst.next()) { 
                  
                trans_position = rst.getString("position");
                position_idList.add(trans_position);
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
    
    public int homeowner_id_dropdown(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT ho_id FROM officer");
            ResultSet rst = pstmt.executeQuery();
            homeowner_idList.clear();
          
            
            while(rst.next()) { 
                  
                homeowner_id = rst.getInt("ho_id");
                homeowner_idList.add(homeowner_id);
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
    
    public int register(){
        try{
            // this is where we will put codes that will interact with database
            // 1: Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2: Prepare our SQL Statement
            

            // 2.2 Save the new asset transaction
            PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO asset_transactions (asset_id, transaction_date, trans_hoid, trans_position, trans_electiondate, isdeleted, transaction_type) VALUE (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, asset_id);
            pstmt.setDate(2, transaction_date);
            pstmt.setInt(3, trans_hoid);
            pstmt.setString(4, trans_position);
            pstmt.setDate(5, trans_electiondate);
            pstmt.setInt(6, isdeleted);
            pstmt.setString(7, transaction_type);
            pstmt.executeUpdate();
            pstmt.close();
            
            if(approval_hoid != ""){
                PreparedStatement pstmt2 = conn.prepareStatement ("UPDATE asset_transactions SET approval_hoid = ? WHERE asset_id = ? AND transaction_date = ?");
                pstmt2.setString(1, approval_hoid);
                pstmt2.setInt(2, asset_id);
                pstmt2.setDate(3, transaction_date);
                pstmt2.executeUpdate();
                pstmt2.close();
            }
            
            if(approval_position != ""){
                PreparedStatement pstmt3 = conn.prepareStatement ("UPDATE asset_transactions SET approval_position = ? WHERE asset_id = ? AND transaction_date = ?");
                pstmt3.setString(1, approval_position);
                pstmt3.setInt(2, asset_id);
                pstmt3.setDate(3, transaction_date);
                pstmt3.executeUpdate();
                pstmt3.close();
            }
            
            if(approval_electiondate.compareTo(java.sql.Date.valueOf("2023-04-15")) == 0){
                PreparedStatement pstmt4 = conn.prepareStatement ("UPDATE asset_transactions SET approval_electiondate = ? WHERE asset_id = ? AND transaction_date = ?");
                approval_electiondate = null;
                pstmt4.setDate(1, approval_electiondate);
                pstmt4.setInt(2, asset_id);
                pstmt4.setDate(3, transaction_date);
                pstmt4.executeUpdate();
                pstmt4.close();
            } else {
                PreparedStatement pstmt4 = conn.prepareStatement ("UPDATE asset_transactions SET approval_electiondate = ? WHERE asset_id = ? AND transaction_date = ?");
                pstmt4.setDate(1, approval_electiondate);
                pstmt4.setInt(2, asset_id);
                pstmt4.setDate(3, transaction_date);
                pstmt4.executeUpdate();
                pstmt4.close();
            }
            
            if(ornum != ""){
                PreparedStatement pstmt5 = conn.prepareStatement ("UPDATE asset_transactions SET ornum = ? WHERE asset_id = ? AND transaction_date = ?");
                pstmt5.setString(1, ornum);
                pstmt5.setInt(2, asset_id);
                pstmt5.setDate(3, transaction_date);
                pstmt5.executeUpdate();
                pstmt5.close();
            }
            
            conn.close();
            System.out.println("Successful");
            return 1;
                    
            
                
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public transaction(){
        
    }
    
    public static void main (String args[]){
        transaction A = new transaction();
        A.asset_id = 5001;
        A.transaction_date = java.sql.Date.valueOf("2022-04-17");
        A.trans_hoid = 9001;
        A.trans_position = "President";
        A.trans_electiondate = java.sql.Date.valueOf("2022-06-01");
        A.isdeleted = 1;
        A.approval_hoid = "9004";
        A.approval_position = "President";
        A.approval_electiondate = java.sql.Date.valueOf("2022-12-01");
        A.ornum = "3000001";  
        A.transaction_type = "R";
        A.register();
    }
    
}