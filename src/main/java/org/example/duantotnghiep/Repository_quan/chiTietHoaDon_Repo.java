package org.example.duantotnghiep.Repository_quan;

import org.example.duantotnghiep.DTO_quan.chiTietHoaDon;
import org.example.duantotnghiep.Entity_quan.chiTietHoaDon_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface chiTietHoaDon_Repo extends JpaRepository<chiTietHoaDon_Entity, Integer> {
        @Query(value = """
        SELECT hdct.id,
               sp.ten_san_pham AS tenSanPham,
               ms.ten_mau AS mauSac,
               sz.ten_size AS size,
               hdct.so_luong_mua AS soLuong,
               hdct.gia_ban AS giaBan
        FROM HOA_DON_CHI_TIET hdct
        JOIN CHI_TIET_SAN_PHAM ctsp ON ctsp.id = hdct.id_chi_tiet_san_pham
        JOIN SAN_PHAM sp ON sp.id = ctsp.id_san_pham
        JOIN MAU_SAC ms ON ms.id = ctsp.id_mau_sac
        JOIN SIZE sz ON sz.id = ctsp.id_size
        WHERE hdct.id_hoa_don = ?1
    """, nativeQuery = true)
        List<chiTietHoaDon> getChiTietByHoaDon(Integer idHoaDon);


}
