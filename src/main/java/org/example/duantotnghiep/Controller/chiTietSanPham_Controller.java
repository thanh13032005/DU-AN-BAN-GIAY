package org.example.duantotnghiep.Controller;

import org.example.duantotnghiep.Entity.chiTietSanPham_Entity;
import org.example.duantotnghiep.Service.chiTietSanPham_Servidce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quan_ly_chi_tiet_san_pham")
@CrossOrigin("*")
public class chiTietSanPham_Controller {
    @Autowired
    private chiTietSanPham_Servidce ctsp;


    @GetMapping()
    public ResponseEntity<?> getAllTable() {
        return ResponseEntity.ok(ctsp.getAllChiTietSanPham());
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody chiTietSanPham_Entity chiTietSanPham_entity) {
        try {
            ctsp.add(chiTietSanPham_entity);
            return ResponseEntity.ok(" Thêm thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" Lỗi " );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (ctsp.delete(id)) {
            return ResponseEntity.ok("Xóa thành công");
        } else {
            return ResponseEntity.status(404).body("Không tìm thấy ID cần xóa");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody chiTietSanPham_Entity entity) {
        chiTietSanPham_Entity updated = ctsp.update(id, entity);
        if (updated != null) {
            return ResponseEntity.ok("Cập nhật thành công");
        }
        return ResponseEntity.status(404).body("Không tìm thấy chi tiết sản phẩm");
    }


}
