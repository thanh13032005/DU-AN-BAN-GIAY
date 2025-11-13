package org.example.duantotnghiep.DTO_quan;

import java.math.BigDecimal;
import java.util.Date;

public interface chiTietSanPham_DTO {
    Integer getid();
    Integer getIdSanPham();
    Integer getIdSize();
    Integer getIdMauSac();
    Integer getIdChiTietKhuyenMai();
    BigDecimal getGiaBan();
    Integer getSoLuongTon();
    Boolean getTrangThai();
    Date getNgayTao();
    String getTheLoai();
}
