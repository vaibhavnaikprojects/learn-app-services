package com.zensar.learnappservices.daoservices;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.zensar.learnappservices.beans.EvaluationBean;
import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.beans.ExamGroupBean;
import com.zensar.learnappservices.beans.QuestionBean;
import com.zensar.learnappservices.beans.TutorialBean;
import com.zensar.learnappservices.mappers.AudioMapper;
import com.zensar.learnappservices.mappers.ExamGroupMapper;
import com.zensar.learnappservices.mappers.ExamMapper;
import com.zensar.learnappservices.mappers.ImageMapper;
import com.zensar.learnappservices.mappers.QuestionMapper;
import com.zensar.learnappservices.mappers.TutorialMapper;
import com.zensar.learnappservices.util.Queries;

@Repository
public class ExamDAOServicesImpl extends JdbcDaoSupport{
	//app services
	//dashboards
	public List<ExamGroupBean> getExamGroupsForUser(String userId){
		return getJdbcTemplate().query(Queries.GET_EXAMS_GROUPS_FOR_USER,new Object[]{userId},new ExamGroupMapper());
	}
	public List<ExamBean> getExamFromExamGroup(int examGroupId,String userId){//need to update bean
		return getJdbcTemplate().query(Queries.GET_EXAMS_FROM_GROUP,new Object[]{examGroupId,userId},new ExamMapper());
	}
	public ExamBean getExam(int examId) {
		return getJdbcTemplate().queryForObject(Queries.GET_EXAM_BY_ID,new Object[] {examId},new ExamMapper());
	}
	public List<TutorialBean> getTutorialForExam(int examId){
		return getJdbcTemplate().query(Queries.GET_TUTORIAL_FOR_EXAM,new Object[] {examId},new TutorialMapper());
	}
	public InputStream getImageForExamSlide(int examId, int slideNo) {
		return getJdbcTemplate().queryForObject(Queries.GET_IMAGE,new Object[]{slideNo,examId},new ImageMapper());
	}
	public InputStream getAudioForExamSlide(int examId,int slideNo){
		return getJdbcTemplate().queryForObject(Queries.GET_AUDIO,new Object[]{slideNo,examId},new AudioMapper());
	}
	public List<QuestionBean> getQuestionsForExam(int examId) {
		return getJdbcTemplate().query(Queries.GET_QUESTIONS_FOR_EXAM,new Object[] {examId},new QuestionMapper());
	}
	public boolean updateEvaluationForUser(EvaluationBean evaluationBean,String userId){
		int a=getJdbcTemplate().update(Queries.UPDATE_SCORE_FOR_EXAM,new Object[] {evaluationBean.getUserMarks(),evaluationBean.getQuestionsAttempted(),evaluationBean.getStatus(),evaluationBean.getUserPerks(),evaluationBean.getExamName(),userId,evaluationBean.getExamId()});
		if(a>0)	return true;
		return false;
	}
	//all exams
	public List<ExamGroupBean> getAllExamGroupsForUser(String userId){
		return getJdbcTemplate().query(Queries.GET_ALL_EXAM_GROUPS_FOR_USER,new Object[]{userId},new ExamGroupMapper());
	}
	public ExamGroupBean subscribeExamGroup(int examGroupId,final String userId){
		int a=getJdbcTemplate().update(Queries.SUBSCRIBE_GROUP,new Object[] {examGroupId,userId});
		final List<ExamBean> examBeans=getAllExamsForExamGroup(examGroupId);
		int[] data= getJdbcTemplate().batchUpdate(Queries.ADD_EXAMGROUP_FOR_USER, new BatchPreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ExamBean examBean=examBeans.get(i);
				ps.setInt(1, examBean.getExamId());
				ps.setString(2, userId);
			}
			@Override
			public int getBatchSize() {
				return examBeans.size();
			}
		});
		if(data.length>0)	return getJdbcTemplate().queryForObject(Queries.GET_EXAM_GROUP_BY_ID, new Object[]{examGroupId},new ExamGroupMapper());
		return null;
	}
	public ExamGroupBean unsubscribeExamGroup(int examGroupId,String userId){
		int a=getJdbcTemplate().update(Queries.UNSUBSCRIBE_GROUP,new Object[] {examGroupId,userId});
		if(a>0)	return getJdbcTemplate().queryForObject(Queries.GET_EXAM_GROUP_BY_ID, new Object[]{examGroupId},new ExamGroupMapper());
		return null;
	}
	
	//application
	public List<ExamGroupBean> getAllExamsGroups() {
		return getJdbcTemplate().query(Queries.GET_EXAM_GROUPS,new ExamGroupMapper());
	}
	public List<ExamBean> getAllExamsForExamGroup(int examGroupId) {
		return getJdbcTemplate().query(Queries.GET_EXAMS_FROM_GROUP_WP,new Object[]{examGroupId},new ExamMapper());
	}
	public int getQuestionsCount(int examId) throws DataAccessException{
		return getJdbcTemplate().queryForObject(Queries.GET_QUESTION_COUNT,new Object[]{examId}, Integer.class);
	}

	public int getTutorialCount(int examId) {
		return getJdbcTemplate().queryForObject(Queries.GET_TUTORIAL_COUNT,new Object[]{examId}, Integer.class);
	}
	public int addExamGroup(final ExamGroupBean examGroupBean,InputStream examGroupIcon,int imageSize) throws SQLException{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps =connection.prepareStatement(Queries.ADD_EXAM_GROUP, new String[] {"id"});
				ps.setString(1, examGroupBean.getExamGroupName());
				ps.setString(2, examGroupBean.getExamGroupDesc());
				return ps;
			}
		},keyHolder);
		int count= keyHolder.getKey().intValue();
		Connection con = null;
		PreparedStatement ps=null;
		try{
			DataSource ds = getJdbcTemplate().getDataSource();
			con = ds.getConnection();
			ps = con.prepareStatement(Queries.ADD_IMAGE_FOR_EXAMGROUP);
			ps.setBinaryStream(1, examGroupIcon,imageSize);
			ps.setInt(2,count);
			ps.executeUpdate();
		}catch(SQLException e){
		}finally{
			con.close();
			ps.close();
		}
		return count;
	}
	
	public int addExam(final ExamBean examBean,final int examGroupId,InputStream examImage,int imageSize) throws SQLException{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps =connection.prepareStatement(Queries.ADD_EXAM, new String[] {"id"});
				ps.setString(1, examBean.getExamName());
				ps.setString(2, examBean.getExamDescription());
				ps.setInt(3, examBean.getMaxMarks());
				ps.setInt(4, examBean.getPassingMarks());
				ps.setInt(5, examGroupId);
				ps.setInt(6, examBean.getPerks());
				return ps;
			}
		},keyHolder);
		int count= keyHolder.getKey().intValue();
		Connection con = null;
		PreparedStatement ps=null;
		try{
			DataSource ds = getJdbcTemplate().getDataSource();
			con = ds.getConnection();
			ps = con.prepareStatement(Queries.ADD_IMAGE_FOR_EXAM);
			ps.setBinaryStream(1, examImage,imageSize);
			ps.setInt(2,count);
			ps.executeUpdate();
		}catch(SQLException e){
		}finally{
			con.close();
			ps.close();
		}
		return count;
	}
	
	public boolean addTutorial(final TutorialBean tutorialBean,InputStream slideImage,int slideSize,InputStream slideAudio,int audioSize) throws DataAccessException, IOException, SQLException{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int a=getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps =connection.prepareStatement(Queries.ADD_TUTORIAL, new String[] {"id"});
				ps.setInt(1,tutorialBean.getSlideNo());
				ps.setString(2,tutorialBean.getSlideDescription());
				ps.setInt(3,tutorialBean.getExamId());
				return ps;
			}
		},keyHolder);
		a=keyHolder.getKey().intValue();
		Connection con = null;
		PreparedStatement ps=null;
		try{
			DataSource ds = getJdbcTemplate().getDataSource();
			con = ds.getConnection();
			ps = con.prepareStatement(Queries.ADD_IMAGE_AUDIO_TO_TUTORIAL);
			ps.setBinaryStream(1, slideImage,slideSize);
			ps.setBinaryStream(2, slideAudio,audioSize);
			ps.setInt(3, a);
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
			return false;
		}finally{
			con.close();
			ps.close();
		}
	}
	
	public boolean addQuestions(final List<QuestionBean> questionBeans,final int examId){
		int[] data= getJdbcTemplate().batchUpdate(Queries.ADD_QUESTIONS, new BatchPreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				QuestionBean questionBean=questionBeans.get(i);
				ps.setString(1, questionBean.getQuestion());
				ps.setString(2, questionBean.getOption1());
				ps.setString(3, questionBean.getOption2());
				ps.setString(4, questionBean.getOption3());
				ps.setString(5, questionBean.getOption4());
				ps.setString(6, questionBean.getCorrectAnswer());
				ps.setInt(7, examId);
			}

			@Override
			public int getBatchSize() {
				return questionBeans.size();
			}
		});
		if(data.length>0)	return true;
		return false;
	}
	

	public boolean deleteExam(int examId) {
		int a=getJdbcTemplate().update(Queries.DELETE_EXAM,new Object[]{examId});
		if(a>0)	return true;
		return false;
	}
	public InputStream getImagesForExamGroups(int examGroupId) {
		return getJdbcTemplate().queryForObject(Queries.GET_EXAM_GROUP_IMAGE,new Object[]{examGroupId},new ImageMapper());
	}
	
	public InputStream getExamImage(int examId) {
		return getJdbcTemplate().queryForObject(Queries.GET_EXAM_IMAGE,new Object[]{examId},new ImageMapper());
	}
	
	public List<ExamBean> getPendingExam(String userId) {
		return getJdbcTemplate().query(Queries.PENDING_EXAMS_FOR_USER,new Object[]{userId},new ExamMapper());
	}
	public ExamBean getExamFromType(int examGroupId, String examType) {
		 return getJdbcTemplate().queryForObject(Queries.GET_EXAM_FROM_TYPE,new Object[]{examGroupId,"%"+examType+"%"},new ExamMapper());
	}
}
