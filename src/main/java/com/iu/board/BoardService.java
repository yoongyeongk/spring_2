package com.iu.board;

import java.util.List;

public interface BoardService {

	//insert
	public int insert(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(int num) throws Exception;
	
	//selectOne
	public BoardDTO selectOne(int num) throws Exception;
	
	//selectList
	public List<BoardDTO> selectList() throws Exception;
	
}
