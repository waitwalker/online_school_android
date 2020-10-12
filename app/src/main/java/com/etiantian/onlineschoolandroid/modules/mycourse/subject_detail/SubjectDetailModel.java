package com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail;

public class SubjectDetailModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"subjectId":2,"subjectName":"数学","gradeId":6,"gradeName":"初中一年级","cardEndTime":"9999-12-31 23:59:59","onlineLabel":1,"aiLabel":1,"zixueLabel":1,"thisCourseId":null,"thisClassQRCode":null,"nextLiveTime":null,"courseId":4090623417}
     */

    private int code;
    private String msg;
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
        /**
         * subjectId : 2
         * subjectName : 数学
         * gradeId : 6
         * gradeName : 初中一年级
         * cardEndTime : 9999-12-31 23:59:59
         * onlineLabel : 1
         * aiLabel : 1
         * zixueLabel : 1
         * thisCourseId : null
         * thisClassQRCode : null
         * nextLiveTime : null
         * courseId : 4090623417
         */

        private int subjectId;
        private String subjectName;
        private int gradeId;
        private String gradeName;
        private String cardEndTime;
        private int onlineLabel;
        private int aiLabel;
        private int zixueLabel;
        private Object thisCourseId;
        private Object thisClassQRCode;
        private Object nextLiveTime;
        private long courseId;

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public int getGradeId() {
            return gradeId;
        }

        public void setGradeId(int gradeId) {
            this.gradeId = gradeId;
        }

        public String getGradeName() {
            return gradeName;
        }

        public void setGradeName(String gradeName) {
            this.gradeName = gradeName;
        }

        public String getCardEndTime() {
            return cardEndTime;
        }

        public void setCardEndTime(String cardEndTime) {
            this.cardEndTime = cardEndTime;
        }

        public int getOnlineLabel() {
            return onlineLabel;
        }

        public void setOnlineLabel(int onlineLabel) {
            this.onlineLabel = onlineLabel;
        }

        public int getAiLabel() {
            return aiLabel;
        }

        public void setAiLabel(int aiLabel) {
            this.aiLabel = aiLabel;
        }

        public int getZixueLabel() {
            return zixueLabel;
        }

        public void setZixueLabel(int zixueLabel) {
            this.zixueLabel = zixueLabel;
        }

        public Object getThisCourseId() {
            return thisCourseId;
        }

        public void setThisCourseId(Object thisCourseId) {
            this.thisCourseId = thisCourseId;
        }

        public Object getThisClassQRCode() {
            return thisClassQRCode;
        }

        public void setThisClassQRCode(Object thisClassQRCode) {
            this.thisClassQRCode = thisClassQRCode;
        }

        public Object getNextLiveTime() {
            return nextLiveTime;
        }

        public void setNextLiveTime(Object nextLiveTime) {
            this.nextLiveTime = nextLiveTime;
        }

        public long getCourseId() {
            return courseId;
        }

        public void setCourseId(long courseId) {
            this.courseId = courseId;
        }
    }
}
