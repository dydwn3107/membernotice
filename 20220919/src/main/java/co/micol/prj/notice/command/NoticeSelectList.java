package co.micol.prj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지글 전체 목록 보기
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> lists = new ArrayList<NoticeVO>(); 
		lists = dao.noticeSelectList();
		request.setAttribute("list", lists);
		
		return "notice/noticeSelectList";
	}

}
