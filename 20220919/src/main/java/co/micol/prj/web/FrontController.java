package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.main;
import co.micol.prj.common.Command;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;
import co.micol.prj.notice.command.NoticeEditForm;
import co.micol.prj.notice.command.NoticeInsert;
import co.micol.prj.notice.command.NoticeSelect;
import co.micol.prj.notice.command.NoticeSelectList;
import co.micol.prj.notice.command.NoticeWriteFrom;
import co.micol.prj.notice.command.NoticeDelete;
import co.micol.prj.notice.command.NoticeEdit;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// map에 명령집단 담기 위해
	private HashMap<String, Command> map = new HashMap<String, Command>();
    
    public FrontController() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException {
		// 명령집단 저장하는 곳
		map.put("/main.do", new main());
		map.put("/noticeSelectList.do", new NoticeSelectList());
		map.put("/noticeWriteFrom.do", new NoticeWriteFrom()); // 글쓰기
		map.put("/noticeInsert.do", new NoticeInsert()); // 등록
		map.put("/noticeSelect.do", new NoticeSelect()); //notice 상세조회
		map.put("/noticeEditForm.do", new NoticeEditForm()); // 게시글 수정 폼
		map.put("/noticeEdit.do", new NoticeEdit()); // 수정누르면 실행
		map.put("/noticeDelete.do", new NoticeDelete()); //게시글 삭제
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogout.do", new MemberLogout());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제수행할 서비스
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				// ajax 처리
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			} else { 
				if(viewPage.startsWith("no:")) //tiles안태울때
					viewPage = "/WEB-INF/views/" + viewPage.substring(3) + ".jsp"; 
				else {
					viewPage = viewPage + ".tiles"; //tiles layout 사용
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
					dispatcher.forward(request, response);
				}
			}
		} else { //.do일때
			response.sendRedirect(viewPage);
		}
	}
		

}
