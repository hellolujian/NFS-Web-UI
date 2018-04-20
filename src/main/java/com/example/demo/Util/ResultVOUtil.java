package com.example.demo.Util;

import com.example.demo.VO.ResultVO;

/**
 * Created by DELL on 2018/4/16.
 */
public class ResultVOUtil {

    public static ResultVO success(Object object, Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(Object object, Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO error() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("error");
        return resultVO;
    }

}
