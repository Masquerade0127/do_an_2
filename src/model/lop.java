package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class lop {
    private Connect connect = new Connect();

    public lop() {
    }
    
    public String maLop_300(){
        String ma_lop = null;
        String sql = "select ma_lop from lop where ten_lop = 'toeic 300'";
        try{
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ma_lop = rs.getString(1);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return ma_lop;
    }
    
    public String maLop_450(){
        String ma_lop = null;
        String sql = "select ma_lop from lop where ten_lop = 'toeic 450'";
        try{
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ma_lop = rs.getString(1);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return ma_lop;
    }
    
    public String maLop_800(){
        String ma_lop = null;
        String sql = "select ma_lop from lop where ten_lop = 'toeic 800'";
        try{
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ma_lop = rs.getString(1);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return ma_lop;
    }
}
