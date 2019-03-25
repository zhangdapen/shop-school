package cn.zzu.entity;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer schoolId;

    private String userNickname;

    private String userImage;

    private Integer userType;

    private Integer userState;

    private Date userDate;

    private String userQuestion;

    private String userAnswer;

    public UserInfo(Integer userId, String userName, String userPassword, Integer schoolId, String userNickname, String userImage, Integer userType, Integer userState, Date userDate, String userQuestion, String userAnswer) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.schoolId = schoolId;
        this.userNickname = userNickname;
        this.userImage = userImage;
        this.userType = userType;
        this.userState = userState;
        this.userDate = userDate;
        this.userQuestion = userQuestion;
        this.userAnswer = userAnswer;
    }

    public UserInfo() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", schoolId=" + schoolId +
                ", userNickname='" + userNickname + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userType=" + userType +
                ", userState=" + userState +
                ", userDate=" + userDate +
                ", userQuestion='" + userQuestion + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                '}';
    }
}