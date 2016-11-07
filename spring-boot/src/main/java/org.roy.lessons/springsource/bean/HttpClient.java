package org.roy.lessons.springsource.bean;

/**
 * Created by lilei on 2016/10/14.
 */
public class HttpClient {
    private int version;
    private String versionDesc;

    public HttpClient() {
    }

    public HttpClient(int version, String versionDesc) {
        this.version = version;
        this.versionDesc = versionDesc;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc;
    }
}
