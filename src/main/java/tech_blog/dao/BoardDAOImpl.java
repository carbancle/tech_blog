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
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setUserId(rs.getString("user_id"));
				boards.add(b);
				// System.out.println(boards);
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
	public Board findBoardByUserId(String userId) {
		Connection conn = null;
		PreparedStatement ps;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM board WHERE user_id = ? AND board.user_id = users.user_id");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Board(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}

	@Override
    public boolean save(Board board) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("INSERT INTO board (title, content, user_id) VALUES (?, ?, ?)");
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getContent());
            ps.setString(3, board.getUserId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

	@Override
	public boolean update(Board board) {
		Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("UPDATE board SET title = ?, content = ?, user_id = ? WHERE id = ?");
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getContent());
            ps.setString(3, board.getUserId());
            ps.setInt(4, board.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
	}

	@Override
	public boolean delete(int id, String userId) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM board WHERE id = ? AND user_id = ?");
			ps.setInt(1, id);
			ps.setString(2, userId);
			
			int affectedRows = ps.executeUpdate();
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return false;
	}

	@Override
	public Board findBoardById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM board WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Board(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getString("user_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return null;
	}

	@Override
	public List<Board> findBoardByKeyword(String keyword) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM board WHERE title LIKE ?");
			
			ps.setString(1, "%" + keyword + "%");
			
			
			List<Board> boards = new ArrayList<>();
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Board b = new Board();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setUserId(rs.getString("user_id"));
				boards.add(b);
				System.out.println(boards + "boards??");
			}
			// System.out.println(rs);
			return boards;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}
}
