package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class danh_sach_hv {
    private ArrayList<hoc_vien> danh_sach_hv;
    private Connect connect;

    public danh_sach_hv() {
    }

    public ArrayList<hoc_vien> danh_sach_hoc_vien(){
        danh_sach_hv = new ArrayList<hoc_vien>();
        this.connect = new Connect();
        String sql = "select * from hoc_vien";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                danh_sach_hv.add(new hoc_vien(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Mã lỗi: " + ex);
        }
        return danh_sach_hv;
    }
    public ArrayList<hoc_vien> danh_sach_hv_tung_lop(String ma_lop){
        danh_sach_hv = new ArrayList<hoc_vien>();
        this.connect = new Connect();
        String sql = "select * from hoc_vien where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?)";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                danh_sach_hv.add(new hoc_vien(rs.getInt(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Mã lỗi: " + ex);
        }
        return danh_sach_hv;
    }
    /*
    *danh sach hoc hien tung lop test vector
    *parameter: ma_lop
    */
    public DefaultTableModel danh_sach_tung_lop_vector(String ma_lop){
        DefaultTableModel model = new DefaultTableModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        connect = new Connect();
        String sql = "select * from hoc_vien where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?)";
        Vector vector;
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                vector = new Vector();
                vector.add(rs.getInt("ma_hv"));
                vector.add(rs.getString("ten_hv"));
                vector.add(rs.getString("ngay_sinh"));
                vector.add(rs.getString("dien_thoai"));
                vector.add(rs.getString("email"));
                vector.add(rs.getString("dia_chi"));
                model.addRow(vector.toArray());
            }
            //table_name.setModel(model);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return model;
    }
}