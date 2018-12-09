package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class tim_kiem {
    private Connect connect;
    private ArrayList<hoc_vien> danh_sach_hv;

    public tim_kiem() {
    }
    
    public ArrayList<hoc_vien> tim_kiem(String ma_hv){
        danh_sach_hv = new ArrayList<hoc_vien>();
        this.connect = new Connect();
        String sql = "select * from hoc_vien where ma_hv like ? ";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_hv);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                danh_sach_hv.add(new hoc_vien(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "không tìm thấy học viên");
        }
        return danh_sach_hv;
    }
}
