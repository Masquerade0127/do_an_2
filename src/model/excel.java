package model;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
    private Connect connect;
    private XSSFWorkbook wb;

    public excel() {
    }
    //tao workbook cho excel
    private void tao_excel(ResultSet rs){
        try{
            this.wb = new XSSFWorkbook();
            Sheet sheet = this.wb.createSheet();
            ResultSetMetaData rsmd = rs.getMetaData();
            Row row = sheet.createRow(0);
            int colnumber = rsmd.getColumnCount();
            for(int i = 0; i < colnumber; i++){
                String colname = rsmd.getColumnName(i+1);
                Cell cell = row.createCell(i);
                cell.setCellValue(colname);
            }
            while(rs.next()){
                row = sheet.createRow(rs.getRow());
                for (int i = 0; i < colnumber; i++){
                    String cell_value = rs.getString(i+1);
                    Cell cell = row.createCell(i);
                    cell.setCellValue(cell_value);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "mã lỗi: " + e);
        }
    }
    //xuat danh sách tung phong
    public void ds_phong(String ma_lop, int begin, int end, String phong){
        connect = new Connect();
        String sql = "select * from hoc_vien "
                + "where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?) "
                    + "limit ?, ?";
        try{
            PreparedStatement ps = connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ps.setInt(2, begin);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            this.tao_excel(rs);
            try{
                FileOutputStream fos = new FileOutputStream(new File(phong + ".xlsx"));
                this.wb.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(null, "đã xuất file excel");
                this.connect.getConnect().close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "lỗi: " + ex);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //xuat danh sach hoc vien theo ma lop
    public void xuat_danh_sach_hv(String ma_lop){
        this.connect = new Connect();
        String sql = "select * \n" +
                    "from hoc_vien\n" +
                    "where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?)";
        try {
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            this.tao_excel(rs);
            try{
                FileOutputStream fos = new FileOutputStream(new File(ma_lop + ".xlsx"));
                this.wb.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(null, "đã xuất file excel");
                this.connect.getConnect().close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
        }
    }
    //xuat file excel danh sach giang vien
    public void xuat_danh_sach_gv(){
        this.connect = new Connect();
        String sql = "select * from giang_vien";
        try {
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            this.tao_excel(rs);
            try{
                FileOutputStream fos = new FileOutputStream(new File("danh sach giang vien.xlsx"));
                this.wb.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(null, "đã xuất file excel");
                this.connect.getConnect().close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
        }
    }
    //xuat danh sach diem
    public void bang_diem(String ma_lop){
        this.connect = new Connect();
        String sql = "select * from bai_thi where ma_hv in (select ma_hv from lich_hoc where ma_lop = ?)";
        try {
            PreparedStatement ps = this.connect.getConnect().prepareStatement(sql);
            ps.setString(1, ma_lop);
            ResultSet rs = ps.executeQuery();
            this.tao_excel(rs);
            try{
                FileOutputStream fos = new FileOutputStream(new File("bang diem " + ma_lop + ".xlsx"));
                this.wb.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(null, "đã xuất file excel");
                this.connect.getConnect().close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "mã lỗi: " + ex);
        }
    }
}
