package org.example.duantotnghiep.sevice;

import org.example.duantotnghiep.entity.VoucherEntity;
import org.example.duantotnghiep.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public List<VoucherEntity> getAll() {
        return voucherRepository.findAll();
    }

    public Optional<VoucherEntity> getById(Integer id) {
        return voucherRepository.findById(id);
    }

    public VoucherEntity create(VoucherEntity voucher) {
        return voucherRepository.save(voucher);
    }

    public VoucherEntity update(Integer id, VoucherEntity newVoucher) {
        return voucherRepository.findById(id)
                .map(v -> {
                    v.setMaVoucher(newVoucher.getMaVoucher());
                    v.setTenVoucher(newVoucher.getTenVoucher());
                    v.setGiaTri(newVoucher.getGiaTri());
                    v.setKieuGiam(newVoucher.getKieuGiam());
                    v.setNgayBatDau(newVoucher.getNgayBatDau());
                    v.setNgayKetThuc(newVoucher.getNgayKetThuc());
                    v.setTrangThai(newVoucher.getTrangThai());
                    return voucherRepository.save(v);
                })
                .orElseThrow(() -> new RuntimeException("Voucher không tồn tại"));
    }

    public void delete(Integer id) {
        voucherRepository.deleteById(id);
    }
}
