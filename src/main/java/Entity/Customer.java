package Entity;

/**
 * @author 杨光儒
 * @Title: entity
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1010:56
 */
public class Customer {
    private int userid;
    private String username;
    private String password;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
