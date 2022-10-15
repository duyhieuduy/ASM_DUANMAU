package com.example.asm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelperne extends SQLiteOpenHelper {
    private static final String DB_NAME = "DB";
    private static final int DB_VERSION = 2;
//    static final String CREATE_TABLE_THU_THU =
//            "create table ThuThu ("+
//            "IDTT   TEXT PRIMARY KEY,"+
//            "hoTen   TEXT NOT NULL,"+
//            "matKhau TEXT NOT NULL)";
//    static final String CREATE_TABLE_THANH_VIEN =
//            "create table ThanhVien ("+
//                    "maTV    TEXT PRIMARY KEY,"+
//                    "hoTen   TEXT NOT NULL,"+
//                    "namSinh TEXT NOT NULL)";
//    static final String CREATE_TABLE_LOAI_SACH =
//            "create table LoaiSach ("+
//                    "maLoai  INTEGER PRIMARY KEY AUTOINCREMENT,"+
//                    "tenLoai TEXT    NOT NULL)";
//    static final String CREATE_TABLE_SACH =
//            "create table Sach ("+
//                    "maSach  INTEGER PRIMARY KEY AUTOINCREMENT,"+
//                    "tenSach TEXT    NOT NULL,"+
//                    "giaThue INTEGER NOT NULL,"+
//                    "maLoai  INTEGER REFERENCES LoaiSach (maLoai) )";
//    static final String CREATE_TABLE_PHIEU_MUON =
//            "create table PhieuMuon ("+
//                    "maPM     INTEGER PRIMARY KEY AUTOINCREMENT,"+
//                    "maTT     TEXT    REFERENCES ThuThu (maTT),"+
//                    "maTV     TEXT    REFERENCES ThanhVien (matv),"+
//                    "maSach   INTEGER REFERENCES Sach (maSach),"+
//                    "tienThue INTEGER NOT NULL,"+
//                    "ngay     DATE    NOT NULL,"+
//                    "traSach  INTEGER NOT NULL)";



    public DBhelperne(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_ThuThu = "CREATE TABLE ThuThu (maTT TEXT PRIMARY KEY," +
                                                    " hoTen TEXT NOT NULL," +
                                                    "matKhau TEXT NOT NULL)";
        db.execSQL(create_ThuThu);
        String create_LoaiSach = "CREATE TABLE LoaiSach (maLoai INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        " tenLoai TEXT NOT NULL)";
        db.execSQL(create_LoaiSach);
        String create_ThanhVien = "CREATE TABLE ThanhVien (maTV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                            "hoTen TEXT NOT NULL, " +
                                                            "namSinh TEXT NOT NULL)";
        db.execSQL(create_ThanhVien);
        String create_Sach = "CREATE TABLE Sach (maSach INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                " tenSach TEXT NOT NULL, " +
                                                "giaThue INTEGER NOT NULL, " +
                                                "maLoai INTEGER REFERENCES LoaiSach(maLoai))";
        db.execSQL(create_Sach);
        String create_PhieuMuon = "CREATE TABLE PhieuMuon (maPM INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                        "maTT TEXT REFERENCES ThuThu(maTT)" +
                                                        ",maTV INTEGER REFERENCES ThanhVien(maTV)," +
                                                        "maSach INTEGER REFERENCES Sach(maSach)," +
                                                        "tienThue INTEGER NOT NULL," +
                                                        "ngay DATE NOT NULL, " +
                                                        "traSach INTEGER NOT NULL)";
        db.execSQL(create_PhieuMuon);


        //inert du lieu mau
        String insThuThu = "INSERT INTO THUTHU VALUES('tt1','Nguyen Van Teo', 'tt123'),('tt2','Nguyen Van be', 'tt125'),('tt3','Nguyen Van Can', 'tt345'),('admin','hieupmps23989', '1')";
        db.execSQL(insThuThu);
        String insThanhVien = "INSERT INTO THANHVIEN VALUES (1, 'Tran Van Nam','2000'),(2, 'Tran van Binh','2002'),(3, 'Nguyen Thi be','1999'),(4, 'Le Thi Mai','2000')";
        db.execSQL(insThanhVien);
        String insLoaiSach = "INSERT INTO LOAISACH VALUES (1,'Công Nghệ Thông Tin'),(2,'Kinh Tế-chính Trị'),(3, 'Thiết kế đồ hoạ'), (4, 'Truyện trinh thám')";
        db.execSQL(insLoaiSach);
        String insSach = "INSERT INTO SACH VALUES (1, 'Lập trình java 1', 1500, 1),(2, 'Lập trình java 2', 5500, 1),(3, 'Android cơ bản', 2000, 1),(4, 'MacLeNin', 3500, 2),(5, 'Photoshop', 2000, 3)";
        db.execSQL(insSach);
        String insPhieuMuon = "INSERT INTO PHIEUMUON VALUES (1, 'tt1', 1, 2, 5500, '2022-10-09','Đa tra sach' ),(2, 'tt3', 3, 4, 3500, '2022-09-09','Chưa trả sach' )";
        db.execSQL(insPhieuMuon);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTableLoaiThuThu = "drop table if exists ThuThu";
        db.execSQL(dropTableLoaiThuThu);
        String dropTableLoaiThanhVien = "drop table if exists ThanhVien";
        db.execSQL(dropTableLoaiThanhVien);
        String dropTableLoaiLoaiSach = "drop table if exists LoaiSach";
        db.execSQL(dropTableLoaiLoaiSach);
        String dropTableLoaiSach = "drop table if exists Sach";
        db.execSQL(dropTableLoaiSach);
        String dropTableLoaiPhieuMuon = "drop table if exists PhieuMuon";
        db.execSQL(dropTableLoaiPhieuMuon);

        onCreate(db);
    }
}
