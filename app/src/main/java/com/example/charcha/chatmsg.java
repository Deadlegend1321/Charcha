package com.example.charcha;

import java.util.Date;

public class chatmsg {
    private String msg,msguser;
    private long msgtime;

    public chatmsg(String msg, String msguser) {
        this.msg = msg;
        this.msguser = msguser;
        msgtime = new Date().getTime();
    }

    public chatmsg() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsguser() {
        return msguser;
    }

    public void setMsguser(String msguser) {
        this.msguser = msguser;
    }

    public long getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(long msgtime) {
        this.msgtime = msgtime;
    }
}
