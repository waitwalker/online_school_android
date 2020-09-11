package com.etiantian.onlineschoolandroid.modules.mycourse.recommend;

///
/// @description 推荐学习Model
/// @author waitwalker
/// @time 2020/9/11 10:49 AM
///
public class RecommendModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"aiActivationStatus":1,"aiRecommendId":1000117618,"versionId":125445,"aiSubjectId":2,"aiName":"AI测试","aiTitle":"AI智能推送 快速高效刷题","aiSubtitle":"每天只需10分钟","aiCourseId":4028019424,"zxActivationStatus":1,"zxRecommendId":418943,"resName":"Book 4 Unit 5 Theme parks词汇精讲","resType":1,"courseCardId":4090623416,"zxName":"智慧学习","zxTitle":"四中老师微课等你学","zxSubtitle":"15分钟搞定难点","zxFrom":"Unit 5   Theme parks","liveStatus":2,"gradeId":6,"subjectId":3,"liveUrl":null,"nextLiveTime":null,"liveName":"大师直播","liveTitle":"在线体验大师直播课","liveSubtitle":"预告时间"}
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
         * aiActivationStatus : 1
         * aiRecommendId : 1000117618
         * versionId : 125445
         * aiSubjectId : 2
         * aiName : AI测试
         * aiTitle : AI智能推送 快速高效刷题
         * aiSubtitle : 每天只需10分钟
         * aiCourseId : 4028019424
         * zxActivationStatus : 1
         * zxRecommendId : 418943
         * resName : Book 4 Unit 5 Theme parks词汇精讲
         * resType : 1
         * courseCardId : 4090623416
         * zxName : 智慧学习
         * zxTitle : 四中老师微课等你学
         * zxSubtitle : 15分钟搞定难点
         * zxFrom : Unit 5   Theme parks
         * liveStatus : 2
         * gradeId : 6
         * subjectId : 3
         * liveUrl : null
         * nextLiveTime : null
         * liveName : 大师直播
         * liveTitle : 在线体验大师直播课
         * liveSubtitle : 预告时间
         */

        private int aiActivationStatus;
        private int aiRecommendId;
        private int versionId;
        private int aiSubjectId;
        private String aiName;
        private String aiTitle;
        private String aiSubtitle;
        private long aiCourseId;
        private int zxActivationStatus;
        private int zxRecommendId;
        private String resName;
        private int resType;
        private long courseCardId;
        private String zxName;
        private String zxTitle;
        private String zxSubtitle;
        private String zxFrom;
        private int liveStatus;
        private int gradeId;
        private int subjectId;
        private Object liveUrl;
        private Object nextLiveTime;
        private String liveName;
        private String liveTitle;
        private String liveSubtitle;

        public int getAiActivationStatus() {
            return aiActivationStatus;
        }

        public void setAiActivationStatus(int aiActivationStatus) {
            this.aiActivationStatus = aiActivationStatus;
        }

        public int getAiRecommendId() {
            return aiRecommendId;
        }

        public void setAiRecommendId(int aiRecommendId) {
            this.aiRecommendId = aiRecommendId;
        }

        public int getVersionId() {
            return versionId;
        }

        public void setVersionId(int versionId) {
            this.versionId = versionId;
        }

        public int getAiSubjectId() {
            return aiSubjectId;
        }

        public void setAiSubjectId(int aiSubjectId) {
            this.aiSubjectId = aiSubjectId;
        }

        public String getAiName() {
            return aiName;
        }

        public void setAiName(String aiName) {
            this.aiName = aiName;
        }

        public String getAiTitle() {
            return aiTitle;
        }

        public void setAiTitle(String aiTitle) {
            this.aiTitle = aiTitle;
        }

        public String getAiSubtitle() {
            return aiSubtitle;
        }

        public void setAiSubtitle(String aiSubtitle) {
            this.aiSubtitle = aiSubtitle;
        }

        public long getAiCourseId() {
            return aiCourseId;
        }

        public void setAiCourseId(long aiCourseId) {
            this.aiCourseId = aiCourseId;
        }

        public int getZxActivationStatus() {
            return zxActivationStatus;
        }

        public void setZxActivationStatus(int zxActivationStatus) {
            this.zxActivationStatus = zxActivationStatus;
        }

        public int getZxRecommendId() {
            return zxRecommendId;
        }

        public void setZxRecommendId(int zxRecommendId) {
            this.zxRecommendId = zxRecommendId;
        }

        public String getResName() {
            return resName;
        }

        public void setResName(String resName) {
            this.resName = resName;
        }

        public int getResType() {
            return resType;
        }

        public void setResType(int resType) {
            this.resType = resType;
        }

        public long getCourseCardId() {
            return courseCardId;
        }

        public void setCourseCardId(long courseCardId) {
            this.courseCardId = courseCardId;
        }

        public String getZxName() {
            return zxName;
        }

        public void setZxName(String zxName) {
            this.zxName = zxName;
        }

        public String getZxTitle() {
            return zxTitle;
        }

        public void setZxTitle(String zxTitle) {
            this.zxTitle = zxTitle;
        }

        public String getZxSubtitle() {
            return zxSubtitle;
        }

        public void setZxSubtitle(String zxSubtitle) {
            this.zxSubtitle = zxSubtitle;
        }

        public String getZxFrom() {
            return zxFrom;
        }

        public void setZxFrom(String zxFrom) {
            this.zxFrom = zxFrom;
        }

        public int getLiveStatus() {
            return liveStatus;
        }

        public void setLiveStatus(int liveStatus) {
            this.liveStatus = liveStatus;
        }

        public int getGradeId() {
            return gradeId;
        }

        public void setGradeId(int gradeId) {
            this.gradeId = gradeId;
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public Object getLiveUrl() {
            return liveUrl;
        }

        public void setLiveUrl(Object liveUrl) {
            this.liveUrl = liveUrl;
        }

        public Object getNextLiveTime() {
            return nextLiveTime;
        }

        public void setNextLiveTime(Object nextLiveTime) {
            this.nextLiveTime = nextLiveTime;
        }

        public String getLiveName() {
            return liveName;
        }

        public void setLiveName(String liveName) {
            this.liveName = liveName;
        }

        public String getLiveTitle() {
            return liveTitle;
        }

        public void setLiveTitle(String liveTitle) {
            this.liveTitle = liveTitle;
        }

        public String getLiveSubtitle() {
            return liveSubtitle;
        }

        public void setLiveSubtitle(String liveSubtitle) {
            this.liveSubtitle = liveSubtitle;
        }
    }
}
