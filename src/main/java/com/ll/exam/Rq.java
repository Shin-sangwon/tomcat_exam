package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Rq {
    private final HttpServletRequest req;

    private final HttpServletResponse resp;
    public Rq(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

    }

    public int getIntParam(String paramName, int defaultnum){
        String value = req.getParameter(paramName);

        if(value == null){
            return defaultnum;
        }

        try{
            return Integer.parseInt(value);
        }catch(NumberFormatException e){
            return defaultnum;
        }

    }

    public void appendBody(String body){
        try{
            resp.getWriter().append(body);
        }catch(IOException e){
            throw new RuntimeException();
        }

    }
}
