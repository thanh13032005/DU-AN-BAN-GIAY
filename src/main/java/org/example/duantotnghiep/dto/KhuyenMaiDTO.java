package org.example.duantotnghiep.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class KhuyenMaiDTO {

        @NotBlank(message = "Mã chương trình không được để trống")
        private String maChuongTrinh;

        @NotBlank(message = "Tên chương trình không được để trống")
        private String tenChuongTrinh;

        @DecimalMin(value = "0.0", inclusive = false, message = "Phần trăm giảm phải lớn hơn 0")
        @DecimalMax(value = "1.0", message = "Phần trăm giảm không được lớn hơn 1 (tức 100%)")
        private BigDecimal phanTramGiam;

        @NotNull(message = "Ngày bắt đầu không được để trống")
        private LocalDate ngayBatDau;

        @NotNull(message = "Ngày kết thúc không được để trống")
        private LocalDate ngayKetThuc;

        @NotNull(message = "Trạng thái không được để trống")
        private Boolean trangThai;

        private String moTa;

}
