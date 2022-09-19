package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session = request.getSession(); // 아이디 등 값이 담겨있음
		String name = (String) session.getAttribute("name"); // 세션에 담긴 이름 가져오기
		session.invalidate(); // 세션을 완전히 없애주는 것
		request.setAttribute("message", name + "님 정상적으로 로그아웃 되었습니다.");
		return "member/memberMessage";
	}

}
