package com.springcloudlx.apigatewaywitheureka.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SuccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(SuccessFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //request.getMethod()请求的类型，post get ..
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        //取到accessToken参数
        Object accessToken = request.getParameter("accessToken");
        //如果为空
        if(accessToken == null) {
            //log WARN输出打印
            log.warn("access token is empty");
            //关闭响应
            ctx.setSendZuulResponse(false);
            //状态码set为401
            ctx.setResponseStatusCode(401);
            return null;
        }
        //成功
        log.info("access token ok");
        return null;
    }
}
