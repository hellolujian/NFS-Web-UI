package com.example.demo.VO;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by DELL on 2018/4/16.
 */
@Getter
@Setter
public class ResultVO<T> {

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;
}
