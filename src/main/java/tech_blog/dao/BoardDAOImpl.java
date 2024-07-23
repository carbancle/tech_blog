package tech_blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech_blog.model.Board;
import tech_blog.util.DBUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<Board> findAllBoard() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BOARD");
			ResultSet rs = ps.executeQuery();
			
			List<Board> boards = new ArrayList<>();
			
			while (rs.next()) {
				Board b = new Board();
				b.setUserId(rs.getString("user_id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				boards.add(b);
				System.out.println(boards);
			}
			return boards;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}

	@Override
	public Board findByBoardUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
