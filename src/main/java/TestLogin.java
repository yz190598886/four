import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.*;
import org.apache.commons.httpclient.methods.*;

public class TestLogin {
        static final String LOGON_SITE = "120.76.84.195" ;
        static final int     LOGON_PORT = 8084;

        public  void one() throws Exception{
            HttpClient client = new HttpClient();
            client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);

            // 登录
            PostMethod post = new PostMethod( "/submitLogin" );
            NameValuePair account = new NameValuePair( "account" , "191415" );
            NameValuePair password = new NameValuePair( "password" , "158743" );
            post.setRequestBody( new NameValuePair[]{account,password});
            int status = client.executeMethod(post);
            System.out.println(status);
            System.out.println("-------------------------------------------------------");
            System.out.println(post.getResponseBodyAsString());
            System.out.println("-------------------------------------------------------");
            post.releaseConnection();

            // 查看 cookie 信息
            CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
            Cookie[] cookies = cookiespec.match(LOGON_SITE, LOGON_PORT, "/" , false , client.getState().getCookies());
            if (cookies.length == 0) {
                System.out.println( "None" );
            } else {
                for ( int i = 0; i < cookies.length; i++) {
                    System.out.println(cookies[i].toString());
                    System.out.println("-------------------------------------------------------");
                }
            }
//            // 养老项目
//            PostMethod post1=new PostMethod("/service/queryServiceItems");
//            NameValuePair streetId = new NameValuePair( "streetId" , "900109" );
//            NameValuePair groupId = new NameValuePair( "groupId" , "2" );
//            NameValuePair type = new NameValuePair( "type" , "1" );
//            post1.setRequestBody( new NameValuePair[]{streetId,groupId,type});
//            client.executeMethod(post1);
//            String Fh=post1.getResponseBodyAsString();//返回json
//            System.out.println(Fh);
//            post1.releaseConnection();
//            JSONObject json= JSON.parseObject(Fh);
//            String a = json.get("pageView").toString();//取第一层
//            JSONObject j2 = JSON.parseObject(a);
//            System.out.println(j2.get("rowCount").toString());// 取第二层
//            String c = j2.get("records").toString();// 取第三层【】
//            JSONArray c1 = (JSONArray) JSONArray.parse(c);
//             JSONObject jsonObject1 = null;
//                 jsonObject1=(JSONObject) c1.get(0);//取第一个项目id
//                 String ok=jsonObject1.get("id").toString();
//                 System.out.println(ok);

            PostMethod post1=new PostMethod("/service/createOrders");
            NameValuePair groupId= new NameValuePair( "groupId" , "2" );
            NameValuePair classification = new NameValuePair( "classification" , "1" );
            NameValuePair idcard = new NameValuePair( "idcard" , "971513191701170177" );
            NameValuePair uid = new NameValuePair( "uid" , "472637" );
            NameValuePair itemsId = new NameValuePair( "itemsId" , "8761" );
            NameValuePair number = new NameValuePair( "number" , "1" );
            NameValuePair endDate = new NameValuePair( "endDate" , "2017-11-21 23:59:59" );
            post1.setRequestBody( new NameValuePair[]{groupId,classification,idcard,uid,itemsId,number,endDate});
            int status1 = client.executeMethod(post1);
            System.out.println(status1);
            if(status1!=200){
                System.out.println("生成失败----------------------------------------------");
            }
           else{
                client.executeMethod(post1);
            String hy=post1.getResponseBodyAsString();//返回json
            System.out.println(hy);
            }

    }
    }

