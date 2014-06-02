/**
 * 
 */
package cn.com.school.eat.code.util.user;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-5-23 ����7:12:45 ��˵��
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
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//��ͷ�ļ�������ת��
	NameValuePair[] data ={ new NameValuePair("Uid", "�ŷ����"),new NameValuePair("Key", "b6bb776672f6549dd2ae"),new NameValuePair("smsMob",mobile),new NameValuePair("smsText","��ӭע�᡾�޶�����������֤����"+num)};
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