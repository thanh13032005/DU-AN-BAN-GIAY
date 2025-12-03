package org.example.duantotnghiep.Repository_quan;
import org.example.duantotnghiep.DTO_quan.chiTietSanPham_DTO;
import org.example.duantotnghiep.Entity_quan.chiTietSanPham_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface chiTietSanPham_Repository extends JpaRepository<chiTietSanPham_Entity, Integer> {

    @Query(value = """
            SELECT ID, ID_SAN_PHAM,ID_SIZE,ID_MAU_SAC,GIA_BAN,SO_LUONG_TON,TRANG_THAI,NGAY_TAO,THE_LOAI FROM CHI_TIET_SAN_PHAM
        """, nativeQuery = true)
    List<chiTietSanPham_DTO> getAllChiTietSanPham();


}
