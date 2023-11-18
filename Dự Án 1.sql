USE master
GO

CREATE DATABASE FA23_PRO1041_SD18309
GO

USE FA23_PRO1041_SD18309
GO

/*==============================================================*/
/* 1. Table: Chức Vụ                                            */
/*==============================================================*/

IF OBJECT_ID('ChucVu') IS NOT NULL
DROP TABLE ChucVu
GO

CREATE TABLE ChucVu 
(MaCV INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenCV NVARCHAR(50) NOT NULL,
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
ID_Luong INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
ID_NV INT NOT NULL,
MucLuong MONEY NOT NULL,
NgayTra DATE NOT NULL,
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
MaThuong INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaNV INT NOT NULL,
NgayThuong DATE NOT NULL,
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
	MaPhieuGiaoCa INT NOT NULL PRIMARY KEY,
	MaNV INT NOT NULL,
	TenNV NVARCHAR(50) NOT NULL,
	TGBD DATETIME NOT NULL,
	TGKT DATETIME NOT NULL,
	TienMatDauCa MONEY NOT NULL,
	TienMatCuoiCa MONEY NOT NULL,
	TienCK MONEY,
	TienGG MONEY,
	TongTien MONEY NOT NULL,
	Note NVARCHAR(250)
)

/*==============================================================*/
/* 5. Phiếu Chấm Công                                           */
/*==============================================================*/

IF OBJECT_ID('PhieuChamCong') IS NOT NULL
DROP TABLE PhieuChamCong
GO

CREATE TABLE PhieuChamCong (
    MaPhieu INT NOT NULL PRIMARY KEY,
    MaNhanVien INT NOT NULL,
    NgayCham DATE NOT NULL,
    GioVao TIME NOT NULL,
    GioRa TIME NOT NULL,
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
MaNV INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaCV INT NOT NULL,
TenNV NVARCHAR(50) NOT NULL,
Email NVARCHAR(50) NULL,
MatKhau NVARCHAR(50) NOT NULL,
GioiTinh Bit NOT NULL,
NgaySinh DATE NOT NULL,
DiaChi NVARCHAR(250) NOT NULL,
VaiTro BIT NOT NULL
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
MaTK INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaKH INT NOT NULL,
TenTK NVARCHAR(50) NOT NULL,
MatKhau NVARCHAR(50) NOT NULL,
VaiTro BIT NOT NULL,
TrangThai BIT NOT NULL
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
MaKH INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenKH NVARCHAR(50) NOT NULL,
MatKhau NVARCHAR(50) NOT NULL,
GioiTinh BIT NOT NULL,
NgaySinh DATE NOT NULL,
DiaChi NVARCHAR(250) NOT NULL,
DienThoai VARCHAR(10) NOT NULL,
Email NVARCHAR(50),
Hinh NVARCHAR(50),
MoTa NVARCHAR(250)
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
MaHD INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaKH INT NOT NULL,
MaNV INT NOT NULL,
MaTT INT NOT NULL,
MaVC INT NOT NULL,
MaSP INT NOT NULL,
MaGH INT NOT NULL,
MaCT INT,
MaGG INT,
MaDGG INT,
NgayDat DATE NOT NULL,
NgayCan DATE,
NgayGiao DATE,
TenKH NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(250) NOT NULL,
PhiVanChuyen MONEY NOT NULL,
TongTien MONEY NOT NULL,
TongTienSauGiam MONEY NOT NULL,
TrangThai NVARCHAR(50) NOT NULL,
GhiChu NVARCHAR(250) NOT NULL
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
MaCT INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaHD INT NOT NULL,
MaSP INT NOT NULL,
MaGG INT,
MaGH INT NOT NULL,
MaDGG INT,
TenSP NVARCHAR(50) NOT NULL,
DonGia MONEY NOT NULL,
SoLuong INT NOT NULL
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
ID_MS BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenMS NVARCHAR(50) NOT NULL,
Hinh NVARCHAR(50),
TrangThai BIT NOT NULL,
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
MaTL INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenTL NVARCHAR(50) NOT NULL,
Hinh NVARCHAR(50),
TrangThai BIT NOT NULL,
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
MaKT INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
KichThuoc NVARCHAR(50) NOT NULL,
GiaTriKT NVARCHAR(50) NOT NULL,
TrangThai BIT NOT NULL,
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
MaCL INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
ChatLieu NVARCHAR(50) NOT NULL,
Hinh NVARCHAR(50),
TrangThai BIT NOT NULL,
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
ID_HA BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaSP INT NOT NULL,
URL VARCHAR(50) NOT NULL,
DinhDang VARCHAR(50) NOT NULL,
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
MaSP INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaNCC INT NOT NULL,
MaMS INT NOT NULL,
MaTL INT NOT NULL,
MaCL INT NOT NULL,
MaKT INT NOT NULL,
MaGG INT NOT NULL,
MaHA INT NOT NULL,
TenSP NVARCHAR(50) NOT NULL,
SoLuong INT NOT NULL,
DonGia MONEY NOT NULL,
NgaySanXuat DATE NOT NULL,
SoLuongTon INT NOT NULL,
SoLuotXem INT NOT NULL,
TrangThai BIT NOT NULL,
MoTa NVARCHAR(250) 
)
GO

--Thêm dữ liệu cho bảng SanPham
INSERT INTO SanPham VALUES
  (1, 101, 201, 301, 401, 501, 601, N'Sản phẩm áo phông nữ', 1000000, '2023-01-01', 50, 100, 1, N'Mô tả sản phẩm 1'),
  (2, 102, 202, 302, 402, 502, 602, N'Sản phẩm áo phông nam 2', 1500000, '2023-02-15', 30, 80, 1, N'Mô tả sản phẩm 2'),
  (3, 103, 203, 303, 403, 503, 603, N'Sản phẩm áo phông thể thao', 800000, '2023-03-10', 70, 120, 1, N'Mô tả sản phẩm 3'),
  (4, 104, 204, 304, 404, 504, 604, N'Sản phẩm áo phông dành cho trẻ em', 1200000, '2023-04-20', 20, 60, 1, N'Mô tả sản phẩm 4'),
  (5, 105, 205, 305, 405, 505, 605, N'Sản phẩm áo phông nữ', 2000000, '2023-05-05', 40, 150, 1, N'Mô tả sản phẩm 5');


/*==============================================================*/
/* 17. Table: Logo Công Ty                                      */
/*==============================================================*/

IF OBJECT_ID('LoGo') IS NOT NULL
DROP TABLE LoGo
GO

CREATE TABLE LoGo
(
MaLG INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenLG NVARCHAR(50) NOT NULL,
Hinh NVARCHAR(50) NOT NULL,
NgayTao DATE NOT NULL,
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
MaNLL INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenNLL NVARCHAR(50) NOT NULL,
DienThoai CHAR(10) NOT NULL,
ChucVu NVARCHAR(50) NOT NULL,
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
MaNCC INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenCT NVARCHAR(50) NOT NULL,
MaLG INT NOT NULL,
MaNLL INT NOT NULL,
Email NVARCHAR(50),
DienThoai CHAR(10) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
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
MaDC INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenDC NVARCHAR(50) NOT NULL,
TenNguoiNhan NVARCHAR(50) NOT NULL,
DienThoai CHAR(10) NOT NULL,
NoiNhan NVARCHAR(50) NOT NULL,
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
MaGH INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaSP INT NOT NULL,
MaKH INT NOT NULL,
MaNV INT NOT NULL,
MaHD INT NOT NULL,
NgayGiao DATE NOT NULL,
MaDC INT NOT NULL,
TrangThaiGH BIT NOT NULL,
TrangThaiTT BIT NOT NULL,
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
	MaGG INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    MaKH INT NOT NULL,
    MaSP INT NOT NULL,
	MaTSP INT NOT NULL,
	MATKH INT NOT NULL,
    NgayBatDau DATE NOT NULL,
    NgayHH DATE NOT NULL,
    GiaTriGG NVARCHAR(50) NOT NULL,
    TrangThai BIT NOT NULL,
    NgayTao DATE NOT NULL,
    NgaySuDung DATE NOT NULL,
    MOTA NVARCHAR(250),
)
GO

/*==============================================================*/
/* 23. Table: Giảm Giá Theo Sản Phẩm                            */
/*==============================================================*/

IF OBJECT_ID('GiamGiaTheoSP') IS NOT NULL
DROP TABLE GiamGiaTheoSP
GO

CREATE TABLE GiamGiaTheoSP(
MaTSP INT IDENTITY(1,1)  PRIMARY KEY NOT NULL,
MaSP INT NOT NULL,
GiaTriGG NVARCHAR(50)NOT NULL,
DieuKienGG NVARCHAR(50)NOT NULL,
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
MaTKH INT IDENTITY(1,1)  PRIMARY KEY NOT NULL,
MaKH INT NOT NULL,
VaiTro BIT NOT NULL,
GiaTriGG NVARCHAR(50) NOT NULL,
DieuKienGG NVARCHAR(50) NOT NULL,
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
   MaDGG INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
   TeNDGG NVARCHAR(500) NOT NULL,
   NgayBatDau DATE NOT NULL,
   NgayKetThuc DATE NOT NULL,
   LoaiGiamGia NVARCHAR(50) NOT NULL,
   GiaTriGG NVARCHAR(250) NOT NULL,
   DieuKienGiamGia NVARCHAR(50) NOT NULL,
   MoTa NVARCHAR(250),
)

/*==============================================================*/
/* 26. Table: Phương Thức Vận Chuyển                            */
/*==============================================================*/

IF OBJECT_ID('PhuongThucVanChuyen') IS NOT NULL
DROP TABLE PhuongThucVanChuyen
GO

CREATE TABLE PhuongThucVanChuyen(
	MaVC INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	HinhThucVC NVARCHAR(50) NOT NULL,
	MoTa NVARCHAR(250),
)

/*==============================================================*/
/* 27. Table: Phương Thức Thanh Toán                            */
/*==============================================================*/

IF OBJECT_ID('PhuongThucThanhToan') IS NOT NULL
DROP TABLE PhuongThucThanhToan
GO

CREATE TABLE PhuongThucThanhToan(
	MaTT INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	HinhThucTT NVARCHAR(50) NOT NULL,
	TrangThaiTT NVARCHAR(50) NOT NULL,
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
MaDG INT PRIMARY KEY NOT NULL,
MaKH INT NOT NULL,
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
MaTinNhan INT PRIMARY KEY NOT NULL,
MaNV INT NOT NULL,
MaKH INT NOT NULL,
NoiDungChat NVARCHAR(250) NOT NULL,
TrangThai BIT,
LichSu DATETIME
)

/*==============================================================*/
/* 30. Table: Loại Giảm Giá                                     */
/*==============================================================*/
IF OBJECT_ID('LoaiGiamGia') IS NOT NULL
DROP TABLE LoaiGiamGia
GO
CREATE TABLE LoaiGiamGia
(
MaLGG INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaDGG INT NOT NULL,
TenLGG NVARCHAR(50) NOT NULL,
SoTienGiam MONEY NOT NULL,
DKApDung NVARCHAR(50) NOT NULL,
MoTa NVARCHAR(250)
)
GO


---THÊM CÁC RÀNG BUỘC
 -- Nhân Viên ---
ALTER TABLE dbo.NhanVien
	ADD FOREIGN KEY(MaCV) REFERENCES dbo.ChucVu(MaCV);

ALTER TABLE dbo.Luong
	ADD FOREIGN KEY (MaNV) REFERENCES dbo.NhanVien(MaNV);

ALTER TABLE dbo.PhieuChamCong
	ADD FOREIGN KEY (MaNhanVien) REFERENCES dbo.NhanVien(MaNV);

ALTER TABLE dbo.PhieuGiaoCa
	ADD FOREIGN KEY (MaNV) REFERENCES dbo.NhanVien(MaNV);

ALTER TABLE dbo.Thuong
	ADD FOREIGN KEY (MaNV) REFERENCES dbo.NhanVien(MaNV);

    --Phiếu Giảm Giá ---
ALTER TABLE PhieuGiamGia
	ADD CONSTRAINT FK_PhieuGiamGia_GiamGiaTheoSP
	FOREIGN KEY (MaTSP) REFERENCES GiamGiaTheoSP(MaTSP)

ALTER TABLE PhieuGiamGia
	ADD CONSTRAINT FK_PhieuGiamGia_GiamGiaTheoKH
	FOREIGN KEY (MaTKH) REFERENCES GiamGiaTheoKH(MaTKH)

	-- Nhà Cung Cấp --
ALTER TABLE NhaCungCap
	ADD CONSTRAINT FK_NhaCungCap_LoGoCT_ChiTietNguoiLienLac
	FOREIGN KEY (MaLG) REFERENCES LoGoCT(MaLG)

ALTER TABLE NhaCungCap
	ADD CONSTRAINT FK_NhaCungCap_ChiTietNguoiLienLac
	FOREIGN KEY (MaNLL) REFERENCES ChiTietNguoiLienLac(MaNLL)

	-- Phiếu Giao Hàng--
ALTER TABLE PhieuGiaoHang
	ADD CONSTRAINT FK_PhieuGiaoHang_DiaChi
	FOREIGN KEY (MaDC) REFERENCES DiaChi(MaDC)

ALTER TABLE PhieuGiaoHang
	ADD CONSTRAINT FK_PhieuGiaoHang_NhanVien
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)

ALTER TABLE PhieuGiaoHang
	ADD CONSTRAINT FK_PhieuGiaoHang_SanPham
	FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)

ALTER TABLE PhieuGiaoHang
	ADD CONSTRAINT FK_PhieuGiaoHang_KhachHang
	FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)

	-- Khách Hàng --
ALTER TABLE DanhGia 
   ADD FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
       
ALTER TABLE TinNhan 
   ADD FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)

ALTER TABLE TaiKhoan
   ADD FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
   	-- Sản Phẩm --
ALTER TABLE SanPham
    ADD FOREIGN KEY(MaNCC) REFERENCES NhaCungCap(MaNCC),
	FOREIGN KEY(MaMS) REFERENCES MauSac(MaMS),
	FOREIGN KEY(MaTL) REFERENCES TheLoai(MaTL),
	FOREIGN KEY(MaCL) REFERENCES ChatLieu(MaCL),
	FOREIGN KEY(MaKT) REFERENCES KichThuoc(MaKT),
	FOREIGN KEY(MaGG) REFERENCES PhieuGiamGia(MaGG)

ALTER TABLE NhaCungCap
    ADD FOREIGN KEY(MaNCC) REFERENCES SanPham(MaNCC)
	-- Hình Ảnh --
ALTER TABLE HinhAnh
	ADD FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP)

	-- Loại Giảm Giá --
ALTER TABLE LoaiGiamGia
	ADD FOREIGN KEY(MaDGG) REFERENCES DotGiamGia(MaDGG)

	-- Hóa Đơn --
ALTER TABLE HoaDon
    ADD FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP),
	FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH),
	FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV),
	FOREIGN KEY(MaTT) REFERENCES PhuongThucThanhToan(MaTT),
	FOREIGN KEY(MaVC) REFERENCES PhuongThucVanChuyen(MaVC),
	FOREIGN KEY(MaGG) REFERENCES PhieuGiamGia(MaGG),
	FOREIGN KEY(MaDGG) REFERENCES DotGiamGia(MaDGG),
	FOREIGN KEY(MaCT) REFERENCES ChiTietHoaDon(MaCT),
	FOREIGN KEY(MaGH) REFERENCES PhieuGiaoHang(MaGH)

	-- Xóa khóa ngoại MaNCC
ALTER TABLE SanPham
DROP CONSTRAINT [tên_constraint]; 


---THÊM DỮ LIỆU VÀO BẢNG

---MÀU SẮC
INSERT INTO MauSac (TenMS, Hinh, TrangThai, MoTa) VALUES
(N'Đen', 'den.jpg', 1, N'Màu đen cho áo phông'),
(N'Trắng', 'trang.jpg', 1, N'Màu trắng cho áo phông'),
(N'Xanh dương', 'xanh_duong.jpg', 1, N'Màu xanh dương cho áo phông'),
(N'Đỏ', 'do.jpg', 1, N'Màu đỏ cho áo phông'),
(N'Xám', 'xam.jpg', 1, N'Màu xám cho áo phông');

SELECT * FROM MauSac

---KÍCH THƯỚC
INSERT INTO KichThuoc (KichThuoc, GiaTriKT, TrangThai, MoTa) VALUES
('S', 'Small', 1, N'Kích thước nhỏ cho áo phông'),
('M', 'Medium', 1, N'Kích thước trung bình cho áo phông'),
('L', 'Large', 1, N'Kích thước lớn cho áo phông'),
('XL', 'Extra Large', 1, N'Kích thước cực lớn cho áo phông'),
('XXL', 'Double Extra Large', 1, N'Kích thước rất lớn cho áo phông');

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

INSERT INTO ChatLieu (ChatLieu, Hinh, TrangThai, MoTa) VALUES 
(N'Cotton', 'cotton.jpg', 1, N'Chất liệu cotton thông thường'),
(N'Len', 'len.jpg', 1, N'Chất liệu len dày dặn và ấm áp'),
(N'Polyester', 'polyester.jpg', 1, N'Chất liệu polyester bền và chống nhăn'),
(N'Satin', 'satin.jpg', 1, N'Chất liệu satin mềm mại và lịch lãm'),
(N'Kaki', 'kaki.jpg', 1, N'Chất liệu kaki bền và thoải mái');

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
INSERT INTO SanPham (MaNCC, MaMS, MaTL, MaCL, MaKT, MaGG, MaHA, TenSP, DonGia, NgaySanXuat, SoLuongTon, SoLuotXem, TrangThai, MoTa) VALUES
(1, 1, 1, 1, 1, 1, 1, N'Áo phông nam màu đen', 200000, '2023-01-01', 50, 100, 1, N'Áo phông nam màu đen thông thoáng và thoải mái'),
(2, 2, 1, 2, 2, 1, 2, N'Áo phông nam màu trắng', 180000, '2023-01-02', 70, 90, 1, N'Áo phông nam màu trắng đơn giản và thời trang'),
(3, 3, 1, 3, 3, 2, 3, N'Áo phông nam màu xanh dương', 220000, '2023-01-03', 40, 80, 1, N'Áo phông nam màu xanh dương năng động và trẻ trung'),
(4, 4, 1, 4, 1, 2, 4, N'Áo phông nam màu đỏ', 210000, '2023-01-04', 60, 70, 1, N'Áo phông nam màu đỏ cá tính và phong cách'),
(5, 5, 1, 5, 2, 3, 5, N'Áo phông nữ màu xám', 190000, '2023-01-05', 30, 60, 1, N'Áo phông nữ màu xám nhẹ nhàng và duyên dáng');

ALTER TABLE SanPham
DROP CONSTRAINT FK__SanPham__MaGG__57DD0BE4; 

SELECT * FROM SanPham

---HÓA ĐƠN
INSERT INTO HoaDon (MaKH, MaNV, MaTT, MaVC, MaGG, MaDGG, NgayDat, NgayCan, NgayGiao, TenKH, DiaChi, PhiVanChuyen, TongTien, TongTienSauGiam, TrangThai, GhiChu) VALUES
(1, 1, 1, 1, 1, 1, '2023-01-01', '2023-01-03', '2023-01-03', N'Nguyễn Thị Yến Nhi', N'Hà Giang', 30000, 250000, 200000, N'Đã giao hàng', N'Giao hàng nhanh'),
(2, 2, 1, 2, 2, 1, '2023-01-02', '2023-01-05', '2023-01-06', N'Nguyễn Thị Cẩm Vân', N'Hà Nội', 25000, 220000, 180000, N'Đã xác nhận', N'Giao hàng tiết kiệm'),
(3, 3, 2, 1, 3, 2, '2023-02-03', '2023-02-07', '2023-02-12', N'Nguyễn Thu Hồng', N'Thái Bình', 35000, 280000, 240000, N'Đang vận chuyển', N'Giao hàng chậm'),
(4, 4, 2, 2, 4, 2, '2023-02-04', '2023-02-07', '2023-01-07', N'Nguyễn Thùy Dương', N'Hà Giang', 40000, 320000, 270000, N'Đang xử lý', N'Giao hàng nhanh'),
(5, 5, 3, 3, 5, 3, '2023-08-05', '2023-08-08', '2023-08-11', N'Trịnh Như Quỳnh', N'Hà Nội', 30000, 200000, 170000, N'Đã hủy', N'Giao hàng tiết kiệm');

SELECT * FROM HoaDon

---CHI TIẾT HÓA ĐƠN
INSERT INTO ChiTietHoaDon (MaHD, MaSP, MaGG, MaGH, MaDGG, TenSP, DonGia, SoLuong) VALUES
-- Chi tiết hóa đơn 1
(1, 1, 1, 1, 1, N'Áo phông nam màu đen', 200000, 2),
-- Chi tiết hóa đơn 2
(2, 2, 2, 2, 1, N'Áo phông nữ màu trắng', 180000, 1),
-- Chi tiết hóa đơn 3
(3, 3, 3, 3, 2, N'Áo phông trẻ em màu xanh dương', 220000, 3),
-- Chi tiết hóa đơn 4
(4, 4, 4, 4, 2, N'Áo phông nam màu đỏ', 210000, 2),
-- Chi tiết hóa đơn 5
(5, 5, 5, 5, 3, N'Áo phông nữ màu xám', 190000, 1);

SELECT * FROM ChiTietHoaDon

--logo ct
INSERT INTO LoGoCT (TenLG, Hinh, NgayTao, MoTa)
VALUES ('Relation of ship', 'relationsjo.jpg','2022-09-07','Logo nhà Relation bản 2022 mới nhất'),
       ('Internation', 'internationggh.jpg','2021-06-01','Logo giúp chúng ta ghi nhớ thương hiệu'),
	   ('Zyro hydrate', 'zyrohydate.jpg','2020-01-01','Logo bắt đầu hành trình xây dựng thương hiệu của mình'),
	   ('Cookie dinner', 'cookierela.jpg','2023-05-11','Logo giúp bạn có ý tưởng hoàn thiện thiết kế của mình'),
	   ('Slogan trying', 'sloganehew.jpg','2021-02-10','Logo truyền cảm hứng cho công việc')
--chitietnll
INSERT INTO ChiTietNguoiLienLac (TenNLL, DienThoai, ChucVu, Email, GhiChu)
VALUES ('Lê Hoài Nam', '0983123329','Nhân Viên','namhl@gmail.com','Số lượng áo phông nhiều hơn thun'),
       ('Trần Đình Thái', '0966368202','Quản Lí','thaitd@gmail.com',''),
	   ('Vũ Mị Nương', '0966383222','Quản Lí','nuongvm@gmail.com','Quần jogy nỉ thun sll'),
	   ('Hồ Quý Ly', '0966383404','Nhân Viên','lyhq@gmail.com',''),
	   ('Nguyễn Văn Long', '0982122226','Nhân Viên','longnv@gmail.com','Hoodie gấu nâu')
--nha cung cap
INSERT INTO NhaCungCap (TenCT, MaLG, MaNLL, Email, DienThoai, DiaChi, MoTa)
VALUES ('Công Ty TNHH Vải Elo',2,3,'vaielo@gmail.com','0993234543','Số 5 Nguyễn Hữu Dục','Tòa nhà 10A'),
       ('Công Ty Trello',1,4,'trelloxtre@gmail.com','0987677643','Số 9 Đường Lê Đức Thọ','Tầng 5 tòa BA'),
	   ('Công Ty XTreme',5,2,'xtremex@gmail.com','0988477643','22 phố Nguyên Xá','Tòa thị chính HHC'),
	   ('Công Ty RelaChew',3,1,'relachew@gmail.com','0924177643','Tòa HaChiCo Nguyễn Xiển','Ngõ 46 Lê Lợi'),
	   ('Công Ty Villa Hex',4,5,'vaillahex@gmail.com','0985677643','Tòa Villa Nguyễn Hùng','Số 22 Nguyễn Trãi')
--dia chi
INSERT INTO DiaChi (TenDC, TenNguoiNhan, DienThoai, NoiNhan, GhiChu)
VALUES ('P502 VinHome', 'Vu Ha My','0993234543','Số 9 Đường Lê Đức Thọ','Ship tan nha'),
       ('H307 HaTeCo', 'Tran Van Luong','0987677643','Số 5 Nguyễn Hữu Dục',''),
	   ('L303 RichMax', 'Ngo Hao','0988477643','22 phố Nguyên Xá',''),
	   ('F210 Villa', 'Co Hai Bao','0985677643','135 Ngô Nhai','2 ao 1 quan'),
	   ('T405 TreLlo', 'Mo Hai','0985677643','162 Trần Văn Lương','')
--phieu giao hang
INSERT INTO PhieuGiaoHang (MaSP, MaKH, MaNV,MaHD, NgayGiao, MaDC, TrangThaiGH, TrangThaiTT, GhiChu)
VALUES (1,2,4,5,'2023-01-01',3,'Dang Giao','Da Thanh Toan','Giao Hoa Toc'),
       (3,4,3,3,'2023-11-02',5,'Da Giao','Chua Thanh Toan','Giao Hoa Toc'),
	   (4,5,1,2,'2023-09-05',1,'Dang Giao','Da Thanh Toan','Giao Thuong'),
	   (2,1,5,4,'2023-10-11',2,'Da Huy','Da Thanh Toan','Giao Thuong'),
	   (5,3,2,1,'2023-09-09',4,'Dang Giao','Chua Thanh Toan','Giao Thuong')

INSERT INTO DanhGia (MaHD, MaKH, MoTa, TrangThai) VALUES
(1, 1, N'Sản phẩm khá ổn', 1),
(2, 2, N'Tệ', 0),
(3, 3, N'Sản phẩm dùng được', 1),
(4, 4, N'Sản phẩm ổn', 0),
(5, 5, N'Cũng được', 1);
SELECT * FROM DanhGia

INSERT INTO TinNhan (MaTinNhan, MaNV, MaKH, NoiDungChat, TrangThai, LichSu) VALUES
(1, 1, 1, N'Sản phẩm còn không', 1, '2023-10-07 12:00:00'),
(2, 2, 2, N'Cần thiết', 0, '2023-11-06 12:15:00'),
(3, 3, 3, N'Cũng được ', 1, '2023-11-05 12:30:00'),
(4, 4, 4, N'Sản phẩm này không được', 0, '2023-10-12 12:45:00'),
(5, 5, 5, N'Sản phẩm um', 1, '2023-11-01 13:00:00');
SELECT * FROM TinNhan

---Chức Vụ
INSERT INTO ChucVu (MaCV, TenCV, MoTa) VALUES
(1, 'Quản Lý', N'Quản lý phòng ban với trách nhiệm lớn.'),
(2, 'Nhân Viên', N'Nhân viên với nhiệm vụ cụ thể được giao.'),
(3, 'Kế Toán', N'Kế toán tổng hợp phụ trách tài chính công ty.'),
(4, 'Lao Công', N'Công việc lao động với sự chăm chỉ và kiên nhẫn.');

---Lương
INSERT INTO Luong (MaNV, MucLuong, NgayTra, MoTa) VALUES
(101, 10000000, '2023-11-05', N'Lương tháng 11/2023 của nhân viên'),
(102, 8500000, '2023-11-05', N'Lương tháng 11/2023 của nhân viên'),
(103, 12000000, '2023-11-05', N'Lương tháng 11/2023 của nhân viên'),
(104, 9000000, '2023-11-05', N'Lương tháng 11/2023 của nhân viên'),
(201, 15000000, '2023-11-05', N'Lương tháng 11/2023 của nhân viên');


---Thưởng
INSERT INTO Thuong (MaNV, NgayThuong, MoTa) VALUES
(101, '2023-11-01', N'Nhận thưởng do hoàn thành xuất sắc dự án A.'),
(102, '2023-11-01', N'Được thưởng vì thành tích kinh doanh cao trong tháng.'),
(103, '2023-11-02', N'Nhận thưởng do đề xuất giải pháp tiết kiệm chi phí hiệu quả.'),
(104, '2023-11-02', N'Nhận thưởng vì tích cực đóng góp trong việc tạo không gian làm việc thoải mái.');
GO


--- Nhân Viên
INSERT INTO NhanVien (MaCV, TenNV, Email, MatKhau, GioiTinh, NgaySinh, DiaChi, VaiTro) VALUES
(1, N'Dương Đức Mạnh', 'manhddm@gmail.com', '123123asd', 1, '1990-01-01', 'Hà Nội', 1),
(2, N'Hoắc Vũ Hạo', 'haohvh@gmail.com', '123123asd', 0, '1995-05-05', 'Hồ Chí Minh', 0),
(3, N'Hạo Đông Nhi', 'nhihdn@gmail.com', '123123asd', 1, '1992-02-02', 'Đà Nẵng', 0),
(4, N'Lê Thị Đoàn','doanltd@gmail.com', '123123asd', 1, '1991-03-03', 'Huế', 0);


--- Phiếu Giao Ca
INSERT INTO PhieuGiaoCa (MaPhieuGiaoCa, MaNV, TenNV, TGBD, TGKT, TienMatDauCa, TienMatCuoiCa, TienCK, TienGG, TongTien, Note) VALUES
(1, 201, N'Lê Thi Đoàn', '2023-11-01 07:00:00', '2023-11-01 17:00:00', 500000, 550000, NULL, NULL, 550000, N'Giao ca làm việc đầu tiên của nhân viên.'),
(2, 202, N'Hoắc Vũ Hạo', '2023-11-01 07:30:00', '2023-11-01 17:30:00', 450000, 500000, NULL, NULL, 500000, N'Giao ca làm việc đầu tiên của nhân viên.'),
(3, 203, N'Hạo Đông Nhi', '2023-11-02 08:00:00', '2023-11-02 18:00:00', 550000, 600000, 20000, 5000, 625000, N'Giao ca làm việc thứ hai của nhân viên.'),
(4, 204, N'Dương Đức Mạnh', '2023-11-02 07:00:00', '2023-11-02 17:00:00', 500000, 550000, 10000, 3000, 563000, N'Giao ca làm việc thứ hai của nhân viên.');

--- Phiếu Chấm Công
INSERT INTO PhieuChamCong (MaPhieu, MaNhanVien, NgayCham, GioVao, GioRa, GhiChu) VALUES
(1, 101, '2023-11-01', '08:00:00', '17:00:00', N'Chấm công ngày làm việc thứ nhất của nhân viên.'),
(2, 102, '2023-11-01', '08:30:00', '17:30:00', N'Chấm công ngày làm việc thứ nhất của nhân viên.'),
(3, 103, '2023-11-02', '09:00:00', '18:00:00', N'Chấm công ngày làm việc thứ hai của nhân viên.'),
(4, 104, '2023-11-02', '08:00:00', '17:00:00', N'Chấm công ngày làm việc thứ hai của nhân viên.');