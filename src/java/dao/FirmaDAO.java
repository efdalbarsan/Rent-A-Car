package dao;

import entity.Firma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class FirmaDAO {

    private DBConnection connection;
    private Connection c;

    public Firma find(int firmaid) {
        Firma f = null;

        try {
            Statement st = this.getC().createStatement();    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma where firmaid=" + firmaid); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            f = new Firma();
            f.setFirmaid(rs.getInt("firmaid"));
            f.setAdi(rs.getString("adi"));
            f.setTelefon(rs.getString("telefon"));
            f.setEamil(rs.getString("email"));
            f.setAdres(rs.getString("Adres"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return f;
    }

    public DBConnection getConnection() {
        if (this.connection == null) {
            this.connection = new DBConnection();
        }
        return connection;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = new DBConnection().connect();
        }
        return c;
    }
}
