package com.iu.member;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;

@Service
public class MemberService {

	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileSaver fileSaver;
	
	public int insert(MemberDTO memberDTO, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filePath);
		
		//파일의 fname, oname 구해서 memberDTO에 넣기, 파일 저장
		if(memberDTO.getF1() != null){
			MultipartFile file = memberDTO.getF1();
			memberDTO.setOname(file.getOriginalFilename());
			memberDTO.setFname(fileSaver.save2(filePath, file));
		}
		int result = memberDAO.insert(memberDTO);
		
		return result;
	}
	
	public int login(MemberDTO memberDTO, HttpServletRequest request) throws Exception{
		//아이디 비밀번호로 확인
		MemberDTO memberDTO2 = memberDAO.selectOne(memberDTO);
		
		int result = 0;
		if(memberDTO2 != null){
			result = 1;
			//세션 등록
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO2);
		}
		
		return result;
	}
	
	public void logout(HttpSession session) throws Exception{
		session.invalidate();
	}
	
	public int update(MemberDTO memberDTO, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filePath);
		if(memberDTO.getF1() != null){
			memberDTO.setFname(fileSaver.save2(filePath, memberDTO.getF1()));
			memberDTO.setOname(memberDTO.getF1().getOriginalFilename());
		}else{
			memberDTO.setFname((memberDAO.selectOne(memberDTO.getId())).getFname());
		}
		int result = memberDAO.update(memberDTO);
		
		return result;
	}
	
	public int delete(String id, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		MemberDTO memberDTO = memberDAO.selectOne(id);
		if(memberDTO.getFname() != null){
			String fileName = memberDTO.getFname();
			File file = new File(filePath, fileName);
			if(file.exists()){
				file.delete();
			}
		}
		int result = memberDAO.delete(id);
		session.invalidate();
		
		return result;
	}
}
