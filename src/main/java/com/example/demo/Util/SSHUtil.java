package com.example.demo.Util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by DELL on 2018/4/19.
 */
public class SSHUtil {

    public static void centos(String command) {

        String hostname = "192.168.174.128";
        String username = "root";
        String password = "lj&19950808";

        Connection connection = new Connection(hostname);
        try {
            connection.connect();
            boolean isAuthenticated = connection.authenticateWithPassword(username,password);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed");
            Session session = connection.openSession();
            session.execCommand(command);

            System.out.println("Here is some infomation about the remote host:");
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stdout));
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            System.out.println("ExitCode:" + session.getExitStatus());
            session.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
