package com.etiantian.onlineschoolandroid.modules.login;

public class UserInfoModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"userId":9615692,"userName":"xwx18600000001","userPhoto":"http://attach.etiantian.com/ett20/study/common/upload/9615692_62173340.jpg","sex":0,"birthday":"1970-01-01 00:00:00","vipStatus":null,"bindingStatus":1,"address":"hjhhhhhhjhh","email":"未填","realName":"未确定","autoType":1,"stateType":1,"gradeId":5,"schoolId":2352,"mobile":"18600000001","schoolType":1,"thisSchoolStatus":null,"schoolName":"功能测试2","lianTongCardState":-1}
     */

    private int code;
    private String msg;
    /**
     * userId : 9615692
     * userName : xwx18600000001
     * userPhoto : http://attach.etiantian.com/ett20/study/common/upload/9615692_62173340.jpg
     * sex : 0
     * birthday : 1970-01-01 00:00:00
     * vipStatus : null
     * bindingStatus : 1
     * address : hjhhhhhhjhh
     * email : 未填
     * realName : 未确定
     * autoType : 1
     * stateType : 1
     * gradeId : 5
     * schoolId : 2352
     * mobile : 18600000001
     * schoolType : 1
     * thisSchoolStatus : null
     * schoolName : 功能测试2
     * lianTongCardState : -1
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int userId;
        private String userName;
        private String userPhoto;
        private int sex;
        private String birthday;
        private Object vipStatus;
        private int bindingStatus;
        private String address;
        private String email;
        private String realName;
        private int autoType;
        private int stateType;
        private int gradeId;
        private int schoolId;
        private String mobile;
        private int schoolType;
        private Object thisSchoolStatus;
        private String schoolName;
        private int lianTongCardState;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Object getVipStatus() {
            return vipStatus;
        }

        public void setVipStatus(Object vipStatus) {
            this.vipStatus = vipStatus;
        }

        public int getBindingStatus() {
            return bindingStatus;
        }

        public void setBindingStatus(int bindingStatus) {
            this.bindingStatus = bindingStatus;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getAutoType() {
            return autoType;
        }

        public void setAutoType(int autoType) {
            this.autoType = autoType;
        }

        public int getStateType() {
            return stateType;
        }

        public void setStateType(int stateType) {
            this.stateType = stateType;
        }

        public int getGradeId() {
            return gradeId;
        }

        public void setGradeId(int gradeId) {
            this.gradeId = gradeId;
        }

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getSchoolType() {
            return schoolType;
        }

        public void setSchoolType(int schoolType) {
            this.schoolType = schoolType;
        }

        public Object getThisSchoolStatus() {
            return thisSchoolStatus;
        }

        public void setThisSchoolStatus(Object thisSchoolStatus) {
            this.thisSchoolStatus = thisSchoolStatus;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public int getLianTongCardState() {
            return lianTongCardState;
        }

        public void setLianTongCardState(int lianTongCardState) {
            this.lianTongCardState = lianTongCardState;
        }
    }
}
