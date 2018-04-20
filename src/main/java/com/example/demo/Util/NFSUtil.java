package com.example.demo.Util;

import com.sun.nfs.XFileExtensionAccessor;
import com.sun.org.apache.xml.internal.utils.StringBufferPool;
import com.sun.xfile.XFile;
import com.sun.xfile.XFileInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DELL on 2018/4/13.
 */
public class NFSUtil {

    private static final Logger logger = LoggerFactory.getLogger(NFSUtil.class);

    /**
     * 连接NFS
     * @param path
     * @return
     */
    public static XFile NFSconnection(String path) {
        XFile xfile = new XFile(path);
        //调用exists()判断是否连接成功
        if (xfile.exists()) {
            logger.info("connect success!");
            return xfile;
        }
        logger.info("connect error!");
        return null;

    }

    public static List<String> getShareDir(String path) {

        XFile xfile = NFSconnection(path);
        return Arrays.asList(xfile.list());
    }

    public static boolean deleteDir(String prefixPath, String dirName) {

        String path = prefixPath + dirName;
        XFile file = new XFile(path);

        if (file.exists() && file.canWrite()) {
            file.delete();
            return true;
        }
        return false;
    }

    public static boolean addDir(String prefixPath, String dirName) {
        String newDir = prefixPath + dirName;
        XFile file = new XFile(newDir);
        if (file.mkdir())
            return false;
        return false;
    }

}
