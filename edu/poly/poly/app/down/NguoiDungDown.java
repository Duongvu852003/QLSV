package edu.poly.poly.app.down;
// kiểm tra thông tin ở SQL

import edu.poly.poly.app.helpers.DatabaseHelper;
import edu.poly.poly.app.model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NguoiDungDown {

    public NguoiDung checkLogin(String tenDangNhap, String matKhau)
            //throws Exception không bắt sử dụng ngoại lệ
            throws Exception {
        // tạo câu lệnh truy vấn
        String spl = "select tenDangNhap, matKhau, vaitro from nguoidung"
                + "where tendangnhap = ? and matKhau = ?";

        try (
                // Connection con = DatabaseHelper.openConnection()) : mở kết nối
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareCall(spl);
                ){
            pstmt.setString(1, tenDangNhap);
            pstmt.setString(2, matKhau);
            //executeQuery(): Thực hiện câu lệnh truy vấn
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(tenDangNhap);
                    nd.setVaiTro(rs.getString("vaitro"));
                    return nd;
                }
                
            }
            return null;
        }
    }

}
