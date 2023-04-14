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
public class asset {
    
    // Fields of Assets
    public int asset_id;
    public String asset_name;
    public String asset_description;
    public java.sql.Date acquisition_date;
    public int forrent;
    public float asset_value;
    public String type_asset;
    public String status; 
    public String loc_lattitude;
    public String loc_longitude;
    public String enclosing_asset;
    public String hoa_name;
    
    // list of assets
    public ArrayList<Integer> asset_idlist = new ArrayList<> ();
    public ArrayList<String> asset_namelist = new ArrayList<> ();
    public ArrayList<String> asset_descriptionlist = new ArrayList<>();
    public ArrayList<java.sql.Date> acquisition_datelist = new ArrayList<>();
    public ArrayList<Integer> forrentlist = new ArrayList<>();
    public ArrayList<Float> asset_valuelist = new ArrayList<>();
    public ArrayList<String> type_assetlist = new ArrayList<>();
    public ArrayList<String> statuslist = new ArrayList<>();
    public ArrayList<String> loc_lattitudelist = new ArrayList<>();
    public ArrayList<String> loc_longitudelist = new ArrayList<>();
    public ArrayList<String> enclosing_assetlist = new ArrayList<>();
    public ArrayList<String> hoa_namelist = new ArrayList<>();
    
    
    public asset(){
        
    }
    
    public int dispose_asset(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE assets SET status = 'X' WHERE asset_id= ?;");
            pstmt.setInt(1, asset_id);
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
    
    public int asset_for_disposal(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM assets WHERE status = 'S'");
            ResultSet rst = pstmt.executeQuery();
            asset_idlist.clear();
            asset_namelist.clear();
            asset_descriptionlist.clear();
            acquisition_datelist.clear();
            forrentlist.clear();
            asset_valuelist.clear();
            type_assetlist.clear();
            statuslist.clear();;
            loc_lattitudelist.clear();
            loc_longitudelist.clear();
            enclosing_assetlist.clear();
            hoa_namelist.clear();
            
            
            while(rst.next()) { 
                asset_id = rst.getInt("asset_id");
                asset_name = rst.getString("asset_name");
                asset_description = rst.getString("asset_description");
                acquisition_date = rst.getDate("acquisition_date");
                forrent = rst.getInt("forrent");
                asset_value = rst.getFloat("asset_value");
                type_asset = rst.getString("type_asset");
                status = rst.getString("status");
                loc_lattitude = rst.getString("loc_lattitude");
                loc_longitude = rst.getString("loc_longitude");
                enclosing_asset = rst.getString("enclosing_asset");
                hoa_name = rst.getString("hoa_name");
                
                asset_idlist.add(asset_id);
                asset_namelist.add(asset_name);
                asset_descriptionlist.add(asset_description);
                acquisition_datelist.add(acquisition_date);
                forrentlist.add(forrent);
                asset_valuelist.add(asset_value);
                type_assetlist.add(type_asset);
                statuslist.add(status);
                loc_lattitudelist.add(loc_lattitude);
                loc_longitudelist.add(loc_longitude);
                enclosing_assetlist.add(enclosing_asset);
                hoa_namelist.add(hoa_name);
          
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
    
    public int delete_asset(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM assets WHERE asset_id = ?");
            pstmt.setInt(1, asset_id);
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
    
    public int asset_for_deletion(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM assets WHERE asset_id NOT IN (SELECT asset_id FROM asset_transactions);");
            ResultSet rst = pstmt.executeQuery();
            asset_idlist.clear();
            asset_namelist.clear();
            asset_descriptionlist.clear();
            acquisition_datelist.clear();
            forrentlist.clear();
            asset_valuelist.clear();
            type_assetlist.clear();
            statuslist.clear();;
            loc_lattitudelist.clear();
            loc_longitudelist.clear();
            enclosing_assetlist.clear();
            hoa_namelist.clear();
            
            
            while(rst.next()) { 
                asset_id = rst.getInt("asset_id");
                asset_name = rst.getString("asset_name");
                asset_description = rst.getString("asset_description");
                acquisition_date = rst.getDate("acquisition_date");
                forrent = rst.getInt("forrent");
                asset_value = rst.getFloat("asset_value");
                type_asset = rst.getString("type_asset");
                status = rst.getString("status");
                loc_lattitude = rst.getString("loc_lattitude");
                loc_longitude = rst.getString("loc_longitude");
                enclosing_asset = rst.getString("enclosing_asset");
                hoa_name = rst.getString("hoa_name");
                
                asset_idlist.add(asset_id);
                asset_namelist.add(asset_name);
                asset_descriptionlist.add(asset_description);
                acquisition_datelist.add(acquisition_date);
                forrentlist.add(forrent);
                asset_valuelist.add(asset_value);
                type_assetlist.add(type_asset);
                statuslist.add(status);
                loc_lattitudelist.add(loc_lattitude);
                loc_longitudelist.add(loc_longitude);
                enclosing_assetlist.add(enclosing_asset);
                hoa_namelist.add(hoa_name);
          
            }
            
            pstmt.close();
            conn.close();
            System.out.println("Successful");
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int update_asset(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            if(enclosing_asset != ""){
                PreparedStatement pstmt = conn.prepareStatement("UPDATE assets SET asset_name = ?, asset_description = ?, acquisition_date = ?, forrent = ?, asset_value = ?, type_asset = ?, status = ?, loc_lattitude = ?, loc_longitude = ?, enclosing_asset = ? WHERE asset_id = ?");
                pstmt.setString(1, asset_name);
                pstmt.setString(2, asset_description);
                pstmt.setDate(3, acquisition_date);
                pstmt.setInt(4, forrent);
                pstmt.setFloat(5, asset_value);
                pstmt.setString(6, type_asset);
                pstmt.setString(7, status);
                pstmt.setString(8, loc_lattitude);
                pstmt.setString(9, loc_longitude);
                pstmt.setString(10, enclosing_asset);
                pstmt.setInt(11, asset_id);
                pstmt.executeUpdate();
                pstmt.close();
            } else {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE assets SET asset_name = ?, asset_description = ?, acquisition_date = ?, forrent = ?, asset_value = ?, type_asset = ?, status = ?, loc_lattitude = ?, loc_longitude = ? WHERE asset_id = ?");
                pstmt.setString(1, asset_name);
                pstmt.setString(2, asset_description);
                pstmt.setDate(3, acquisition_date);
                pstmt.setInt(4, forrent);
                pstmt.setFloat(5, asset_value);
                pstmt.setString(6, type_asset);
                pstmt.setString(7, status);
                pstmt.setString(8, loc_lattitude);
                pstmt.setString(9, loc_longitude);
                pstmt.setInt(10, asset_id);
                pstmt.executeUpdate();
                pstmt.close();
            }
            conn.close();
            System.out.println("Successful");
            
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int asset_for_update(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM assets");
            ResultSet rst = pstmt.executeQuery();
            asset_idlist.clear();
            asset_namelist.clear();
            asset_descriptionlist.clear();
            acquisition_datelist.clear();
            forrentlist.clear();
            asset_valuelist.clear();
            type_assetlist.clear();
            statuslist.clear();;
            loc_lattitudelist.clear();
            loc_longitudelist.clear();
            enclosing_assetlist.clear();
            hoa_namelist.clear();
            
            
            while(rst.next()) { 
                asset_id = rst.getInt("asset_id");
                asset_name = rst.getString("asset_name");
                asset_description = rst.getString("asset_description");
                acquisition_date = rst.getDate("acquisition_date");
                forrent = rst.getInt("forrent");
                asset_value = rst.getFloat("asset_value");
                type_asset = rst.getString("type_asset");
                status = rst.getString("status");
                loc_lattitude = rst.getString("loc_lattitude");
                loc_longitude = rst.getString("loc_longitude");
                enclosing_asset = rst.getString("enclosing_asset");
                hoa_name = rst.getString("hoa_name");
                
                asset_idlist.add(asset_id);
                asset_namelist.add(asset_name);
                asset_descriptionlist.add(asset_description);
                acquisition_datelist.add(acquisition_date);
                forrentlist.add(forrent);
                asset_valuelist.add(asset_value);
                type_assetlist.add(type_asset);
                statuslist.add(status);
                loc_lattitudelist.add(loc_lattitude);
                loc_longitudelist.add(loc_longitude);
                enclosing_assetlist.add(enclosing_asset);
                hoa_namelist.add(hoa_name);
          
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
    
    public int register_asset(){
        try{
            // this is where we will put codes that will interact with database
            // 1: Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2: Prepare our SQL Statement
            // 2.1 To get the next AssetID
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_id) + 1 AS newID FROM assets");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()) { 
                asset_id = rst.getInt("newID");
            }
            // 2.2 Save the new asset 
            if(enclosing_asset != ""){
                pstmt = conn.prepareStatement ("INSERT INTO assets (asset_id, asset_name, asset_description, acquisition_date, forrent, asset_value, type_asset, status, loc_lattitude, loc_longitude, hoa_name, enclosing_asset) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, asset_id);
                pstmt.setString(2, asset_name);
                pstmt.setString(3, asset_description);
                pstmt.setDate(4, acquisition_date);
                pstmt.setInt(5, forrent);
                pstmt.setFloat(6, asset_value);
                pstmt.setString(7, type_asset);
                pstmt.setString(8, status);
                pstmt.setString(9, loc_lattitude);
                pstmt.setString(10, loc_longitude);
                pstmt.setString(11, hoa_name);
                pstmt.setString(12, enclosing_asset);
                pstmt.executeUpdate();
                pstmt.close();
            } else {
                pstmt = conn.prepareStatement ("INSERT INTO assets (asset_id, asset_name, asset_description, acquisition_date, forrent, asset_value, type_asset, status, loc_lattitude, loc_longitude, hoa_name) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, asset_id);
                pstmt.setString(2, asset_name);
                pstmt.setString(3, asset_description);
                pstmt.setDate(4, acquisition_date);
                pstmt.setInt(5, forrent);
                pstmt.setFloat(6, asset_value);
                pstmt.setString(7, type_asset);
                pstmt.setString(8, status);
                pstmt.setString(9, loc_lattitude);
                pstmt.setString(10, loc_longitude);
                pstmt.setString(11, hoa_name);
                pstmt.executeUpdate();
                pstmt.close();
            }
        
            /*if(enclosing_asset != null){
                PreparedStatement pstmt2 = conn.prepareStatement("UPDATE assets SET enclosing_asset = ? WHERE asset_id = ?");
                pstmt2.setString(1, enclosing_asset);
                pstmt2.setInt(2, asset_id);
                pstmt.executeUpdate();
                pstmt2.executeUpdate();
                pstmt2.close();
                
            } else {*/
               // pstmt.executeUpdate();
           // }
            //pstmt.close();

            
            conn.close();
            System.out.println("Successful");
            return 1;
                    
            
                
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
            
    }
    
    public static void main (String args[]){
        asset A = new asset();
        
        A.asset_name = "Basketball Court";
        A.asset_description = "Normal court";
        A.acquisition_date = java.sql.Date.valueOf("2023-05-04");
        A.forrent = 1;
        A.asset_value = 30000;
        A.type_asset = "P";
        A.status = "W";
        A.loc_lattitude = "300";
        A.loc_longitude = "200";
        A.hoa_name = "SJH";   
        //A.enclosing_asset = "5002";
        //A.enclosing_asset = Integer.parseInt(null);
        System.out.println(A.register_asset());
         /*A.asset_for_update();*/
         

        
    }
}
