package com.iu.s2;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String selectOne(Model model, int num){
		
		try {
			qnaService.selectOne(num, model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("board", "qna");
		
		return "board/boardView";
	}
}
