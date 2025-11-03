package org.example.duantotnghiep.controller;

import org.example.duantotnghiep.entity.VoucherEntity;
import org.example.duantotnghiep.sevice.VoucherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voucher")
//@CrossOrigin("*")
public class VoucherController {

    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping
    public List<VoucherEntity> getAll() {
        return voucherService.getAll();
    }

    @GetMapping("/{id}")
    public VoucherEntity getById(@PathVariable Integer id) {
        return voucherService.getById(id).orElse(null);
    }

    @PostMapping
    public VoucherEntity create(@RequestBody VoucherEntity voucher) {
        return voucherService.create(voucher);
    }

    @PutMapping("/{id}")
    public VoucherEntity update(@PathVariable Integer id, @RequestBody VoucherEntity voucher) {
        return voucherService.update(id, voucher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        voucherService.delete(id);
    }
}
