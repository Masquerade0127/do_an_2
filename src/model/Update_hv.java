package model;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Update_hv {
    private Connect connect;
    private DefaultTableModel model = new DefaultTableModel();
    public Update_hv() {
    }
    public void update_data(String ma_hv, String cot, String gia_tri){
        connect = new Connect();
        String sql = "update hoc_vien set " + cot + " = ?" + "where ma_hv = ?";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, gia_tri);
            ps.setString(2, ma_hv);
            ps.execute();
            JOptionPane.showMessageDialog(null, "đã nhập");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
