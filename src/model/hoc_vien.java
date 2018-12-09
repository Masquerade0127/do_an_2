package model;

public class hoc_vien {
    private int ma_hv, ngay, thang, nam;
    private String ngay_sinh;
    private String ten_hv, dien_thoai, email, dia_chi;
    
    public hoc_vien() {
    }

    public hoc_vien(String ten_hv, String ngay_sinh, String dien_thoai, String email, String dia_chi) {
        this.ngay_sinh = ngay_sinh;
        this.ten_hv = ten_hv;
        this.dien_thoai = dien_thoai;
        this.email = email;
        this.dia_chi = dia_chi;
    }
    
    public hoc_vien(int ma_hv, String ten_hv, String ngay_sinh, String dien_thoai, String email, String dia_chi) {
        this.ma_hv = ma_hv;
        this.ten_hv = ten_hv;
        this.ngay_sinh = ngay_sinh;
        this.dien_thoai = dien_thoai;
        this.email = email;
        this.dia_chi = dia_chi;
    }
    
    public int getMa_hv() {
        return ma_hv;
    }

    public void setMa_hv(int ma_hv) {
        this.ma_hv = ma_hv;
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

    public String getTen_hv() {
        return ten_hv;
    }

    public void setTen_hv(String ten_hv) {
        this.ten_hv = ten_hv;
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
        return new Object[]{ma_hv,ten_hv,ngay_sinh, dien_thoai, email, dia_chi};
    }
    
    public static void main(String[] args){
     hoc_vien hv = new hoc_vien();
    }
    
}
