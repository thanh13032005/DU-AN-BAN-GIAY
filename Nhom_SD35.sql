USE master;
GO

-- 1. Nếu DB tồn tại thì buộc chuyển single_user + drop
IF EXISTS (SELECT 1 FROM sys.databases WHERE name = 'DU_AN_NHOM_SD35')
BEGIN
    ALTER DATABASE DU_AN_NHOM_SD35 SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE DU_AN_NHOM_SD35;
END
GO

-- 2. Tạo lại database và chuyển vào
CREATE DATABASE DU_AN_NHOM_SD35;
GO
USE DU_AN_NHOM_SD35;
GO

-- ======================= BẢNG CHÍNH =======================

CREATE TABLE CHUC_VU(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_CHUC_VU NVARCHAR(255) NOT NULL UNIQUE,
    TEN_CHUC_VU NVARCHAR(255) NOT NULL,
    TRANG_THAI BIT NOT NULL
)
GO

CREATE TABLE NHAN_VIEN(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_CHUC_VU INT NOT NULL,
    MA_NHAN_VIEN NVARCHAR(255) NOT NULL UNIQUE,
    HO_TEN NVARCHAR(255) NOT NULL,
    GIOI_TINH BIT NOT NULL,
    NGAY_SINH DATE NOT NULL,
    EMAIL NVARCHAR(255) NOT NULL,
    TAI_KHOAN NVARCHAR(255) NOT NULL UNIQUE,
    MAT_KHAU NVARCHAR(255) NOT NULL,
    LUONG DECIMAL(18,2) NOT NULL,
    DIA_CHI NVARCHAR(255) NOT NULL,
    SDT NVARCHAR(255) NOT NULL,
    HINH_ANH NVARCHAR(255),
    TRANG_THAI BIT NOT NULL,
    NGAY_TAO DATE NOT NULL DEFAULT GETDATE(),
    FOREIGN KEY (ID_CHUC_VU) REFERENCES CHUC_VU(ID)
)
GO

CREATE TABLE KHACH_HANG(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_KHACH_HANG NVARCHAR(255) UNIQUE,
    TEN_KHACH_HANG NVARCHAR(255),
    GIOI_TINH BIT,
    NGAY_SINH DATE,
    HINH_ANH NVARCHAR(255),
    EMAIL NVARCHAR(255),
    TAI_KHOAN NVARCHAR(255) NOT NULL UNIQUE,
    MAT_KHAU NVARCHAR(255) NOT NULL,
    SDT NVARCHAR(255),
    TRANG_THAI BIT,
    NGAY_TAO DATE DEFAULT GETDATE()
)
GO
-- ======================= ĐỊA CHỈ & VOUCHER =======================

CREATE TABLE DIA_CHI(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_KHACH_HANG INT NOT NULL,
    MA_DIA_CHI NVARCHAR(255) NOT NULL,
    THANH_PHO NVARCHAR(255) NOT NULL,
    QUAN_HUYEN NVARCHAR(255) NOT NULL,
    XA_PHUONG NVARCHAR(255) NOT NULL,
    SO_NHA NVARCHAR(255) NOT NULL,
    TEN_NGUOI_NHAN NVARCHAR(255) NOT NULL,
    SDT_NGUOI_NHAN NVARCHAR(255) NOT NULL,
    FOREIGN KEY (ID_KHACH_HANG) REFERENCES KHACH_HANG(ID)
)
GO

CREATE TABLE VOUCHER(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_VOUCHER NVARCHAR(255) NOT NULL UNIQUE,
    TEN_VOUCHER NVARCHAR(255) NOT NULL,
    GIA_TRI DECIMAL(18,2) NOT NULL,
    KIEU_GIAM NVARCHAR(255) NOT NULL, -- % hoặc số tiền
    NGAY_BAT_DAU DATE NOT NULL,
    NGAY_KET_THUC DATE NOT NULL,
    TRANG_THAI BIT NOT NULL
)
GO

-- ======================= KHUYẾN MÃI =======================

CREATE TABLE KHUYEN_MAI(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_CHUONG_TRINH NVARCHAR(255) NOT NULL UNIQUE,
    TEN_CHUONG_TRINH NVARCHAR(255) NOT NULL,
    PHAN_TRAM_GIAM DECIMAL(5,3),
    NGAY_BAT_DAU DATE NOT NULL,
    NGAY_KET_THUC DATE NOT NULL,
    TRANG_THAI BIT NOT NULL,
    MO_TA NVARCHAR(MAX)
)
GO

CREATE TABLE CHI_TIET_KHUYEN_MAI(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_KHUYEN_MAI INT NOT NULL,
    MA_CHI_TIET_KHUYEN_MAI NVARCHAR(255) NOT NULL,
    SO_TIEN_GIAM DECIMAL(18,3),
    TRANG_THAI BIT NOT NULL,
    FOREIGN KEY (ID_KHUYEN_MAI) REFERENCES KHUYEN_MAI(ID)
)
GO

-- ======================= DANH MỤC SẢN PHẨM =======================

CREATE TABLE XUAT_XU(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_XUAT_XU NVARCHAR(255) NOT NULL UNIQUE,
    TEN_XUAT_XU NVARCHAR(255) NOT NULL,
    TRANG_THAI BIT NOT NULL
)
GO

CREATE TABLE THUONG_HIEU(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_THUONG_HIEU NVARCHAR(255) NOT NULL UNIQUE,
    TEN_THUONG_HIEU NVARCHAR(255) NOT NULL,
    TRANG_THAI BIT NOT NULL
)
GO

CREATE TABLE SAN_PHAM(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_XUAT_XU INT NOT NULL,
    ID_THUONG_HIEU INT NOT NULL,
    MA_SAN_PHAM NVARCHAR(255) NOT NULL UNIQUE,
    TEN_SAN_PHAM NVARCHAR(255) NOT NULL,
    NGAY_TAO DATE NOT NULL,
    TRANG_THAI BIT NOT NULL,
    FOREIGN KEY (ID_XUAT_XU) REFERENCES XUAT_XU(ID),
    FOREIGN KEY (ID_THUONG_HIEU) REFERENCES THUONG_HIEU(ID)
)
GO
-- ======================= SIZE & MÀU =======================

CREATE TABLE SIZE(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_SIZE NVARCHAR(255) NOT NULL UNIQUE,
    TEN_SIZE NVARCHAR(255) NOT NULL,
    TRANG_THAI BIT NOT NULL,
    NGAY_TAO DATE NOT NULL DEFAULT GETDATE()
)
GO 

CREATE TABLE MAU_SAC(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MA_MAU NVARCHAR(255) NOT NULL UNIQUE,
    TEN_MAU NVARCHAR(255) NOT NULL,
    TRANG_THAI BIT NOT NULL,
    NGAY_TAO DATE NOT NULL DEFAULT GETDATE()
)
GO

-- ======================= CHI TIẾT SẢN PHẨM =======================

CREATE TABLE CHI_TIET_SAN_PHAM(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_SAN_PHAM INT NOT NULL,
    ID_SIZE INT NOT NULL,
    ID_MAU_SAC INT NOT NULL,
    ID_CHI_TIET_KHUYEN_MAI INT NULL,
    GIA_BAN DECIMAL(18,2) NOT NULL,
    SO_LUONG_TON INT NOT NULL,
    TRANG_THAI BIT NOT NULL,
    NGAY_TAO DATE NOT NULL DEFAULT GETDATE(),
    THE_LOAI NVARCHAR(255) NULL,
    FOREIGN KEY (ID_SAN_PHAM) REFERENCES SAN_PHAM(ID),
    FOREIGN KEY (ID_SIZE) REFERENCES SIZE(ID),
    FOREIGN KEY (ID_MAU_SAC) REFERENCES MAU_SAC(ID),
    FOREIGN KEY (ID_CHI_TIET_KHUYEN_MAI) REFERENCES CHI_TIET_KHUYEN_MAI(ID)
);
GO


CREATE TABLE HINH_ANH(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_CHI_TIET_SAN_PHAM INT NOT NULL,
    MA_ANH NVARCHAR(255) NOT NULL,
    TEN_ANH NVARCHAR(255) NOT NULL,
    URL NVARCHAR(MAX) NOT NULL,
    TRANG_THAI BIT NOT NULL,
    FOREIGN KEY (ID_CHI_TIET_SAN_PHAM) REFERENCES CHI_TIET_SAN_PHAM(ID)
)
GO

-- ======================= HÓA ĐƠN =======================

CREATE TABLE HOA_DON(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_KHACH_HANG INT NOT NULL,
    ID_NHAN_VIEN INT NOT NULL,
    ID_VOUCHER INT NULL,
    MA_HOA_DON NVARCHAR(255) NULL UNIQUE,
    TEN_KHACH_HANG NVARCHAR(255) NULL,
    DIA_CHI NVARCHAR(255) NULL,
    SO_DIEN_THOAI NVARCHAR(255) NULL,
    NGAY_TAO DATE NOT NULL DEFAULT GETDATE(),
    NGAY_THANH_TOAN DATE NULL,
    TONG_TIEN DECIMAL(18,2) NULL,
    TONG_TIEN_GIAM DECIMAL(18,2) NULL,
    TRANG_THAI BIT NULL,
    FOREIGN KEY(ID_KHACH_HANG) REFERENCES KHACH_HANG(ID),
    FOREIGN KEY(ID_NHAN_VIEN) REFERENCES NHAN_VIEN(ID),
    FOREIGN KEY(ID_VOUCHER) REFERENCES VOUCHER(ID)
)
GO

CREATE TABLE HOA_DON_CHI_TIET(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_HOA_DON INT NOT NULL,
    ID_CHI_TIET_SAN_PHAM INT NOT NULL,
    SO_LUONG_MUA INT NOT NULL,
    GIA_GOC DECIMAL(18,2) NOT NULL,
    GIA_BAN DECIMAL(18,2) NOT NULL,
    TRANG_THAI BIT NOT NULL,
    NGAY_TAO DATE NOT NULL DEFAULT GETDATE(),
    FOREIGN KEY (ID_HOA_DON) REFERENCES HOA_DON(ID),
    FOREIGN KEY(ID_CHI_TIET_SAN_PHAM) REFERENCES CHI_TIET_SAN_PHAM(ID)
)
GO

CREATE TABLE THANH_TOAN(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_HOA_DON INT NOT NULL,
    MA_THANH_TOAN NVARCHAR(255) NOT NULL UNIQUE,
    HINH_THANH_TOAN BIT NOT NULL, -- 0: Tiền mặt | 1: Chuyển khoản
    SO_TIEN_THANH_TOAN DECIMAL(18,2) NOT NULL,
    TRANG_THAI BIT,
    NGAY_THANH_TOAN DATE,
    GHI_CHU NVARCHAR(255),
    FOREIGN KEY(ID_HOA_DON) REFERENCES HOA_DON(ID)
)
GO

----------------------------------------------------
-- 1. CHUC_VU
----------------------------------------------------
INSERT INTO CHUC_VU (MA_CHUC_VU, TEN_CHUC_VU, TRANG_THAI) VALUES
('CV01', N'Quản trị viên', 1),
('CV02', N'Nhân viên bán hàng', 1),
('CV03', N'Nhân viên kho', 1);

----------------------------------------------------
-- 2. NHAN_VIEN
----------------------------------------------------
INSERT INTO NHAN_VIEN (ID_CHUC_VU, MA_NHAN_VIEN, HO_TEN, GIOI_TINH, NGAY_SINH, EMAIL, TAI_KHOAN, MAT_KHAU, LUONG, DIA_CHI, SDT, HINH_ANH, TRANG_THAI)
VALUES
(1, 'NV01', N'Nguyễn Văn A', 1, '1990-05-10', 'admin@example.com', 'admin', '123456', 15000000, N'Hà Nội', '0901111111', NULL, 1),
(2, 'NV02', N'Lê Thị B', 0, '1995-08-20', 'b@example.com', 'nv1', '123456', 8000000, N'Hồ Chí Minh', '0902222222', NULL, 1),
(3, 'NV03', N'Phạm Văn C', 1, '1998-03-15', 'c@example.com', 'nv2', '123456', 7000000, N'Đà Nẵng', '0903333333', NULL, 1);

----------------------------------------------------
-- 3. KHACH_HANG
----------------------------------------------------
INSERT INTO KHACH_HANG (MA_KHACH_HANG, TEN_KHACH_HANG, GIOI_TINH, NGAY_SINH, EMAIL, TAI_KHOAN, MAT_KHAU, SDT, TRANG_THAI)
VALUES
('KH01', N'Trần Quốc D', 1, '2000-01-01', 'd@example.com', 'kh1', '123456', '0911111111', 1),
('KH02', N'Hoàng Thị E', 0, '1999-10-10', 'e@example.com', 'kh2', '123456', '0922222222', 1),
('KH03', N'Vũ Văn F', 1, '1997-07-07', 'f@example.com', 'kh3', '123456', '0933333333', 1);

----------------------------------------------------
-- 4. DIA_CHI
----------------------------------------------------
INSERT INTO DIA_CHI (ID_KHACH_HANG, MA_DIA_CHI, THANH_PHO, QUAN_HUYEN, XA_PHUONG, SO_NHA, TEN_NGUOI_NHAN, SDT_NGUOI_NHAN)
VALUES
(1, 'DC01', N'Hà Nội', N'Nam Từ Liêm', N'Mễ Trì', N'123 Lê Đức Thọ', N'Trần Quốc D', '0911111111'),
(2, 'DC02', N'HCM', N'Quận 3', N'Phường 5', N'45 Nguyễn Thị Minh Khai', N'Hoàng Thị E', '0922222222'),
(3, 'DC03', N'Đà Nẵng', N'Hải Châu', N'Phước Ninh', N'67 Nguyễn Văn Linh', N'Vũ Văn F', '0933333333');

----------------------------------------------------
-- 5. XUAT_XU
----------------------------------------------------
INSERT INTO XUAT_XU (MA_XUAT_XU, TEN_XUAT_XU, TRANG_THAI) VALUES
('XX01', N'Việt Nam', 1),
('XX02', N'Mỹ', 1),
('XX03', N'Trung Quốc', 1);
GO

----------------------------------------------------
-- 6. THUONG_HIEU
----------------------------------------------------
INSERT INTO THUONG_HIEU (MA_THUONG_HIEU, TEN_THUONG_HIEU, TRANG_THAI) VALUES
('TH01', N'Nike', 1),
('TH02', N'Adidas', 1),
('TH03', N'Puma', 1),
('TH04', N'Bata', 1),
('TH05', N'Apex', 1);
GO


INSERT INTO SIZE (MA_SIZE, TEN_SIZE, TRANG_THAI) VALUES
('S38', N'38', 1),
('S39', N'39', 1),
('S40', N'40', 1),
('S41', N'41', 1),
('S42', N'42', 1);
GO

INSERT INTO MAU_SAC (MA_MAU, TEN_MAU, TRANG_THAI) VALUES
('M01', N'Đen', 1),
('M02', N'Trắng', 1),
('M03', N'Đỏ', 1),
('M04', N'Xanh', 1),
('M05', N'Vàng', 1);
GO


----------------------------------------------------
-- 7. SAN_PHAM
----------------------------------------------------
INSERT INTO SAN_PHAM (ID_XUAT_XU, ID_THUONG_HIEU, MA_SAN_PHAM, TEN_SAN_PHAM, NGAY_TAO, TRANG_THAI) VALUES
(1, 1, 'SP01', N'Running Sneaker Shoes', GETDATE(), 1),
(2, 4, 'SP02', N'Leather Mens Slipper', GETDATE(), 1),
(3, 5, 'SP03', N'Simple Fabric Shoe', GETDATE(), 1),
(1, 1, 'SP04', N'Air Jordan 7 Retro', GETDATE(), 1),
(2, 1, 'SP05', N'Nike Air Max 270 SE', GETDATE(), 1),
(3, 2, 'SP06', N'Adidas Sneakers Shoes', GETDATE(), 1),
(1, 1, 'SP07', N'Nike Basketball Shoes', GETDATE(), 1),
(3, 3, 'SP08', N'Simple Fabric Shoe (Puma)', GETDATE(), 1);
GO

----------------------------------------------------
-- 10. CHI_TIET_SAN_PHAM
----------------------------------------------------
INSERT INTO CHI_TIET_SAN_PHAM (ID_SAN_PHAM, ID_SIZE, ID_MAU_SAC, GIA_BAN, SO_LUONG_TON, TRANG_THAI, THE_LOAI)
VALUES
(1, 1, 1, 180.85, 20, 1, N'Nam '),
(2, 2, 2, 190.85, 15, 1, N'Nam '),
(3, 3, 3, 160.85, 25, 1, N'Nam '),
(4, 4, 4, 170.85, 10, 1, N' Thể thao'),
(5, 5, 5, 120.85, 18, 1, N'Nữ'),
(6, 1, 2, 100.85, 22, 1, N'Nữ'),
(7, 2, 3, 120.85, 17, 1, N'Thể thao'),
(8, 3, 1, 100.85, 30, 1, N'Nữ');
GO



----------------------------------------------------
-- 11. HOA_DON
----------------------------------------------------
INSERT INTO HOA_DON (ID_KHACH_HANG, ID_NHAN_VIEN, MA_HOA_DON, TEN_KHACH_HANG, DIA_CHI, SO_DIEN_THOAI, TRANG_THAI)
VALUES
(1, 2, 'HD01', N'Trần Quốc D', N'Hà Nội', '0911111111', 1),
(2, 3, 'HD02', N'Hoàng Thị E', N'HCM', '0922222222', 1);

----------------------------------------------------
-- 12. HOA_DON_CHI_TIET
----------------------------------------------------
INSERT INTO HOA_DON_CHI_TIET (ID_HOA_DON, ID_CHI_TIET_SAN_PHAM, SO_LUONG_MUA, GIA_GOC, GIA_BAN, TRANG_THAI)
VALUES
(1, 1, 1, 2500000, 2500000, 1),
(1, 2, 1, 2500000, 2500000, 1),
(2, 3, 2, 3000000, 3000000, 1);

----------------------------------------------------
-- 13. THANH_TOAN
----------------------------------------------------
INSERT INTO THANH_TOAN (ID_HOA_DON, MA_THANH_TOAN, HINH_THANH_TOAN, SO_TIEN_THANH_TOAN, TRANG_THAI)
VALUES
(1, 'TT01', 1, 5000000, 1),
(2, 'TT02', 0, 6000000, 1);
----------------------------------------------------
-- 14. VOUCHER
----------------------------------------------------
INSERT INTO VOUCHER (MA_VOUCHER, TEN_VOUCHER, GIA_TRI, KIEU_GIAM, NGAY_BAT_DAU, NGAY_KET_THUC, TRANG_THAI)
VALUES
('VC01', N'Giảm 10%', 10, N'%', '2025-01-01', '2025-12-31', 1),
('VC02', N'Giảm 100k', 100000, N'Tiền', '2025-02-01', '2025-12-31', 1),
('VC03', N'Giảm 15%', 15, N'%', '2025-03-01', '2025-12-31', 1),
('VC04', N'Giảm 50k', 50000, N'Tiền', '2025-04-01', '2025-12-31', 1),
('VC05', N'Giảm 20%', 20, N'%', '2025-05-01', '2025-12-31', 1);

----------------------------------------------------
-- 15. KHUYEN_MAI
----------------------------------------------------
INSERT INTO KHUYEN_MAI (MA_CHUONG_TRINH, TEN_CHUONG_TRINH, PHAN_TRAM_GIAM, NGAY_BAT_DAU, NGAY_KET_THUC, TRANG_THAI, MO_TA)
VALUES
('KM01', N'Khuyến mãi Tết', 0.10, '2025-01-15', '2025-02-15', 1, N'Giảm giá toàn bộ sản phẩm trong dịp Tết'),
('KM02', N'Giảm giá Hè', 0.15, '2025-06-01', '2025-07-31', 1, N'Chương trình ưu đãi mùa hè'),
('KM03', N'Back to School', 0.20, '2025-08-01', '2025-09-30', 1, N'Khuyến mãi mùa tựu trường'),
('KM04', N'Giảm sốc 11/11', 0.30, '2025-11-01', '2025-11-11', 1, N'Khuyến mãi lớn ngày hội mua sắm'),
('KM05', N'Noel Sale', 0.25, '2025-12-01', '2025-12-31', 1, N'Ưu đãi mùa Giáng sinh');

----------------------------------------------------
-- 16. CHI_TIET_KHUYEN_MAI
----------------------------------------------------
INSERT INTO CHI_TIET_KHUYEN_MAI (ID_KHUYEN_MAI, MA_CHI_TIET_KHUYEN_MAI, SO_TIEN_GIAM, TRANG_THAI)
VALUES
(1, 'CTKM01', 250000, 1),
(1, 'CTKM02', 150000, 1),
(2, 'CTKM03', 300000, 1),
(3, 'CTKM04', 200000, 1),
(4, 'CTKM05', 500000, 1),
(5, 'CTKM06', 350000, 1);

-- HÌNH ẢNH
INSERT INTO HINH_ANH (ID_CHI_TIET_SAN_PHAM, MA_ANH, TEN_ANH, URL, TRANG_THAI)
VALUES
(1, 'IMG01', N'Running Sneaker Shoes', N'/images/products/product1.jpg', 1),
(2, 'IMG02', N'Leather Mens Slipper', N'/images/products/product2.jpg', 1),
(3, 'IMG03', N'Simple Fabric Shoe', N'/images/products/product3.jpg', 1),
(4, 'IMG04', N'Air Jordan 7 Retro', N'/images/products/product4.jpg', 1),
(5, 'IMG05', N'Nike Air Max 270 SE', N'/images/products/product5.jpg', 1),
(6, 'IMG06', N'Adidas Sneakers Shoes', N'/images/products/product6.jpg', 1),
(7, 'IMG07', N'Nike Basketball Shoes', N'/images/products/product7.jpg', 1),
(8, 'IMG08', N'Simple Fabric Shoe (Puma)', N'/images/products/product8.jpg', 1);
GO


SELECT * FROM CHUC_VU;
SELECT * FROM NHAN_VIEN;
SELECT * FROM KHACH_HANG;
SELECT * FROM DIA_CHI;
SELECT * FROM VOUCHER;
SELECT * FROM KHUYEN_MAI;
SELECT * FROM CHI_TIET_KHUYEN_MAI;
SELECT * FROM HINH_ANH;
SELECT * FROM THUONG_HIEU;
SELECT * FROM SAN_PHAM;
SELECT * FROM SIZE;
SELECT * FROM MAU_SAC;
SELECT * FROM CHI_TIET_SAN_PHAM;
SELECT * FROM HINH_ANH;
SELECT * FROM HOA_DON;
SELECT * FROM HOA_DON_CHI_TIET;
SELECT * FROM THANH_TOAN;
