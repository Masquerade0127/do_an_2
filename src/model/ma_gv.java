package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ma_gv {
    private Connect connect = new Connect();

    public ma_gv() {
    }
    
    public int getMaGV(String ma_lop){
        int ma_gv = 0;
        String sql = "select ma_gv from lich_day where ma_lop = ?";
        try {
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ma_gv = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ma_gv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ma_gv;
    }
    public static void main(String[] args){
        ma_gv ma = new ma_gv();
        System.out.print("ma giang vien: " + ma.getMaGV("to300"));
    }
}
