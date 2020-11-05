package com.etiantian.onlineschoolandroid.modules.personal.my_card_record;

import java.util.List;

///
/// @description 我的卡记录模型类
/// @author waitwalker
/// @time 2020/11/5 10:29 AM
///
public class MyCardRecordModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : [{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2020-08-03 14:09:39"},{"courseCardId":100374879752,"courseCardName":"强国推荐课课程卡","subjectId":0,"gardId":1590631944,"activationTime":"2020-07-02 17:32:19"},{"courseCardId":100374879752,"courseCardName":"强国推荐课课程卡","subjectId":0,"gardId":1590631944,"activationTime":"2020-07-02 17:26:53"},{"courseCardId":100374879752,"courseCardName":"强国推荐课课程卡","subjectId":0,"gardId":1590631944,"activationTime":"2020-07-02 16:37:02"},{"courseCardId":100374879752,"courseCardName":"强国推荐课课程卡","subjectId":0,"gardId":1590631944,"activationTime":"2020-07-02 16:33:33"},{"courseCardId":100374879752,"courseCardName":"强国推荐课课程卡","subjectId":0,"gardId":1590631944,"activationTime":"2020-07-02 16:03:44"},{"courseCardId":100374879752,"courseCardName":"强国推荐课课程卡","subjectId":0,"gardId":1590631944,"activationTime":"2020-07-01 16:30:45"},{"courseCardId":100374252385,"courseCardName":"小升初起航卡","subjectId":0,"gardId":1590004577,"activationTime":"2020-06-29 14:09:01"},{"courseCardId":100374252385,"courseCardName":"小升初起航卡","subjectId":0,"gardId":1590004577,"activationTime":"2020-06-29 14:08:18"},{"courseCardId":100156049654,"courseCardName":"小升初进阶卡","subjectId":0,"gardId":1371801846,"activationTime":"2020-06-28 14:07:09"},{"courseCardId":100358508941,"courseCardName":"中国联通用户专属权益卡","subjectId":0,"gardId":1574261133,"activationTime":"2020-06-03 11:54:53"},{"courseCardId":100358508941,"courseCardName":"中国联通用户专属权益卡","subjectId":0,"gardId":1574261133,"activationTime":"2020-06-03 09:59:49"},{"courseCardId":100339426063,"courseCardName":"中考语文阅读或写作二选一","subjectId":0,"gardId":1555178255,"activationTime":"2020-05-05 18:37:07"},{"courseCardId":100301261846,"courseCardName":"小学魔法拼音课","subjectId":0,"gardId":1517014038,"activationTime":"2020-04-08 13:38:59"},{"courseCardId":100290984729,"courseCardName":"2020高考冲刺卡","subjectId":0,"gardId":1506736921,"activationTime":"2020-03-19 16:47:46"},{"courseCardId":100290984729,"courseCardName":"2020高考冲刺卡","subjectId":0,"gardId":1506736921,"activationTime":"2020-03-19 16:25:28"},{"courseCardId":100290984729,"courseCardName":"2020高考冲刺卡","subjectId":0,"gardId":1506736921,"activationTime":"2020-03-18 23:28:26"},{"courseCardId":100290984729,"courseCardName":"2020高考冲刺卡","subjectId":0,"gardId":1506736921,"activationTime":"2020-03-18 22:12:55"},{"courseCardId":100290984729,"courseCardName":"2020高考冲刺卡","subjectId":0,"gardId":1506736921,"activationTime":"2020-03-18 22:08:37"},{"courseCardId":100246004215,"courseCardName":"小升初圆梦卡","subjectId":0,"gardId":1461756407,"activationTime":"2020-02-23 14:34:47"},{"courseCardId":100246004215,"courseCardName":"小升初圆梦卡","subjectId":0,"gardId":1461756407,"activationTime":"2020-02-23 14:33:09"},{"courseCardId":100143950640,"courseCardName":"小升初领学卡","subjectId":0,"gardId":1359702832,"activationTime":"2019-12-26 16:53:41"},{"courseCardId":100143950640,"courseCardName":"小升初领学卡","subjectId":0,"gardId":1359702832,"activationTime":"2019-12-26 16:53:41"},{"courseCardId":100143950640,"courseCardName":"小升初领学卡","subjectId":0,"gardId":1359702832,"activationTime":"2019-12-26 16:53:41"},{"courseCardId":100143950640,"courseCardName":"小升初领学卡","subjectId":0,"gardId":1359702832,"activationTime":"2019-12-26 16:53:41"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":100040744926,"courseCardName":"智学卡（演示卡）","subjectId":0,"gardId":1256497118,"activationTime":"2019-09-04 15:19:29"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"},{"courseCardId":4090623416,"courseCardName":"智领365天卡（演示卡）","subjectId":0,"gardId":-204343880,"activationTime":"2019-07-26 13:33:40"}]
     */

    private int code;
    private String msg;
    /**
     * courseCardId : 100040744926
     * courseCardName : 智学卡（演示卡）
     * subjectId : 0
     * gardId : 1256497118
     * activationTime : 2020-08-03 14:09:39
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
        private long courseCardId;
        private String courseCardName;
        private int subjectId;
        private int gardId;
        private String activationTime;

        public long getCourseCardId() {
            return courseCardId;
        }

        public void setCourseCardId(long courseCardId) {
            this.courseCardId = courseCardId;
        }

        public String getCourseCardName() {
            return courseCardName;
        }

        public void setCourseCardName(String courseCardName) {
            this.courseCardName = courseCardName;
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public int getGardId() {
            return gardId;
        }

        public void setGardId(int gardId) {
            this.gardId = gardId;
        }

        public String getActivationTime() {
            return activationTime;
        }

        public void setActivationTime(String activationTime) {
            this.activationTime = activationTime;
        }
    }
}
