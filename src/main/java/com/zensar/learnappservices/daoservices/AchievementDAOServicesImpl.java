package com.zensar.learnappservices.daoservices;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.zensar.learnappservices.beans.AchievementGroupBean;
import com.zensar.learnappservices.beans.UserBean;
import com.zensar.learnappservices.mappers.AchievementMapper;
import com.zensar.learnappservices.mappers.UserMapper;
import com.zensar.learnappservices.util.Queries;

@Repository
public class AchievementDAOServicesImpl extends JdbcDaoSupport{

	private static final int ONE_STAR_POINTS=3;
	private static final int TWO_STAR_POINTS=5;
	private static final int THREE_STAR_POINTS=8;
	
	public List<AchievementGroupBean> getUserAchievements(String userId) {
		return getJdbcTemplate().query(Queries.GET_USER_ACHIEVEMENTS, new Object[]{userId},new AchievementMapper());
	}
	
	public void claimAchievement(String userId, String groupName){
		UserBean userBean= getJdbcTemplate().queryForObject(Queries.GET_USER, new Object[]{userId},new UserMapper());
		int starCount=getJdbcTemplate().queryForObject(Queries.GET_STARS, new Object[]{userId,groupName},Integer.class);
		int updatedPerks=0;
		switch(starCount){
		case 1:
			updatedPerks=(int)userBean.getTotalPerks()+ONE_STAR_POINTS;
			break;
		case 2:
			updatedPerks=(int)userBean.getTotalPerks()+TWO_STAR_POINTS;
			break;
		case 3:
			updatedPerks=(int)userBean.getTotalPerks()+THREE_STAR_POINTS;
			break;
		default:
			updatedPerks=(int)userBean.getTotalPerks();
		}
		getJdbcTemplate().update(Queries.UPDATE_TOTAL_PERKS, new Object[]{updatedPerks,userId});
		getJdbcTemplate().update(Queries.UPDATE_CLAIM_STATUS,new Object[]{userId,groupName});
		
	}

}
