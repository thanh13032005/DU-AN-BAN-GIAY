package org.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "VOUCHER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "MA_VOUCHER", nullable = false, unique = true)
        private String maVoucher;

        @Column(name = "TEN_VOUCHER", nullable = false)
        private String tenVoucher;

        @Column(name = "GIA_TRI", nullable = false, precision = 18, scale = 2)
        private BigDecimal giaTri;

        @Column(name = "KIEU_GIAM", nullable = false)
        private String kieuGiam; // "%", "TIEN"

        @Column(name = "NGAY_BAT_DAU", nullable = false)
        private LocalDate ngayBatDau;

        @Column(name = "NGAY_KET_THUC", nullable = false)
        private LocalDate ngayKetThuc;

        @Column(name = "TRANG_THAI", nullable = false)
        private Boolean trangThai;
}
