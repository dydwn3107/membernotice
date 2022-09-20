package co.micol.prj.notice.command;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command { // cos 라이브러리를 사용해서 파일업로드 할때
	private String saveFolder = "c:\\fileUploadTest"; // 실제파일이 저장할 공간
	private String charactSet = "utf-8"; // 전송되는 한글 깨짐 방지
	private int maxSize = 1024*1024*1024; // 파일 최대 사이즈
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String viewPage = "notice/noticeError";
		//파일 업로드 저장
		String filename="";
		String originalFileName="";
		try {
			MultipartRequest multi = 
					new MultipartRequest(request, saveFolder, maxSize, charactSet, new DefaultFileRenamePolicy());
			filename = multi.getFilesystemName("file"); //물리적 위치에 파일저장
			originalFileName = multi.getOriginalFileName("file"); //실제 파일명
			// 게시글 등록
			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			vo.setNoticeAttech(originalFileName);
			vo.setNoticeAttechDir(saveFolder+File.separator+filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int n = dao.noticeInsert(vo);
		if(n != 0) { // 성공하면
			viewPage = "noticeSelectList.do";
		}else {
			request.setAttribute("message", "게시글 등록이 실패했습니다.");
		}
		return viewPage;
	}

}
