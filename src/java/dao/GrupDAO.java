package dao;

import entity.Grup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GrupDAO extends Dao {

    @Override
    public List read() {
        List<Grup> clist = new ArrayList();

        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
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

    @Override
    public void create(Object obj) {
        Grup grup = (Grup) obj;
        String q = "insert into grup(grupadi) values (?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, grup.getGrupadi());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Grup grup = (Grup) obj;
        String q = "delete from grup where grupid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, grup.getGrupid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void update(Object obj) {
        Grup grup = (Grup) obj;
        String q = "update grup set grupadi=? where grupid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, grup.getGrupadi());
            st.setInt(2, grup.getGrupid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
