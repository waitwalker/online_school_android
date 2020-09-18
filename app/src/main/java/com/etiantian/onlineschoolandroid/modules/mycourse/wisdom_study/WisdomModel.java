package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import java.util.List;

public class WisdomModel {

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
        private int level;
        private int nodeId;
        private String nodeName;
        private List<NodeListBean> nodeList;
        private List<NodeListBean.ResourceIdListBean> resourceIdList;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }

        public List<NodeListBean> getNodeList() {
            return nodeList;
        }

        public void setNodeList(List<NodeListBean> nodeList) {
            this.nodeList = nodeList;
        }

        public List<NodeListBean.ResourceIdListBean> getResourceIdList() {
            return resourceIdList;
        }

        public void setResourceIdList(List<NodeListBean.ResourceIdListBean> resourceIdList) {
            this.resourceIdList = resourceIdList;
        }

        public static class NodeListBean {
            private int level;
            private int nodeId;
            private String nodeName;
            private List<NodeListBean> nodeList;
            private List<NodeListBean.ResourceIdListBean> resourceIdList;

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getNodeId() {
                return nodeId;
            }

            public void setNodeId(int nodeId) {
                this.nodeId = nodeId;
            }

            public String getNodeName() {
                return nodeName;
            }

            public void setNodeName(String nodeName) {
                this.nodeName = nodeName;
            }

            public List<DataBean.NodeListBean> getNodeList() {
                return nodeList;
            }

            public void setNodeList(List<NodeListBean> nodeList) {
                this.nodeList = nodeList;
            }

            public List<NodeListBean.ResourceIdListBean> getResourceIdList() {
                return resourceIdList;
            }

            public void setResourceIdList(List<NodeListBean.ResourceIdListBean> resourceIdList) {
                this.resourceIdList = resourceIdList;
            }

            public static class ResourceIdListBean {

                private Object cTime;
                private int clicks;
                private int diffType;
                private int downloadnum;
                private int fileSize;
                private String fileSuffixname;
                private int fileType;
                private int grade;
                private Object mTime;
                private int netShareStatus;
                private int reportnum;
                private int resDegree;
                private int resId;
                private String resIntroduce;
                private String resName;
                private int resScore;
                private int resSource;
                private int resStatus;
                private int resType;
                private int shareStatus;
                private String srcABPaperQuesIds;
                private int storenum;
                private int studyStatus;
                private int subject;
                private int totalShareStatus;
                private int userId;

                public Object getCTime() {
                    return cTime;
                }

                public void setCTime(Object cTime) {
                    this.cTime = cTime;
                }

                public int getClicks() {
                    return clicks;
                }

                public void setClicks(int clicks) {
                    this.clicks = clicks;
                }

                public int getDiffType() {
                    return diffType;
                }

                public void setDiffType(int diffType) {
                    this.diffType = diffType;
                }

                public int getDownloadnum() {
                    return downloadnum;
                }

                public void setDownloadnum(int downloadnum) {
                    this.downloadnum = downloadnum;
                }

                public int getFileSize() {
                    return fileSize;
                }

                public void setFileSize(int fileSize) {
                    this.fileSize = fileSize;
                }

                public String getFileSuffixname() {
                    return fileSuffixname;
                }

                public void setFileSuffixname(String fileSuffixname) {
                    this.fileSuffixname = fileSuffixname;
                }

                public int getFileType() {
                    return fileType;
                }

                public void setFileType(int fileType) {
                    this.fileType = fileType;
                }

                public int getGrade() {
                    return grade;
                }

                public void setGrade(int grade) {
                    this.grade = grade;
                }

                public Object getMTime() {
                    return mTime;
                }

                public void setMTime(Object mTime) {
                    this.mTime = mTime;
                }

                public int getNetShareStatus() {
                    return netShareStatus;
                }

                public void setNetShareStatus(int netShareStatus) {
                    this.netShareStatus = netShareStatus;
                }

                public int getReportnum() {
                    return reportnum;
                }

                public void setReportnum(int reportnum) {
                    this.reportnum = reportnum;
                }

                public int getResDegree() {
                    return resDegree;
                }

                public void setResDegree(int resDegree) {
                    this.resDegree = resDegree;
                }

                public int getResId() {
                    return resId;
                }

                public void setResId(int resId) {
                    this.resId = resId;
                }

                public String getResIntroduce() {
                    return resIntroduce;
                }

                public void setResIntroduce(String resIntroduce) {
                    this.resIntroduce = resIntroduce;
                }

                public String getResName() {
                    return resName;
                }

                public void setResName(String resName) {
                    this.resName = resName;
                }

                public int getResScore() {
                    return resScore;
                }

                public void setResScore(int resScore) {
                    this.resScore = resScore;
                }

                public int getResSource() {
                    return resSource;
                }

                public void setResSource(int resSource) {
                    this.resSource = resSource;
                }

                public int getResStatus() {
                    return resStatus;
                }

                public void setResStatus(int resStatus) {
                    this.resStatus = resStatus;
                }

                public int getResType() {
                    return resType;
                }

                public void setResType(int resType) {
                    this.resType = resType;
                }

                public int getShareStatus() {
                    return shareStatus;
                }

                public void setShareStatus(int shareStatus) {
                    this.shareStatus = shareStatus;
                }

                public String getSrcABPaperQuesIds() {
                    return srcABPaperQuesIds;
                }

                public void setSrcABPaperQuesIds(String srcABPaperQuesIds) {
                    this.srcABPaperQuesIds = srcABPaperQuesIds;
                }

                public int getStorenum() {
                    return storenum;
                }

                public void setStorenum(int storenum) {
                    this.storenum = storenum;
                }

                public int getStudyStatus() {
                    return studyStatus;
                }

                public void setStudyStatus(int studyStatus) {
                    this.studyStatus = studyStatus;
                }

                public int getSubject() {
                    return subject;
                }

                public void setSubject(int subject) {
                    this.subject = subject;
                }

                public int getTotalShareStatus() {
                    return totalShareStatus;
                }

                public void setTotalShareStatus(int totalShareStatus) {
                    this.totalShareStatus = totalShareStatus;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }
            }
        }

    }
}
