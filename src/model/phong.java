package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class phong {
    private Connect connect = new Connect();
    public phong() {
    }
    
    public String ma_phong(String ma_lop){
        String ma_phong = null;
        String sql = "select ma_phong from lich_day where ma_lop = ?";
        try{
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ma_phong = rs.getString(1);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return ma_phong;
    }
    public static void main(String[] args){
        phong p = new phong();
        System.out.print("ma phong: " + p.ma_phong("to300"));
    }
}
