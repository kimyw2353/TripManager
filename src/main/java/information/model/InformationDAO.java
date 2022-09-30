package information.model;

import org.apache.ibatis.session.SqlSession;

import common.model.DAOTripManagerBase;

public class InformationDAO extends DAOTripManagerBase {
	
	private final String NS="common.mapper.InforMapper";
	
	public InformationVO selectInformaitonByNum(int num) {
		try(SqlSession ses=this.getSessionFactory().openSession(true)){
			InformationVO vo = ses.selectOne(NS+".selectInformationByNum", num);
			return vo;
		}
	}
	
	
}
