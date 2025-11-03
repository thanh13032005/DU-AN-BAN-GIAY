package org.example.duantotnghiep.Service_quan;


import org.example.duantotnghiep.DTO_quan.sanPham_DTO;
import org.example.duantotnghiep.Entity_quan.sanPham_Entity;
import org.example.duantotnghiep.Repository_quan.sanPham_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sanPham_Service {
    @Autowired
    private sanPham_Repository sp_repository;
    // hiện thị table
    public List<sanPham_DTO> getAllSanPham(){
        return sp_repository.getAllSanPham();
    }
    //    Thêm dữ liệu
    public sanPham_Entity add(sanPham_Entity sanPham_entity){
        return sp_repository.save(sanPham_entity);
    }
    //    Xóa Dữ liệu
    public boolean delete(Integer id) {
        Optional<sanPham_Entity> entity = sp_repository.findById(id);
        if (entity.isPresent()) {
            sp_repository.delete(entity.get());
            return true;
        }
        return false;
    }
    public sanPham_Entity update(Integer id, sanPham_Entity sanPhamUpdate) {
        Optional<sanPham_Entity> optional = sp_repository.findById(id);

        if (optional.isPresent()) {
            sanPham_Entity existing = optional.get();
            existing.setIdThuongHieu(sanPhamUpdate.getIdThuongHieu());
            existing.setIdXuatXu(sanPhamUpdate.getIdXuatXu());
            existing.setMaSanPham(sanPhamUpdate.getMaSanPham());
            existing.setTenSanPham(sanPhamUpdate.getTenSanPham());
            existing.setNgayTao(sanPhamUpdate.getNgayTao());
            existing.setTrangThai(sanPhamUpdate.getTrangThai());
            return sp_repository.save(existing);
        }
        return null;
    }
    public List<sanPham_DTO> search(String keyword){
        return sp_repository.search(keyword);
    }




}
