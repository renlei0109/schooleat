/**
 * 
 */
package cn.com.school.eat.code.util.user;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-23 下午7:12:45 简单说明
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {

public void sendMsg(String mobile,int num) throws Exception{

	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
	NameValuePair[] data ={ new NameValuePair("Uid", "信风软件"),new NameValuePair("Key", "b6bb776672f6549dd2ae"),new NameValuePair("smsMob",mobile),new NameValuePair("smsText","欢迎注册【巨饿】，您的验证码是"+num)};
	post.setRequestBody(data);
	
	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
		System.out.println(h.toString());
	}
		String result = null;
		try {
			result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(result);
		
		
		post.releaseConnection();
	
	}

	public static void main(String[] args)throws Exception
	{
			
		new SendMsg_webchinese().sendMsg("15524878489", 787987);
	}
}