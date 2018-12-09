package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class danh_sach_gv {
    private Connect connect = new Connect();
    ArrayList<giang_vien> danh_sach_gv;

    public danh_sach_gv() {
    }
    
    public ArrayList<giang_vien> danh_sach_giang_vien(){
        danh_sach_gv = new ArrayList<giang_vien>();
        this.connect = new Connect();
        String sql = "select * from giang_vien";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                danh_sach_gv.add(new giang_vien(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
        }
        return danh_sach_gv;
    }
}