import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia,
                int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        if (namXuatBan > 0 && namXuatBan <= Year.now().getValue()) {
            this.namXuatBan = namXuatBan;
        } else {
            throw new IllegalArgumentException("Nam xuat ban khong hop le!");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            throw new IllegalArgumentException("So luong khong hop le!");
        }
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
    }

    public static void main(String[] args) {
        Test.quanLySach();
    }
}

class Test {
    public static void quanLySach() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> dsSach = new ArrayList<>();
        int chon;

        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tinh tong so luong sach");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    try {
                        System.out.print("Nhap ma sach: ");
                        String maSach = sc.nextLine();

                        System.out.print("Nhap tieu de: ");
                        String tieuDe = sc.nextLine();

                        System.out.print("Nhap tac gia: ");
                        String tacGia = sc.nextLine();

                        System.out.print("Nhap nam xuat ban: ");
                        int namXuatBan = sc.nextInt();

                        System.out.print("Nhap so luong: ");
                        int soLuong = sc.nextInt();
                        sc.nextLine();

                        Sach sach = new Sach(
                            maSach, tieuDe, tacGia,
                            namXuatBan, soLuong
                        );

                        dsSach.add(sach);
                        System.out.println("Them sach thanh cong!");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    if (dsSach.isEmpty()) {
                        System.out.println("Danh sach sach rong!");
                    } else {
                        for (Sach s : dsSach) {
                            System.out.println("--------------------");
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 3:
                    int tong = 0;
                    for (Sach s : dsSach) {
                        tong += s.getSoLuong();
                    }
                    System.out.println("Tong so luong sach: " + tong);
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}