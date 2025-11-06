
package org.example.duantotnghiep.service;
import org.example.duantotnghiep.entity.VoucherEntity;
import org.example.duantotnghiep.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository repository;

    public List<VoucherEntity> getAll() {
        return repository.findAll();
    }

    public VoucherEntity add(VoucherEntity voucher) {
        if (repository.existsByMaVoucher(voucher.getMaVoucher())) {
            throw new RuntimeException("Mã voucher đã tồn tại");
        }
        return repository.save(voucher);
    }

    public VoucherEntity update(Integer id, VoucherEntity newData) {
        return repository.findById(id).map(v -> {
            v.setTenVoucher(newData.getTenVoucher());
            v.setGiaTri(newData.getGiaTri());
            v.setKieuGiam(newData.getKieuGiam());
            v.setNgayBatDau(newData.getNgayBatDau());
            v.setNgayKetThuc(newData.getNgayKetThuc());
            v.setTrangThai(newData.getTrangThai());
            return repository.save(v);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy voucher cần cập nhật"));
    }

    public boolean delete(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
