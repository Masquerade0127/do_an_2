package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dang_nhap {
    private Connect connect = new Connect();

    public dang_nhap() {
    }
    
    public boolean getdang_nhap(String user_name, char[] password){
        boolean check = false;
        if(user_name.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng điền tên tài khoản!");
            check = false;
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng điền mật khẩu!");
            check =  false;
        }else{
            try{
                String sql = "SELECT * FROM tai_khoan_nv WHERE ten_tai_khoan=? AND mat_khau=?";
                PreparedStatement ps = connect.getConnect().prepareStatement(sql);
                ps.setString(1, user_name);
                ps.setString(2, String.valueOf(password));
                ResultSet rs = ps.executeQuery();
                if(!rs.next()){
                    JOptionPane.showMessageDialog(null, "thông tin tài khoản không chính xác");
                }
                else
                    check = true;
            } catch (SQLException ex) {
                ex.printStackTrace();       
            }
        }
        return check;
    }
}
