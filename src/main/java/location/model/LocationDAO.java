package location.model;

import org.apache.ibatis.session.SqlSession;

import common.model.DAOTripManagerBase;

public class LocationDAO extends DAOTripManagerBase {
	
	private final String NS="common.mapper.InforMapper";
	
	public LocationVO selectLocationByNum(int num) {
		try(SqlSession ses=this.getSessionFactory().openSession(true)){
			LocationVO vo = ses.selectOne(NS+".selectLocationByNum",num);
			return vo;
		}
	}

}
