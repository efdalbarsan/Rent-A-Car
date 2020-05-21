/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Barsan
 */
public class DocumentDao extends Dao {

    public List<Document> findAll() {
        List<Document> dList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setId(rs.getLong("id"));
                d.setFilePath(rs.getString("filepath"));
                d.setFileName(rs.getString("filename"));
                d.setFileType(rs.getString("filetype"));
                
                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }
    
    public void insert(Document d){
        String query ="insert into document (filepath, filename, filetype) values(?,?,?)"; 
        try {
            PreparedStatement pst = this.getConn().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
