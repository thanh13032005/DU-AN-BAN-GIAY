package org.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "KHUYEN_MAI")
@Getter
@Setter
public class KhuyenMaiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MA_CHUONG_TRINH", nullable = false, unique = true)
    private String maChuongTrinh;

    @Column(name = "TEN_CHUONG_TRINH", nullable = false)
    private String tenChuongTrinh;

    @Column(name = "PHAN_TRAM_GIAM")
    private BigDecimal phanTramGiam;

    @Column(name = "NGAY_BAT_DAU", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "NGAY_KET_THUC", nullable = false)
    private LocalDate ngayKetThuc;

    @Column(name = "TRANG_THAI", nullable = false)
    private Boolean trangThai;

    @Column(name = "MO_TA")
    private String moTa;
}
