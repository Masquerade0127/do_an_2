package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class nhap_diem {
    private Connect connect;
    private ArrayList<diem> bang_diem;

    public nhap_diem() {
    }
    
    public ArrayList<diem> getBD(){
        this.connect = new Connect();
        bang_diem = new ArrayList<diem>();
        String sql = "select * from bai_thi";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bang_diem.add(new diem(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return bang_diem;
    }
    public void nhap_diem(int ma_hv, int diem){
        this.connect = new Connect();
        String sql = "insert into bai_thi(ma_hv,diem) values (?,?)";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setInt(1, ma_hv);
            ps.setInt(2, diem);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "đã nhập điểm");
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Học viên không tồn tại");
        }
    }
}
