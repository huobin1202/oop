import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BanTSUI extends JFrame {
    private JButton btnDoUong, btnKhachHang, btnHoaDon, btnThoat;
    private DSDrink dsDoUong = new DSDrink();
    private CustomerList dsKhachHang = new CustomerList();
    private DSHoaDon dsHoaDon = new DSHoaDon();

    public BanTSUI() {
        setTitle("Quản Lý Quán Trà Sữa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        btnDoUong = new JButton("Quản lý đồ uống");
        btnKhachHang = new JButton("Quản lý khách hàng");
        btnHoaDon = new JButton("Quản lý hóa đơn");
        btnThoat = new JButton("Thoát");

        panel.add(btnDoUong);
        panel.add(btnKhachHang);
        panel.add(btnHoaDon);
        panel.add(btnThoat);

        add(panel);

        btnThoat.addActionListener(e -> System.exit(0));

        // ...existing code...
btnDoUong.addActionListener(e -> {
    String[] options = {"Nhập DS", "Xuất DS", "Thêm", "Sửa", "Xóa", "Tìm kiếm"};
    int chon = JOptionPane.showOptionDialog(this, "Chọn chức năng", "Đồ uống",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    switch (chon) {
        case 0: // Nhập DS bằng GUI
            String soLuongStr = JOptionPane.showInputDialog(this, "Nhập số lượng đồ uống:");
            if (soLuongStr != null) {
                try {
                    int soLuong = Integer.parseInt(soLuongStr);
                    dsDoUong = new DSDrink(soLuong, new Drink[soLuong]);
                    for (int i = 0; i < soLuong; i++) {
                        String[] loai = {"Trà sữa", "Trà trái cây"};
                        int loaiChon = JOptionPane.showOptionDialog(this, "Chọn loại đồ uống", "Loại",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, loai, loai[0]);
                        if (loaiChon == 0) {
                            String ten = JOptionPane.showInputDialog(this, "Tên trà sữa:");
                            String giaStr = JOptionPane.showInputDialog(this, "Giá:");
                            String topping = JOptionPane.showInputDialog(this, "Topping:");
                            dsDoUong.dsdrink[i] = new Milktea(ten, Integer.parseInt(giaStr), topping);
                        } else if (loaiChon == 1) {
                            String ten = JOptionPane.showInputDialog(this, "Tên trà trái cây:");
                            String giaStr = JOptionPane.showInputDialog(this, "Giá:");
                            String traicay = JOptionPane.showInputDialog(this, "Loại trái cây:");
                            dsDoUong.dsdrink[i] = new Fruittea(ten, Integer.parseInt(giaStr), traicay);
                        }
                    }
                    dsDoUong.n = soLuong;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
                }
            }
            break;
        case 1: // Xuất DS
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dsDoUong.n; i++) {
                if (dsDoUong.dsdrink[i] != null) {
                    sb.append(dsDoUong.dsdrink[i].getTen()).append(" - ").append(dsDoUong.dsdrink[i].getGia()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "Danh sách rỗng!");
            break;
        // Các chức năng khác giữ nguyên hoặc chuyển sang GUI tương tự
        case 2: dsDoUong.them(); break;
        case 3: dsDoUong.sua(); break;
        case 4: dsDoUong.xoa(); break;
        case 5: dsDoUong.timkiem(); break;
    }
});
// ...existing code...

        btnKhachHang.addActionListener(e -> {
            String[] options = {"Nhập DS", "Xuất DS", "Thêm", "Sửa", "Xóa", "Tìm kiếm"};
            int chon = JOptionPane.showOptionDialog(this, "Chọn chức năng", "Khách hàng",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chon) {
                case 0: dsKhachHang.nhap(); break;
                case 1: dsKhachHang.xuat(); break;
                case 2: dsKhachHang.them(); break;
                case 3: dsKhachHang.sua(); break;
                case 4: dsKhachHang.xoa(); break;
                case 5: dsKhachHang.timkiem(); break;
            }
        });

        btnHoaDon.addActionListener(e -> {
            String[] options = {"Nhập DS", "Xuất DS", "Thêm", "Sửa", "Xóa", "Tìm kiếm", "Doanh thu"};
            int chon = JOptionPane.showOptionDialog(this, "Chọn chức năng", "Hóa đơn",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (chon) {
                case 0: dsHoaDon.nhap(); break;
                case 1: dsHoaDon.xuat(); break;
                case 2: dsHoaDon.them(); break;
                case 3: dsHoaDon.sua(); break;
                case 4: dsHoaDon.xoa(); break;
                case 5: dsHoaDon.timkiem(); break;
                case 6: dsHoaDon.doanhthu(); break;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BanTSUI().setVisible(true);
        });
    }
}