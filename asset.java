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
    public int assetid;
    public String name;
    public String description;
    public java.sql.Date acq_date;
    public int forrent;
    public float value;
    public String type;
    public String status; 
    public String location;
    public String location_mapx;
    public String location_mapy;
    public int location_assetid;
    public String hoaname;
    
    // list of assets
    public ArrayList<Integer> assetidlist = new ArrayList<> ();
    public ArrayList<String> namelist = new ArrayList<> ();
    public ArrayList<String> descriptionlist = new ArrayList<>();
    public ArrayList<java.sql.Date> acq_datelist = new ArrayList<>();
    public ArrayList<Integer> forrentlist = new ArrayList<>();
    public ArrayList<Float> valuelist = new ArrayList<>();
    public ArrayList<String> typelist = new ArrayList<>();
    public ArrayList<String> statuslist = new ArrayList<>();
    public ArrayList<String> locationlist = new ArrayList<>();
    public ArrayList<String> location_mapxlist = new ArrayList<>();
    public ArrayList<String> location_mapylist = new ArrayList<>();
    public ArrayList<Integer> location_assetidlist = new ArrayList<>();
    public ArrayList<String> hoanamelist = new ArrayList<>();
    
    
    public asset(){
        
    }
    
    public int dispose_asset(){
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset SET status = 'DI' WHERE assetid= ?;");
            pstmt.setInt(1, assetid);
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset");
            ResultSet rst = pstmt.executeQuery();
            assetidlist.clear();
            namelist.clear();
            descriptionlist.clear();
            acq_datelist.clear();
            forrentlist.clear();
            valuelist.clear();
            typelist.clear();
            statuslist.clear();
            locationlist.clear();
            location_mapxlist.clear();
            location_mapylist.clear();
            location_assetidlist.clear();
            hoanamelist.clear();
            
            
            while(rst.next()) { 
                assetid = rst.getInt("assetid");
                name = rst.getString("name");
                description = rst.getString("description");
                acq_date = rst.getDate("acq_date");
                forrent = rst.getInt("forrent");
                value = rst.getFloat("value");
                type = rst.getString("type");
                status = rst.getString("status");
                location = rst.getString("location");
                location_mapx = rst.getString("location_mapx");
                location_mapy = rst.getString("location_mapy");
                location_assetid = rst.getInt("location_assetid");
                hoaname = rst.getString("hoaname");
                
                assetidlist.add(assetid);
                namelist.add(name);
                descriptionlist.add(description);
                acq_datelist.add(acq_date);
                forrentlist.add(forrent);
                valuelist.add(value);
                typelist.add(type);
                statuslist.add(status);
                locationlist.add(location);
                location_mapxlist.add(location_mapx);
                location_mapylist.add(location_mapy);
                location_assetidlist.add(location_assetid);
                hoanamelist.add(hoaname);
          
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM asset WHERE assetid = ?");
            pstmt.setInt(1, assetid);
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset WHERE assetid NOT IN (SELECT assetid FROM asset_activity) AND assetid NOT IN (SELECT assetid FROM assets_rented);");
            ResultSet rst = pstmt.executeQuery();
            assetidlist.clear();
            namelist.clear();
            descriptionlist.clear();
            acq_datelist.clear();
            forrentlist.clear();
            valuelist.clear();
            typelist.clear();
            statuslist.clear();
            locationlist.clear();
            location_mapxlist.clear();
            location_mapylist.clear();
            location_assetidlist.clear();
            hoanamelist.clear();
            
            
            while(rst.next()) { 
                assetid = rst.getInt("assetid");
                name = rst.getString("name");
                description = rst.getString("description");
                acq_date = rst.getDate("acq_date");
                forrent = rst.getInt("forrent");
                value = rst.getFloat("value");
                type = rst.getString("type");
                status = rst.getString("status");
                location = rst.getString("location");
                location_mapx = rst.getString("location_mapx");
                location_mapy = rst.getString("location_mapy");
                location_assetid = rst.getInt("location_assetid");
                hoaname = rst.getString("hoaname");
                
                assetidlist.add(assetid);
                namelist.add(name);
                descriptionlist.add(description);
                acq_datelist.add(acq_date);
                forrentlist.add(forrent);
                valuelist.add(value);
                typelist.add(type);
                statuslist.add(status);
                locationlist.add(location);
                location_mapxlist.add(location_mapx);
                location_mapylist.add(location_mapy);
                location_assetidlist.add(location_assetid);
                hoanamelist.add(hoaname);
          
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset SET name = ?, description = ?, acq_date = ?, forrent = ?, value = ?, type = ?, status = ?, location = ?, location_mapx = ?, location_mapy = ?, location_assetid = ? WHERE assetid = ?");
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setDate(3, acq_date);
            pstmt.setInt(4, forrent);
            pstmt.setFloat(5, value);
            pstmt.setString(6, type);
            pstmt.setString(7, status);
            pstmt.setString(8, location);
            pstmt.setString(9, location_mapx);
            pstmt.setString(10, location_mapy);
            pstmt.setInt(11, location_assetid);
            pstmt.setInt(12, assetid);
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
    
    public int asset_for_update(){
        try{
            // 1. Connect to our database
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2. Prepare SQL Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset");
            ResultSet rst = pstmt.executeQuery();
            assetidlist.clear();
            namelist.clear();
            descriptionlist.clear();
            acq_datelist.clear();
            forrentlist.clear();
            valuelist.clear();
            typelist.clear();
            statuslist.clear();
            locationlist.clear();
            location_mapxlist.clear();
            location_mapylist.clear();
            location_assetidlist.clear();
            hoanamelist.clear();
            
            
            while(rst.next()) { 
                assetid = rst.getInt("assetid");
                name = rst.getString("name");
                description = rst.getString("description");
                acq_date = rst.getDate("acq_date");
                forrent = rst.getInt("forrent");
                value = rst.getFloat("value");
                type = rst.getString("type");
                status = rst.getString("status");
                location = rst.getString("location");
                location_mapx = rst.getString("location_mapx");
                location_mapy = rst.getString("location_mapy");
                location_assetid = rst.getInt("location_assetid");
                hoaname = rst.getString("hoaname");
                
                assetidlist.add(assetid);
                namelist.add(name);
                descriptionlist.add(description);
                acq_datelist.add(acq_date);
                forrentlist.add(forrent);
                valuelist.add(value);
                typelist.add(type);
                statuslist.add(status);
                locationlist.add(location);
                location_mapxlist.add(location_mapx);
                location_mapylist.add(location_mapy);
                location_assetidlist.add(location_assetid);
                hoanamelist.add(hoaname);
          
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhomeowners?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // 2: Prepare our SQL Statement
            // 2.1 To get the next AssetID
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(assetid) + 1 AS newID FROM asset");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()) { 
                assetid = rst.getInt("newID");
            }
            
            // 2.2 Save the new asset 
            pstmt = conn.prepareStatement ("INSERT INTO asset (assetid, name, description, acq_date, forrent, value, type, status, location, location_mapx, location_mapy, location_assetid, hoaname) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, assetid);
            pstmt.setString(2, name);
            pstmt.setString(3, description);
            pstmt.setDate(4, acq_date);
            pstmt.setInt(5, forrent);
            pstmt.setFloat(6, value);
            pstmt.setString(7, type);
            pstmt.setString(8, status);
            pstmt.setString(9, location);
            pstmt.setString(10, location_mapx);
            pstmt.setString(11, location_mapy);
            pstmt.setInt(12, location_assetid);
            pstmt.setString(13, hoaname);
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
        asset A = new asset();
        /*
        A.name = "Basketball Court";
        A.description = "Normal court";
        A.acq_date = java.sql.Date.valueOf("2023-05-04");
        A.forrent = 1;
        A.value = 30000;
        A.type = "P";
        A.status = "W";
        A.location = "Tayabas City";
        A.location_mapx = "300";
        A.location_mapy = "200";
        A.hoaname = "Ayala Alabang Village Homeowners Association";        
        //System.out.println(A.register_asset());
        /*
        A.asset_for_update();
        for(int i = 0; i < A.assetidlist.size(); i++){
            System.out.println(A.assetidlist.get(i));
            System.out.println(A.namelist.get(i));
            System.out.println(A.descriptionlist.get(i));
            System.out.println(A.acq_datelist.get(i));
            System.out.println(A.forrentlist.get(i));
            System.out.println(A.valuelist.get(i));
            System.out.println(A.typelist.get(i));
            System.out.println(A.statuslist.get(i));
            System.out.println(A.locationlist.get(i));
            System.out.println(A.location_mapxlist.get(i));
            System.out.println(A.location_mapylist.get(i));
            System.out.println(A.location_assetidlist.get(i));
            System.out.println(A.hoanamelist.get(i));

        }
        A.assetid = 1;
        System.out.println(A.update_asset());*/
        
        //A.asset_for_deletion();
     
        System.out.println(A.asset_for_disposal());
        for(int i = 0; i < A.assetidlist.size(); i++){
            System.out.println(A.assetidlist.get(i));
            System.out.println(A.namelist.get(i));
            System.out.println(A.descriptionlist.get(i));
            System.out.println(A.acq_datelist.get(i));
            System.out.println(A.forrentlist.get(i));
            System.out.println(A.valuelist.get(i));
            System.out.println(A.typelist.get(i));
            System.out.println(A.statuslist.get(i));
            System.out.println(A.locationlist.get(i));
            System.out.println(A.location_mapxlist.get(i));
            System.out.println(A.location_mapylist.get(i));
            System.out.println(A.location_assetidlist.get(i));
            System.out.println(A.hoanamelist.get(i));

        }
        
    }
}
