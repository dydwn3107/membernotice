package co.micol.prj.notice.service;

import java.util.List;


public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	// 조회수 증가
	void noticeHitUpdate(int id);
	// 게시글 검색
	List<NoticeVO> noticeSearchList(String Key, String val);
}
