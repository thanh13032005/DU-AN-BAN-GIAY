package org.example.duantotnghiep.controller;

import jakarta.validation.Valid;
import org.example.duantotnghiep.dto.KhuyenMaiDTO;
import org.example.duantotnghiep.entity.KhuyenMaiEntity;
import org.example.duantotnghiep.service.KhuyenMaiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khuyen-mai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService service;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody KhuyenMaiDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            String msg = result.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(msg);
        }
        try {
            KhuyenMaiEntity entity = new KhuyenMaiEntity();
            BeanUtils.copyProperties(dto, entity);
            service.add(entity);
            return ResponseEntity.ok("Thêm khuyến mãi thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody KhuyenMaiDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            String msg = result.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(msg);
        }
        try {
            KhuyenMaiEntity entity = new KhuyenMaiEntity();
            BeanUtils.copyProperties(dto, entity);
            service.update(id, entity);
            return ResponseEntity.ok("Cập nhật khuyến mãi thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (service.delete(id)) {
            return ResponseEntity.ok("Xóa khuyến mãi thành công!");
        }
        return ResponseEntity.status(404).body("Không tìm thấy khuyến mãi cần xóa");
    }
}
