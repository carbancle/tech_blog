package tech_blog.dao;

import java.util.List;

import tech_blog.model.Board;

public interface BoardDAO {
	// 전체 게시물 조회
	List<Board> findAllBoard();
	// 등록한 작성자의 게시글 조회
	Board findByBoardUserId(String userId);
	// 게시글 작성하기
	boolean save(Board board);
	// 게시글 수정하기
	boolean update(Board board);
	// 게시글 삭제하기
	boolean delete(String id, String userId);
}
