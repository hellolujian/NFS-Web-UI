package com.example.demo.Util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DELL on 2018/4/19.
 */
public class SSHUtilTest {

    @Test
    public void testCentos() throws Exception {

        //String command = "showmount -e && echo /private * >> /etc/exports && exportfs -r && showmount -e";
        String command = "showmount -e";
        SSHUtil.centos(command);

    }
}