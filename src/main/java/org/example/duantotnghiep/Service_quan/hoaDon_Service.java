package org.example.duantotnghiep.Service_quan;

import org.example.duantotnghiep.DTO_quan.hoaDon_DTO;
import org.example.duantotnghiep.Entity_quan.hoaDon_Entity;
import org.example.duantotnghiep.Repository_quan.hoaDon_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hoaDon_Service {
    @Autowired
    private hoaDon_Repository repo;

    // lấy danh sách hóa đơn
    public List<hoaDon_DTO> getAll() {
        return repo.getAllHoaDon();
    }

    // tìm kiếm theo mã
    public List<hoaDon_DTO> search(String keyword) {
        return repo.searchHoaDon(keyword);
    }

    // lấy 1 hóa đơn theo id
    public hoaDon_Entity getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

}
