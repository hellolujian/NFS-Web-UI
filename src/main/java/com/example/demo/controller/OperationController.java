package com.example.demo.controller;

import com.example.demo.Util.NFSUtil;
import com.example.demo.Util.ResultVOUtil;
import com.example.demo.VO.ResultVO;
import com.sun.xfile.XFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by DELL on 2018/4/13.
 */
@RestController
@RequestMapping(value = "/fushitong/nfs")
public class OperationController {

    @Value("${NFS.path}")
    private String path;

    @GetMapping(value = "/shareDirs")
    public ResultVO getShareDir() {

        List<String> dirList = NFSUtil.getShareDir(path);
        ResultVO resultVO = ResultVOUtil.success(dirList);
        return resultVO;
    }

    @RequestMapping(value = "/delete")
    public ResultVO deleteDir(@RequestParam(value = "deleteDirName") String deleteDirName) {
        if (NFSUtil.deleteDir(path,deleteDirName)) {
            return ResultVOUtil.success(null);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping(value = "/add")
    public ResultVO addDir(@RequestParam(value = "newDirName") String newDirName) {

        NFSUtil.addDir(path,newDirName);
        return ResultVOUtil.success(null);
    }
}
