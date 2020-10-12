package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import java.util.List;

///
/// @description 微课视频model
/// @author waitwalker
/// @time 2020/10/12 2:05 PM
///
public class MicroCourseModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"resouceId":560746,"resourceName":"有理数随堂练习(新授)","imageUrl":"https://cdn9-hd.etiantian.net/45e05a182d4179dced0ac132bded380e/1602509598/etthd/wkczsx001444/cover.jpg","videoUrl":"https://cdn9-hd.etiantian.net/6f992f287a920799a9298d5f3448f794/1602509598/etthd/wkczsx001444/400.mp4","planUrlList":[{"previewPlanUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=dde6c415e3a4de7a922b83f6d4ae6388/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/dde6c415e3a4de7a922b83f6d4ae6388/b.doc","dowPlanUrl":"https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/dde6c415e3a4de7a922b83f6d4ae6388/b.doc"},{"previewPlanUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=6337cf412183e064b18f82e3c48e9e4e/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/6337cf412183e064b18f82e3c48e9e4e/b.doc","dowPlanUrl":"https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/6337cf412183e064b18f82e3c48e9e4e/b.doc"},{"previewPlanUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=b8d55535d29466af2b27a9d0e1401d6f/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/b8d55535d29466af2b27a9d0e1401d6f/b.doc","dowPlanUrl":"https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/b8d55535d29466af2b27a9d0e1401d6f/b.doc"}],"path":"wkczsx001444/"}
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
         * resouceId : 560746
         * resourceName : 有理数随堂练习(新授)
         * imageUrl : https://cdn9-hd.etiantian.net/45e05a182d4179dced0ac132bded380e/1602509598/etthd/wkczsx001444/cover.jpg
         * videoUrl : https://cdn9-hd.etiantian.net/6f992f287a920799a9298d5f3448f794/1602509598/etthd/wkczsx001444/400.mp4
         * planUrlList : [{"previewPlanUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=dde6c415e3a4de7a922b83f6d4ae6388/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/dde6c415e3a4de7a922b83f6d4ae6388/b.doc","dowPlanUrl":"https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/dde6c415e3a4de7a922b83f6d4ae6388/b.doc"},{"previewPlanUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=6337cf412183e064b18f82e3c48e9e4e/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/6337cf412183e064b18f82e3c48e9e4e/b.doc","dowPlanUrl":"https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/6337cf412183e064b18f82e3c48e9e4e/b.doc"},{"previewPlanUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=b8d55535d29466af2b27a9d0e1401d6f/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/b8d55535d29466af2b27a9d0e1401d6f/b.doc","dowPlanUrl":"https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/b8d55535d29466af2b27a9d0e1401d6f/b.doc"}]
         * path : wkczsx001444/
         */

        private int resouceId;
        private String resourceName;
        private String imageUrl;
        private String videoUrl;
        private String path;
        private List<PlanUrlListBean> planUrlList;

        public int getResouceId() {
            return resouceId;
        }

        public void setResouceId(int resouceId) {
            this.resouceId = resouceId;
        }

        public String getResourceName() {
            return resourceName;
        }

        public void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public List<PlanUrlListBean> getPlanUrlList() {
            return planUrlList;
        }

        public void setPlanUrlList(List<PlanUrlListBean> planUrlList) {
            this.planUrlList = planUrlList;
        }

        public static class PlanUrlListBean {
            /**
             * previewPlanUrl : https://vip.ow365.cn/?i=13509&ssl=1&fname=dde6c415e3a4de7a922b83f6d4ae6388/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/dde6c415e3a4de7a922b83f6d4ae6388/b.doc
             * dowPlanUrl : https://video.etiantian.com/security/7cfababa4c84c70a030d6dfc7b1fe045/5f83f1a5/ett20/resource/dde6c415e3a4de7a922b83f6d4ae6388/b.doc
             */

            private String previewPlanUrl;
            private String dowPlanUrl;

            public String getPreviewPlanUrl() {
                return previewPlanUrl;
            }

            public void setPreviewPlanUrl(String previewPlanUrl) {
                this.previewPlanUrl = previewPlanUrl;
            }

            public String getDowPlanUrl() {
                return dowPlanUrl;
            }

            public void setDowPlanUrl(String dowPlanUrl) {
                this.dowPlanUrl = dowPlanUrl;
            }
        }
    }
}
