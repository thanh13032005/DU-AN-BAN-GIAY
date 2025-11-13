package org.example.duantotnghiep.Entity_quan;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOA_DON")
public class hoaDon_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ID_KHACH_HANG")
    private Integer idKhachHang;

    @Column(name = "ID_NHAN_VIEN")
    private Integer idNhanVien;

    @Column(name = "ID_VOUCHER")
    private Integer idVoucher;

    @Column(name = "MA_HOA_DON")
    private String maHoaDon;

    @Column(name = "TEN_KHACH_HANG")
    private String tenKhachHang;

    @Column(name = "DIA_CHI")
    private String diaChi;

    @Column(name = "SO_DIEN_THOAI")
    private String soDienThoai;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "NGAY_THANH_TOAN")
    private Date ngayThanhToan;

    @Column(name = "TONG_TIEN")
    private BigDecimal tongTien;

    @Column(name = "TONG_TIEN_GIAM")
    private BigDecimal tongTienGiam;

    @Column(name = "TRANG_THAI")
    private Boolean trangThai; // 1: đã thanh toán, 0: chưa
}
