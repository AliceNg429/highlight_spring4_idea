package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEvent;

//Spring的事件（Application Event）为Bean与Bean之间的消息
// 通信提供了支持。当一个Bean处理完一个任务之后，希望另外一个Bean
// 知道并能做相应的处理，这时我们就需要让另外一个Bean监听当前Bean所发送的事件。
//1 自定义事件，集成ApplicationEvent。
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}