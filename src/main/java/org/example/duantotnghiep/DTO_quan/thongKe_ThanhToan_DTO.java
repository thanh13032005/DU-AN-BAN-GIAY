package org.example.duantotnghiep.DTO_quan;

import java.math.BigDecimal;
import java.util.Date;

public interface thongKe_ThanhToan_DTO {
    Integer getId();
    String getMaThanhToan();
    Boolean getHinhThanhToan();
    BigDecimal getSoTienThanhToan();
    Boolean getTrangThai();
    Date getNgay();
    String getGhiChu();

    // Lấy mã hóa đơn từ quan hệ ManyToOne
    String getMaHoaDon();
}
