package model;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class insert_hoc_vien {
    private Connect connect;
    private ma_gv gv = new ma_gv();
    private phong ma_phong = new phong();
    public insert_hoc_vien() {
    }
    //insert bang hoc_vien va bang lich_hoc
    public void insert_hoc_vien(String ma_lop, String ten_hv, String ngay_sinh, String dien_thoai, String email, String dia_chi){
        int generation_key = 0;
        connect = new Connect();
            String sql = "insert into hoc_vien(ten_hv,ngay_sinh,dien_thoai,email,dia_chi)"
                    + " values(?,?,?,?,?)";
            String sql_1 = "insert into lich_hoc values(?,?,?,?)";
        try{
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ten_hv);
            ps.setString(2, ngay_sinh);
            ps.setString(3, dien_thoai);
            ps.setString(4, email);
            ps.setString(5, dia_chi);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                generation_key = rs.getInt(1);
            }
            PreparedStatement ps_1 = this.connect.getConnect().prepareStatement(sql_1);
            ps_1.setInt(1, generation_key);
            ps_1.setInt(2, gv.getMaGV(ma_lop));
            ps_1.setString(3, ma_lop);
            ps_1.setString(4, ma_phong.ma_phong(ma_lop));
            ps_1.execute();
            JOptionPane.showMessageDialog(null, "đã thêm học viên");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "lỗi: " + ex);
        }
    }
    //insert 2 dung cho class import excel
    public void insert_hoc_vien_for_excel(String ma_lop, String ten_hv, String ngay_sinh, String dien_thoai, String email, String dia_chi){
        int generation_key = 0;
        connect = new Connect();
            String sql = "insert into hoc_vien(ten_hv,ngay_sinh,dien_thoai,email,dia_chi)"
                    + " values(?,?,?,?,?)";
            String sql_1 = "insert into lich_hoc values(?,?,?,?)";
        try{
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ten_hv);
            ps.setString(2, ngay_sinh);
            ps.setString(3, dien_thoai);
            ps.setString(4, email);
            ps.setString(5, dia_chi);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                generation_key = rs.getInt(1);
            }
            PreparedStatement ps_1 = this.connect.getConnect().prepareStatement(sql_1);
            ps_1.setInt(1, generation_key);
            ps_1.setInt(2, gv.getMaGV(ma_lop));
            ps_1.setString(3, ma_lop);
            ps_1.setString(4, ma_phong.ma_phong(ma_lop));
            ps_1.execute();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "lỗi: " + ex);
        }
    }
}
