package model;

public class diem {
    private int ma_bt, ma_hv, diem;

    public diem(int ma_bt, int ma_hv, int diem) {
        this.ma_bt = ma_bt;
        this.ma_hv = ma_hv;
        this.diem = diem;
    }

    public int getMa_bt() {
        return ma_bt;
    }

    public void setMa_bt(int ma_bt) {
        this.ma_bt = ma_bt;
    }

    public int getMa_hv() {
        return ma_hv;
    }

    public void setMa_hv(int ma_hv) {
        this.ma_hv = ma_hv;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
    
    public Object[] toArray(){
        return new Object[]{ma_bt, ma_hv, diem};
    }

}
