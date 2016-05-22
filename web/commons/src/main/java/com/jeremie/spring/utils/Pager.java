package com.jeremie.spring.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guanhong 15/10/4 下午7:31.
 */
public class Pager extends PageRequest {

    //默认到第一页
    private static int DEFAULT_PAGE = 1;
    //默认十行数据
    private static int DEFAULT_SIZE = 10;

    public Pager(int page, int size) {
        super(page - 1, size);
    }

    public Pager(int page, int size, Sort.Direction direction, String... properties) {
        super(page -1 , size, direction, properties);
    }

    public Pager(int page, int size, Sort sort) {
        super(page - 1 , size, sort);
    }

    public Pager(HttpServletRequest request) {
        super(getPage(request), getSize(request));
    }

    public Pager(HttpServletRequest request, int size) {
        super(getPage(request), size);
    }

    public Pager(HttpServletRequest request, Sort sort) {
        super(getPage(request), getSize(request), sort);
    }

    public Pager(HttpServletRequest request, int size, Sort sort) {
        super(getPage(request), size, sort);
    }

    public Pager(HttpServletRequest request, Sort.Direction direction, String... properties) {
        super(getPage(request), getSize(request), direction, properties);
    }

    public Pager(HttpServletRequest request, int size, Sort.Direction direction, String... properties) {
        super(getPage(request), size, direction, properties);
    }

    private static int getPage(HttpServletRequest request) {
        String pageStr = request.getParameter("pageNo");
        if (StringUtils.isNumeric(pageStr))
            return Integer.parseInt(pageStr) - 1;
        else
            return DEFAULT_PAGE - 1;
    }

    private static int getSize(HttpServletRequest request) {
        String sizeStr = request.getParameter("pageSize");
        if (StringUtils.isNumeric(sizeStr))
            return Integer.parseInt(sizeStr);
        else
            return DEFAULT_SIZE;
    }


}
