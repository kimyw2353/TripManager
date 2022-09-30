package recommend.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.model.DAOTripManagerBase;

public class RecommendDAO extends DAOTripManagerBase {
	
	private final String NS="common.mapper.InforMapper";

	public List<RecommendVO> selectRecommendByNum(int num) {
		try(SqlSession ses=this.getSessionFactory().openSession(true)){
			List<RecommendVO> arr = ses.selectList(NS+".selectRecommendByNum", num);
			return arr;
		}
	}
}
