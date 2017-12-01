

import org.testng.annotations.Test;

import java.sql.SQLException;

public class Test1{
    @Test
    public void one(){
        jdbc db=new jdbc();
        try {
            db.initDb();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            db.startTime();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
    }
    @Test(enabled = false)
    public void two(){
        TestLogin ok=new TestLogin();
        try {
            ok.one();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("++++++++++++++++++++++++++++");

    }
}
