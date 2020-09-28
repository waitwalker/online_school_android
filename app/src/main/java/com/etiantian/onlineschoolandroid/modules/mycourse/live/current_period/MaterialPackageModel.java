package com.etiantian.onlineschoolandroid.modules.mycourse.live.current_period;

import java.util.List;

public class MaterialPackageModel {

    /**
     * code : 1
     * msg : null
     * data : [{"courseId":100400709340,"resourceId":744270,"name":"【2020-2021秋季讲义】初二物理 第一讲《测量和运动快慢 》 非凡班","classId":2,"path":"e6feb6b606ccec7605fd4510961289f5/","fileName":"1599715006745.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/e6feb6b606ccec7605fd4510961289f5/1599715006745.pdf","ctime":"2020-09-10 13:16:46"},{"courseId":100400709340,"resourceId":745116,"name":"【2020-2021秋季讲义】初二物理 第二讲《平均速度和速度计算经典模型 》 非凡班","classId":2,"path":"5c92a2413eea8a40f731f1d4cbb8616d/","fileName":"1600330737761.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/5c92a2413eea8a40f731f1d4cbb8616d/1600330737761.pdf","ctime":"2020-09-17 16:18:57"},{"courseId":100400709340,"resourceId":745789,"name":"【2020-2021秋季讲义】初二物理 第三讲《声现象进阶 》 非凡班","classId":2,"path":"25b123455ad362e16f4e243ffec87f0f/","fileName":"1600935024957.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/25b123455ad362e16f4e243ffec87f0f/1600935024957.pdf","ctime":"2020-09-24 16:10:24"},{"courseId":100400709040,"resourceId":744269,"name":"【2020-2021秋季讲义】初二物理 第一讲《测量和运动快慢 》 蓄能班","classId":2,"path":"392cc3f659b774ba84bbd8e9003ba76f/","fileName":"1599714883293.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/392cc3f659b774ba84bbd8e9003ba76f/1599714883293.pdf","ctime":"2020-09-10 13:14:43"},{"courseId":100400709040,"resourceId":745112,"name":"【2020-2021秋季讲义】初二物理 第二讲《平均速度和速度计算经典模型 》 蓄能班","classId":2,"path":"fecc9319b0acdcc68c30786ab9e4b2d4/","fileName":"1600331044661.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/fecc9319b0acdcc68c30786ab9e4b2d4/1600331044661.pdf","ctime":"2020-09-17 16:14:49"},{"courseId":100400709040,"resourceId":745788,"name":"【2020-2021秋季讲义】 初二物理 第三讲 《声现象进阶》 蓄能班","classId":2,"path":"cdaa46800e98b8709624f4abf78d14c9/","fileName":"1600934822159.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/cdaa46800e98b8709624f4abf78d14c9/1600934822159.pdf","ctime":"2020-09-24 16:07:02"},{"courseId":100400709040,"resourceId":746112,"name":"【2020-2021秋季讲义】初二物理 第四讲《温度、熔化和凝固 》 蓄能班 讲义","classId":2,"path":"cc8aaae7580cf734f4ec5dbacf897bd5/","fileName":"1601192465589.pdf","subjectId":4,"schoolId":0,"ownerSchoolId":0,"submitUserId":2303100,"submitUsername":"刘冰","enable":1,"enableUserId":2303100,"enableUsername":"刘冰","fileUrl":"https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/cc8aaae7580cf734f4ec5dbacf897bd5/1601192465589.pdf","ctime":"2020-09-27 15:41:05"}]
     */

    private int code;
    private Object msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
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
         * courseId : 100400709340
         * resourceId : 744270
         * name : 【2020-2021秋季讲义】初二物理 第一讲《测量和运动快慢 》 非凡班
         * classId : 2
         * path : e6feb6b606ccec7605fd4510961289f5/
         * fileName : 1599715006745.pdf
         * subjectId : 4
         * schoolId : 0
         * ownerSchoolId : 0
         * submitUserId : 2303100
         * submitUsername : 刘冰
         * enable : 1
         * enableUserId : 2303100
         * enableUsername : 刘冰
         * fileUrl : https://attach.etiantian.com/security/2e9c708ca87646ee6050f47bd9ae6a36/5f7184e6/ett20/resource/e6feb6b606ccec7605fd4510961289f5/1599715006745.pdf
         * ctime : 2020-09-10 13:16:46
         */

        private long courseId;
        private int resourceId;
        private String name;
        private int classId;
        private String path;
        private String fileName;
        private int subjectId;
        private int schoolId;
        private int ownerSchoolId;
        private int submitUserId;
        private String submitUsername;
        private int enable;
        private int enableUserId;
        private String enableUsername;
        private String fileUrl;
        private String ctime;

        public long getCourseId() {
            return courseId;
        }

        public void setCourseId(long courseId) {
            this.courseId = courseId;
        }

        public int getResourceId() {
            return resourceId;
        }

        public void setResourceId(int resourceId) {
            this.resourceId = resourceId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
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

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public int getOwnerSchoolId() {
            return ownerSchoolId;
        }

        public void setOwnerSchoolId(int ownerSchoolId) {
            this.ownerSchoolId = ownerSchoolId;
        }

        public int getSubmitUserId() {
            return submitUserId;
        }

        public void setSubmitUserId(int submitUserId) {
            this.submitUserId = submitUserId;
        }

        public String getSubmitUsername() {
            return submitUsername;
        }

        public void setSubmitUsername(String submitUsername) {
            this.submitUsername = submitUsername;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public int getEnableUserId() {
            return enableUserId;
        }

        public void setEnableUserId(int enableUserId) {
            this.enableUserId = enableUserId;
        }

        public String getEnableUsername() {
            return enableUsername;
        }

        public void setEnableUsername(String enableUsername) {
            this.enableUsername = enableUsername;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }
    }
}
