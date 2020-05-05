/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.DBConnection;

/**
 *
 * @author Barsan
 */
public abstract class Dao {
   private DBConnection db;
    private Connection conn;
    
    public abstract void create(Object obj);
//    public abstract List read(); 
    public abstract void update(Object obj);
    public abstract void delete(Object obj);

    public DBConnection getDb() {
        if (db == null) {
            db =  DBConnection.getDb();
        }
        return db;
    }

    public Connection getConn() {
        if (conn == null) {
            conn = getDb().getConnection();
        }
        return conn;
    }   
}
