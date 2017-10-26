/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.lab;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 *
 * @author HP Notebook
 */
@WebFilter(filterName = "IpFilter", value = "/",initParams ={
    @WebInitParam(name = "ip",value = "default")})
public class IpFilter implements Filter {
    
    private String ip=null;
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

            ip=filterConfig.getInitParameter("ip");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String c = request.getLocalName();
        
        request.setAttribute("ip", c);
        chain.doFilter(request, response);
          



    }

    @Override
    public void destroy() {
    }

}
