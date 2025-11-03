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
@Table(name = "SAN_PHAM")
public class sanPham_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_XUAT_XU")
    private Integer idXuatXu;

    @Column(name = "ID_THUONG_HIEU")
    private Integer idThuongHieu;


    @Column(name = "MA_SAN_PHAM")
    private String maSanPham;

    @Column(name = "TEN_SAN_PHAM")
    private String tenSanPham;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "TRANG_THAI")
    private Boolean trangThai;



}
