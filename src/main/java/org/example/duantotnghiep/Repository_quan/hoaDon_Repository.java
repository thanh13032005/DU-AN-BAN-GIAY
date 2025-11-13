package org.example.duantotnghiep.Repository_quan;

import org.example.duantotnghiep.DTO_quan.hoaDon_DTO;
import org.example.duantotnghiep.DTO_quan.sanPham_DTO;
import org.example.duantotnghiep.Entity_quan.hoaDon_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface hoaDon_Repository extends JpaRepository<hoaDon_Entity, Integer> {
    @Query(value = """
        SELECT id, ma_hoa_don AS maHoaDon, ten_khach_hang AS tenKhachHang,
               so_dien_thoai AS soDienThoai, ngay_tao AS ngayTao,
               tong_tien AS tongTien, trang_thai AS trangThai
        FROM HOA_DON
    """, nativeQuery = true)
    List<hoaDon_DTO> getAllHoaDon();


    @Query(value = """
    SELECT id, ma_hoa_don AS maHoaDon, ten_khach_hang AS tenKhachHang,
           so_dien_thoai AS soDienThoai, ngay_tao AS ngayTao,
           tong_tien AS tongTien, trang_thai AS trangThai
    FROM HOA_DON
    WHERE ma_hoa_don LIKE %?1%
       OR ten_khach_hang LIKE %?1%
       OR so_dien_thoai LIKE %?1%
""", nativeQuery = true)
    List<hoaDon_DTO> searchHoaDon(String keyword);

}
