package org.example.duantotnghiep.Service_quan;

import org.example.duantotnghiep.DTO_quan.chiTietHoaDon;
import org.example.duantotnghiep.Repository_quan.chiTietHoaDon_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chiTietHoaDon_Service {
    @Autowired
    private chiTietHoaDon_Repo cthd_repo;

    public List<chiTietHoaDon> getByHoaDonId(Integer idHoaDon) {
        return cthd_repo.getChiTietByHoaDon(idHoaDon);
    }
}
