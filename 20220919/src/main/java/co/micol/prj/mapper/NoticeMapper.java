package co.micol.prj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	// 조회수 증가
	void noticeHitUpdate(int id);
	// 게시글 검색 2개이상일 때 @Param 으로 
	List<NoticeVO> noticeSearchList(@Param("key") String Key, @Param("val") String val);
}
