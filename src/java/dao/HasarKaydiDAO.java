package dao;


import entity.HasarKaydi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class HasarKaydiDAO {

    private DBConnection connection;
    private Connection c;

    public List<HasarKaydi> getHasarKaydi() {
        List<HasarKaydi> clist = new ArrayList();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from hasarkaydi"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                HasarKaydi tmp;
                tmp = new HasarKaydi(rs.getInt("hasarid"), rs.getInt("aracid"), rs.getString("boya"), rs.getString("cizik"), rs.getString("degisim"), rs.getString("aciklama"));

                clist.add(tmp);//Her yeni hasarKaydii listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return clist;
    }

    public void insert(HasarKaydi hasarKaydi) {
        String q = "insert into hasarkaydi(aracid,boya,cizik,degisim,aciklama) values (?,?,?,?,?)";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, hasarKaydi.getAracid());
            st.setString(2, hasarKaydi.getBoya());
            st.setString(3, hasarKaydi.getCizik());
            st.setString(4, hasarKaydi.getDegisim());
            st.setString(5, hasarKaydi.getAciklama());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(HasarKaydi hasarKaydi) {
        String q = "delete from hasarkaydi where hasarid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, hasarKaydi.getHasarid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void update(HasarKaydi hasarKaydi) {
        String q = "update hasarkaydi set aracid=?,boya=?,cizik=?,degisim=?,aciklama=? where hasarid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, hasarKaydi.getAracid());
            st.setString(2, hasarKaydi.getBoya());
            st.setString(3, hasarKaydi.getCizik());
            st.setString(4, hasarKaydi.getDegisim());
            st.setString(5, hasarKaydi.getAciklama());
            st.setInt(6, hasarKaydi.getHasarid());

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
