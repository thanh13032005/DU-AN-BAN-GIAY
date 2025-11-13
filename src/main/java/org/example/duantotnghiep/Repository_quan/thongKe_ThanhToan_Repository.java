package org.example.duantotnghiep.Repository_quan;

import org.example.duantotnghiep.DTO_quan.thongKe_ThanhToan_DTO;
import org.example.duantotnghiep.Entity_quan.thongKe_ThanhToan_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface thongKe_ThanhToan_Repository extends JpaRepository<thongKe_ThanhToan_Entity, Integer> {
    // Lấy tất cả sản phẩm
    @Query(value = """
        select TT.ID , HD.MA_HOA_DON , TT.MA_THANH_TOAN, TT.HINH_THANH_TOAN ,TT.SO_TIEN_THANH_TOAN,TT.NGAY_THANH_TOAN,TT.TRANG_THAI  from THANH_TOAN TT JOIN HOA_DON HD ON TT.ID_HOA_DON =HD.ID
        """, nativeQuery = true)
    List<thongKe_ThanhToan_DTO> getALLThongKe_ThanhToan();

    @Query(value = """
    SELECT TT.ID,
           HD.MA_HOA_DON,
           TT.MA_THANH_TOAN,
           TT.HINH_THANH_TOAN,
           TT.SO_TIEN_THANH_TOAN,
           TT.NGAY_THANH_TOAN,
           TT.TRANG_THAI
    FROM THANH_TOAN TT
    JOIN HOA_DON HD ON TT.ID_HOA_DON = HD.ID
    WHERE TT.NGAY_THANH_TOAN >= :startDate
      AND TT.NGAY_THANH_TOAN <= :endDate
""", nativeQuery = true)
    List<thongKe_ThanhToan_DTO> searchByDate(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    @Query(value = """
    SELECT COUNT(*)
    FROM THANH_TOAN
    WHERE NGAY_THANH_TOAN >= :startDate
      AND NGAY_THANH_TOAN <= :endDate
""", nativeQuery = true)
    Integer countHoaDon(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    @Query(value = """
    SELECT COALESCE(SUM(SO_TIEN_THANH_TOAN), 0)
    FROM THANH_TOAN
    WHERE NGAY_THANH_TOAN >= :startDate
      AND NGAY_THANH_TOAN <= :endDate
""", nativeQuery = true)
    BigDecimal sumTien(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );


}
