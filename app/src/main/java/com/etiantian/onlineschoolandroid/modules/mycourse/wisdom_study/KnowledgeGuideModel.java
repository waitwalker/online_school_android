package com.etiantian.onlineschoolandroid.modules.mycourse.wisdom_study;

import java.util.List;

public class KnowledgeGuideModel {

    /**
     * code : 1
     * data : [{"resId":675588,"resName":"立体图形与平面图形"},{"resId":675589,"resName":"从不同方向看立体图形\u2014视图"},{"resId":675590,"resName":"立体图形的折叠与展开"},{"resId":675591,"resName":"点、线、面、体"},{"resId":675592,"resName":"直线、射线、线段的相关概念"},{"resId":675593,"resName":"直线、射线、线段的作图"},{"resId":675594,"resName":"线段的相关概念"},{"resId":675596,"resName":"角的相关概念"},{"resId":675597,"resName":"角的度量--角度制"},{"resId":675606,"resName":"正数和负数"},{"resId":675607,"resName":"有理数"},{"resId":675608,"resName":"数轴"},{"resId":675609,"resName":"相反数"},{"resId":675611,"resName":"化简多重符号"},{"resId":675654,"resName":"列代数式"},{"resId":675655,"resName":"代数式的值"},{"resId":675671,"resName":"角的比较和运算"},{"resId":675672,"resName":"余角"},{"resId":675673,"resName":"补角"},{"resId":675713,"resName":"单项式的相关概念"},{"resId":675715,"resName":"多项式的相关概念"},{"resId":675806,"resName":"绝对值"},{"resId":675807,"resName":"有理数的大小比较"},{"resId":675808,"resName":"绝对值的非负性"},{"resId":675809,"resName":"绝对值的化简"},{"resId":675810,"resName":"有理数的加法"},{"resId":675811,"resName":"有理数的减法"},{"resId":675812,"resName":"有理数的加减混合运算"},{"resId":675813,"resName":"有理数的乘法"},{"resId":675919,"resName":"整式的概念"},{"resId":675920,"resName":"整式的应用"},{"resId":676046,"resName":"有理数的除法"},{"resId":676047,"resName":"有理数的加减乘除混合运算"},{"resId":676048,"resName":"有理数的乘方"},{"resId":676049,"resName":"幂的符号规律"},{"resId":676050,"resName":"有理数的混合运算"},{"resId":676051,"resName":"近似数"},{"resId":676053,"resName":"科学记数法"},{"resId":676086,"resName":"同类项的定义"},{"resId":676087,"resName":"合并同类项"},{"resId":676088,"resName":"去括号法则"},{"resId":676089,"resName":"添括号法则"},{"resId":676443,"resName":"等式的性质及应用"},{"resId":676444,"resName":"设未知数列方程"},{"resId":676447,"resName":"解较简单的一元一次方程"},{"resId":676450,"resName":"解含括号的一元一次方程"},{"resId":676452,"resName":"解含分母的一元一次方程"},{"resId":676546,"resName":"解含字母的一元一次方程"},{"resId":676547,"resName":"和差倍分问题（一）"},{"resId":676548,"resName":"行程问题（一）"},{"resId":676549,"resName":"工程问题（一）"},{"resId":676550,"resName":"配套问题（一）"},{"resId":676608,"resName":"利润问题"},{"resId":676610,"resName":"存贷款与盈不足问题"},{"resId":676611,"resName":"数字问题（一）"},{"resId":676612,"resName":"几何图形问题"}]
     * msg : 操作成功
     */

    private int code;
    private String msg;
    /**
     * resId : 675588
     * resName : 立体图形与平面图形
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
        private int resId;
        private String resName;

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public String getResName() {
            return resName;
        }

        public void setResName(String resName) {
            this.resName = resName;
        }
    }
}
