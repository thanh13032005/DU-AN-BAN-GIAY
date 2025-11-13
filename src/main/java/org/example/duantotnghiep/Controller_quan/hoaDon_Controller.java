package org.example.duantotnghiep.Controller_quan;

import org.example.duantotnghiep.Service_quan.hoaDon_Service;
import org.example.duantotnghiep.Service_quan.chiTietHoaDon_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quan_ly_hoa_don")
@CrossOrigin("*")
public class hoaDon_Controller {
    @Autowired
    private hoaDon_Service hd_service;

    @Autowired
    private chiTietHoaDon_Service ctdv_service;

    // Lấy tất cả
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(hd_service.getAll());
    }

    // Tìm kiếm theo mã hóa đơn
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String key) {
        return ResponseEntity.ok(hd_service.search(key));
    }

    // Click vào hóa đơn → hiện chi tiết
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        return ResponseEntity.ok(ctdv_service.getByHoaDonId(id));
    }

}
