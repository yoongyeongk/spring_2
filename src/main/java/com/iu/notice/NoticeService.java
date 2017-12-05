package com.iu.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int num = noticeDAO.getNum();
		String filePath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filePath);
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		FileDTO fileDTO = null;
		for(MultipartFile f: ((NoticeDTO)boardDTO).getF1()){
			fileDTO = new FileDTO();
			fileDTO.setFilename(fileSaver.save2(filePath, f));
			fileDTO.setOriname(f.getOriginalFilename());
			fileDTO.setNum(num);
			files.add(fileDTO);
			fileDAO.insert(fileDTO);
		}
		
		boardDTO.setNum(num);
		
		return noticeDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		//notice 업데이트
		result = noticeDAO.update(boardDTO);
		
		//file 업데이트(새로 추가 시)
		String filePath = session.getServletContext().getRealPath("resources/upload");
		MultipartFile [] ar = ((NoticeDTO)boardDTO).getF1();
		if(ar.length != 0){
			FileDTO fileDTO = null;
			for(MultipartFile f: ar){
				fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setFilename(fileSaver.save2(filePath, f));
				fileDTO.setOriname(f.getOriginalFilename());
				fileDAO.insert(fileDTO);
			}
		}
		return result;
	}

	@Override
	public int delete(int num, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		String filePath = session.getServletContext().getRealPath("resources/upload");
		List<FileDTO> ar = fileDAO.selectList(num);
		if(ar.size() != 0){
			for(FileDTO fileDTO: ar){
				String fileName = fileDTO.getFilename();
				File file = new File(filePath, fileName);
				if(file.exists()){
					file.delete();
				}
			}
			result = fileDAO.delete(num);
		}
		result = noticeDAO.delete(num);
				
		return result;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.hitUpdate(num);
		NoticeDTO noticeDTO = (NoticeDTO)noticeDAO.selectOne(num);
		List<FileDTO> ar = fileDAO.selectList(num);
		noticeDTO.setAr(ar);
		return noticeDTO;
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
