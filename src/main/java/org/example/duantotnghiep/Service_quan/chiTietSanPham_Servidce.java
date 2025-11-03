package org.example.duantotnghiep.Service_quan;

import org.example.duantotnghiep.DTO_quan.chiTietSanPham_DTO;
import org.example.duantotnghiep.Entity_quan.chiTietSanPham_Entity;
import org.example.duantotnghiep.Repository_quan.chiTietSanPham_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class chiTietSanPham_Servidce {
    @Autowired
    private chiTietSanPham_Repository chiTietSanPham_repository;

    // hiện thị table
    public List<chiTietSanPham_DTO> getAllChiTietSanPham() {
        return chiTietSanPham_repository.getAllChiTietSanPham();
    }

    //    Thêm dữ liệu
    public chiTietSanPham_Entity add(chiTietSanPham_Entity chiTietSanPham_entity) {
        return chiTietSanPham_repository.save(chiTietSanPham_entity);
    }

    //    Xóa Dữ liệu
    public boolean delete(Integer id) {
        Optional<chiTietSanPham_Entity> entity = chiTietSanPham_repository.findById(id);
        if (entity.isPresent()) {
            chiTietSanPham_repository.delete(entity.get());
            return true;
        }
        return false;
    }
    public chiTietSanPham_Entity update(Integer id, chiTietSanPham_Entity chiTietSanPham_entity) {
        Optional<chiTietSanPham_Entity> opt = chiTietSanPham_repository.findById(id);
        if (opt.isEmpty()) {
            return null;
        }

        chiTietSanPham_Entity existing = opt.get();
        existing.setIdSanPham(chiTietSanPham_entity.getIdSanPham());
        existing.setIdSize(chiTietSanPham_entity.getIdSize());
        existing.setIdMauSac(chiTietSanPham_entity.getIdMauSac());
        existing.setIdChiTietKhuyenMai(chiTietSanPham_entity.getIdChiTietKhuyenMai());
        existing.setGiaBan(chiTietSanPham_entity.getGiaBan());
        existing.setSoLuongTon(chiTietSanPham_entity.getSoLuongTon());
        existing.setTrangThai(chiTietSanPham_entity.getTrangThai());
        existing.setNgayTao(chiTietSanPham_entity.getNgayTao());

        return chiTietSanPham_repository.save(existing);
    }

}

