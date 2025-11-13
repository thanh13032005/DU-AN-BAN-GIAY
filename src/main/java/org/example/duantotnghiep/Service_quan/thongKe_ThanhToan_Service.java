package org.example.duantotnghiep.Service_quan;

import org.example.duantotnghiep.DTO_quan.thongKe_ThanhToan_DTO;
import org.example.duantotnghiep.Repository_quan.thongKe_ThanhToan_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class thongKe_ThanhToan_Service {
    @Autowired
    private thongKe_ThanhToan_Repository TT_repository;
    // hiện thị table
    public List<thongKe_ThanhToan_DTO> ggetAllThongKe_ThanhToan(){
        return TT_repository.getALLThongKe_ThanhToan();
    }
    public Map<String, Object> search(Date start, Date end) {

        Map<String, Object> result = new HashMap<>();

        result.put("data", TT_repository.searchByDate(start, end));
        result.put("tongHoaDon", TT_repository.countHoaDon(start, end));
        result.put("tongTienThanhToan", TT_repository.sumTien(start, end));

        return result;
    }

}
