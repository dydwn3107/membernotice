package co.micol.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEditForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 수정 폼 호출
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		// 밑에 히든폼에 숨겨져있는 "id" 를 들고 오는 것
		vo.setNoticeId(Integer.valueOf(request.getParameter("id")));
		vo = dao.noticeSelect(vo);
		request.setAttribute("vo", vo); //실어서 보내는 것
		return "notice/noticeEditForm";
	}

}
