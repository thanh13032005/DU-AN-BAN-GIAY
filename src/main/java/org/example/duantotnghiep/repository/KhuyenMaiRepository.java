package org.example.duantotnghiep.repository;

import org.example.duantotnghiep.entity.KhuyenMaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface KhuyenMaiRepository extends JpaRepository<KhuyenMaiEntity, Integer> {
        boolean existsByMaChuongTrinh(String maChuongTrinh);
    }


