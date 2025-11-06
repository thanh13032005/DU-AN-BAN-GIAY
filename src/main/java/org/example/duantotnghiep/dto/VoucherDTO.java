
package org.example.duantotnghiep.dto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class VoucherDTO {

    @NotBlank(message = "Mã voucher không được để trống")
    private String maVoucher;

    @NotBlank(message = "Tên voucher không được để trống")
    private String tenVoucher;

    @NotNull(message = "Giá trị giảm không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá trị giảm phải lớn hơn 0")
    private BigDecimal giaTri;

    @NotBlank(message = "Kiểu giảm không được để trống")
    private String kieuGiam;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate ngayBatDau;

    @NotNull(message = "Ngày kết thúc không được để trống")
    private LocalDate ngayKetThuc;

    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;
}
