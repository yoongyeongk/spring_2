package com.iu.qna;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;
	
	public void setQnaDAO(QnaDAO qnaDAO) {
		this.qnaDAO = qnaDAO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String filePath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filePath);
		int num = qnaDAO.getNum();
		
		FileDTO fileDTO = null;
		for(MultipartFile f: ((QnaDTO)boardDTO).getF1()){
			fileDTO = new FileDTO();
			fileDTO.setFilename(fileSaver.save2(filePath, f));
			fileDTO.setOriname(f.getOriginalFilename());
			fileDTO.setNum(num);
			fileDAO.insert(fileDTO);
		}
		boardDTO.setNum(num);
		
		return qnaDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String filePath = session.getServletContext().getRealPath("resources/upload");
		
		//qna update
		int result = qnaDAO.update(boardDTO);
		
		//file insert
		MultipartFile [] files = ((QnaDTO)boardDTO).getF1();
		if(files.length != 0){
			FileDTO fileDTO = null;
			for(MultipartFile f: files){
				fileDTO = new FileDTO();
				fileDTO.setFilename(fileSaver.save2(filePath, f));
				fileDTO.setOriname(f.getOriginalFilename());
				fileDTO.setNum(boardDTO.getNum());
				fileDAO.insert(fileDTO);
			}
		}
		
		return result;
	}

	@Override
	public int delete(int num, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String filePath = session.getServletContext().getRealPath("resources/upload");
		List<FileDTO> ar = fileDAO.selectList(num);
		if(ar.size() != 0){
			for(FileDTO fileDTO: ar){
				File file = new File(filePath, fileDTO.getFilename());
				if(file.exists()){
					file.delete();
				}
			}
			fileDAO.delete(num);
		}
		int result = qnaDAO.delete(num);
		
		return result;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.hitUpdate(num);
		List<FileDTO> ar = fileDAO.selectList(num);
		BoardDTO boardDTO = qnaDAO.selectOne(num);
		((QnaDTO)boardDTO).setAr(ar);
		
		return boardDTO;
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
