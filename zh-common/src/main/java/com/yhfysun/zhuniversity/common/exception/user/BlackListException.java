package com.yhfysun.zhuniversity.common.exception.user;

/**
 * 黑名单IP异常类
 * 
 * @author yhfysun
 */
public class BlackListException extends UserException
{
    private static final long serialVersionUID = 1L;

    public BlackListException()
    {
        super("login.blocked", null);
    }
}
