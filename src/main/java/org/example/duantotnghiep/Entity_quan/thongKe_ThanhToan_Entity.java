package org.example.duantotnghiep.Entity_quan;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
@Table(name = "THANH_TOAN")
public class thongKe_ThanhToan_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MA_THANH_TOAN")
    private String maThanhToan;


    @Column(name = "HINH_THANH_TOAN")
    private Boolean hinhThanhToan;

    @Column(name = "SO_TIEN_THANH_TOAN")
    private BigDecimal soTienThanhToan;

    @Column(name = "TRANG_THAI")
    private Boolean trangThai;

    @Column(name = "NGAY_THANH_TOAN")
    private Date ngay;

    @Column(name = "GHI_CHU")
    private String GHI_CHU;

    @ManyToOne
    @JoinColumn(name = "ID_HOA_DON")
    private hoaDon_Entity hoaDon;
}
