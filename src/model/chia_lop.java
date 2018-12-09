package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class chia_lop {
    private Connect connect;
    private ArrayList<hoc_vien> list;

    public chia_lop() {
    }
    
   public ArrayList<hoc_vien> ds_phong(String ma_lop, int begin, int end){
        connect = new Connect();
        list = new ArrayList<hoc_vien>();
        String sql = "select * from hoc_vien "
                + "where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?) "
                    + "limit ?, ?";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ps.setInt(2, begin);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new hoc_vien(rs.getInt(1),rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    public int countRow(String ma_lop){
        connect = new Connect();
        int sl = 0;
        String sql = "select count(*) from hoc_vien "
                + "where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?)";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sl = rs.getInt(1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return sl;
    }
}
