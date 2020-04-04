package dao;

import entity.Yorum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YorumDAO {

    private DBConnection connection;
    private Connection c;

    public List<Yorum> getYorum() {
        List<Yorum> clist = new ArrayList();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from yorum"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Yorum tmp;
                tmp = new Yorum(rs.getInt("yorumid"), rs.getInt("musteriid"), rs.getInt("aracid"), rs.getString("yorum"));

                clist.add(tmp);//Her yeni yorumi listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public void insert(Yorum yorum) {
        String q = "insert into yorum(musteriid,aracid,yorum) values (?,?,?)";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, yorum.getMusteriid());
            st.setInt(2, yorum.getAracid());
            st.setString(3, yorum.getYorum());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Yorum yorum) {
        String q = "delete from yorum where yorumid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, yorum.getYorumid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Yorum yorum) {
        String q = "update yorum set musteriid=?,aracid=?,yorum=? where yorumid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, yorum.getMusteriid());
            st.setInt(2, yorum.getAracid());
            st.setString(3, yorum.getYorum());
            st.setInt(4, yorum.getYorumid());

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
