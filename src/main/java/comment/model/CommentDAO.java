package comment.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import common.model.DAOTripManagerBase;

public class CommentDAO extends DAOTripManagerBase{
	
	private final String NS="common.mapper.CommentMapper";
	
	public CommentDAO() {
		System.out.println("CommentDAO()»ý¼ºÀÚ...");
	}
	
	public List<CommentVO> commentList(int re_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			List<CommentVO> arr = ses.selectList(NS+".commentList",re_num);
			return arr;
		}
	}

	public int insetComment(CommentVO rvo) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			int n = ses.insert(NS+".insertComment", rvo);
			return n;
		}
	}

	public int deleteComment(int re_num, String u_id, String com_content) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			Map<String, Object> map = new HashMap<>();
			map.put("re_num", re_num);
			map.put("u_id",u_id);
			map.put("com_content",com_content);
			int n = ses.insert(NS+".deleteComment", map);
			return n;
		}
	}
}
