package com.cuit.pojo;

import java.util.List;

public class PageBean {
    private int total; //总记录数
    private int pages; //总页数
    private int currentPage; //当前页
    private int pagetotal; //当前页上的显示条数
    private List<Route> routeList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPagetotal() {
        return pagetotal;
    }

    public void setPagetotal(int pagetotal) {
        this.pagetotal = pagetotal;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", pages=" + pages +
                ", currentPage=" + currentPage +
                ", pagetotal=" + pagetotal +
                ", routeList=" + routeList +
                '}';
    }
}
