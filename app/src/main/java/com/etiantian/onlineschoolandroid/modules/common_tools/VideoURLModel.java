package com.etiantian.onlineschoolandroid.modules.common_tools;

///
/// @description VideoURLModel
/// @author waitwalker
/// @time 2020/9/25 9:48 AM
///
public class VideoURLModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"onlineCourseId":129510,"onlineCourseName":"有理数的相关概念","videoUrl":"http://cdn9-hd.etiantian.net/a781a54f4a0918fb3596b86f34d7a6b5/1601024359/etthd/mscz000635/400.mp4","imageUrl":"http://cdn9-hd.etiantian.net/adb426743301916aba41c6dd2a782118/1601024359/etthd/mscz000635/cover.jpg","playVideoUrl":"http://web.etiantian.com/ett20/hls/hd.m3u8?p=mscz000635&s=a&t=1600998425&v=61B363FE4914DA7C45B23E538592B3EA&h=http%3A%2F%2Fcdn5.hd.etiantian.net","resourceId":682893}
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
         * onlineCourseId : 129510
         * onlineCourseName : 有理数的相关概念
         * videoUrl : http://cdn9-hd.etiantian.net/a781a54f4a0918fb3596b86f34d7a6b5/1601024359/etthd/mscz000635/400.mp4
         * imageUrl : http://cdn9-hd.etiantian.net/adb426743301916aba41c6dd2a782118/1601024359/etthd/mscz000635/cover.jpg
         * playVideoUrl : http://web.etiantian.com/ett20/hls/hd.m3u8?p=mscz000635&s=a&t=1600998425&v=61B363FE4914DA7C45B23E538592B3EA&h=http%3A%2F%2Fcdn5.hd.etiantian.net
         * resourceId : 682893
         */

        private int onlineCourseId;
        private String onlineCourseName;
        private String videoUrl;
        private String imageUrl;
        private String playVideoUrl;
        private int resourceId;

        public int getOnlineCourseId() {
            return onlineCourseId;
        }

        public void setOnlineCourseId(int onlineCourseId) {
            this.onlineCourseId = onlineCourseId;
        }

        public String getOnlineCourseName() {
            return onlineCourseName;
        }

        public void setOnlineCourseName(String onlineCourseName) {
            this.onlineCourseName = onlineCourseName;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getPlayVideoUrl() {
            return playVideoUrl;
        }

        public void setPlayVideoUrl(String playVideoUrl) {
            this.playVideoUrl = playVideoUrl;
        }

        public int getResourceId() {
            return resourceId;
        }

        public void setResourceId(int resourceId) {
            this.resourceId = resourceId;
        }
    }
}
