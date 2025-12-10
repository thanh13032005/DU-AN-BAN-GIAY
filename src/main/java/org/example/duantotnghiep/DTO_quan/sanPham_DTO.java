package org.example.duantotnghiep.DTO_quan;

import java.util.Date;

public interface sanPham_DTO {

    Integer getId();
    Integer getIdXuatXu();
    Integer getIdThuongHieu();
    Integer getIdChiTietKhuyenMai();

    String getMaSanPham();
    String getTenSanPham();

    Date getNgayTao();
    Boolean getTrangThai();
}

