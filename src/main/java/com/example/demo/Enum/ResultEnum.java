package com.example.demo.Enum;

import lombok.Getter;

/**
 * Created by DELL on 2018/4/16.
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"success"),
    FILE_NOT_EXIST(1,"文件不存在"),
    FILE_ALREADY_EXISt(2,"文件已存在"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
