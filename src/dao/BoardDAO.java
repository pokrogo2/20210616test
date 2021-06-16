package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import dto.ReplyDTO;
import ub.util.DBConnector;

public class BoardDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {
		con = DBConnector.getInstance().getConnection();
	}
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	public List<BoardDTO> selectList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			
			sql = "SELECT * FROM BOARD ORDER BY NO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getLong(1));
				dto.setContent(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getLong(5));
				dto.setIp(rs.getString(6));
				dto.setPostdate(rs.getDate(7));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.getInstance().close(ps, null);
		}
		return list;
	}
	public int insertBoard(BoardDTO dto) {
		int result = 0;
		try {
			sql = "INSERT INTO BOARD(NO,AUTHOR,TITLE,CONTENT,HIT,IP,POSTDATE) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, 0,'test', SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAuthor());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	public void updateHit(Long no) {
		try {
			sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE no = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
	}
	public BoardDTO selectOneBoardByNo(Long no) {
		BoardDTO dto =null;
		try {
			sql = "SELECT NO,AUTHOR,TITLE,CONTENT,HIT,IP,POSTDATE  FROM BOARD WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setNo(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getLong(5));
				dto.setIp(rs.getString(6));
				dto.setPostdate(rs.getDate(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return dto;
	}
	public int insertReply(ReplyDTO dto) {
		int result = 0;
		try {
			sql = "INSERT INTO REPLY(NO,AUTHOR,CONTENT,IP,BOARD_NO,POSTDATE) VALUES (REPLY_SEQ.NEXTVAL, ?, ?,'127',?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAuthor());
			ps.setString(2, dto.getContent());;
			ps.setLong(3, dto.getBoardNo());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	public List<ReplyDTO> selectListReply(long no) {
		List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		try {
			sql = "SELECT NO, AUTHOR, CONTENT,IP, BOARD_NO,POSTDATE FROM REPLY WHERE BOARD_NO = ? ORDER BY POSTDATE";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setNo(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setIp(rs.getString(4));
				dto.setBoardNo(rs.getLong(5));
				dto.setPostdate(rs.getDate(6));
				replyList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return replyList;
	}
	public int deleteBoard(long no) {
		int result = 0;
		try {
			sql = "DELETE FROM BOARD WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
}
