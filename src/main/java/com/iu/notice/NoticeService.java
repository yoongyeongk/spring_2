package com.iu.notice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

public class NoticeService implements BoardService {

	@Inject
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		
	}
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
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
		noticeDAO.hitUpdate(num);
		model.addAttribute("view", noticeDAO.selectOne(num));
	}

	@Override
	public void selectList(ListData listData, Model model) throws Exception {
		// TODO Auto-generated method stub
		
		//페이징
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(noticeDAO.getTotalCount(rowNum));
		model.addAttribute("list", noticeDAO.selectList(rowNum));
		model.addAttribute("pager", pager);
	}

}
