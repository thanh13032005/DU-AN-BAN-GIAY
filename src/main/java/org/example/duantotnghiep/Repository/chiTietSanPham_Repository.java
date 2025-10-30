package org.example.duantotnghiep.Repository;
import org.example.duantotnghiep.DTO.chiTietSanPham_DTO;
import org.example.duantotnghiep.Entity.chiTietSanPham_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface chiTietSanPham_Repository extends JpaRepository<chiTietSanPham_Entity, Integer> {

    @Query(value = """
            SELECT * FROM CHI_TIET_SAN_PHAM
        """, nativeQuery = true)
    List<chiTietSanPham_DTO> getAllChiTietSanPham();

    @Query(value = """
            SELECT * FROM CHI_TIET_SAN_PHAM
            WHERE ID_SAN_PHAM IN (SELECT ID FROM SAN_PHAM WHERE TEN_SAN_PHAM LIKE %:keyword%)
               OR ID_SIZE IN (SELECT ID FROM SIZE WHERE TEN_SIZE LIKE %:keyword%)
               OR ID_MAU_SAC IN (SELECT ID FROM MAU_SAC WHERE TEN_MAU_SAC LIKE %:keyword%)
        """, nativeQuery = true)
    List<chiTietSanPham_DTO> searchChiTietSanPham(String keyword);
}
