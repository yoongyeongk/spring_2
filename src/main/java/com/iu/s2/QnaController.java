package com.iu.s2;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.qna.QnaDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Inject
	private QnaService qnaService;

	@RequestMapping(value="qnaList")
	public String selectList(Model model, ListData listData){

			try {
				qnaService.selectList(listData, model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("board", "qna");
		
		return "board/boardList";
	}
	
	@RequestMapping(value="qnaView")
	public String selectOne(Model model, @RequestParam(defaultValue="0",required=false)int num){
		
		try {
			BoardDTO boardDTO = qnaService.selectOne(num);
			model.addAttribute("view", boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("board", "qna");
		
		return "board/boardView";
	}
	
	@RequestMapping(value="qnaWrite", method={RequestMethod.GET})
	public String insert(Model model){
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="qnaWrite", method={RequestMethod.POST})
	public String insert(RedirectAttributes rd, QnaDTO qnaDTO, HttpSession session){
		int result = 0;
		try {
			result = qnaService.insert(qnaDTO, session);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "fail";
		if(result>0){
			message = "success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./qnaList";
	}

	@RequestMapping(value="qnaDelete")
	public String delete(RedirectAttributes rd, int num, HttpSession session){
		
		int result = 0;
		try {
			result = qnaService.delete(num, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = "fail";
		if(result>0){
			message = "success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(Model model, int num){
		
		try {
			BoardDTO boardDTO = qnaService.selectOne(num);
			model.addAttribute("view", boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("board", "qna");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(RedirectAttributes rd, QnaDTO qnaDTO, HttpSession session){
		
		int result = 0;
		try {
			result = qnaService.update(qnaDTO, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = "fail";
		if(result>0){
			message = "success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./qnaList";
	}
	
}
