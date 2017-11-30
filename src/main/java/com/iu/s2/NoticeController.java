package com.iu.s2;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {

	@Inject
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
	public String selectOne(Model model, int num){
		try {
			noticeService.selectOne(num, model);
			model.addAttribute("board", "notice");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/boardView";
	}
}
