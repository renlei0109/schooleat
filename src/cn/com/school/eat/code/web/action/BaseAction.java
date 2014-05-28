package cn.com.school.eat.code.web.action;

import java.util.Map;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
  
public class BaseAction extends ActionSupport implements SessionAware{  
      
    private static final long serialVersionUID = 1L;  
  
    public void setSession(Map<String, Object> sessionMap) {        
          
    }     
      
    protected Map<String,Object> getSession(){  
        return  (Map<String,Object>)ActionContext.getContext().getSession();  
    }  
      
    protected HttpServletRequest getRequest(){  
        return ServletActionContext.getRequest ();   
    }  
}  
