package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/4
 *
 * 所有action父类
 */
public class SuperAction extends ActionSupport implements ServletContextAware, ServletResponseAware, ServletRequestAware {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    protected HttpSession session;

    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
        this.session = request.getSession();
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response=response;

    }

    public void setServletContext(ServletContext context) {
        this.context=context;
    }
}



















