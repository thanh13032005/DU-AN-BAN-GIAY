package org.example.duantotnghiep.DTO;

import java.util.Date;

public interface sanPham_DTO {
    Integer  getid();
    Integer getIdXuatXu();
    Integer getIdThuongHieu();
    String getmaSanPham();
    String gettenSanPham();
    Date getngayTao();
    Boolean getTrangThai();

}
