package org.example.duantotnghiep.Entity_quan;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
@Table(name = "CHI_TIET_SAN_PHAM")
public class chiTietSanPham_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_SAN_PHAM")
    private Integer idSanPham;

    @Column(name = "ID_SIZE")
    private Integer idSize;

    @Column(name = "ID_MAU_SAC")
    private Integer idMauSac;

    @Column(name = "ID_CHI_TIET_KHUYEN_MAI")
    private Integer idChiTietKhuyenMai;

    @Column(name = "GIA_BAN")
    private Float giaBan;

    @Column(name = "SO_LUONG_TON")
    private Integer soLuongTon;

    @Column(name = "TRANG_THAI")
    private Boolean trangThai;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;




}
