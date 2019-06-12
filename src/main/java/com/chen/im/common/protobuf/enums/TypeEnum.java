package com.chen.im.common.protobuf.enums;

import lombok.Getter;

@Getter
public enum TypeEnum {

    LOGIN(1, ""),
    RE_LOGIN(2,""),
    SINGLE(3,""),
    ALL(4,""),
    ;
    int code;
    String desc;

    TypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
