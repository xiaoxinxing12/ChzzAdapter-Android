package org.chzz.adapter.demo.mode;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/21 14:53
 * 描述:
 */
public class NormalModel {
    public String title;
    public String detail;
    public String avatorPath;
    public boolean selected;

    public NormalModel() {
    }

    public NormalModel(String title, String detail, String avatorPath) {
        this.title = title;
        this.detail = detail;
        this.avatorPath = avatorPath;
    }
}