package com.etiantian.onlineschoolandroid.modules.mycourse.subject_detail;

public class ResourceInfoModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"resouceId":675607,"resourceName":"有理数","imageUrl":"https://cdn9-hd.etiantian.net/f46cea4ce4367f75084cb00cf63aeba4/1602511996/etthd/ff5a22c44ecd113529ed646373e7288f/cover.jpg","introduction":null,"videoUrl":"https://web.etiantian.com/ett20/hls/hd1.m3u8?p=ff5a22c44ecd113529ed646373e7288f&s=a&t=1602484995&v=e88515bf97f0c0366040b09915d0218c&h=http%3A%2F%2Fcdn9-hd.etiantian.net","downPlanUrl":"http://attach.etiantian.com/security/7b6bff6457440d2e6fee81b93093ac08/5f83fb03/ett20/resource/nullnull","authorName":"","authorIntro":"","points":3,"path":"ff5a22c44ecd113529ed646373e7288f/","fileName":"1559265856920.pdf","literatureDownUrl":"https://attach.etiantian.com/security/7b6bff6457440d2e6fee81b93093ac08/5f83fb03/ett20/resource/ff5a22c44ecd113529ed646373e7288f/1559265856920.pdf","literaturePreviewUrl":"https://vip.ow365.cn/?i=13509&ssl=1&fname=ff5a22c44ecd113529ed646373e7288f/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7b6bff6457440d2e6fee81b93093ac08/5f83fb03/ett20/resource/ff5a22c44ecd113529ed646373e7288f/1559265856920.pdf","downloadVideoUrl":"https://cdn9-hd.etiantian.net/c04f19c57f9fbb8d52f7f9f25de7041a/1602511996/etthd/ff5a22c44ecd113529ed646373e7288f/400.mp4","subjectId":2}
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
         * resouceId : 675607
         * resourceName : 有理数
         * imageUrl : https://cdn9-hd.etiantian.net/f46cea4ce4367f75084cb00cf63aeba4/1602511996/etthd/ff5a22c44ecd113529ed646373e7288f/cover.jpg
         * introduction : null
         * videoUrl : https://web.etiantian.com/ett20/hls/hd1.m3u8?p=ff5a22c44ecd113529ed646373e7288f&s=a&t=1602484995&v=e88515bf97f0c0366040b09915d0218c&h=http%3A%2F%2Fcdn9-hd.etiantian.net
         * downPlanUrl : http://attach.etiantian.com/security/7b6bff6457440d2e6fee81b93093ac08/5f83fb03/ett20/resource/nullnull
         * authorName :
         * authorIntro :
         * points : 3
         * path : ff5a22c44ecd113529ed646373e7288f/
         * fileName : 1559265856920.pdf
         * literatureDownUrl : https://attach.etiantian.com/security/7b6bff6457440d2e6fee81b93093ac08/5f83fb03/ett20/resource/ff5a22c44ecd113529ed646373e7288f/1559265856920.pdf
         * literaturePreviewUrl : https://vip.ow365.cn/?i=13509&ssl=1&fname=ff5a22c44ecd113529ed646373e7288f/&furl=https://cdn1.school.etiantian.net/wxpdf/security/7b6bff6457440d2e6fee81b93093ac08/5f83fb03/ett20/resource/ff5a22c44ecd113529ed646373e7288f/1559265856920.pdf
         * downloadVideoUrl : https://cdn9-hd.etiantian.net/c04f19c57f9fbb8d52f7f9f25de7041a/1602511996/etthd/ff5a22c44ecd113529ed646373e7288f/400.mp4
         * subjectId : 2
         */

        private int resouceId;
        private String resourceName;
        private String imageUrl;
        private Object introduction;
        private String videoUrl;
        private String downPlanUrl;
        private String authorName;
        private String authorIntro;
        private int points;
        private String path;
        private String fileName;
        private String literatureDownUrl;
        private String literaturePreviewUrl;
        private String downloadVideoUrl;
        private int subjectId;

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

        public Object getIntroduction() {
            return introduction;
        }

        public void setIntroduction(Object introduction) {
            this.introduction = introduction;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getDownPlanUrl() {
            return downPlanUrl;
        }

        public void setDownPlanUrl(String downPlanUrl) {
            this.downPlanUrl = downPlanUrl;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getAuthorIntro() {
            return authorIntro;
        }

        public void setAuthorIntro(String authorIntro) {
            this.authorIntro = authorIntro;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getLiteratureDownUrl() {
            return literatureDownUrl;
        }

        public void setLiteratureDownUrl(String literatureDownUrl) {
            this.literatureDownUrl = literatureDownUrl;
        }

        public String getLiteraturePreviewUrl() {
            return literaturePreviewUrl;
        }

        public void setLiteraturePreviewUrl(String literaturePreviewUrl) {
            this.literaturePreviewUrl = literaturePreviewUrl;
        }

        public String getDownloadVideoUrl() {
            return downloadVideoUrl;
        }

        public void setDownloadVideoUrl(String downloadVideoUrl) {
            this.downloadVideoUrl = downloadVideoUrl;
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }
    }
}
