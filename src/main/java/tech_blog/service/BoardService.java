package tech_blog.service;

import java.util.List;

import tech_blog.model.Board;

public interface BoardService {
	List<Board> getFindAllBoard();
	List<Board> getFindBoardByKeword(String keyword);
	boolean createBoard(Board board);
	boolean updateBoard(Board board);
	boolean deleteBoard(int id, String userId);
	Board getBoardById(int id);
}
