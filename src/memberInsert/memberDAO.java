package memberInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;

public class memberDAO implements memberIn{

	private static memberDAO dao = new memberDAO();
	
	private memberDAO() {
		
	}
	
	public static memberDAO getInstance() {
		return dao;
	}
	
	
	
	@Override
	public boolean memberInsert(memberDTO dto) {
		String sql = "INSERT INTO USERINFO VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 memberInsert");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 memberInsert");
			
			psmt.setString(1, dto.getid());
			psmt.setString(2, dto.getpwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getPhone());
			psmt.setString(6, dto.getGender());
			psmt.setInt(7, dto.getAge());
			psmt.setString(8, dto.getAddress());
			psmt.setString(9, dto.getEtc());
			psmt.setInt(10, dto.getPoint());
			psmt.setInt(11, dto.getAuth());
			
			count = psmt.executeUpdate();
			System.out.println("3/6 memberInsert");
			
		} catch (SQLException e) {
			System.out.println("addMember fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		
		return count>0?true:false;
	}

	@Override
	public boolean memberLogin(String id, String pwd) {
		String sql = " SELECT PWD FROM USERINFO WHERE ID=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean aa = false;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				String pw = rs.getString(1);
				if(pwd.equals(pw)) {
					aa = true;
				} else {
					aa = false;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		
		return aa;
	}

	@Override
	public boolean idchk(String id) {
		String sql = " SELECT ID FROM USERINFO "
				+ " WHERE ID=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String idcheck = "";
		
		boolean a = false;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1 idchk suc");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2 idchk suc");
			
			psmt.setString(1, id.trim());
			
			rs = psmt.executeQuery();
			System.out.println("3 idchk suc");
			
			if(rs.next()) {
				idcheck = rs.getString(1);
				
				if(id.equals(idcheck)) {
					System.out.println("아이디가 동일 합니다");
					a = true;
				} else {
					System.out.println("아이디가 동일하지 않습니다");
					a = false;
				}

			
			}
		} catch (SQLException e) {
			System.out.println("idchk fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return a;
	}

}
