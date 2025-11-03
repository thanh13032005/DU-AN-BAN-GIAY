package org.example.duantotnghiep.Controller_quan;

import org.example.duantotnghiep.Entity_quan.sanPham_Entity;
import org.example.duantotnghiep.Service_quan.sanPham_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quan_ly_san_pham")
@CrossOrigin("*")
public class sanPham_Controller {
    @Autowired
    private sanPham_Service sp_service;


    @GetMapping()
    public ResponseEntity<?> getAllTable() {
        return ResponseEntity.ok(sp_service.getAllSanPham());
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody sanPham_Entity sanPham_entity) {
        try {
            sp_service.add(sanPham_entity);
            return ResponseEntity.ok(" Thêm thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" Lỗi " );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (sp_service.delete(id)) {
            return ResponseEntity.ok("Xóa thành công");
        } else {
            return ResponseEntity.status(404).body("Không tìm thấy ID cần xóa");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody sanPham_Entity sanPham_entity) {
        sanPham_Entity sanPham = sp_service.update(id, sanPham_entity);
        if (sanPham != null) {
            return ResponseEntity.ok("Cập nhật thành công");
        }
        return ResponseEntity.status(404).body("Không tìm thấy sản phẩm");
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(defaultValue = "") String keyword) {
        return ResponseEntity.ok(sp_service.search(keyword));
    }





}
