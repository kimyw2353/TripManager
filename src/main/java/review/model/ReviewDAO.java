package review.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import common.model.DAOTripManagerBase;

public class ReviewDAO extends DAOTripManagerBase{

	private final String NS="common.mapper.ReviewMapper";
	
	public ReviewDAO() {
		System.out.println("ReviewDAO()������...");
	}
	
	//�� ���� ��
	public int getTotalCount(int loc_num) {
		try(SqlSession ses=this.getSessionFactory().openSession(true)){
			int count=ses.selectOne(NS+".getTotalCount",loc_num);
			return count;
		}
		
	}
	
	//��ü ���� �������ϱ�
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
	
	//��ȸ�� ����
	public int updateReadnum(int re_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			int n = ses.update(NS+".updateReadnum", re_num);
			return n;
		}
	}
	
	//�� ��ȣ�� �ش��ϴ� ���丸 �������ϱ�
	public ReviewVO reviewchk(int re_num) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			ReviewVO vo = ses.selectOne(NS+".reviewChk", re_num);
			return vo;
		}
	}

	public int insertReview(ReviewVO vo) {
		try(SqlSession ses = this.getSessionFactory().openSession(true)){
			System.out.println("������ȣ"+vo.getLoc_num());
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
			//��� ���� ���� ó��
			int n1 = ses.delete(NS+".deleteCommentAll", vo);
			if(n1>0) {
				//��� ������ �����ߴٸ� �θ�� ���� ó��
				int n=ses.delete(NS+".deleteReview", vo);
				if(n>0) {
					ses.commit();//��� �����Ǹ� commit()
				}else {
					ses.rollback();//�θ�� ������ �����ϸ� ��� ��� rollback()
				}				
				}else {
					//��� ������ �����ߴٸ� rollback();
					ses.rollback();
				}
				return n1;
			}else {
				//����� ���ٸ�=> �θ�� ���� ó��
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