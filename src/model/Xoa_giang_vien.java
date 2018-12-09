package model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Xoa_giang_vien {
    private Connect connect;
    public void xoa_table_tai_khoan_gv(String ma_gv){
        connect = new Connect();
        String sql = "delete from tai_khoan_gv where ten_tai_khoan = ?";
        try {
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_gv);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void xoa_giang_vien(String ma_gv){
        connect = new Connect();
        String sql = "delete from giang_vien where ma_gv = ?";
        try {
            PreparedStatement ps = (PreparedStatement) connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_gv);
            xoa_table_tai_khoan_gv(ma_gv);
            ps.execute();
            JOptionPane.showMessageDialog(null, "đã xóa giảng viên");
        } catch (SQLException ex) {
            Logger.getLogger(hoc_vien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
