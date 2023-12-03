
USE DU_AN_1
GO

-- Nhi
--- Thêm
IF OBJECT_ID('insert_SanPham') IS NOT NULL
DROP PROCEDURE insert_SanPham
GO

CREATE PROC insert_SanPham
	@TenSP NVARCHAR(50), @TheLoai NVARCHAR(50), @KichThuoc NVARCHAR(50),
	@MauSac NVARCHAR(50), @ChatLieu NVARCHAR(50), @DonGia MONEY, 
	@SoLuongTon INT, @TrangThai INT
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @id_tl INT;
	INSERT INTO dbo.TheLoai(TenTL) VALUES(@TheLoai);
	SET @id_tl = SCOPE_IDENTITY();	
	DECLARE @id_kt INT;
	INSERT INTO dbo.KichThuoc(TenKT) VALUES(@KichThuoc);
	SET @id_kt = SCOPE_IDENTITY();
	DECLARE @id_ms INT;
	INSERT INTO dbo.MauSac(TenMS) VALUES(@MauSac);
	SET @id_ms = SCOPE_IDENTITY();
	DECLARE @id_cl INT;
	INSERT INTO dbo.ChatLieu(TenCL) VALUES(@ChatLieu);
	SET @id_cl = SCOPE_IDENTITY();

	INSERT INTO SanPham(TenSP, ID_TL, ID_KT, ID_MS, ID_CL, DonGia, SoLuongTon, TrangThai) VALUES
		(@TenSP,@id_tl,@id_kt,@id_ms,@id_cl,@DonGia,@SoLuongTon,@TrangThai);
END;

--- Cập nhật
IF OBJECT_ID('update_SanPham') IS NOT NULL
DROP PROCEDURE update_SanPham
GO


CREATE PROCEDURE update_SanPham
    @id_sp INT, 
    @TenSP NVARCHAR(50), 
    @TheLoai NVARCHAR(50), 
    @KichThuoc NVARCHAR(50),
    @MauSac NVARCHAR(50), 
    @ChatLieu NVARCHAR(50), 
    @DonGia MONEY, 
    @SoLuongTon INT, 
    @TrangThai INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Cập nhật thông tin bảng TheLoai
    DECLARE @id_tl INT;
    UPDATE dbo.TheLoai SET TenTL = @TheLoai WHERE ID_TL = (SELECT ID_TL FROM dbo.SanPham WHERE ID_SP = @id_sp);
    SET @id_tl = (SELECT ID_TL FROM dbo.SanPham WHERE ID_SP = @id_sp);

    -- Cập nhật thông tin bảng KichThuoc
    DECLARE @id_kt INT;
    UPDATE dbo.KichThuoc SET TenKT = @KichThuoc WHERE ID_KT = (SELECT ID_KT FROM dbo.SanPham WHERE ID_SP = @id_sp);
    SET @id_kt = (SELECT ID_KT FROM dbo.SanPham WHERE ID_SP = @id_sp);

    -- Cập nhật thông tin bảng MauSac
    DECLARE @id_ms INT;
    UPDATE dbo.MauSac SET TenMS = @MauSac WHERE ID_MS = (SELECT ID_MS FROM dbo.SanPham WHERE ID_SP = @id_sp);
    SET @id_ms = (SELECT ID_MS FROM dbo.SanPham WHERE ID_SP = @id_sp);

    -- Cập nhật thông tin bảng ChatLieu
    DECLARE @id_cl INT;
    UPDATE dbo.ChatLieu SET TenCL = @ChatLieu WHERE ID_CL = (SELECT ID_CL FROM dbo.SanPham WHERE ID_SP = @id_sp);
    SET @id_cl = (SELECT ID_CL FROM dbo.SanPham WHERE ID_SP = @id_sp);

    -- Cập nhật thông tin bảng SanPham
    UPDATE dbo.SanPham
    SET 
        TenSP = @TenSP,
        ID_TL = @id_tl,
        ID_KT = @id_kt,
        ID_MS = @id_ms,
        ID_CL = @id_cl,
        DonGia = @DonGia,
        SoLuongTon = @SoLuongTon,
        TrangThai = @TrangThai
    WHERE ID_SP = @id_sp;
END;

--Xóa
IF OBJECT_ID('delete_SanPham') IS NOT NULL
DROP PROCEDURE delete_SanPham
GO

CREATE PROCEDURE delete_SanPham
    @id_sp INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Xóa dữ liệu từ bảng SanPham
    DELETE FROM dbo.SanPham WHERE ID_SP = @id_sp;

    -- Xóa dữ liệu từ các bảng liên quan (TheLoai, KichThuoc, MauSac, ChatLieu) nếu cần
    DECLARE @id_tl INT, @id_kt INT, @id_ms INT, @id_cl INT;

    -- Lấy các ID từ bảng SanPham
    SELECT @id_tl = ID_TL, @id_kt = ID_KT, @id_ms = ID_MS, @id_cl = ID_CL
    FROM dbo.SanPham
    WHERE ID_SP = @id_sp;

    -- Xóa dữ liệu từ bảng TheLoai
    IF @id_tl IS NOT NULL
        DELETE FROM dbo.TheLoai WHERE ID_TL = @id_tl;

    -- Xóa dữ liệu từ bảng KichThuoc
    IF @id_kt IS NOT NULL
        DELETE FROM dbo.KichThuoc WHERE ID_KT = @id_kt;

    -- Xóa dữ liệu từ bảng MauSac
    IF @id_ms IS NOT NULL
        DELETE FROM dbo.MauSac WHERE ID_MS = @id_ms;

    -- Xóa dữ liệu từ bảng ChatLieu
    IF @id_cl IS NOT NULL
        DELETE FROM dbo.ChatLieu WHERE ID_CL = @id_cl;
END;

-- Thiện
IF OBJECT_ID('insert_PhieuGiaoHang') IS NOT NULL
DROP PROCEDURE insert_PhieuGiaoHang
GO

CREATE PROC insert_PhieuGiaoHang
	@ngaygiao date, @ttgiaohang bit, @ttthanhtoan bit, @ghichu NVARCHAR(250),
	@dienthoai varchar(10), @tennv nvarchar(50), @phivc money, @tendc NVARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @id_kh INT;
	INSERT INTO dbo.KhachHang(DienThoai) VALUES(@dienthoai);
	SET @id_kh = SCOPE_IDENTITY();	
	DECLARE @id_nv INT;
	INSERT INTO dbo.NhanVien(TenNV) VALUES(@tennv);
	SET @id_nv = SCOPE_IDENTITY();
	DECLARE @id_hd INT;
	INSERT INTO dbo.HoaDon(PhiVanChuyen) VALUES(@phivc);
	SET @id_hd = SCOPE_IDENTITY();
	DECLARE @id_dc INT;
	INSERT INTO dbo.DiaChi(TenDC) VALUES(@tendc);
	SET @id_dc = SCOPE_IDENTITY();

	INSERT INTO dbo.PhieuGiaoHang(ID_KH, ID_NV, ID_HD, NgayGiao, ID_DC, TrangThaiGH, TrangThaiTT, GhiChu) VALUES
		(@id_kh,@id_nv,@id_hd,@ngaygiao,@id_dc,@ttgiaohang,@ttthanhtoan,@ghichu);
END;

IF OBJECT_ID('update_PhieuGiaoHang') IS NOT NULL
DROP PROCEDURE update_PhieuGiaoHang
GO

CREATE PROCEDURE update_PhieuGiaoHang
    @id_pg INT, 
    @ngaygiao DATE, 
    @ttgiaohang BIT, 
    @ttthanhtoan BIT, 
    @ghichu NVARCHAR(250), 
    @dienthoai VARCHAR(10), 
    @tennv NVARCHAR(50), 
    @phivc MONEY, 
    @tendc NVARCHAR(50)
AS
BEGIN
    SET NOCOUNT ON;
    -- Cập nhật thông tin bảng KhachHang
    DECLARE @id_kh INT;
    UPDATE dbo.KhachHang SET DienThoai = @dienthoai WHERE ID_KH = (SELECT ID_KH FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);
    SET @id_kh = (SELECT ID_KH FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);

    -- Cập nhật thông tin bảng NhanVien
    DECLARE @id_nv INT;
    UPDATE dbo.NhanVien SET TenNV = @tennv WHERE ID_NV = (SELECT ID_NV FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);
    SET @id_nv = (SELECT ID_NV FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);

    -- Cập nhật thông tin bảng HoaDon
    DECLARE @id_hd INT;
    UPDATE dbo.HoaDon SET PhiVanChuyen = @phivc WHERE ID_HD = (SELECT ID_HD FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);
    SET @id_hd = (SELECT ID_HD FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);

    -- Cập nhật thông tin bảng DiaChi
    DECLARE @id_dc INT;
    UPDATE dbo.DiaChi SET TenDC = @tendc WHERE ID_DC = (SELECT ID_DC FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);
    SET @id_dc = (SELECT ID_DC FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg);

    -- Cập nhật thông tin bảng PhieuGiaoHang
    UPDATE dbo.PhieuGiaoHang
    SET 
        NgayGiao = @ngaygiao,
        TrangThaiGH = @ttgiaohang,
        TrangThaiTT = @ttthanhtoan,
        GhiChu = @ghichu,
        ID_KH = @id_kh,
        ID_NV = @id_nv,
        ID_HD = @id_hd,
        ID_DC = @id_dc
    WHERE ID_GH = @id_pg;
END;

IF OBJECT_ID('delete_PhieuGiaoHang') IS NOT NULL
DROP PROCEDURE delete_PhieuGiaoHang
GO

CREATE PROCEDURE delete_PhieuGiaoHang
    @id_pg INT
AS
BEGIN
    SET NOCOUNT ON;
    -- Xóa dữ liệu từ bảng PhieuGiaoHang
    DELETE FROM dbo.PhieuGiaoHang WHERE ID_GH = @id_pg;
    -- Xóa dữ liệu từ các bảng liên quan (KhachHang, NhanVien, HoaDon, DiaChi) nếu cần
    DECLARE @id_kh INT, @id_nv INT, @id_hd INT, @id_dc INT;
    -- Lấy các ID từ bảng PhieuGiaoHang
    SELECT @id_kh = ID_KH, @id_nv = ID_NV, @id_hd = ID_HD, @id_dc = ID_DC
    FROM dbo.PhieuGiaoHang
    WHERE ID_GH = @id_pg;
    -- Xóa dữ liệu từ bảng KhachHang
    IF @id_kh IS NOT NULL
        DELETE FROM dbo.KhachHang WHERE ID_KH = @id_kh;
    -- Xóa dữ liệu từ bảng NhanVien
    IF @id_nv IS NOT NULL
        DELETE FROM dbo.NhanVien WHERE ID_NV = @id_nv;
    -- Xóa dữ liệu từ bảng HoaDon
    IF @id_hd IS NOT NULL
        DELETE FROM dbo.HoaDon WHERE ID_HD = @id_hd;
    -- Xóa dữ liệu từ bảng DiaChi
    IF @id_dc IS NOT NULL
        DELETE FROM dbo.DiaChi WHERE ID_DC = @id_dc;
END;

select *from DiaChi
select*from NhanVien
select*from KhachHang