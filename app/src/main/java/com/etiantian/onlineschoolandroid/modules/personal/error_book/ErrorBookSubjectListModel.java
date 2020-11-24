package com.etiantian.onlineschoolandroid.modules.personal.error_book;

import java.util.List;

///
/// @description 错题本学科列表model
/// @author waitwalker
/// @time 11/24/20 9:59 AM
///
public class ErrorBookSubjectListModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : [{"subjectId":1,"subjectName":"语文","cnt":71},{"subjectId":2,"subjectName":"数学","cnt":1030},{"subjectId":3,"subjectName":"英语","cnt":388},{"subjectId":4,"subjectName":"物理","cnt":225},{"subjectId":5,"subjectName":"化学","cnt":270},{"subjectId":6,"subjectName":"历史","cnt":58},{"subjectId":7,"subjectName":"生物","cnt":27},{"subjectId":8,"subjectName":"地理","cnt":101},{"subjectId":9,"subjectName":"政治","cnt":15},{"subjectId":10,"subjectName":"科学","cnt":9}]
     */

    private int code;
    private String msg;
    /**
     * subjectId : 1
     * subjectName : 语文
     * cnt : 71
     */

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
        private int subjectId;
        private String subjectName;
        private int cnt;

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

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}
