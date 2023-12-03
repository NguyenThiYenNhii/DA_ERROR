
USE master
GO

create database PRO1041_DA
GO

USE PRO1041_DA
GO

IF OBJECT_ID('HoaDon') IS NOT NULL
DROP TABLE HoaDon
GO

CREATE TABLE HoaDon(
MaHD INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenNV NVARCHAR(50) NOT NULL,
TenKH NVARCHAR(50) NOT NULL,
NgayTao DATE NOT NULL,
TrangThai NVARCHAR(50) NOT NULL
)
GO

IF OBJECT_ID('GioHang') IS NOT NULL
DROP TABLE GioHang
GO

CREATE TABLE GioHang
(
MaGH INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
MaSP INT NOT NULL,
TenSP NVARCHAR(50) NOT NULL,
SoLuong INT NOT NULL,
DonGia MONEY NOT NULL,
GiamGia MONEY NOT NULL,
ThanhTien MONEY NOT NULL,
TrangThai NVARCHAR(50)
)
GO

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

IF OBJECT_ID('MauSac') IS NOT NULL
DROP TABLE MauSac
GO

CREATE TABLE MauSac
(
MaMS INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenMS NVARCHAR(50) NOT NULL,
Hinh NVARCHAR(50),
TrangThai BIT NOT NULL,
MoTa NVARCHAR(250) 
)
GO

IF OBJECT_ID('SanPham') IS NOT NULL
DROP TABLE SanPham
GO

CREATE TABLE SanPham
(
MaSP INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
TenSP NVARCHAR(50) NOT NULL,
MaTL INT NOT NULL,
MaCL INT NOT NULL,
MaKT INT NOT NULL,
MaMS INT NOT NULL,
SoLuong INT NOT NULL,
DonGia MONEY NOT NULL
)
GO

ALTER TABLE SanPham
    ADD FOREIGN KEY(MaMS) REFERENCES MauSac(MaMS),
	FOREIGN KEY(MaTL) REFERENCES TheLoai(MaTL),
	FOREIGN KEY(MaCL) REFERENCES ChatLieu(MaCL),
	FOREIGN KEY(MaKT) REFERENCES KichThuoc(MaKT)

ALTER TABLE GioHang
    ADD FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP)

INSERT INTO MauSac (TenMS, Hinh, TrangThai, MoTa) VALUES
(N'Đen', 'den.jpg', 1, N'Màu đen cho áo phông'),
(N'Trắng', 'trang.jpg', 1, N'Màu trắng cho áo phông'),
(N'Xanh dương', 'xanh_duong.jpg', 1, N'Màu xanh dương cho áo phông'),
(N'Đỏ', 'do.jpg', 1, N'Màu đỏ cho áo phông'),
(N'Xám', 'xam.jpg', 1, N'Màu xám cho áo phông');


---KÍCH THƯỚC
INSERT INTO KichThuoc (KichThuoc, GiaTriKT, TrangThai, MoTa) VALUES
('S', 'Small', 1, N'Kích thước nhỏ cho áo phông'),
('M', 'Medium', 1, N'Kích thước trung bình cho áo phông'),
('L', 'Large', 1, N'Kích thước lớn cho áo phông'),
('XL', 'Extra Large', 1, N'Kích thước cực lớn cho áo phông'),
('XXL', 'Double Extra Large', 1, N'Kích thước rất lớn cho áo phông');


---THỂ LOẠI
INSERT INTO TheLoai (TenTL, Hinh, TrangThai, MoTa) VALUES 
(N'Áo phông nam', 'ao_phong_nam.jpg', 1, N'Các loại áo phông dành cho nam giới'),
(N'Áo phông nữ', 'ao_phong_nu.jpg', 1, N'Các loại áo phông dành cho nữ giới'),
(N'Áo phông trẻ em', 'ao_phong_tre_em.jpg', 1, N'Các loại áo phông dành cho trẻ em'),
(N'Áo phông Unisex', 'ao_phong_unisex.jpg', 1, N'Các loại áo phông có thể dùng cho cả nam và nữ giới'),
(N'Áo phông thể thao', 'ao_phong_the_thao.jpg', 1, N'Các loại áo phông thích hợp cho hoạt động thể thao');


---CHẤT LIỆU

INSERT INTO ChatLieu (ChatLieu, Hinh, TrangThai, MoTa) VALUES 
(N'Cotton', 'cotton.jpg', 1, N'Chất liệu cotton thông thường'),
(N'Len', 'len.jpg', 1, N'Chất liệu len dày dặn và ấm áp'),
(N'Polyester', 'polyester.jpg', 1, N'Chất liệu polyester bền và chống nhăn'),
(N'Satin', 'satin.jpg', 1, N'Chất liệu satin mềm mại và lịch lãm'),
(N'Kaki', 'kaki.jpg', 1, N'Chất liệu kaki bền và thoải mái');

select*from SanPham

INSERT INTO SanPham (TenSP, MaTL, MaCL, MaKT, MaMS, SoLuong, DonGia) VALUES
(N'Áo Phông Cộc', 1, 1, 3, 2, 100, 200000),
(N'Áo Thun Nỉ', 2, 3, 4, 4, 90, 180000),
(N'Áo Phông Len', 3, 2, 5, 3, 80, 220000),
(N'Áo Viền Đen', 4, 4, 1, 1,70, 210000),
(N'Áo Bà Ba', 5, 1, 5, 3, 30, 250000),
(N'Áo phông nam màu đen', 2, 1, 4, 5, 90, 250000),
(N'Áo phông nam màu trắng', 3, 2, 1, 4, 35, 350000),
(N'Áo phông nam màu xanh dương', 1, 3, 5, 2, 20, 450000),
(N'Áo phông nam màu đỏ',  4, 5, 3, 1, 50, 500000),
(N'Áo Gió', 5, 4, 2, 3, 100, 230000);

select MaSP, TenSP, TenTL, ChatLieu.ChatLieu, KichThuoc.KichThuoc, TenMS, SoLuong, DonGia from SanPham
join TheLoai on SanPham.MaTL = TheLoai.MaTL
join ChatLieu on SanPham.MaCL = ChatLieu.MaCL
join KichThuoc on SanPham.MaKT = KichThuoc.MaKT
join MauSac on SanPham.MaMS = MauSac.MaMS
where MaSP = 1

select*from HoaDon
select*from SanPham
delete from HoaDon
select *from PhieuGiamGia
join GiamGiaTheoSP on PhieuGiamGia.MaSP = GiamGiaTheoSP.MaSP
join GiamGiaTheoKH on PhieuGiamGia.MaKH = GiamGiaTheoKH.MaKH

insert into SanPham(MaSP, TenSP, MaTL, MaCL, MaKT, MaMS, SoLuong, DonGia)
join MauSac on SanPham.MaMS= MauSac.MaMS