package tech_blog.service;

import java.util.List;

import tech_blog.dao.BoardDAO;
import tech_blog.dao.BoardDAOImpl;
import tech_blog.model.Board;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO = new BoardDAOImpl();

	@Override
    public boolean createBoard(Board board) {
        try {
            return boardDAO.save(board);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return false;
    }

	@Override
	public Board getBoardById(int id) {
		return boardDAO.findBoardById(id); 
	}

	@Override
	public boolean updateBoard(Board board) {
		return boardDAO.update(board);
	}

	@Override
	public List<Board> getFindAllBoard() {
		return boardDAO.findAllBoard();
	}

	@Override
	public boolean deleteBoard(int id, String userId) {
		return boardDAO.delete(id, userId);
	}

	@Override
	public List<Board> getFindBoardByKeword(String keyword) {
		return boardDAO.findBoardByKeyword(keyword);
	}

}
