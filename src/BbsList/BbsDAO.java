package BbsList;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import db.DBClose;
import db.DBConnection;

public class BbsDAO implements iBbsList {
	
	private static BbsDAO bbs = new BbsDAO();
	
	private BbsDAO() {
		
	}
	
	public static BbsDAO getInstance() {
		return bbs;
	}
	

	@Override
	public List<BbsDTO> getBbsList(String searchWord, String choice) {
		
		
		String sql1 = "SELECT SEQ, ID, REF, STEP, DEPTH, QATYPE, TITLE, CONTENT, WDATE, PARENT, IMAGE, DEL, READCOUNT FROM QABOARD " 
				+ " ORDER BY REF DESC, STEP ASC";
		

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDTO> list = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			while(rs.next()) {		
				int seq = rs.getInt(1);
				String id = rs.getString(2);
				int ref = rs.getInt(3);
				int step = rs.getInt(4);
				int depth = rs.getInt(5);
				String qatype = rs.getString(6);
				String title = rs.getString(7);
				String content = rs.getString(8);
				String wdate = rs.getString(9);
				int parent = rs.getInt(10);
				String image = rs.getString(11);
				int del = rs.getInt(12);
				int readcount = rs.getInt(13);
				BbsDTO dto = new BbsDTO(seq, id, ref, step, depth, qatype, title, content, wdate, parent, image, del, readcount);
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return list;
	}

	@Override
	public boolean BbsInsert(String id, String qnatype, String title, String content, String image) {
		String sql = " INSERT INTO QABOARD(SEQ, ID, REF, STEP, DEPTH, QATYPE, TITLE, CONTENT, WDATE, PARENT, IMAGE, DEL, READCOUNT) " 
				+  " VALUES(SEQ_QABOARD.nextval, ?, (SELECT NVL(MAX(REF),0)+1 FROM QABOARD),0,0,?, ?, ?, SYSDATE, 0, ?, 0, 0)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count=0;
		
		

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, qnatype);
			psmt.setString(3, title);
			psmt.setString(4, content);
			psmt.setString(5, image);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		
		return count>0?true:false;
	}

	@Override
	public BbsDTO getBbsSelect(int seq) {
		String sql = " select SEQ, ID, REF, STEP, DEPTH, QATYPE, TITLE, CONTENT, WDATE, PARENT, IMAGE, DEL, READCOUNT  from qaboard where seq = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BbsDTO dto = null;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				
				int seqs = rs.getInt(1);
				String id = rs.getString(2);
				int ref = rs.getInt(3);
				int step = rs.getInt(4);
				int depth = rs.getInt(5);
				String qatype = rs.getString(6);
				String title = rs.getString(7);
				String content = rs.getString(8);
				String wdate = rs.getString(9);
				int parent = rs.getInt(10);
				String image = rs.getString(11);
				int del = rs.getInt(12);
				int readcount = rs.getInt(13);
				
				dto = new BbsDTO(seqs, id, ref, step, depth, qatype, title, content, wdate, parent, image, del, readcount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		
		
		return dto;
	}
	
	
	@Override
	public String getFileSelect(String seq) {
		String sql = " select image from qaboard where seq= ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String result = "";
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return result;
	}

	@Override
	public boolean BbsUpdate(String seq, String id, String qnatype, String title, String content, String all) {
		String sql = " UPDATE QABOARD SET QATYPE = ?, TITLE = ?, CONTENT = ?, IMAGE = ? WHERE SEQ = ?";
		System.out.println("[BbsUpdateDAO] 시작");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, qnatype);
			psmt.setString(2, title);
			psmt.setString(3, content);
			psmt.setString(4, all);
			psmt.setString(5, seq);
			count = psmt.executeUpdate();
			System.out.println("[BbsUpdateDAO] DB DAO 결과 값  = " + count );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		System.out.println("[BbsUpdateDAO] DAO 종료");
		return count>0?true:false;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
