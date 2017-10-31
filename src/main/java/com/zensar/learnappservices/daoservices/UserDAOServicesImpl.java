package com.zensar.learnappservices.daoservices;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.zensar.learnappservices.beans.AchievementGroupBean;
import com.zensar.learnappservices.beans.EvaluationBean;
import com.zensar.learnappservices.beans.UserBean;
import com.zensar.learnappservices.mappers.EvaluationMapper;
import com.zensar.learnappservices.mappers.UserMapper;
import com.zensar.learnappservices.util.Queries;

@Repository
public class UserDAOServicesImpl extends JdbcDaoSupport{
	
	public UserBean getUserFromCredentials(final String userId,String password){
		//LDAP ldap=new LDAP();
		//if(ldap.validateUser(employeeBean.getUserId(), employeeBean.getPassword())){
		if(getJdbcTemplate().queryForObject(Queries.IS_USER_PRESENT,new Object[] {userId},Integer.class)>0){
			getJdbcTemplate().update(Queries.UPDATE_USER_STATUS,new Object[]{"Active",userId});
		}
		else{
			getJdbcTemplate().update(Queries.INSERT_USER,new Object[]{"","user",0,"NewUser",userId});
			final List<AchievementGroupBean> achievementGroupBeans=AchievementGroupBean.getAchievements();
			int[] data= getJdbcTemplate().batchUpdate(Queries.ADD_ACHIEVEMENTS, new BatchPreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					AchievementGroupBean groupBean=achievementGroupBeans.get(i);
					ps.setString(1, groupBean.getGroupName());
					ps.setString(2, groupBean.getFirstStarText());
					ps.setString(3, groupBean.getSecondStarText());
					ps.setString(4, groupBean.getThirdStarText());
					ps.setInt(5, groupBean.getUserStarCount());
					ps.setInt(6, groupBean.getStatCount());
					ps.setString(7,userId);
					ps.setString(8, groupBean.getClaimButtonStatus());
				}
				@Override
				public int getBatchSize() {
					return achievementGroupBeans.size();
				}
			});
		}
		UserBean userBean=getJdbcTemplate().queryForObject(Queries.GET_USER,new Object[] {userId},new UserMapper());
		return userBean;
		
		//}else return null;
	}
	public UserBean getUserByUserId(String userId){
		UserBean userBean=getJdbcTemplate().queryForObject(Queries.GET_USER,new Object[] {userId},new UserMapper());
		userBean.setEvaluationBeans(getEvaluationsAsPerUser(userId));
		return userBean;
	}
	
	public List<EvaluationBean> getEvaluationsAsPerUser(String userId){
		return getJdbcTemplate().query(Queries.GET_EVALUATION_BY_USER,new Object[] {userId},new EvaluationMapper());
	}
	public int getUserAchievementsCount(String userId) {
		return getJdbcTemplate().queryForObject(Queries.GET_USER_ACHIEVEMENTS_COUNT,new Object[]{userId},Integer.class);
	}
	
}
