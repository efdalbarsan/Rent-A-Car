package dao;

import entity.Grup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class GrupDAO {

    private DBConnection connection;
    private Connection c;

    public List<Grup> getGrup() {
        List<Grup> clist = new ArrayList();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from grup"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Grup tmp;
                tmp = new Grup(rs.getInt("grupid"), rs.getString("grupadi"));

                clist.add(tmp);//Her yeni grupi listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public void insert(Grup grup) {
        String q = "insert into grup(grupadi) values (?)";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, grup.getGrupadi());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Grup grup) {
        String q = "delete from grup where grupid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, grup.getGrupid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Grup grup) {
        String q = "update grup set grupadi=? where grupid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, grup.getGrupadi());
            st.setInt(2, grup.getGrupid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
