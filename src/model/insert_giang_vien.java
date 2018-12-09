package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class insert_giang_vien {
    private Connect connect;

    public insert_giang_vien() {
    }
    public void inset_giang_vien(String ten_gv, String ngay_sinh, String dien_thoai, String email, String dia_chi){
        connect = new Connect();
        String sql = "insert into giang_vien(ten_gv,ngay_sinh,dien_thoai,email,dia_chi) "
                + "values(?,?,?,?,?)";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ten_gv);
            ps.setString(2, ngay_sinh);
            ps.setString(3, dien_thoai);
            ps.setString(4, email);
            ps.setString(5, dia_chi);
            ps.execute();
            JOptionPane.showMessageDialog(null, "đã thêm giảng viên");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
        }
    }
    //insert giang vien 2
    public void inset_giang_vien_sc(String ten_gv, String ngay_sinh, String dien_thoai, String email, String dia_chi){
        connect = new Connect();
        String sql = "insert into giang_vien(ten_gv,ngay_sinh,dien_thoai,email,dia_chi) "
                + "values(?,?,?,?,?)";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ten_gv);
            ps.setString(2, ngay_sinh);
            ps.setString(3, dien_thoai);
            ps.setString(4, email);
            ps.setString(5, dia_chi);
            ps.execute();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
        }
    }
}