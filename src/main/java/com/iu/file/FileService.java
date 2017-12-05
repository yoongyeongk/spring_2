package com.iu.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;

@Service
public class FileService {

	private FileSaver fileSaver;
	@Autowired
	private FileDAO fileDAO;
	
	//파일 저장
	public List<String> fileSave(MultipartFile [] f1, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		
		ArrayList<String> names = new ArrayList<String>();
		for(MultipartFile f: f1){
			names.add(fileSaver.save2(filePath, f));
		}
		
		return names;
	}
	
	//파일 삭제
	public int fileDelete(int fnum, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		String fileName = fileDAO.selectOne(fnum);
		File file = new File(filePath, fileName);
		if(file.exists()){
			file.delete();
		}
		int result = fileDAO.deleteOne(fnum);
		return result;
	}
}
