package com.hjj.ben.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ben on 6/26/17.
 */
public class ShellUtil {
    /**
     * 执行shell脚本
     * @param cmd
     */
    public void startShell(String cmd) {
        try {

            String [] shellcmd = {"/bin/sh", "-c", cmd};
            Process process = Runtime.getRuntime().exec(shellcmd);

            process.waitFor();

            InputStream in = process.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
