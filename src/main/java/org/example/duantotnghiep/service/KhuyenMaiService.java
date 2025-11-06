package org.example.duantotnghiep.service;

import org.example.duantotnghiep.entity.KhuyenMaiEntity;
import org.example.duantotnghiep.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository repository;

    public List<KhuyenMaiEntity> getAll() {
        return repository.findAll();
    }

    public KhuyenMaiEntity add(KhuyenMaiEntity km) {
        if (repository.existsByMaChuongTrinh(km.getMaChuongTrinh())) {
            throw new RuntimeException("Mã chương trình khuyến mãi đã tồn tại");
        }
        return repository.save(km);
    }

    public KhuyenMaiEntity update(Integer id, KhuyenMaiEntity newData) {
        return repository.findById(id).map(km -> {
            km.setTenChuongTrinh(newData.getTenChuongTrinh());
            km.setPhanTramGiam(newData.getPhanTramGiam());
            km.setNgayBatDau(newData.getNgayBatDau());
            km.setNgayKetThuc(newData.getNgayKetThuc());
            km.setTrangThai(newData.getTrangThai());
            km.setMoTa(newData.getMoTa());
            return repository.save(km);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy chương trình cần cập nhật"));
    }

    public boolean delete(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}

