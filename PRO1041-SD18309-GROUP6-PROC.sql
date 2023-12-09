
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

IF OBJECT_ID('insert_SanPhamCT') IS NOT NULL
DROP PROCEDURE insert_SanPhamCT
GO

CREATE PROC insert_SanPhamCT
	@TenSP NVARCHAR(50), @nhaCungCap NVARCHAR(50), @ngaySX DATE,
	 @DonGia MONEY, @Hinh NVARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @id_ncc INT;
	INSERT INTO dbo.NhaCungCap(TenCT) VALUES(@nhaCungCap);
	SET @id_ncc = SCOPE_IDENTITY();	
	
	INSERT INTO SanPham(TenSP, ID_NCC, NgaySanXuat, DonGia, Hinh) VALUES
		(@TenSP,@id_ncc,@ngaySX,@DonGia, @Hinh);
END;
GO
--- Cập nhật
IF OBJECT_ID('update_SanPham') IS NOT NULL
DROP PROCEDURE update_SanPham
GO

CREATE PROC update_SanPham
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

---Chi tiết SP
IF OBJECT_ID('update_SanPhamCT') IS NOT NULL
DROP PROCEDURE update_SanPhamCT
GO

CREATE PROCEDURE update_SanPhamCT
	@idSP INT,
	@TenSP NVARCHAR(50),
	@nhaCungCap NVARCHAR(50),
	@ngaySX DATE,
	@DonGia MONEY,
	@Hinh NVARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @id_ncc INT;

	-- Kiểm tra xem sản phẩm có tồn tại hay không
	IF NOT EXISTS (SELECT 1 FROM dbo.SanPham WHERE ID_SP = @idSP)
	BEGIN
		RAISERROR (N'Sản phẩm không tồn tại.', 16, 1);
		RETURN;
	END

	-- Kiểm tra xem nhà cung cấp có tồn tại hay không, nếu không thì thêm mới
	IF NOT EXISTS (SELECT 1 FROM dbo.NhaCungCap WHERE TenCT = @nhaCungCap)
	BEGIN
		INSERT INTO dbo.NhaCungCap(TenCT) VALUES (@nhaCungCap);
		SET @id_ncc = SCOPE_IDENTITY();
	END
	ELSE
	BEGIN
		SELECT @id_ncc = ID_NCC FROM dbo.NhaCungCap WHERE TenCT = @nhaCungCap;
	END

	-- Cập nhật thông tin sản phẩm
	UPDATE dbo.SanPham
	SET 
		TenSP = @TenSP,
		ID_NCC = @id_ncc,
		NgaySanXuat = @ngaySX,
		DonGia = @DonGia,
		Hinh = @Hinh
	WHERE ID_SP = @idSP;
END;
GO


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

SELECT *FROM SanPham

--Chi tiết sản phẩm
IF OBJECT_ID('delete_SanPhamCT') IS NOT NULL
DROP PROCEDURE delete_SanPhamCT
GO

CREATE PROCEDURE delete_SanPhamCT
	@idSP INT
AS
BEGIN
	SET NOCOUNT ON;

	-- Kiểm tra xem sản phẩm có tồn tại hay không
	IF NOT EXISTS (SELECT 1 FROM dbo.SanPham WHERE ID_SP = @idSP)
	BEGIN
		RAISERROR ('Sản phẩm không tồn tại.', 16, 1);
		RETURN;
	END

	-- Xóa sản phẩm
	DELETE FROM dbo.SanPham WHERE ID_SP = @idSP;
END;
GO


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


--MẠNH

IF OBJECT_ID('ins_PhieuGiamGia1') IS NOT NULL
DROP PROCEDURE ins_PhieuGiamGia1
GO

CREATE PROCEDURE ins_PhieuGiamGia1
    @tendgg NVARCHAR(50),
    @masp INT,
    @hinhthucgg NVARCHAR(50),
    @ngaybatdau DATE,
    @ngayhh DATE,
    @gaitrigg NVARCHAR(50),
    @trangthai BIT,
    @dieukien NVARCHAR(50),
    @mota NVARCHAR(250)
AS
BEGIN
    SET NOCOUNT ON;
	DECLARE @iddgg INT;
    INSERT INTO dbo.DotGiamGia (TeNDGG)
    VALUES (@tendgg);
    SET @iddgg = SCOPE_IDENTITY();

	DECLARE @iddieukien INT;
    INSERT INTO GiamGiaTheoKH (Hinhthuc)
    VALUES ( @dieukien);
    SET @iddieukien = SCOPE_IDENTITY();

   INSERT INTO dbo.PhieuGiamGia (ID_DGG, ID_SP,ID_TKH, NgayBatDau, NgayHH, GiaTriGG, TrangThai,Hinhthuc, MoTa)
    VALUES (@iddgg, @masp, @iddieukien, @ngaybatdau, @ngayhh, @gaitrigg, @trangthai,@hinhthucgg, @mota);
END;
GO

CREATE PROCEDURE delete_PhieuGiamGia
    @id_dgg INT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @id_tkh INT, @id_dgg_parent INT;

    -- Lấy ID_TKH và ID_DGG từ bảng PhieuGiamGia
    SELECT @id_tkh = ID_TKH, @id_dgg_parent = ID_DGG
    FROM dbo.PhieuGiamGia
    WHERE ID_DGG = @id_dgg;

    -- Xóa dữ liệu từ bảng PhieuGiamGia
    DELETE FROM dbo.PhieuGiamGia WHERE ID_DGG = @id_dgg;

    -- Xóa dữ liệu từ bảng GiamGiaTheoKH nếu có
    IF @id_tkh IS NOT NULL
        DELETE FROM dbo.GiamGiaTheoKH WHERE ID_TKH = @id_tkh;

    -- Xóa dữ liệu từ bảng DotGiamGia nếu có
    IF @id_dgg_parent IS NOT NULL
        DELETE FROM dbo.DotGiamGia WHERE ID_DGG = @id_dgg_parent;
END;

--Thêm

CREATE PROCEDURE ins_PhieuGiamGia2
    @tendgg NVARCHAR(50),
    @masp INT,
    @hinhthucgg NVARCHAR(50),
    @ngaybatdau DATE,
    @ngayhh DATE,
    @gaitrigg NVARCHAR(50),
    @trangthai BIT,
    @dieukien NVARCHAR(50),
    @mota NVARCHAR(250)
AS
BEGIN
    SET NOCOUNT ON;
	DECLARE @iddgg INT;
    INSERT INTO dbo.DotGiamGia (TeNDGG)
    VALUES (@tendgg);
    SET @iddgg = SCOPE_IDENTITY();

    DECLARE @idtsp NVARCHAR;
    INSERT INTO dbo.GiamGiaTheoSP (Hinhthuc)
    VALUES (@hinhthucgg);
    SET @idtsp = SCOPE_IDENTITY();

	DECLARE @idtsp2 NVARCHAR;
    INSERT INTO dbo.GiamGiaTheoKH (DieuKienGG)
    VALUES ( @dieukien);
    SET @idtsp2 = SCOPE_IDENTITY();

    INSERT INTO dbo.PhieuGiamGia (ID_DGG, ID_SP, ID_TSP, NgayBatDau, NgayHH, GiaTriGG, TrangThai,ID_TKH, MoTa)
    VALUES (@iddgg, @masp, @idtsp, @ngaybatdau, @ngayhh, @gaitrigg, @trangthai,@idtsp2, @mota);
    

END;
GO


--Phong
CREATE PROC insert_NhanVien_TaiKhoan
	@id_Cv INT, @ten NVARCHAR(50), @email NVARCHAR(50), @sdt NVARCHAR(11),
	@gioitinh BIT, @ngaysinh DATE, @diachi NVARCHAR(250), @tk NVARCHAR(50),
	@mk NVARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @id_tk INT;
	INSERT INTO dbo.TaiKhoan (TenTK, MatKhau) VALUES(@tk,@mk);
	SET @id_tk = SCOPE_IDENTITY();

	INSERT INTO dbo.NhanVien (ID_CV, ID_TK, TenNV, Email, SoDienThoai, GioiTinh, NgaySinh, DiaChi) VALUES
		(@id_Cv,@id_tk,@ten,@email,@sdt,@gioitinh,@ngaysinh,@diachi);
END;

EXEC dbo.insert_NhanVien_TaiKhoan 
	@id_Cv = ?, @ten = ?, @email = ?, @sdt = ?, @gioitinh = ?,
	@ngaysinh = ?, @diachi = ?, @tk = ?, @mk = ?;

-- Hồng
IF OBJECT_ID('insert_DotGiamGia') IS NOT NULL
DROP PROCEDURE insert_DotGiamGia
GO

--Insert
CREATE PROCEDURE insert_DotGiamGia
	@TenSP NVARCHAR(50), @TenKH NVARCHAR(50),@TeNDGG NVARCHAR(500), @GiaTriGG NVARCHAR(250),  @NgayBatDau DATE,
	@NgayKetThuc DATE, 
	@DieuKienGiamGia NVARCHAR(50), @MoTa NVARCHAR(250)
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @id_tsp INT;
	INSERT INTO dbo.DotGiamGiaTheoSP(TenSP) VALUES(@TenSP);
	SET @id_tsp = SCOPE_IDENTITY();	
	DECLARE @id_tkh INT;
	INSERT INTO dbo.DotGiamGiaTheoKH(TenKH) VALUES(@TenKH);
	SET @id_tkh = SCOPE_IDENTITY();

	INSERT INTO DotGiamGia( ID_TSP, ID_TKH,TeNDGG, GiaTriGG, NgayBatDau, NgayKetThuc,  DieuKienGiamGia, MoTa) VALUES
		( @id_tsp, @id_tkh, @TeNDGG, @GiaTriGG, @NgayBatDau, @NgayKetThuc,@DieuKienGiamGia,@MoTa);
END;

EXECUTE insert_DotGiamGia N'a', N'KH2', N'rfskdj', N'20%', '2023-02-13', '2023-02-20', N'ẻwf', N'srw'
SELECT * FROM DotGiamGia
-- Cập nhật
IF OBJECT_ID('update_DotGiamGia') IS NOT NULL
DROP PROCEDURE update_DotGiamGia
GO

CREATE PROCEDURE update_DotGiamGia
	@id_dgg INT,
	@TenSP NVARCHAR(50), 
	@TenKH NVARCHAR(50),
	@TeNDGG NVARCHAR(500),
	@GiaTriGG NVARCHAR(250), 
	@NgayBatDau DATE,
	@NgayKetThuc DATE, 
	@DieuKienGiamGia NVARCHAR(50), 
	@MoTa NVARCHAR(250)
AS
BEGIN
    SET NOCOUNT ON;

    -- Cập nhật thông tin bảng DotGiamGiaTheoSP
    DECLARE @id_tsp INT;
    UPDATE dbo.DotGiamGiaTheoSP SET TenSP = @TenSP WHERE ID_TSP = (SELECT ID_TSP FROM dbo.DotGiamGiaTheoSP WHERE ID_DGG = @id_dgg);
    SET @id_tsp = (SELECT ID_TSP FROM dbo.DotGiamGiaTheoSP WHERE ID_DGG = @id_dgg);

    -- Cập nhật thông tin bảng DotGiamGiaTheoKH
    DECLARE @id_tkh INT;
    UPDATE dbo.DotGiamGiaTheoKH SET TenKH = @TenKH WHERE ID_TKH = (SELECT ID_TKH FROM dbo.DotGiamGiaTheoKH WHERE ID_DGG = @id_dgg);
    SET @id_tkh = (SELECT ID_TKH FROM dbo.DotGiamGiaTheoKH WHERE ID_DGG = @id_dgg);

    UPDATE dbo.DotGiamGia
    SET 
        ID_TSP = @id_tsp,
        ID_TKH = @id_tkh,
		TeNDGG = @TeNDGG,
		GiaTriGG = @GiaTriGG,
        NgayBatDau = @NgayBatDau,
        NgayKetThuc = @NgayKetThuc,
        DieuKienGiamGia = @DieuKienGiamGia,
        MoTa = @MoTa
    WHERE ID_DGG = @id_dgg;
END;

-- Xóa
IF OBJECT_ID('delete_DotGiamGia') IS NOT NULL
DROP PROC delete_DotGiamGia
GO

CREATE PROC delete_DotGiamGia
    @id_dgg INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Xóa dữ liệu từ bảng DotGiamGia
    DELETE FROM dbo.DotGiamGia WHERE ID_DGG = @id_dgg;
	-- Xóa dữ liệu từ các bảng liên quan 
    DECLARE @id_tsp INT, @id_tkh INT;
	-- Lấy các ID từ bảng DotGiamGi
    SELECT @id_tsp = ID_TSP, @id_tkh = ID_TKH
    FROM dbo.DotGiamGia
    WHERE ID_DGG = @id_dgg;
    -- Xóa dữ liệu từ bảng DotGiamGiaTheoSP
    IF @id_tsp IS NOT NULL
        DELETE FROM dbo.DotGiamGiaTheoSP WHERE ID_TSP = @id_tsp;

    -- Xóa dữ liệu từ bảng DotGiamGiaTheoKH
    IF @id_tkh IS NOT NULL
        DELETE FROM dbo.DotGiamGiaTheoKH WHERE ID_TKH = @id_tkh;
END;

--Quên mật khẩu
IF OBJECT_ID('pro_QuenMatKhau') IS NOT NULL
DROP PROCEDURE pro_QuenMatKhau
GO

CREATE PROC pro_QuenMatKhau
	@email NVARCHAR(50),
	@mk NVARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON 
	DECLARE @id_Tk INT;
	SELECT @id_Tk = ID_TK FROM dbo.NhanVien WHERE Email = @email;
	IF @id_Tk IS NOT NULL 
		UPDATE dbo.TaiKhoan SET MatKhau = @mk WHERE ID_TK = @id_Tk
END;

EXEC dbo.pro_QuenMatKhau  @email = ?, @mk = ?
