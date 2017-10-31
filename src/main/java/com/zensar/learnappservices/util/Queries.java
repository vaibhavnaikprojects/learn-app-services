package com.zensar.learnappservices.util;

public class Queries {
	//dashboard
	public static final String GET_EXAMS_GROUPS_FOR_USER = "SELECT * FROM tbl_exam_group where examGroupId in (select examGroupId from tbl_exam where examId in (SELECT examId FROM tbl_evaluation where userId=?))";
	public static final String GET_EXAMS_FROM_GROUP = "SELECT * FROM tbl_exam t,tbl_evaluation te where t.examId=te.examId and examGroupId=? and te.userId=?";
	public static final String GET_EXAM_BY_ID = "select * from tbl_exam where examId=?";
	public static final String GET_TUTORIAL_FOR_EXAM = "select * from tbl_tutorial where examId=? order by slideNo";
	public static final String GET_EXAM_GROUP_IMAGE = "select examGroupIcon 'slideImage' from tbl_exam_group where examGroupId=?";
	public static final String GET_EXAM_IMAGE = "select examImage 'slideImage' from tbl_exam where examId=?";
	public static final String GET_IMAGE = "select slideImage from tbl_tutorial where slideNo=? and examId=?";
	public static final String GET_AUDIO="select slideAudio from tbl_tutorial where slideNo=? and examId=?";
	public static final String GET_QUESTIONS_FOR_EXAM = "select * from tbl_question where examId=?";
	public static final String UPDATE_SCORE_FOR_EXAM="update tbl_evaluation set where userMarks=?,questionsAttempted=?,status=?,perks=?,examName=? where userId=? and examId=?";
	//all exams
	public static final String GET_ALL_EXAM_GROUPS_FOR_USER="SELECT * FROM tbl_exam_group where examGroupId not in (select examGroupId from tbl_exam where examId in (SELECT examId FROM tbl_evaluation where userId=?))";
	public static final String ADD_EXAMGROUP_FOR_USER="insert into tbl_evaluation(examId, status, userMarks, questionsAttempted, userId,perks) values(?,'Defined',0,0,?,0)";
	public static final String SUBSCRIBE_GROUP="insert into tbl_subscriptions(examGroupId, userId) values(?,?)";
	public static final String UNSUBSCRIBE_GROUP="delete from tbl_subscriptions where examGroupId=? and userId=?";
	public static final String GET_EXAM_GROUP_BY_ID = "select * from tbl_exam_group where examGroupId=?";
	//pending exam
	public static final String PENDING_EXAMS_FOR_USER="SELECT tex.* FROM tbl_exam tex,tbl_evaluation tev where tev.examId=tex.examId and tev.status='Pending' and tev.userId=?";
	
	//Completed Exams
	public static final String GET_EVALUATION_BY_USER = "select * from tbl_evaluation where userId=?";
	public static final String COMPLETED_USER_EXAM = "SELECT tex.* FROM tbl_exam tex,tbl_evaluation tev where tev.examId=tex.examId and tev.status='Completed' and tev.userId=?";
	
	//user details 
	public static final String GET_USER = "SELECT userId,userName,userRole,totalPerks,status,leagueName FROM tbl_user_details t,tbl_league l where totalPerks between l.leagueMinPerks and l.leagueMaxPerks and userId=?";
	public static final String UPDATE_USER_STATUS = "update tbl_user_details set status=? where userId=?";
	public static final String IS_USER_PRESENT = "select count(*) from tbl_user_details where userId=?";
	public static final String INSERT_USER = "insert into tbl_user_details(userName,userRole,totalPerks,status,userId) values(?,?,?,?,?)";
	//application
	public static final String GET_EXAM_GROUPS = "select examGroupId, examGroupName,examGroupDesc from tbl_exam_group";
	public static final String GET_EXAMS_FROM_GROUP_WP = "select * from tbl_exam where examGroupId=?";
	public static final String GET_QUESTION_COUNT = "select count(*) from tbl_question where examId=?";
	public static final String GET_TUTORIAL_COUNT = "select count(*) from tbl_tutorial where examId=?";
	
	
	public static final String ADD_EXAM_GROUP = "insert into tbl_exam_group(examGroupName,examGroupDesc) values(?,?)";
	public static final String ADD_IMAGE_FOR_EXAMGROUP = "update tbl_exam_group set examGroupIcon=? where examGroupId=?";
	public static final String ADD_EXAM = "insert into tbl_exam(examName,examDescription,maxMarks,passingMarks,examGroupId,perks) values(?,?,?,?,?,?)";
	public static final String ADD_IMAGE_FOR_EXAM = "update tbl_exam set examImage=? where examId=?";
	public static final String ADD_TUTORIAL = "replace into tbl_tutorial(slideNo,slideDescription,examId) values(?,?,?)";
	public static final String ADD_IMAGE_AUDIO_TO_TUTORIAL = "update tbl_tutorial set slideImage=?,slideAudio=? where tutorialId=?";
	public static final String ADD_QUESTIONS = "replace into tbl_question(question,option1,option2,option3,option4,correctAnswer,examId) values(?,?,?,?,?,?,?)";
	public static final String DELETE_EXAM = "delete from tbl_exam where examId=?";
	
	//feedback
	public static final String GET_USER_FEEDBACK = "select * from tbl_feedback where userId=?";
	public static final String FEEDBACK_FOUND = "select count(*) from tbl_feedback where userId=?";
	public static final String ADD_RATING = "insert into tbl_feedback(rating,userId,feedback) values(?,?,'')";
	public static final String UPDATE_RATING = "update tbl_feedback set rating=? where userId=?";
	public static final String ADD_FEEDBACK = "insert into tbl_feedback(feedback,userId) values(?,?)";
	public static final String UPDATE_Feedback = "update tbl_feedback set feedback=? where userId=?";
	
	//achievements
	public static final String ADD_ACHIEVEMENTS = "insert into tbl_achievements(groupName,firstStarText,secondStarText,thirdStarText,userStarCount,statCount,userId,claimButtonStatus) values(?,?,?,?,?,?,?,?)";
	public static final String GET_USER_ACHIEVEMENTS = "select * from tbl_achievements where userId=?";
	public static final String SHARE_APP = "insert into tbl_share(invitePeople,message,userId,inviteCount) values(?,?,?,?)";
	public static final String GET_SHARE_ACHIEVEMENT = "SELECT * FROM tbl_achievements where userId=? and  groupName='Sharing is caring'";
	public static final String UPDATE_SHARE_ACHIEVEMENT = "update tbl_achievements set userStarCount=?,statCount=?,claimButtonStatus=? where userId=? and  groupName='Sharing is caring'";
	public static final String GET_STARS = "select userStarCount from tbl_achievements where userId=? and groupName=?";
	public static final String UPDATE_TOTAL_PERKS = "update tbl_user_details set totalPerks=? where userId=?";
	public static final String UPDATE_CLAIM_STATUS = "update tbl_achievements set claimButtonStatus='false' where userId=? and  groupName=?";
	public static final String GET_EXAM_FROM_TYPE = "select * from tbl_exam where examGroupId=? and examName like ?";
	public static final String GET_USER_ACHIEVEMENTS_COUNT = "select count(*) from tbl_achievements where userId=? and claimButtonStatus='true'";
	
}
