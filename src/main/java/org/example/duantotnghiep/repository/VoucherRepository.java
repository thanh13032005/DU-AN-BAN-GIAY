package org.example.duantotnghiep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<org.example.duantotnghiep.entity.VoucherEntity, Integer> {
    boolean existsByMaVoucher(String maVoucher);
}
