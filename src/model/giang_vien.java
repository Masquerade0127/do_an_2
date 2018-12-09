package model;

public class giang_vien {
    private int ma_gv, ngay, thang, nam;
    private String ngay_sinh;
    private String ten_gv, dien_thoai, email, dia_chi;
    
    public giang_vien() {
    }

    public giang_vien(int ma_gv, String ten_gv, String ngay_sinh,  String dien_thoai, String email, String dia_chi) {
        this.ma_gv = ma_gv;
        this.ten_gv = ten_gv;
        this.ngay_sinh = ngay_sinh;
        this.dien_thoai = dien_thoai;
        this.email = email;
        this.dia_chi = dia_chi;
    }

    public int getMa_gv() {
        return ma_gv;
    }

    public void setMa_gv(int ma_gv) {
        this.ma_gv = ma_gv;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getTen_gv() {
        return ten_gv;
    }

    public void setTen_gv(String ten_gv) {
        this.ten_gv = ten_gv;
    }

    public String getDien_thoai() {
        return dien_thoai;
    }

    public void setDien_thoai(String dien_thoai) {
        this.dien_thoai = dien_thoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = String.valueOf(this.nam) + "-" + String.valueOf(this.thang) +
                "-" + String.valueOf(this.ngay);
    }
    
    public Object[] toArray(){
        return new Object[]{ma_gv,ten_gv,ngay_sinh, dien_thoai, email, dia_chi};
    }
}
