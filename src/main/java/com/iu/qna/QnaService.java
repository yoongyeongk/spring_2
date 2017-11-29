package com.iu.qna;

import java.util.List;

import javax.inject.Inject;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	
	public QnaService() {
		// TODO Auto-generated constructor stub
	}

	public void setQnaDAO(QnaDAO qnaDAO) {
		this.qnaDAO = qnaDAO;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.selectList();
	}

}
