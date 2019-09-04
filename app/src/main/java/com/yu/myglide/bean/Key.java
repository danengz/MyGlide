package com.yu.myglide.bean;

import com.yu.myglide.Tool;

public class Key {

    private String key;

    public Key(String key) {
        //用SHA256加密的方式格式化url，去除特殊字符
        this.key = Tool.getSHA256StrJava(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
