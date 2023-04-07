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