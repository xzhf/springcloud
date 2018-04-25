package com.xx.springcloud.zuul.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xx.springcloud.zuul.bean.RestObj;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static com.xx.springcloud.zuul.bean.FilterType.pre;

/**
 * zuul过滤器
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/25
 */
@Component
public class AuthFilter extends ZuulFilter{

    //定义过滤器类型
    @Override
    public String filterType() {
        return pre.name();
    }

    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //具体实现
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                HttpServletResponse response = ctx.getResponse();
                response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                PrintWriter writer = ctx.getResponse().getWriter();
                writer.write(RestObj.tokenFail().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
