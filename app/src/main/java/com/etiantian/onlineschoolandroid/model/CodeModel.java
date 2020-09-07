package com.etiantian.onlineschoolandroid.model;

///
/// @description 获取验证码model
/// @author waitwalker
/// @time 2020/9/7 10:18 AM
///
public class CodeModel {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"code":"123"}
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
         * code : 123
         */

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
