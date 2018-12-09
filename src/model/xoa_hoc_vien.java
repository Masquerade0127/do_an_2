package model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class xoa_hoc_vien {
    private Connect connect;
    /*
    *xoa hoc vien trong table bai thi
    *parameter ma_hv
    */
    public void xoa_hoc_vien_table_bai_thi(String ma_hv){
        connect = new Connect();
        try {
            String sql = "delete from bai_thi where ma_hv=?";
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_hv);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    *xoa hoc vien trong table lich_hoc
    *parameter ma_hv
    */
    public void xoa_hoc_vien_table_lich_hoc(String ma_hv){
        connect = new Connect();
        try {
            String sql = "delete from lich_hoc where ma_hv=?";
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_hv);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    *xoa hoc vien trong table lich_thi
    *parameter ma_hv
    */
    public void xoa_hoc_vien_table_lich_thi(String ma_hv){
        connect = new Connect();
        try {
            String sql = "delete from lich_thi where ma_hv=?";
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_hv);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    *xoa hoc vien trong table hoc_vien
    *parameter ma_hv
    */
    public void xoa_hoc_vien_table_hoc_vien(String ma_hv){
        connect = new Connect();
        try {
            String sql = "delete from hoc_vien where ma_hv=?";
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_hv);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    *xoa hoc vien trong table hoc_vien
    *parameter ma_hv
    */
    public void xoa_hoc_vien_table_tai_khoan_hv(String ma_hv){
        connect = new Connect();
        try {
            String sql = "delete from tai_khoan_hv where ten_tai_khoan=?";
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_hv);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //xoa hoc vien
    public void xoa_hoc_vien(String ma_hv){
        xoa_hoc_vien_table_lich_hoc(ma_hv);
        xoa_hoc_vien_table_bai_thi(ma_hv);
        xoa_hoc_vien_table_lich_thi(ma_hv);
        xoa_hoc_vien_table_tai_khoan_hv(ma_hv);
        xoa_hoc_vien_table_hoc_vien(ma_hv);
        JOptionPane.showMessageDialog(null, "đã xóa học viên");
    }
}
