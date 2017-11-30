package com.iu.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

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
	public void selectOne(int num, Model model) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.hitUpdate(num);
		model.addAttribute("view", qnaDAO.selectOne(num));
	}

	@Override
	public void selectList(ListData listData, Model model) throws Exception {
		// TODO Auto-generated method stub
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(qnaDAO.getTotalCount(rowNum));
		model.addAttribute("list", qnaDAO.selectList(rowNum));
		model.addAttribute("pager", pager);
	}

}
