package com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail;

///
/// @description 当个教材版本
/// @param 
/// @return 
/// @author waitwalker
/// @time 2020/9/17 9:39 AM
///
public class MaterialModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"defVersionId":53387,"defVersionName":"华东师范大学课程标准实验教材","defAbbreviation":"华东师大版","defMaterialId":51550,"defMaterialName":"初一上册","gradeId":6,"subjectId":2,"materialNumber":168,"materialAlreadyLearnedNumber":4}
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
         * defVersionId : 53387
         * defVersionName : 华东师范大学课程标准实验教材
         * defAbbreviation : 华东师大版
         * defMaterialId : 51550
         * defMaterialName : 初一上册
         * gradeId : 6
         * subjectId : 2
         * materialNumber : 168
         * materialAlreadyLearnedNumber : 4
         */

        private int defVersionId;
        private String defVersionName;
        private String defAbbreviation;
        private int defMaterialId;
        private String defMaterialName;
        private int gradeId;
        private int subjectId;
        private int materialNumber;
        private int materialAlreadyLearnedNumber;

        public int getDefVersionId() {
            return defVersionId;
        }

        public void setDefVersionId(int defVersionId) {
            this.defVersionId = defVersionId;
        }

        public String getDefVersionName() {
            return defVersionName;
        }

        public void setDefVersionName(String defVersionName) {
            this.defVersionName = defVersionName;
        }

        public String getDefAbbreviation() {
            return defAbbreviation;
        }

        public void setDefAbbreviation(String defAbbreviation) {
            this.defAbbreviation = defAbbreviation;
        }

        public int getDefMaterialId() {
            return defMaterialId;
        }

        public void setDefMaterialId(int defMaterialId) {
            this.defMaterialId = defMaterialId;
        }

        public String getDefMaterialName() {
            return defMaterialName;
        }

        public void setDefMaterialName(String defMaterialName) {
            this.defMaterialName = defMaterialName;
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

        public int getMaterialNumber() {
            return materialNumber;
        }

        public void setMaterialNumber(int materialNumber) {
            this.materialNumber = materialNumber;
        }

        public int getMaterialAlreadyLearnedNumber() {
            return materialAlreadyLearnedNumber;
        }

        public void setMaterialAlreadyLearnedNumber(int materialAlreadyLearnedNumber) {
            this.materialAlreadyLearnedNumber = materialAlreadyLearnedNumber;
        }
    }
}
