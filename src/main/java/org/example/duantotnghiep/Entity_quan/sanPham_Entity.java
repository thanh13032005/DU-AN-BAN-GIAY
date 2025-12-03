package org.example.duantotnghiep.Entity_quan;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "SAN_PHAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class sanPham_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_XUAT_XU", nullable = false)
    private Integer idXuatXu;

    @Column(name = "ID_THUONG_HIEU", nullable = false)
    private Integer idThuongHieu;

    @Column(name = "ID_CHI_TIET_KHUYEN_MAI")
    private Integer idChiTietKhuyenMai;

    @Column(name = "MA_SAN_PHAM")
    private String maSanPham;

    @Column(name = "TEN_SAN_PHAM")
    private String tenSanPham;

    @Temporal(TemporalType.DATE)
    @Column(name = "NGAY_TAO", nullable = false)
    private Date ngayTao;

    @Column(name = "TRANG_THAI", nullable = false)
    private Boolean trangThai;
}
