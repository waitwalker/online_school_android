package com.etiantian.onlineschoolandroid.model;

///
/// @description 注册model
/// @author waitwalker
/// @time 2020/9/7 1:28 PM
///
public class RegisterModel {
    /**
     * code : 1
     * msg : 操作成功
     * data : {"code":"123"}
     */

    private int code;
    private String msg;
    private CodeModel.DataBean data;

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

    public CodeModel.DataBean getData() {
        return data;
    }

    public void setData(CodeModel.DataBean data) {
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
