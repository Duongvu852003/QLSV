
package edu.poly.poly.app.down;

import edu.poly.poly.app.helpers.DatabaseHelper;
import edu.poly.poly.app.model.NguoiDung;
import edu.poly.poly.app.model.SinhVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.serial.SerialBlob;

public class SinhVienDown {
    public Boolean insert(SinhVien sv)
            //throws Exception không bắt sử dụng ngoại lệ
            throws Exception {
        // tạo câu lệnh truy vấn
        String spl = "INSERT INTO [dbo].[SinhVien]([MaSinhVien], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh])"+
                "values(?, ?, ?, ?, ?, ?, ?)";
         

        try (
                // Connection con = DatabaseHelper.openConnection()) : mở kết nối
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareCall(spl);
                ){
            pstmt.setString(1, sv.getMaSinhVien());
            pstmt.setString(2, sv.getHoTen());
            pstmt.setString(3, sv.getEmail());
            pstmt.setString(4, sv.getSoDT());
            pstmt.setInt(5, sv.getGioiTinh());
            pstmt.setString(6, sv.getDiaChi());
            if(sv.getHinh()!= null){
            Blob hinh = new SerialBlob(sv.getHinh());
            pstmt.setBlob(7, hinh);
            }
            else{
                Blob hinh = null;
            pstmt.setBlob(7, hinh);
            }
            //executeQuery(): Thực hiện câu lệnh truy vấn
         
            return pstmt.executeUpdate() > 0;
            // 
        }
    }

}
