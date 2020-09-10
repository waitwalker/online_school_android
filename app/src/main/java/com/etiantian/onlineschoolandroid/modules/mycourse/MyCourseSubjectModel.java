package com.etiantian.onlineschoolandroid.modules.mycourse;

import java.util.List;

///
/// @description 首页我的课程年级卡片布局
/// @author waitwalker
/// @time 2020/9/9 4:29 PM
///
public class MyCourseSubjectModel {


    /**
     * code : 1
     * msg : 操作成功
     * data : [{"subjectId":1,"subjectName":"语文","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":2,"subjectName":"数学","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":3,"subjectName":"英语","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":4,"subjectName":"物理","grades":[{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":5,"subjectName":"化学","grades":[{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":6,"subjectName":"历史","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":7,"subjectName":"生物","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":8,"subjectName":"地理","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":9,"subjectName":"政治","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]},{"subjectId":10,"subjectName":"科学","grades":[{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null}]}]
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
         * grades : [{"gradeId":6,"gradeName":"初中一年级","signUpType":null,"registerCourseList":null},{"gradeId":5,"gradeName":"初中二年级","signUpType":null,"registerCourseList":null},{"gradeId":4,"gradeName":"初中三年级","signUpType":null,"registerCourseList":null},{"gradeId":3,"gradeName":"高中一年级","signUpType":null,"registerCourseList":null},{"gradeId":2,"gradeName":"高中二年级","signUpType":null,"registerCourseList":null},{"gradeId":1,"gradeName":"高中三年级","signUpType":null,"registerCourseList":null}]
         */

        private int subjectId;
        private String subjectName;
        private List<GradesBean> grades;

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

        public List<GradesBean> getGrades() {
            return grades;
        }

        public void setGrades(List<GradesBean> grades) {
            this.grades = grades;
        }

        public static class GradesBean {
            /**
             * gradeId : 6
             * gradeName : 初中一年级
             * signUpType : null
             * registerCourseList : null
             */

            private int gradeId;
            private String gradeName;
            private Object signUpType;
            private Object registerCourseList;

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

            public Object getSignUpType() {
                return signUpType;
            }

            public void setSignUpType(Object signUpType) {
                this.signUpType = signUpType;
            }

            public Object getRegisterCourseList() {
                return registerCourseList;
            }

            public void setRegisterCourseList(Object registerCourseList) {
                this.registerCourseList = registerCourseList;
            }
        }
    }
}
