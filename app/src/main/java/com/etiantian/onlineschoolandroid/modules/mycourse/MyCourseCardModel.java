package com.etiantian.onlineschoolandroid.modules.mycourse;

import java.util.List;

///
/// @description 首页我的课程年级卡片布局
/// @author waitwalker
/// @time 2020/9/9 4:29 PM
///
public class MyCourseCardModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : [{"subjectId":1,"subjectName":"语文","grades":[]},{"subjectId":2,"subjectName":"数学","grades":[]},{"subjectId":3,"subjectName":"英语","grades":[]},{"subjectId":4,"subjectName":"物理","grades":[]},{"subjectId":5,"subjectName":"化学","grades":[]},{"subjectId":6,"subjectName":"历史","grades":[]},{"subjectId":7,"subjectName":"生物","grades":[]},{"subjectId":8,"subjectName":"地理","grades":[]},{"subjectId":9,"subjectName":"政治","grades":[]},{"subjectId":10,"subjectName":"科学","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null}]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * subjectId : 1
         * subjectName : 语文
         * grades : []
         */

        private int subjectId;
        private String subjectName;
        private List<?> grades;

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

        public List<?> getGrades() {
            return grades;
        }

        public void setGrades(List<?> grades) {
            this.grades = grades;
        }
    }
}
