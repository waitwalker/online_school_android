package com.etiantian.onlineschoolandroid.model;

///
/// @description 活动课弹框model
/// @author waitwalker
/// @time 2020/9/2 11:50 AM
///
public class ActivityCourseAlertModel {


    /**
     * code : 1
     * msg : 操作成功
     * data : {"description":"强国网课节","picture":"http://attach.etiantian.com/common/xwx/course/cover/1598844062156.jpg","url":"http://huodong.etiantian.com/activity01/qiangguom.html","isOpen":1,"tagType":1}
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
         * description : 强国网课节
         * picture : http://attach.etiantian.com/common/xwx/course/cover/1598844062156.jpg
         * url : http://huodong.etiantian.com/activity01/qiangguom.html
         * isOpen : 1
         * tagType : 1
         */

        private String description;
        private String picture;
        private String url;
        private int isOpen;
        private int tagType;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getIsOpen() {
            return isOpen;
        }

        public void setIsOpen(int isOpen) {
            this.isOpen = isOpen;
        }

        public int getTagType() {
            return tagType;
        }

        public void setTagType(int tagType) {
            this.tagType = tagType;
        }
    }
}
