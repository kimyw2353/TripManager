package review.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import common.model.DAOTripManagerBase;

public class ReviewDAO extends DAOTripManagerBase{

	private final String NS="common.mapper.ReviewMapper";
	
	public ReviewDAO() {
		System.out.println("ReviewDAO()생성자...");
	}
	
	//총 리뷰 수
	public int getTotalCount(int loc_num) {
		try(SqlSession ses=this.getSessionFactory().openSession(true)){
			int count=ses.selectOne(NS+".getTotalCount",loc_num);
			return count;
		}
		
	}
	
	//전체 리뷰 나오게하기
	public List<ReviewVO> review(int loc_num, int start, int end) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			Map<String, Object> map = new HashMap<>();
			map.put("loc_num", loc_num);
			map.put("start",start);
			map.put("end", end);
			List<ReviewVO> arr = ses.selectList(NS+".review",map);
			return arr;
		}
	}
	
	//조회수 증가
	public int updateReadnum(int re_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			int n = ses.update(NS+".updateReadnum", re_num);
			return n;
		}
	}
	
	//글 번호에 해당하는 리뷰만 나오게하기
	public ReviewVO reviewchk(int re_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			ReviewVO vo = ses.selectOne(NS+".reviewChk", re_num);
			return vo;
		}
	}

	public int insertReview(ReviewVO vo) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			System.out.println("지역번호"+vo.getLoc_num());
			int n=ses.insert(NS+".insertReview", vo);
			return n;
		}
		
	}

	public List<ReviewVO> reviewList(String u_id, int loc_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			Map<String, Object> map = new HashMap<>();
			map.put("u_id", u_id);
			map.put("loc_num",loc_num);
			List<ReviewVO> arr = ses.selectList(NS+".reviewList",map);
			return arr;
		}
	}

	public int deleteReview(ReviewVO vo) {
		try(SqlSession ses = this.getSessionFactory().openSession(false)){
			int cnt = ses.selectOne(NS+".getCommentCountByIdx", vo);
			System.out.println(cnt);
			if(cnt>0) {			
			//댓글 먼저 삭제 처리
			int n1 = ses.delete(NS+".deleteCommentAll", vo);
			if(n1>0) {
				//댓글 삭제를 성공했다면 부모글 삭제 처리
				int n=ses.delete(NS+".deleteReview", vo);
				if(n>0) {
					ses.commit();//모두 삭제되면 commit()
				}else {
					ses.rollback();//부모글 삭제를 실패하면 모두 취소 rollback()
				}				
				}else {
					//댓글 삭제를 실패했다면 rollback();
					ses.rollback();
				}
				return n1;
			}else {
				//댓글이 없다면=> 부모글 삭제 처리
				int n=ses.delete(NS+".deleteReview", vo);
				if(n>0) ses.commit();
				else ses.rollback();
				return n;
			}
		}
	}

	public ReviewVO updateList(int re_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			ReviewVO vo = ses.selectOne(NS+".updateList", re_num);
			return vo;
		}
	}

	public int updateReview(ReviewVO vo) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			int n=ses.insert(NS+".updateReview", vo);
			return n;
		}
	}
}