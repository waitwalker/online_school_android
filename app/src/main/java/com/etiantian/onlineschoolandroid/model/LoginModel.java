package com.etiantian.onlineschoolandroid.model;

///
/// @description 登录model 返回access_token&超时时间等
/// @author waitwalker
/// @time 2020/9/2 11:32 AM
///
public class LoginModel {


    /**
     * access_token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXRhaWwiOnsidXNlcklkIjo5NjE1NjkyLCJ1c2VyTmFtZSI6Inh3eDE4NjAwMDAwMDAxIiwicGFzc3dvcmQiOiIiLCJ1c2VySWRlbnRpdHkiOjMsImVuYWJsZSI6MSwic2Nob29sVXNlcklkIjowLCJzY2hvb2xJZCI6MCwic2Nob29sVXNlclJlZiI6bnVsbCwic2Nob29sR3JvdXBJZCI6bnVsbCwicm9sZXMiOls1XSwidXJsTGlzdCI6bnVsbH0sImV4cCI6MTU5OTA0NjY4NiwidXNlcl9uYW1lIjoieHd4MTg2MDAwMDAwMDEiLCJqdGkiOiI0NDFmNTI2OC0yNzg1LTRmYzctOGM2Yy02Y2Y4ODlmMTFmNjIiLCJjbGllbnRfaWQiOiJDMkFCQ0E3RUJFMUE5M0QxRjBBMUMzRDlFOEQ2Qjc5RSIsInNjb3BlIjpbImFsbCIsIndlYiIsIm1vYmlsZSJdfQ.fzfIl2lKsYIjI0RaKLrLjBWjI5SElyDS8gqfXxFSUBc
     * expiresIn : 36000
     * refresh_token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ4d3gxODYwMDAwMDAwMSIsInNjb3BlIjpbImFsbCIsIndlYiIsIm1vYmlsZSJdLCJhdGkiOiI0NDFmNTI2OC0yNzg1LTRmYzctOGM2Yy02Y2Y4ODlmMTFmNjIiLCJkZXRhaWwiOnsidXNlcklkIjo5NjE1NjkyLCJ1c2VyTmFtZSI6Inh3eDE4NjAwMDAwMDAxIiwicGFzc3dvcmQiOiIiLCJ1c2VySWRlbnRpdHkiOjMsImVuYWJsZSI6MSwic2Nob29sVXNlcklkIjowLCJzY2hvb2xJZCI6MCwic2Nob29sVXNlclJlZiI6bnVsbCwic2Nob29sR3JvdXBJZCI6bnVsbCwicm9sZXMiOls1XSwidXJsTGlzdCI6bnVsbH0sImV4cCI6MTYwMTYwMjY4NiwianRpIjoiZjhiYWZiYjUtNDcwZC00ZjNmLWJiZTYtOTU5Mjg2MzRkNDU0IiwiY2xpZW50X2lkIjoiQzJBQkNBN0VCRTFBOTNEMUYwQTFDM0Q5RThENkI3OUUifQ.iIYUVwpLSiWHwsWRTPb_724E9LwywEWfDP9bdCXFmrg
     * expiration : 1599046686646
     */

    private String access_token;
    private int expiresIn;
    private String refresh_token;
    private long expiration;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
