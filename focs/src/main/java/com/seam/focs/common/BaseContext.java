package com.seam.focs.common;

/**
 * Based on ThreadLocal Encapsulation Tool, User Maintain, Get Currently Logged-in User
 * Instead of passing the user ID or data explicitly through parameters
 * Use BaseContext.getCurrentId() to retrieve it whenever needed.
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
