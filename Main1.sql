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
	ID_PGK INT PRIMARY KEY,
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
    ID_Phieu INT PRIMARY KEY,
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
TenNV NVARCHAR(50),
Email NVARCHAR(50),
MatKhau NVARCHAR(50),
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
ID_NV INT,
TenTK NVARCHAR(50),
MatKhau NVARCHAR(50),
VaiTro BIT,
TrangThai BIT
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
GioiTinh BIT,
NgaySinh DATE,
DiaChi NVARCHAR(250),
DienThoai VARCHAR(10),
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
ID_DG INT PRIMARY KEY,
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
ID_TinNhan INT PRIMARY KEY,
ID_NV INT,
ID_KH INT,
NoiDungChat NVARCHAR(250),
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
ID_LGG INT IDENTITY(1,1) PRIMARY KEY,
ID_DGG INT,
TenLGG NVARCHAR(50),
SoTienGiam MONEY,
DKApDung NVARCHAR(50),
MoTa NVARCHAR(250)
)
GO


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

ALTER TABLE dbo.TaiKhoan
    ADD FOREIGN KEY (ID_NV) REFERENCES dbo.NhanVien(ID_NV);

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

ALTER TABLE dbo.LoaiGiamGia
    ADD FOREIGN KEY (ID_DGG) REFERENCES dbo.DotGiamGia(ID_DGG);

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