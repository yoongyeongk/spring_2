package com.iu.s2;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="noticeList")
	public String selectList(Model model, ListData listData){
		
		try {
			noticeService.selectList(listData, model);
			
			model.addAttribute("board", "notice");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeView")
	public String selectOne(Model model, @RequestParam(defaultValue="0",required=false)int num){
		try {
			BoardDTO boardDTO = noticeService.selectOne(num);
			model.addAttribute("view", boardDTO);
			model.addAttribute("board", "notice");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/boardView";
	}
	
	@RequestMapping(value="noticeWrite", method={RequestMethod.GET})
	public String insert(Model model){
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeWrite", method={RequestMethod.POST})
	public String insert(RedirectAttributes rd,NoticeDTO boardDTO, HttpSession session){
/*
		//파일 경로 구하기
		String filePath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(filePath);
		
		//해당 경로에 파일이 없을 시 새로 만들기
				if(!f.exists()){
					f.mkdirs();
				}
				
				System.out.println("path:"+filePath);
				
				for(MultipartFile file: files){
					String fileName = file.getOriginalFilename();
					f = new File(filePath, fileName);
					String name = UUID.randomUUID().toString();
					fileName = name + fileName.substring(fileName.lastIndexOf("."));
					
					f = new File(filePath, fileName);
					try {
						file.transferTo(f);
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}*/
				int result = 0;
				try {
					result = noticeService.insert(boardDTO, session);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String message="fail";
				if(result>0){
					message="Success";
				}
				rd.addFlashAttribute("message", message);
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeDelete")
	public String delete(RedirectAttributes rd ,int num, HttpSession session){
		
		int result = 0;
		try {
			result = noticeService.delete(num, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "fail";
		if(result>0){
			message="success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(int num, Model model){
		try {
			BoardDTO boardDTO = noticeService.selectOne(num);
			model.addAttribute("view", boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO, HttpSession session, RedirectAttributes rd){
		
		try {
			int result = noticeService.update(noticeDTO, session);
			
			String message = "fail";
			if(result>0){
				message = "success";
			}
			rd.addFlashAttribute("message", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:./noticeList";
	}
}
