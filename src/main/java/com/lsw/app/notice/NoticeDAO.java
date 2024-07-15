package com.lsw.app.notice;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.util.PageOption;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.lsw.app.notice.NoticeDAO.";

	public List<NoticeDTO> list(PageOption pageOption) {
		return sqlSession.selectList(NAMESPACE + "list", pageOption);
	}

	public long getTotalCount(PageOption pageOption) {
		return 0;
	}

	public NoticeDTO detail(NoticeDTO noticeDTO) {
		return sqlSession.selectOne(NAMESPACE + "detail", noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) {
		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);
	}
	public int add(NoticeDTO noticeDTO) {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}
	public int update(NoticeDTO noticeDTO) {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);
	}

}
