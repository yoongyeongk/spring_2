package com.iu.notice;

import java.util.List;

import javax.inject.Inject;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

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
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		
		//페이징 추가로 해야 함
		
		return noticeDAO.selectList();
	}

}
