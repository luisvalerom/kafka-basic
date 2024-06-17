package com.luisvalerom.common.utils;

import java.util.Random;

import com.luisvalerom.common.model.PageView;

public final class PageViewUtil {

    static final String[] users = "Maria,Pedro,Carla,Juan,Javier,Daniel,Rosa,Rebeca,Sofia,Jhon,Luis,Alondra".split(",");
    static final String[] pages = "index,orders,payment,cart,blog,dashboard,user,account,settings,views".split(",");

    public static String getUserId() {
        var index = new Random().nextInt(users.length);
        return users[index];
    }

    public static String getPage() {
        var index = new Random().nextInt(pages.length);
        return pages[index];
    }

    public static long getDuration() {
        return new Random().nextInt(100);
    }

    public static PageView getPageView() {
        return new PageView(getUserId(), getPage(), getDuration());
    }
}
