package com.zensar.learnappservices.daoservices;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.zensar.learnappservices.beans.AchievementGroupBean;
import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.mappers.AchievementMapper;
import com.zensar.learnappservices.mappers.NoImageExamMapper;
import com.zensar.learnappservices.util.Queries;

@Repository
public class MiscDAOServicesImpl extends JdbcDaoSupport{
	
	public void shareApp(String invitePeople,String message,String userId,int peopleCount){
		int a= getJdbcTemplate().update(Queries.SHARE_APP,new Object[]{invitePeople,message,userId,peopleCount});
		if (a>0) {
			AchievementGroupBean achievementGroupBean=getJdbcTemplate().queryForObject(Queries.GET_SHARE_ACHIEVEMENT,new Object[]{userId},new AchievementMapper());
			int currentCount=achievementGroupBean.getStatCount()+peopleCount;
			boolean check=false;
			if(achievementGroupBean.getUserStarCount()==0 && currentCount>=3){
				getJdbcTemplate().update(Queries.UPDATE_SHARE_ACHIEVEMENT,new Object[]{achievementGroupBean.getUserStarCount()+1,currentCount,"true",userId});
				check=true;
			}
			else
				getJdbcTemplate().update(Queries.UPDATE_SHARE_ACHIEVEMENT,new Object[]{achievementGroupBean.getUserStarCount(),currentCount,"false",userId});
			if(achievementGroupBean.getUserStarCount()==1 && currentCount>=5){
				check=true;
				getJdbcTemplate().update(Queries.UPDATE_SHARE_ACHIEVEMENT,new Object[]{achievementGroupBean.getUserStarCount()+1,currentCount,"true",userId});
			}
			else{
				if(!check)
				getJdbcTemplate().update(Queries.UPDATE_SHARE_ACHIEVEMENT,new Object[]{achievementGroupBean.getUserStarCount(),currentCount,"false",userId});
			}
				
			if(achievementGroupBean.getUserStarCount()==2 && currentCount>=10){
				check=true;
				getJdbcTemplate().update(Queries.UPDATE_SHARE_ACHIEVEMENT,new Object[]{achievementGroupBean.getUserStarCount()+1,currentCount,"true",userId});
			}
			else{
				if(!check)
				getJdbcTemplate().update(Queries.UPDATE_SHARE_ACHIEVEMENT,new Object[]{achievementGroupBean.getUserStarCount(),currentCount,"false",userId});
			}
				
		}
	}

	public List<ExamBean> getCompletedExams(String userId) {
		return getJdbcTemplate().query(Queries.COMPLETED_USER_EXAM,new Object[]{userId},new NoImageExamMapper());
	}
}
