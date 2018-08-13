package CrudDao;

import Entity.Customer;
import Entity.Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨光儒
 * @Title: method
 * @ProjectName project1
 * @Description: TODO
 * @date 2018/8/919:01
 */
public class Conection {
    Connection conn =null;
    PreparedStatement pstmt =null;
    public Connection getConn() throws Exception{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password ="123456";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
        return conn;
    }
    /*
    * 插入数据
    * */
    public int insert()throws Exception{
        Connection conn = getConn();
        int i =0;
        String sql = "insert into study(userid,username,age)values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,3);
        pstmt.setString(2,"韦德");
        pstmt.setString(3,"3");
        i = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return i;
    }
    /*登陆验证
    *
    * */
    public Customer getall() throws Exception{
        Connection conn = getConn();
        String sql = "select*from study";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Customer u = new Customer();
        while (rs.next()){
            u.setUserid(rs.getInt("userid"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
        }
        conn.close();
        return u;
    }
    public List<Film> getfilm() throws Exception {
       Connection conn = getConn();
       String sql = "select* from film f left join language lg on f.language_id = lg.language_id ";
       pstmt = conn.prepareStatement(sql);
       ResultSet rs = pstmt.executeQuery();
       List<Film> list = new ArrayList<Film>();
       Film film;
       while (rs.next()){
           film = new Film();
           System.out.println(rs.getInt("film_id")+" "+rs.getString("title")+" "+rs.getString("description")+" "+rs.getString("language"));
           film.setFile_id(rs.getInt("film_id"));
           film.setTitle(rs.getString("title"));
           film.setDescription(rs.getString("description"));
           film.setLanguage(rs.getString("language"));
           list.add(film);
       }
       conn.close();
       return list;
    }
    public int delect (int id) throws Exception{
        System.out.println(id);
        conn = getConn();
        String sql = "delete from film where film_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        int i =pstmt.executeUpdate();
        conn.close();
        return i;
    }
    /*
    * 添加
    * */
    public int add(Film film) throws Exception {
        conn = getConn();
        String sql = "Insert into film(title,description,language_id) values(?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,film.getTitle());
        pstmt.setString(2,film.getDescription());
        pstmt.setInt(3,film.getLanguage_id());
        int n = pstmt.executeUpdate();
        conn.close();
        return n;
    }
    /*
    * 根据Id查找
    * */
    public Film getById(String id) throws Exception {
        System.out.println("qwert"+id);
        conn = getConn();
        String sql = "select*from film where film_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,Integer.valueOf(id));
        ResultSet rs = pstmt.executeQuery();
        Film film = new Film();
        while (rs.next()){
            film.setFile_id(rs.getInt("film_id"));
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            film.setLanguage_id(rs.getInt("language_id"));
        }
        conn.close();
        System.out.println(film);
        return film;
    }

    /*
    * 更新
    * */

    public int  update(Film film) throws Exception {
        System.out.println("ssss"+Integer.valueOf(film.getFile_id()));
        conn =getConn();
        String sql = "update film set title=?,description=?,language_id=? where film_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,film.getTitle());
        pstmt.setString(2,film.getDescription());
        pstmt.setInt(3,film.getLanguage_id());
        pstmt.setInt(4,Integer.valueOf(film.getFile_id()));
        int n = pstmt.executeUpdate();
        conn.close();
        return n;
    }

}
