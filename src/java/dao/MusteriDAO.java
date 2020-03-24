package dao;

import entity.Musteri;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MusteriDAO {

    private DBConnection connection;
    private Connection c;

    public List<Musteri> findAll() {
        List<Musteri> musteriList = new ArrayList<>();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from musteri"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Musteri tmp;
                tmp = new Musteri(rs.getInt("musteriid"), rs.getString("adi"), rs.getString("telefon"), rs.getString("eposta"), rs.getString("adres"));
                musteriList.add(tmp);//Her yeni araci listeme ekliyorum
            }

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return musteriList;
    }

    public DBConnection getConnection() {
        if (this.connection == null) {
            this.connection = new DBConnection();
        }
        return connection;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = getConnection().connect();
        }
        return c;
    }

}
