import java.util.ArrayList;
import java.util.Scanner;

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
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("----------------------------");
    }

    public int getSoLuong() {
        return soLuong;
    }

    public static void main(String[] args) {
        Test.quanLySach();
    }
}
class Test {
    public static void quanLySach() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();

        int chon;

        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tinh tong so luong sach");
            System.out.println("4. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String maSach = sc.nextLine();

                    System.out.print("Nhap tieu de: ");
                    String tieuDe = sc.nextLine();

                    System.out.print("Nhap tac gia: ");
                    String tacGia = sc.nextLine();

                    System.out.print("Nhap nam xuat ban: ");
                    int namXuatBan = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap so luong: ");
                    int soLuong = Integer.parseInt(sc.nextLine());

                    Sach s = new Sach(maSach, tieuDe, tacGia,
                            namXuatBan, soLuong);

                    danhSach.add(s);

                    System.out.println("Them sach thanh cong!");
                    break;

                case 2:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sach sach rong!");
                    } else {
                        System.out.println("\n===== DANH SACH SACH =====");

                        for (Sach sach : danhSach) {
                            sach.hienThiThongTin();
                        }
                    }
                    break;

                case 3:
                    int tongSoLuong = 0;

                    for (Sach sach : danhSach) {
                        tongSoLuong += sach.getSoLuong();
                    }

                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    break;

                case 4:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 4);

        sc.close();
    }
}