package model;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class import_excel {
    private Connect connect = new Connect();
    private XSSFWorkbook wb;
    private FileInputStream fis;
    private insert_hoc_vien insert_hv;
    private insert_giang_vien insert_gv;
    private nhap_diem diem;
    public import_excel() {
    }
    
    public void nhap_Excel(String file_path, String ma_lop){
        connect.getConnect();
        insert_hv = new insert_hoc_vien();
        try {    
            fis = new FileInputStream(new File(file_path));
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                String ten_hv = row.getCell(0).getStringCellValue();
                String ngay_sinh = row.getCell(1).getStringCellValue();
                String dien_thoai = row.getCell(2).getStringCellValue();
                String email = row.getCell(3).getStringCellValue();
                String dia_chi = row.getCell(4).getStringCellValue();
                insert_hv.insert_hoc_vien_for_excel(ma_lop, ten_hv, ngay_sinh, dien_thoai,
                        email, dia_chi);
            }
            JOptionPane.showMessageDialog(null, "đã nhập file");
        }
            catch (Exception ex) {
            Logger.getLogger(import_excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //nhap excel giang vien
    public void nhap_Excel_gv(String file_path){
        connect.getConnect();
        insert_gv = new insert_giang_vien();
        try {    
            fis = new FileInputStream(new File(file_path));
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                String ten_gv = row.getCell(0).getStringCellValue();
                String ngay_sinh = row.getCell(1).getStringCellValue();
                String dien_thoai = row.getCell(2).getStringCellValue();
                String email = row.getCell(3).getStringCellValue();
                String dia_chi = row.getCell(4).getStringCellValue();
                insert_gv.inset_giang_vien_sc(ten_gv, ngay_sinh, dien_thoai, email, dia_chi);
            }
            JOptionPane.showMessageDialog(null, "đã nhập file");
        }
            catch (Exception ex) {
            Logger.getLogger(import_excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //nhap file excel diem
    public void nhap_Excel_diem(String file_path, String ma_lop){
        connect.getConnect();
        diem = new nhap_diem();
        try {    
            fis = new FileInputStream(new File(file_path));
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                int ma_hv = (int)row.getCell(0).getNumericCellValue();
                int diem_1 = Integer.parseInt(row.getCell(1).getStringCellValue());
                diem.nhap_diem(ma_hv, diem_1);
            }
            JOptionPane.showMessageDialog(null, "đã nhập file");
        }
            catch (Exception ex) {
            Logger.getLogger(import_excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
