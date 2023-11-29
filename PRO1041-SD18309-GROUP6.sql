USE master
GO

CREATE DATABASE DU_AN_1
GO

USE DU_AN_1
GO

/*==============================================================*/
/* 1. Table: Chức Vụ                                            */
/*==============================================================*/

IF OBJECT_ID('ChucVu') IS NOT NULL
DROP TABLE ChucVu
GO

CREATE TABLE ChucVu 
(ID_CV INT IDENTITY(1,1) PRIMARY KEY,
TenCV NVARCHAR(50),
MoTa NVARCHAR(250)
)
GO

/*==============================================================*/
/* 2. Table: Lương                                              */
/*==============================================================*/

IF OBJECT_ID('Luong') IS NOT NULL
DROP TABLE Luong
GO

CREATE TABLE Luong
(
ID_Luong INT IDENTITY(1,1) PRIMARY KEY,
ID_NV INT,
MucLuong MONEY,
NgayTra DATE,
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 3. Table: Thưởng                                           */
/*==============================================================*/

IF OBJECT_ID('Thuong') IS NOT NULL
DROP TABLE Thuong
GO

CREATE TABLE Thuong
(
ID_Thuong INT IDENTITY(1,1) PRIMARY KEY,
ID_NV INT,
NgayThuong DATE,
MoTa NVARCHAR(250) 
)
GO


/*==============================================================*/
/* 4. Phiếu Giao Ca                                             */
/*==============================================================*/

IF OBJECT_ID('PhieuGiaoCa') IS NOT NULL
DROP TABLE PhieuGiaoCa
GO
	
CREATE TABLE PhieuGiaoCa(
	ID_PGK INT IDENTITY(1,1) PRIMARY KEY,
	ID_NV INT,
	TenNV NVARCHAR(50),
	TGBD DATETIME,
	TGKT DATETIME,
	TienMatDauCa MONEY,
	TienMatCuoiCa MONEY,
	TienCK MONEY,
	TienGG MONEY,
	TongTien MONEY,
	Note NVARCHAR(250)
)

/*==============================================================*/
/* 5. Phiếu Chấm Công                                           */
/*==============================================================*/

IF OBJECT_ID('PhieuChamCong') IS NOT NULL
DROP TABLE PhieuChamCong
GO

CREATE TABLE PhieuChamCong (
    ID_Phieu INT IDENTITY(1,1) PRIMARY KEY,
    ID_NV INT,
    NgayCham DATE,
    GioVao TIME,
    GioRa TIME,
    GhiChu NVARCHAR(250)
)

/*==============================================================*/
/* 6. Table: Nhân Viên                                          */
/*==============================================================*/

IF OBJECT_ID('NhanVien') IS NOT NULL
DROP TABLE NhanVien
GO

CREATE TABLE NhanVien
(
ID_NV INT IDENTITY(1,1) PRIMARY KEY,
ID_CV INT,
ID_TK INT,
TenNV NVARCHAR(50),
Email NVARCHAR(50),
SoDienThoai VARCHAR(11),
GioiTinh Bit,
NgaySinh DATE,
DiaChi NVARCHAR(250)
)
GO

/*==============================================================*/
/* 7. Table: Tài Khoản                                          */
/*==============================================================*/

IF OBJECT_ID('TaiKhoan') IS NOT NULL
DROP TABLE TaiKhoan
GO

CREATE TABLE TaiKhoan
(
ID_TK INT IDENTITY(1,1) PRIMARY KEY,
TenTK NVARCHAR(50),
MatKhau NVARCHAR(50)
)
GO

/*==============================================================*/
/* 8. Table: Khách Hàng                                         */
/*==============================================================*/

IF OBJECT_ID('KhachHang') IS NOT NULL
DROP TABLE KhachHang
GO

CREATE TABLE KhachHang
(
ID_KH INT IDENTITY(1,1) PRIMARY KEY,
TenKH NVARCHAR(50),
MatKhau NVARCHAR(50),
GioiTinh NVARCHAR(10),
NgaySinh DATE,
DiaChi NVARCHAR(250),
DienThoai VARCHAR(10),
TrangThai NVARCHAR(50)
)
GO

/*==============================================================*/
/* 9. Table: Hóa Đơn                                            */
/*==============================================================*/

IF OBJECT_ID('HoaDon') IS NOT NULL
DROP TABLE HoaDon
GO

CREATE TABLE HoaDon
(
ID_HD INT IDENTITY(1,1) PRIMARY KEY,
ID_KH INT,
ID_NV INT,
ID_TT INT,
ID_VC INT,
ID_GH INT,
ID_CT INT,
ID_GG INT,
ID_DGG INT,
NgayDat DATE,
NgayCan DATE,
NgayGiao DATE,
TenKH NVARCHAR(50),
DiaChi NVARCHAR(250),
PhiVanChuyen MONEY,
TongTien MONEY,
TongTienSauGiam MONEY,
TrangThai NVARCHAR(50),
GhiChu NVARCHAR(250)
)
GO

/*==============================================================*/
/* 10. Table: Chi Tiết Hóa Đơn                                  */
/*==============================================================*/

IF OBJECT_ID('ChiTietHoaDon') IS NOT NULL
DROP TABLE ChiTietHoaDon
GO

CREATE TABLE ChiTietHoaDon
(
ID_CT INT IDENTITY(1,1) PRIMARY KEY,
ID_HD INT,
ID_SP INT,
ID_GG INT,
ID_GH INT,
ID_DGG INT,
TenSP NVARCHAR(50),
DonGia MONEY,
SoLuong INT
)
GO

/*==============================================================*/
/* 11. Table: Màu Sắc                                           */
/*==============================================================*/

IF OBJECT_ID('MauSac') IS NOT NULL
DROP TABLE MauSac
GO

CREATE TABLE MauSac
(
ID_MS INT IDENTITY(1,1) PRIMARY KEY,
TenMS NVARCHAR(50),
Hinh NVARCHAR(50),
TrangThai BIT,
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 12. Table: Thể Loại                                          */
/*==============================================================*/

IF OBJECT_ID('TheLoai') IS NOT NULL
DROP TABLE TheLoai
GO

CREATE TABLE TheLoai
(
ID_TL INT IDENTITY(1,1) PRIMARY KEY,
TenTL NVARCHAR(50),
Hinh NVARCHAR(50),
TrangThai BIT,
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 13. Table: Kích Thước                                        */
/*==============================================================*/

IF OBJECT_ID('KichThuoc') IS NOT NULL
DROP TABLE KichThuoc
GO

CREATE TABLE KichThuoc
(
ID_KT INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenKT NVARCHAR(50),
GiaTriKT NVARCHAR(50),
TrangThai BIT,
MoTa NVARCHAR(250) 
)
GO


/*==============================================================*/
/* 14. Table: Chất Liệu                                          */
/*==============================================================*/

IF OBJECT_ID('ChatLieu') IS NOT NULL
DROP TABLE ChatLieu
GO

CREATE TABLE ChatLieu
(
ID_CL INT IDENTITY(1,1) PRIMARY KEY,
ID_SP INT,
TenCL NVARCHAR(50),
Hinh NVARCHAR(50),
TrangThai BIT,
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 15. Table: Hình Ảnh                                        */
/*==============================================================*/

IF OBJECT_ID('HinhAnh') IS NOT NULL
DROP TABLE HinhAnh
GO

CREATE TABLE HinhAnh
(
ID_HA INT IDENTITY(1,1) PRIMARY KEY,
ID_SP INT,
URL VARCHAR(50),
DinhDang VARCHAR(50),
KichThuoc FLOAT
)
GO

/*==============================================================*/
/* 16. Table: Sản Phẩm                                           */
/*==============================================================*/

IF OBJECT_ID('SanPham') IS NOT NULL
DROP TABLE SanPham
GO

CREATE TABLE SanPham
(
ID_SP INT IDENTITY(1,1) PRIMARY KEY,
ID_NCC INT,
ID_MS INT,
ID_TL INT,
ID_CL INT,
ID_KT INT,
ID_GG INT,
ID_HA INT,
TenSP NVARCHAR(50),
TheLoai NVARCHAR(50),
KichThuoc NVARCHAR(50),
MauSac NVARCHAR(50),
ChatLieu NVARCHAR(50),
SoLuong INT,
DonGia MONEY,
NgaySanXuat DATE,
SoLuongTon INT,
SoLuotXem INT,
TrangThai BIT,
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 17. Table: Logo Công Ty                                      */
/*==============================================================*/

IF OBJECT_ID('LoGo') IS NOT NULL
DROP TABLE LoGo
GO

CREATE TABLE LoGo
(
ID_LG INT IDENTITY(1,1) PRIMARY KEY,
TenLG NVARCHAR(50),
Hinh NVARCHAR(50),
NgayTao DATE,
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 18. Table: Chi Tiết Người Liên Lạc                           */
/*==============================================================*/

IF OBJECT_ID('NguoiLienLac') IS NOT NULL
DROP TABLE NguoiLienLac
GO

CREATE TABLE NguoiLienLac
(
ID_NLL INT IDENTITY(1,1) PRIMARY KEY,
TenNLL NVARCHAR(50),
DienThoai CHAR(10),
ChucVu NVARCHAR(50),
Email NVARCHAR(50),
GhiChu NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 19. Table: Nhà Cung Cấp                                      */
/*==============================================================*/

IF OBJECT_ID('NhaCungCap') IS NOT NULL
DROP TABLE NhaCungCap
GO

CREATE TABLE NhaCungCap
(
ID_NCC INT IDENTITY(1,1) PRIMARY KEY,
ID_LG INT,
ID_NLL INT,
ID_SP INT,
TenCT NVARCHAR(50),
MaLG INT,
MaNLL INT,
Email NVARCHAR(50),
DienThoai CHAR(10),
DiaChi NVARCHAR(50),
MoTa NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 20. Table: Địa Chỉ                                           */
/*==============================================================*/

IF OBJECT_ID('DiaChi') IS NOT NULL
DROP TABLE DiaChi
GO

CREATE TABLE DiaChi
(
ID_DC INT IDENTITY(1,1) PRIMARY KEY,
TenDC NVARCHAR(50),
TenNguoiNhan NVARCHAR(50),
DienThoai CHAR(10),
NoiNhan NVARCHAR(50),
GhiChu NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 21. Table: Phiếu Giao Hàng                                   */
/*==============================================================*/

IF OBJECT_ID('PhieuGiaoHang') IS NOT NULL
DROP TABLE PhieuGiaoHang
GO

CREATE TABLE PhieuGiaoHang
(
ID_GH INT IDENTITY(1,1) PRIMARY KEY,
ID_SP INT,
ID_KH INT,
ID_NV INT,
ID_HD INT,
NgayGiao DATE,
SoDienThoai VARCHAR(10),
TenNV NVARCHAR(50),
PhiVC MONEY,
DiaChi NVARCHAR(250),
ID_DC INT,
TrangThaiGH BIT,
TrangThaiTT BIT,
GhiChu NVARCHAR(250) 
)
GO

/*==============================================================*/
/* 22. Table: Phiếu Giảm Giá                                    */
/*==============================================================*/

IF OBJECT_ID('PhieuGiamGia') IS NOT NULL
DROP TABLE PhieuGiamGia
GO

CREATE TABLE PhieuGiamGia(
	ID_GG INT IDENTITY(1,1) PRIMARY KEY,
    ID_KH INT,
    ID_SP INT,
	ID_TSP INT,
	ID_TKH INT,
    NgayBatDau DATE,
    NgayHH DATE,
    GiaTriGG NVARCHAR(50),
    TrangThai BIT,
    NgayTao DATE,
    NgaySuDung DATE,
    MoTa NVARCHAR(250),
)
GO

/*==============================================================*/
/* 23. Table: Giảm Giá Theo Sản Phẩm                            */
/*==============================================================*/

IF OBJECT_ID('GiamGiaTheoSP') IS NOT NULL
DROP TABLE GiamGiaTheoSP
GO

CREATE TABLE GiamGiaTheoSP(
ID_TSP INT IDENTITY(1,1)  PRIMARY KEY,
ID_SP INT,
GiaTriGG NVARCHAR(50),
Hinhthuc NVARCHAR(50),
DieuKienGG NVARCHAR(50),
MoTa NVARCHAR(250)
)
GO

/*==============================================================*/
/* 24. Table: Giảm Giá Theo Khách Hàng                          */
/*==============================================================*/

IF OBJECT_ID('GiamGiaTheoKH') IS NOT NULL
DROP TABLE GiamGiaTheoKH
GO


CREATE TABLE GiamGiaTheoKH(
ID_TKH INT IDENTITY(1,1)  PRIMARY KEY,
ID_KH INT,
VaiTro BIT,
GiaTriGG NVARCHAR(50),
Hinhthuc NVARCHAR(50),
DieuKienGG NVARCHAR(50),
MoTa NVARCHAR(250)
)
GO

/*==============================================================*/
/* 25. Table: Đợt Giảm Giá                                      */
/*==============================================================*/

IF OBJECT_ID('DotGiamGia') IS NOT NULL
DROP TABLE DotGiamGia
GO
CREATE TABLE DotGiamGia(
   ID_DGG INT IDENTITY(1,1) PRIMARY KEY,
   ID_TKH INT,
   ID_TSP INT,
   TeNDGG NVARCHAR(500),
   NgayBatDau DATE,
   NgayKetThuc DATE,
   LoaiGiamGia NVARCHAR(50),
   GiaTriGG NVARCHAR(250),
   DieuKienGiamGia NVARCHAR(50),
   MoTa NVARCHAR(250),
)

/*==============================================================*/
/* 26. Table: Phương Thức Vận Chuyển                            */
/*==============================================================*/

IF OBJECT_ID('PhuongThucVanChuyen') IS NOT NULL
DROP TABLE PhuongThucVanChuyen
GO

CREATE TABLE PhuongThucVanChuyen(
	ID_VC INT IDENTITY(1,1) PRIMARY KEY,
	HinhThucVC NVARCHAR(50),
	MoTa NVARCHAR(250),
)

/*==============================================================*/
/* 27. Table: Phương Thức Thanh Toán                            */
/*==============================================================*/

IF OBJECT_ID('PhuongThucThanhToan') IS NOT NULL
DROP TABLE PhuongThucThanhToan
GO

CREATE TABLE PhuongThucThanhToan(
	ID_TT INT IDENTITY(1,1) PRIMARY KEY,
	HinhThucTT NVARCHAR(50),
	TrangThaiTT NVARCHAR(50),
	MoTa NVARCHAR(250),
)
GO

/*==============================================================*/
/* 28. Table: Đánh Giá                                          */
/*==============================================================*/

IF OBJECT_ID('DanhGia') IS NOT NULL
DROP TABLE DanhGia
GO

CREATE TABLE DanhGia(
ID_DG INT IDENTITY(1,1) PRIMARY KEY,
ID_KH INT,
MoTa NVARCHAR(250),
TrangThai BIT
)

/*==============================================================*/
/* 29. Table: Tin Nhắn                                          */
/*==============================================================*/
IF OBJECT_ID('TinNhan') IS NOT NULL
DROP TABLE TinNhan
GO

CREATE TABLE TinNhan(
ID_TinNhan INT IDENTITY(1,1) PRIMARY KEY,
ID_NV INT,
ID_KH INT,
NoiDungChat NVARCHAR(250),
TrangThai BIT,
LichSu DATETIME
)

/*==============================================================*/
/* 30. Table: Dợt Giảm Giá Theo Sản Phẩm                        */
/*==============================================================*/
IF OBJECT_ID('DotGiamGiaTheoSP') IS NOT NULL
DROP TABLE DotGiamGiaTheoSP
GO
CREATE TABLE DotGiamGiaTheoSP(
   ID_TSP INT IDENTITY(1,1) PRIMARY KEY,
   ID_DGG INT,
   ID_SP INT,
   TenSP NVARCHAR(50),
   GiaTriGG NVARCHAR(250),
   DieuKienGiamGia NVARCHAR(50),
   MoTa NVARCHAR(250)
)
GO

/*==============================================================*/
/* 31. Table: Dợt Giảm Giá Theo Khách Hàng                      */
/*==============================================================*/
IF OBJECT_ID('DotGiamGiaTheoKH') IS NOT NULL
DROP TABLE DotGiamGiaTheoKH
GO
CREATE TABLE DotGiamGiaTheoKH(
   ID_TKH INT IDENTITY(1,1) PRIMARY KEY,
   ID_DGG INT,
   ID_KH INT,
   TenKH NVARCHAR(50),
   GiaTriGG NVARCHAR(250),
   DieuKienGiamGia NVARCHAR(50),
   MoTa NVARCHAR(250)
)
GO

--THÊM DỮ LIỆU

-- Chức Vụ
INSERT INTO ChucVu (TenCV, MoTa)
VALUES 
  (N'Quản lý', N'Quản lý nhân sự'),
  (N'Nhân viên', N'Nhân viên bán hàng');

SELECT * FROM ChucVu

-- Lương
INSERT INTO Luong (ID_NV, MucLuong, NgayTra, MoTa)
VALUES 
  (1, 5000000, '2023-11-30', N'Lương tháng 11/2023'),
  (2, 4500000, '2023-11-30', N'Lương tháng 11/2023'),
  (3, 6000000, '2023-11-30', N'Lương tháng 11/2023'),
  (4, 4000000, '2023-11-30', N'Lương tháng 11/2023'),
  (5, 3500000, '2023-11-30', N'Lương tháng 11/2023');

SELECT * FROM Luong

-- Thưởng
INSERT INTO Thuong (ID_NV, NgayThuong, MoTa)
VALUES 
  (1, '2023-11-15', N'Thưởng tháng 11/2023'),
  (2, '2023-11-15', N'Thưởng tháng 11/2023'),
  (3, '2023-11-15', N'Thưởng tháng 11/2023'),
  (4, '2023-11-15', N'Thưởng tháng 11/2023'),
  (5, '2023-11-15', N'Thưởng tháng 11/2023');

SELECT * FROM Thuong

-- Phiếu Giao Ca
INSERT INTO PhieuGiaoCa (ID_NV, TenNV, TGBD, TGKT, TienMatDauCa, TienMatCuoiCa, TienCK, TienGG, TongTien, Note)
VALUES
(1, N'Nguyễn Văn A', '2023-11-18 08:00:00', '2023-11-18 17:00:00', 500000, 600000, 20000, 10000, 590000, N'Giao hàng tới cửa hàng ABC'),
(2, N'Trần Thị B', '2023-11-18 09:30:00', '2023-11-18 18:30:00', 600000, 700000, 25000, 12000, 680000, N'Giao hàng tới cửa hàng XYZ'),
(3, N'Lê Văn C', '2023-11-18 10:15:00', '2023-11-18 19:45:00', 550000, 650000, 18000, 9000, 630000, N'Giao hàng tới cửa hàng LMN'),
(4, N'Phạm Thị D', '2023-11-18 08:45:00', '2023-11-18 17:45:00', 520000, 610000, 22000, 11000, 600000, N'Giao hàng tới cửa hàng PQR'),
(5, N'Hoàng Văn E', '2023-11-18 09:00:00', '2023-11-18 18:00:00', 480000, 580000, 19000, 9500, 560500, N'Giao hàng tới cửa hàng UVW');

SELECT * FROM PhieuGiaoCa

-- Phiếu Chấm Công
INSERT INTO PhieuChamCong (ID_NV, NgayCham, GioVao, GioRa, GhiChu)
VALUES
(1, '2023-11-18', '08:00:00', '17:00:00', N'Giờ làm bình thường'),
(2, '2023-11-18', '09:30:00', '18:30:00', N'Giờ làm thêm'),
(3, '2023-11-18', '10:15:00', '19:45:00', N'Làm thêm cho dự án'),
(4, '2023-11-18', '08:45:00', '17:45:00', N'Nghỉ buổi sáng'),
(5, '2023-11-18', '09:00:00', '18:00:00', N'Thuộc đợt đào tạo');

SELECT * FROM PhieuChamCong

-- Nhân Viên
INSERT INTO NhanVien (ID_CV, ID_TK, TenNV, Email, SoDienThoai, GioiTinh, NgaySinh, DiaChi)
VALUES
(1, 1, N'Nguyễn Văn A', 'a@example.com', '234567890', 1, '1990-01-15', N'123 Đường ABC'),
(2, 2, N'Trần Thị B', 'b@example.com', '87654322', 0, '1995-05-20', N'456 Đường XYZ'),
(2, 3, N'Lê Văn C', 'c@example.com', '2345675754', 1, '1988-09-08', N'789 Đường LMN'),
(2, 4, N'Phạm Thị D', 'd@example.com', '23456234', 0, '1992-03-25', N'456 Đường PQR'),
(2, 5, N'Hoàng Văn E', 'e@example.com', '243567788', 1, '1993-12-12', N'789 Đường UVW');

SELECT * FROM NhanVien 
	join TaiKhoan on TaiKhoan.ID_TK = NhanVien.ID_TK
	join ChucVu on ChucVu.ID_CV = NhanVien.ID_CV

-- Tài Khoản
INSERT INTO TaiKhoan (TenTK, MatKhau)
VALUES
('a_account', 'a_password'),
('b_account', 'b_securepass'),
('c_account', 'c_pass123'),
('d_account', 'd_securepass'),
('e_account', 'e_pass456');

SELECT * FROM TaiKhoan

-- Khách Hàng
INSERT INTO KhachHang (TenKH, MatKhau, GioiTinh, NgaySinh, DiaChi, DienThoai,TrangThai)
VALUES
(N'Khách hàng 1', 'khachhang1pass', N'Nam', '1988-03-10', N'789 Đường Khách Hàng', '1234567890',N'Lâu năm'),
(N'Khách hàng 2', 'khachhang2pass', N'Nữ', '1992-07-25', N'456 Đường Người Dùng', '9876543210',N'Khách hàng mới'),
(N'Khách hàng 3', 'khachhang3pass', N'Nam', '1985-11-18', N'123 Đường Thành Viên', '5556667777',N'Lâu năm'),
(N'Khách hàng 4', 'khachhang4pass', N'Khác', '1990-05-08', N'789 Đường Premium', '9998887777',N'Khách hàng mới'),
(N'Khách hàng 5', 'khachhang5pass', N'Nam', '1993-09-30', N'456 Đường Gold', '3332221111', N'Khách hàng mới');

SELECT * FROM KhachHang

-- Hóa Đơn
INSERT INTO HoaDon (ID_KH, ID_NV, ID_TT, ID_VC, ID_GH, ID_CT, ID_GG, ID_DGG, NgayDat, NgayCan, NgayGiao, TenKH, DiaChi, PhiVanChuyen, TongTien, TongTienSauGiam, TrangThai, GhiChu)
VALUES
(1, 1, 1, 1, 1, 1, 1, 1, '2023-11-18', '2023-11-20', '2023-11-21', N'Khách hàng 1', N'789 Đường Khách Hàng', 30000, 500000, 480000, N'Chờ thanh toán', N'Đang đợi thanh toán'),
(2, 2, 2, 2, 2, 2, 2, 2, '2023-11-18', '2023-11-20', '2023-11-22', N'Khách hàng 2', N'456 Đường Người Dùng', 25000, 600000, 575000, N'Đã giao hàng', N'Đang trên đường giao'),
(3, 3, 3, 3, 3, 3, 3, 3, '2023-11-18', '2023-11-20', '2023-11-23', N'Khách hàng 3', N'123 Đường Thành Viên', 35000, 700000, 670000, N'Đã giao hàng', N'Đã nhận hàng với sự hài lòng'),
(4, 4, 1, 2, 4, 4, 4, 4, '2023-11-18', '2023-11-20', '2023-11-24', N'Khách hàng 4', N'789 Đường Premium', 40000, 800000, 760000, N'Đã giao hàng', N'Khách hàng yêu cầu giao hàng nhanh chóng'),
(5, 5, 2, 1, 5, 5, 5, 5, '2023-11-18', '2023-11-20', '2023-11-25', N'Khách hàng 5', N'456 Đường Gold', 30000, 550000, 520000, N'Chờ thanh toán', N'Đang xử lý thanh toán');

SELECT * FROM HoaDon

-- Chi Tiết Hóa Đơn
INSERT INTO ChiTietHoaDon (ID_HD, ID_SP, ID_GG, ID_GH, ID_DGG, TenSP, DonGia, SoLuong)
VALUES
(1, 1, 1, 1, 1, N'Áo phông nam trắng', 150000, 2),
(2, 2, 2, 2, 2, N'Áo phông nữ đen', 300000, 1),
(3, 3, 3, 3, 3, N'Áo phông unisex xanh', 200000, 1),
(4, 4, 1, 2, 4, N'Áo phông nam đỏ', 400000, 1),
(5, 5, 2, 1, 5, N'Áo phông nữ vàng', 100000, 3);

SELECT * FROM ChiTietHoaDon

---MÀU SẮC
INSERT INTO MauSac (TenMS, Hinh, TrangThai, MoTa) VALUES
(N'Đen', 'den.jpg', 1, N'Màu đen cho áo phông'),
(N'Trắng', 'trang.jpg', 1, N'Màu trắng cho áo phông'),
(N'Xanh dương', 'xanh_duong.jpg', 1, N'Màu xanh dương cho áo phông'),
(N'Đỏ', 'do.jpg', 1, N'Màu đỏ cho áo phông'),
(N'Xám', 'xam.jpg', 1, N'Màu xám cho áo phông');

SELECT * FROM MauSac

---KÍCH THƯỚC
INSERT INTO KichThuoc (TenKT, GiaTriKT, TrangThai, MoTa) VALUES
('S', 'Small', 55, N'Kích thước nhỏ cho áo phông'),
('M', 'Medium', 60, N'Kích thước trung bình cho áo phông'),
('L', 'Large', 66, N'Kích thước lớn cho áo phông'),
('XL', 'Extra Large', 70, N'Kích thước cực lớn cho áo phông'),
('XXL', 'Double Extra Large', 67, N'Kích thước rất lớn cho áo phông');

SELECT * FROM KichThuoc

---THỂ LOẠI
INSERT INTO TheLoai (TenTL, Hinh, TrangThai, MoTa) VALUES 
(N'Áo phông nam', 'ao_phong_nam.jpg', 1, N'Các loại áo phông dành cho nam giới'),
(N'Áo phông nữ', 'ao_phong_nu.jpg', 1, N'Các loại áo phông dành cho nữ giới'),
(N'Áo phông trẻ em', 'ao_phong_tre_em.jpg', 1, N'Các loại áo phông dành cho trẻ em'),
(N'Áo phông Unisex', 'ao_phong_unisex.jpg', 1, N'Các loại áo phông có thể dùng cho cả nam và nữ giới'),
(N'Áo phông thể thao', 'ao_phong_the_thao.jpg', 1, N'Các loại áo phông thích hợp cho hoạt động thể thao');

SELECT * FROM TheLoai

---CHẤT LIỆU

INSERT INTO ChatLieu (ID_SP, TenCL, Hinh, TrangThai, MoTa) VALUES 
(1, N'Cotton', 'cotton.jpg', 1, N'Chất liệu cotton thông thường'),
(2, N'Len', 'len.jpg', 1, N'Chất liệu len dày dặn và ấm áp'),
(3, N'Polyester', 'polyester.jpg', 1, N'Chất liệu polyester bền và chống nhăn'),
(4, N'Satin', 'satin.jpg', 1, N'Chất liệu satin mềm mại và lịch lãm'),
(5, N'Kaki', 'kaki.jpg', 1, N'Chất liệu kaki bền và thoải mái');

SELECT * FROM ChatLieu

--- HÌNH ẢNH
INSERT INTO HinhAnh VALUES
(1, 'https://example.com/hinh1.jpg', 'jpg', 102.4),
(2, 'https://example.com/hinh2.png','png', 51.2),
(3, 'https://example.com/hinh3.jpg','jpg', 72.0),
(4, 'https://example.com/hinh4.png','png', 96.0),
(5, 'https://example.com/hinh5.jpg','jpg', 48.0);

SELECT * FROM HinhAnh

---SẢN PHẨM
INSERT INTO SanPham (ID_NCC, ID_MS, ID_TL, ID_CL, ID_KT, ID_GG, ID_HA, TenSP, TheLoai, KichThuoc, MauSac, ChatLieu, SoLuong, DonGia, NgaySanXuat, SoLuongTon, SoLuotXem, TrangThai, MoTa) VALUES
(1, 1, 1, 1, 1, 1, 1, N'Áo phông nam màu đen', N'Áo phông nam', 'S', N'Đen',  N'Cotton', 50, 200000, '2023-01-01', 1, 100, 1, N'Áo phông nam màu đen thông thoáng và thoải mái'),
(2, 2, 2, 2, 2, 1, 2, N'Áo phông nam màu trắng', N'Áo phông nữ', 'M', N'Trắng',  N'Len', 45, 180000, '2023-01-02', 1, 190, 1, N'Áo phông nam màu trắng đơn giản và thời trang'),
(3, 2, 3, 3, 3, 2, 3, N'Áo phông nam màu xanh dương', N'Áo phông trẻ em', 'L', N'Trắng',  N'Polyester', 35, 300000, '2023-01-03', 1, 109, 1, N'Áo phông nam màu xanh dương năng động và trẻ trung'),
(4, 4, 4, 4, 2, 2, 4, N'Áo phông nam màu đỏ', N'Áo phông Unisex', 'M', N'Đỏ',  N'Satin', 15, 10000, '2023-01-04', 5, 10, 1, N'Áo phông nam màu đỏ cá tính và phong cách'),
(5, 2, 5, 5, 2, 3, 5, N'Áo phông nữ màu trắng', N'Áo phông thể thao', 'M', N'Trắng',  N'Kaki', 50, 200000, '2023-01-05', 1, 100, 1, N'Áo phông nữ màu xám nhẹ nhàng và duyên dáng');

SELECT sp.ID_SP, sp.TenSP, tl.TenTL, kt.TenKT, ms.TenMS, cl.TenCL, sp.DonGia, sp.SoLuongTon, sp.TrangThai FROM SanPham sp
LEFT JOIN MauSac ms ON ms.ID_MS = sp.ID_MS
LEFT JOIN TheLoai tl ON tl.ID_TL = sp.ID_TL
LEFT JOIN ChatLieu cl ON cl.ID_CL = sp.ID_CL
LEFT JOIN KichThuoc kt ON kt.ID_KT = sp.ID_KT
LEFT JOIN HinhAnh ha ON ha.ID_HA = sp.ID_HA

SELECT sp.ID_SP, sp.TenSP, sp.TheLoai, sp.KichThuoc, sp.MauSac, sp.ChatLieu, sp.DonGia, sp.SoLuongTon, sp.TrangThai FROM SanPham sp
LEFT JOIN MauSac ms ON ms.ID_MS = sp.ID_MS
LEFT JOIN TheLoai tl ON tl.ID_TL = sp.ID_TL
LEFT JOIN ChatLieu cl ON cl.ID_CL = sp.ID_CL
LEFT JOIN KichThuoc kt ON kt.ID_KT = sp.ID_KT
LEFT JOIN HinhAnh ha ON ha.ID_HA = sp.ID_HA
					

SELECT * FROM TheLoai
SELECT * FROM SanPham
SELECT * FROM KichThuoc
SELECT * FROM ChatLieu
SELECT * FROM MauSac

-- LoGo
INSERT INTO LoGo (TenLG, Hinh, NgayTao, MoTa)
VALUES
('A-Style Logo', 'a_style_logo.jpg', '2023-11-18', 'A-Style: Chất lượng và Phá Cách.'),
('Chic Trends', 'chic_trends_logo.png', '2023-11-18', 'Chic Trends: Đi theo xu hướng thời trang.'),
('Unique Styles', 'unique_styles_logo.jpg', '2023-11-18', 'Unique Styles: Phong cách độc đáo và sáng tạo.'),
('Cool Vibe', 'cool_vibe_logo.png', '2023-11-18', 'Cool Vibe: Phong cách năng động và mới lạ.'),
('Dynamic Fashion', 'dynamic_fashion_logo.jpg', '2023-11-18', 'Dynamic Fashion: Năng động và thời trang.');

SELECT * FROM LoGo

-- Người Liên Lạc
INSERT INTO NguoiLienLac (TenNLL, DienThoai, ChucVu, Email, GhiChu)
VALUES
('Anna Nguyen', '1234567890', 'Sales Specialist', 'anna_nguyen@example.com', 'Đội trưởng Kinh Doanh.'),
('Bryan Tran', '9876543210', 'Chief Accountant', 'bryan_tran@example.com', 'Chuyên viên Kế Toán.'),
('Catherine Cuong', '5556667777', 'HR Manager', 'catherine_cuong@example.com', 'Quản lý Nhân Sự.'),
('Daniel Lan', '9998887777', 'IT Consultant', 'daniel_lan@example.com', 'Chuyên viên Tư Vấn IT.'),
('Eva Chau', '3332221111', 'Marketing Expert', 'eva_chau@example.com', 'Chuyên Gia Marketing.');

SELECT * FROM NguoiLienLac

-- Nhà Cung Cấp
INSERT INTO NhaCungCap (ID_LG, ID_NLL, ID_SP, TenCT, MaLG, MaNLL, Email, DienThoai, DiaChi, MoTa)
VALUES
(1, 1, 1, N'Công ty Sản Xuất Áo Nam NamNam', 101, 201, 'namnam@example.com', '1234567890', N'123 Đường ABC, Quận 1, TP.HCM', N'Cung cấp áo nam phong cách'),
(2, 2, 2, N'Công ty Thời Trang Bờ Vai Xinh', 102, 202, 'bovaixinh@example.com', '9876543210', N'456 Đường XYZ, Quận 2, TP.HCM', N'Cung cấp áo phông thời trang và nổi bật'),
(3, 3, 3, N'Công ty Áo Phông CoolStyle', 103, 203, 'coolstyle@example.com', '5556667777', N'789 Đường LMN, Quận 3, TP.HCM', N'Cung cấp áo phông với phong cách cool'),
(4, 4, 4, N'Công ty Duy Fashion Trend', 104, 204, 'duyfashiontrend@example.com', '9998887777', N'Đường 4, Quận Gò Vấp, TP.HCM', N'Cung cấp áo phông nam nữ theo xu hướng'),
(5, 5, 5, N'Công ty Áo Thể Thao Energetic', 105, 205, 'energetic@example.com', '3332221111', N'Đường 5, Quận 1, TP.HCM', N'Cung cấp áo thể thao năng động cho giới trẻ');

SELECT * FROM NhaCungCap

-- Địa Chỉ
INSERT INTO DiaChi (TenDC, TenNguoiNhan, DienThoai, NoiNhan, GhiChu)
VALUES
(N'123 Đường ABC, Quận 1, TP.HCM', N'Nguyễn Văn Nam', '1234567890', N'Quận 1, TP.HCM', N'Địa chỉ giao hàng mặc định cho khách hàng Nam'),
(N'456 Đường XYZ, Quận 2, TP.HCM', N'Trần Thị Bình', '9876543210', N'Quận 2, TP.HCM', N'Địa chỉ giao hàng mặc định cho khách hàng Bình'),
(N'789 Đường LMN, Quận 3, TP.HCM', N'Phạm Văn Cường', '5556667777', N'Quận 3, TP.HCM', N'Địa chỉ giao hàng mặc định cho khách hàng Cường'),
(N'Đường 4, Quận Gò Vấp, TP.HCM', N'Nguyễn Thị Duyên', '9998887777', N'Quận Gò Vấp, TP.HCM', N'Địa chỉ giao hàng mặc định cho khách hàng Duyên'),
(N'Đường 5, Quận 1, TP.HCM', N'Lê Văn Eros', '3332221111', N'Quận 1, TP.HCM', N'Địa chỉ giao hàng mặc định cho khách hàng Eros');

SELECT * FROM DiaChi

-- Phiếu Giao Hàng
INSERT INTO PhieuGiaoHang (ID_SP, ID_KH, ID_NV, ID_HD, NgayGiao, ID_DC, TrangThaiGH, TrangThaiTT, GhiChu)
VALUES
(1, 1, 1, 1, '2023-11-20', 1, 0, 0, N'Giao hàng cho đơn hàng #1'),
(2, 2, 2, 2, '2023-11-21', 2, 0, 0, N'Giao hàng cho đơn hàng #2'),
(3, 3, 3, 3, '2023-11-22', 3, 0, 0, N'Giao hàng cho đơn hàng #3'),
(4, 4, 4, 4, '2023-11-23', 4, 0, 0, N'Giao hàng cho đơn hàng #4'),
(5, 5, 5, 5, '2023-11-24', 5, 0, 0, N'Giao hàng cho đơn hàng #5');

SELECT * FROM PhieuGiaoHang

-- Phiếu Giảm Giá
INSERT INTO PhieuGiamGia (ID_KH, ID_SP, ID_TSP, ID_TKH, NgayBatDau, NgayHH, GiaTriGG, TrangThai, NgayTao, NgaySuDung, MoTa)
VALUES
(1, 1, 1, 3, '2023-11-20', '2023-12-31', '10%', 1, '2023-11-15', NULL, N'Phiếu giảm giá cho khách hàng Nam'),
(2, 2, 2, 1, '2023-11-21', '2023-01-12', '15%', 0, '2023-01-18', NULL, N'Phiếu giảm giá cho khách hàng Bình'),
(3, 3, 3, 2, '2023-11-22', '2023-02-05', '20%', 0, '2023-11-17', NULL, N'Phiếu giảm giá cho khách hàng Cường'),
(4, 4, 4, 5, '2023-11-23', '2023-07-25', '25%', 1, '2023-07-28', NULL, N'Phiếu giảm giá cho khách hàng Duyên'),
(5, 5, 5, 4, '2023-11-24', '2023-08-22', '30%', 1, '2023-08-26', NULL, N'Phiếu giảm giá cho khách hàng Eros');


SELECT * FROM PhieuGiamGia

-- Phiếu Giảm Giá Theo SP
INSERT INTO GiamGiaTheoSP (ID_SP, GiaTriGG,Hinhthuc, DieuKienGG, MoTa)
VALUES
(1, '10%', N'Áp dụng cho tất cả sản phẩm',N'Giảm theo(%)', N'Giảm giá 10% cho tất cả sản phẩm áo phông'),
(2, '15%', N'Áp dụng cho sản phẩm mới',N'Giảm theo số tiền' ,N'Giảm giá 15% cho sản phẩm áo phông mới'),
(3, '20%', N'Áp dụng cho hóa đơn từ 1 triệu đồng',N'Giảm theo(%)' ,N'Giảm giá 20% cho hóa đơn từ 1 triệu đồng'),
(4, '25%', N'Áp dụng cho sản phẩm nam',N'Giảm theo số tiền' ,N'Giảm giá 25% cho sản phẩm áo phông nam'),
(5, '30%', N'Áp dụng cho khách hàng VIP', N'Giảm theo(%)',N'Giảm giá 30% cho khách hàng VIP');

SELECT * FROM GiamGiaTheoSP

-- Phiếu Giảm Giá Theo Khách Hàng
INSERT INTO GiamGiaTheoKH (ID_KH, VaiTro, GiaTriGG, Hinhthuc,DieuKienGG, MoTa)
VALUES
(1, 1, '5%', N'Áp dụng cho khách hàng thân thiết',N'Giảm theo(%)', N'Giảm giá 5% cho khách hàng thân thiết'),
(2, 0, '7%', N'Áp dụng cho tất cả khách hàng',N'Giảm theo số tiền' , N'Giảm giá 7% cho tất cả khách hàng'),
(3, 1, '10%', N'Áp dụng cho khách hàng đặc biệt', N'Giảm theo(%)', N'Giảm giá 10% cho khách hàng đặc biệt'),
(4, 0, '8%', N'Áp dụng cho tất cả khách hàng',N'Giảm theo số tiền' ,N'Giảm giá 8% cho tất cả khách hàng'),
(5, 1, '12%', N'Áp dụng cho khách hàng VIP', N'Giảm theo(%)', N'Giảm giá 12% cho khách hàng VIP');
select *from PhieuGiamGia join GiamGiaTheoSP on PhieuGiamGia.ID_SP = GiamGiaTheoSP.ID_SP 
            join DotGiamGia on PhieuGiamGia.ID_TSP = DotGiamGia. ID_TSP
SELECT * FROM GiamGiaTheoKH

-- Phương Thức Vận Chuyển
INSERT INTO PhuongThucVanChuyen (HinhThucVC, MoTa)
VALUES
(N'Giao hàng nhanh', N'Giao hàng trong vòng 24 giờ'),
(N'Giao hàng tiết kiệm', N'Giao hàng trong vòng 3-5 ngày'),
(N'Giao hàng thông thường', N'Giao hàng trong vòng 7 ngày'),
(N'Giao hàng quốc tế', N'Giao hàng quốc tế trong vòng 14 ngày'),
(N'Giao hàng siêu tốc', N'Giao hàng trong vòng 12 giờ');

SELECT * FROM PhuongThucVanChuyen

-- Phương Thức Thanh Toán
INSERT INTO PhuongThucThanhToan (HinhThucTT, TrangThaiTT, MoTa)
VALUES
(N'Thanh toán khi nhận hàng', N'Đã thanh toán', N'Thanh toán khi nhận hàng và đã thanh toán'),
(N'Thanh toán trực tuyến', N'Chưa thanh toán', N'Thanh toán trực tuyến và chưa thanh toán'),
(N'Thanh toán qua ví điện tử', N'Đã thanh toán', N'Thanh toán qua ví điện tử và đã thanh toán'),
(N'Thanh toán qua thẻ tín dụng', N'Chưa thanh toán', N'Thanh toán qua thẻ tín dụng và chưa thanh toán'),
(N'Thanh toán sau', N'Chưa thanh toán', N'Thanh toán sau khi nhận hàng');

SELECT * FROM PhuongThucThanhToan

-- Đánh Giá
INSERT INTO DanhGia (ID_KH, MoTa, TrangThai)
VALUES
(1, N'Sản phẩm rất tốt, hài lòng với chất lượng', 1),
(2, N'Giao hàng nhanh chóng, sản phẩm đúng mô tả', 1),
(3, N'Sản phẩm đẹp, giá cả hợp lý', 1),
(4, N'Nhân viên phục vụ nhiệt tình, giao hàng đúng hẹn', 1),
(5, N'Sản phẩm chất lượng, đóng gói cẩn thận', 1);

SELECT * FROM DanhGia

-- Tin Nhắn
INSERT INTO TinNhan (ID_NV, ID_KH, NoiDungChat, TrangThai, LichSu)
VALUES
(1, 1, N'Chào anh Nam, có gì em giúp được không?', 1, '2023-11-18 10:30:00'),
(2, 2, N'Xin chào Bình, có cần tư vấn thêm không?', 1, '2023-11-18 11:15:00'),
(3, 3, N'Chào anh Cường, sản phẩm mới đã về, anh quan tâm không ạ?', 1, '2023-11-18 12:00:00'),
(4, 4, N'Xin chào chị Duyên, có sản phẩm mới chị quan tâm không?', 1, '2023-11-18 14:30:00'),
(5, 5, N'Chào Eros, đã nhận được đơn hàng của anh, cảm ơn anh đã mua sắm!', 1, '2023-11-18 15:45:00');

SELECT * FROM TinNhan

-- Đợt Giảm giá theo Sản phẩm
INSERT INTO DotGiamGiaTheoSP (ID_DGG, ID_SP,TenSP, GiaTriGG, DieuKienGiamGia, MoTa)
VALUES
(1, 1,N'Áo phông nam', N'10%', N'Mua 2 áo phông trở lên', N'Ưu đãi mua số lượng'),
(5, 2,N'Aó phông nữ', N'5%', N'Mua 3 áo phông trở lên', N'Ưu đãi mua số lượng'),
(2, 3,N'Áo phông nam màu xanh dương', N'15%', N'Mua bất kỳ 4 áo phông nào', N'Khuyến mãi đặc biệt'),
(3, 4, N'Áo phông nam màu đỏ', N'20%', N'Mua bất kỳ 2 áo phông cùng màu', N'Ưu đãi theo màu sắc'),
(4, 5, N'Áo phông nam màu xám', N'25%', N'Mua bất kỳ áo phông nào có logo cụ thể', N'Ưu đãi theo logo')
 
 SELECT * FROM DotGiamGiaTheoSP

-- Đợt Giảm giá theo Khách hàng
INSERT INTO DotGiamGiaTheoKH (ID_DGG, ID_KH,TenKH, GiaTriGG, DieuKienGiamGia, MoTa)
VALUES
(1, 1,N'Khách hàng 1', N'8%', N'Khách hàng VIP', N'Ưu đãi độc quyền cho khách hàng VIP'),
(2, 2,N'Khách hàng 2', N'12%', N'Khách hàng mới', N'Ưu đãi chào mừng cho khách hàng mới'),
(3, 3,N'Khách hàng 3', N'5%', N'Khách hàng thường xuyên mua sắm', N'Ưu đãi trung thành cho khách hàng thường xuyên'),
(4, 4,N'Khách hàng 4', N'10%', N'Khách hàng giới thiệu bạn bè', N'Ưu đãi chương trình giới thiệu'),
(5, 5,N'Khách hàng 5', N'15%', N'Khách hàng có sinh nhật trong tháng này', N'Ưu đãi đặc biệt cho sinh nhật')

SELECT * FROM DotGiamGiaTheoKH

-- Đợt Giảm Giá
INSERT INTO DotGiamGia (ID_TKH, ID_TSP, TeNDGG, NgayBatDau, NgayKetThuc, LoaiGiamGia, GiaTriGG, DieuKienGiamGia, MoTa)
VALUES
    (1, 1, N'Ưu đãi cho khách hàng VIP', '2023-01-01', '2023-01-31', N'Theo sản phẩm', N'10%', N'Mua 2 áo phông trở lên', N'Ưu đãi mua số lượng'),
    (2, 2, N'Ưu đãi cho thành viên mới', '2023-02-01', '2023-02-28', N'Theo sản phẩm', N'15%', N'Mua bất kỳ 3 áo phông nào', N'Ưu đãi cho thành viên mới đăng ký'),
    (3, 3, N'Khuyến mãi mùa hè', '2023-03-01', '2023-04-30', N'Theo sản phẩm', N'20%', N'Mua bất kỳ 4 áo phông nào', N'Khuyến mãi mùa hè'),
    (4, 4, N'Ưu đãi màu sắc', '2023-05-01', '2023-05-31', N'Theo sản phẩm', N'5%', N'Mua bất kỳ 2 áo phông cùng màu', N'Ưu đãi theo màu sắc'),
    (5, 5, N'Ưu đãi đặc biệt cho logo', '2023-06-01', '2023-06-30', N'Theo sản phẩm', N'12%', N'Mua bất kỳ áo phông nào có logo cụ thể', N'Ưu đãi theo logo');

SELECT * FROM DotGiamGia

--THÊM RÀNG BUỘC

ALTER TABLE dbo.NhanVien
    ADD FOREIGN KEY (ID_CV) REFERENCES dbo.ChucVu(ID_CV);

ALTER TABLE dbo.Luong
    ADD FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV);

ALTER TABLE dbo.PhieuChamCong
    ADD FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV);

ALTER TABLE dbo.PhieuGiaoCa
    ADD FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV);

ALTER TABLE dbo.Thuong
    ADD FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV);

ALTER TABLE dbo.PhieuGiamGia
    ADD CONSTRAINT FK_PhieuGiamGia_GiamGiaTheoSP
        FOREIGN KEY (ID_TSP) REFERENCES GiamGiaTheoSP(ID_TSP); 


ALTER TABLE dbo.PhieuGiamGia
    ADD CONSTRAINT FK_PhieuGiamGia_GiamGiaTheoKH
        FOREIGN KEY (ID_TKH) REFERENCES GiamGiaTheoKH(ID_TKH);

ALTER TABLE dbo.NhaCungCap
    ADD FOREIGN KEY (ID_LG) REFERENCES dbo.LoGo(ID_LG),
    FOREIGN KEY (ID_NLL) REFERENCES dbo.NguoiLienLac(ID_NLL);

ALTER TABLE dbo.PhieuGiaoHang
    ADD CONSTRAINT FK_PhieuGiaoHang_DiaChi
        FOREIGN KEY (ID_DC) REFERENCES dbo.DiaChi(ID_DC),
    CONSTRAINT FK_PhieuGiaoHang_NhanVien
        FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV),
    CONSTRAINT FK_PhieuGiaoHang_SanPham
        FOREIGN KEY (ID_SP) REFERENCES dbo.SanPham(ID_SP),
    CONSTRAINT FK_PhieuGiaoHang_KhachHang
        FOREIGN KEY (ID_KH) REFERENCES dbo.KhachHang(ID_KH);

ALTER TABLE dbo.DanhGia
    ADD FOREIGN KEY (ID_KH) REFERENCES dbo.KhachHang(ID_KH);

ALTER TABLE dbo.TinNhan
    ADD FOREIGN KEY (ID_KH) REFERENCES dbo.KhachHang(ID_KH);

ALTER TABLE dbo.NhanVien
    ADD FOREIGN KEY (ID_TK) REFERENCES dbo.TaiKhoan(ID_TK);
	
ALTER TABLE dbo.ChiTietHoaDon
    ADD FOREIGN KEY (ID_SP) REFERENCES dbo.SanPham(ID_SP),
		FOREIGN KEY (ID_HD) REFERENCES dbo.HoaDon(ID_HD);

ALTER TABLE dbo.SanPham
    ADD FOREIGN KEY (ID_MS) REFERENCES dbo.MauSac(ID_MS),
     FOREIGN KEY (ID_TL) REFERENCES dbo.TheLoai(ID_TL),
     FOREIGN KEY (ID_NCC) REFERENCES dbo.NhaCungCap(ID_NCC),
     FOREIGN KEY (ID_KT) REFERENCES dbo.KichThuoc(ID_KT),
     FOREIGN KEY (ID_GG) REFERENCES dbo.PhieuGiamGia(ID_GG);

ALTER TABLE dbo.HinhAnh
    ADD FOREIGN KEY (ID_SP) REFERENCES dbo.SanPham(ID_SP);

ALTER TABLE dbo.HoaDon
    ADD FOREIGN KEY (ID_KH) REFERENCES dbo.KhachHang(ID_KH),
     FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV),
     FOREIGN KEY (ID_TT) REFERENCES dbo.PhuongThucThanhToan(ID_TT),
     FOREIGN KEY (ID_VC) REFERENCES dbo.PhuongThucVanChuyen(ID_VC),
     FOREIGN KEY (ID_GG) REFERENCES dbo.PhieuGiamGia(ID_GG),
     FOREIGN KEY (ID_DGG) REFERENCES dbo.DotGiamGia(ID_DGG),
     FOREIGN KEY (ID_CT) REFERENCES dbo.ChiTietHoaDon(ID_CT),
     FOREIGN KEY (ID_GH) REFERENCES dbo.PhieuGiaoHang(ID_GH);


ALTER TABLE dbo.ChatLieu
    ADD FOREIGN KEY (ID_SP) REFERENCES dbo.SanPham(ID_SP);

ALTER TABLE dbo.DotGiamGiaTheoSP
    ADD CONSTRAINT FK_DotGiamGia_DotGiamGiaTheoSP
        FOREIGN KEY (ID_DGG) REFERENCES DotGiamGia(ID_DGG);

ALTER TABLE dbo.DotGiamGiaTheoKH
    ADD CONSTRAINT FK_DotGiamGia_DotGiamGiaTheoKH
        FOREIGN KEY (ID_DGG) REFERENCES DotGiamGia(ID_DGG);
