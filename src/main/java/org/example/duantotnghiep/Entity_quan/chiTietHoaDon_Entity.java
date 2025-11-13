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
@Table(name = "HOA_DON_CHI_TIET")
public class chiTietHoaDon_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ID_HOA_DON")
    private Integer idHoaDon;

    @Column(name = "ID_CHI_TIET_SAN_PHAM")
    private Integer idChiTietSanPham;

    @Column(name = "SO_LUONG_MUA")
    private Integer soLuong;

    @Column(name = "GIA_GOC")
    private BigDecimal giaGoc;

    @Column(name = "GIA_BAN")
    private BigDecimal giaBan;

    @Column(name = "TRANG_THAI")
    private Boolean trangThai;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;
}
