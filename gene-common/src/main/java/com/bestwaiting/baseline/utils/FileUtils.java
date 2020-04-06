package com.bestwaiting.baseline.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * Created by bestwaiting on 17/5/13.
 */
public class FileUtils {
    public static String readFile(String filePath) {
        if (StringUtils.isBlank(filePath)){
            return StringUtils.EMPTY;
        }
        try (InputStream in = ClassLoader.getSystemResourceAsStream(filePath)) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            return new String(buffer, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }


    /**
     * 创建新文件覆盖原来内容
     *
     * @param fileName
     * @param content
     */
    public static void createFile(String fileName, String content) {
        createFile(new File(fileName),content);
    }
    public static void createFile(File file, String content) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)) {
            outputStreamWriter.write(content);
            outputStreamWriter.flush();
        } catch (Exception ex) {

        }
    }

    /**
     * 向文件中追加内容
     *
     * @param fileName
     * @param content
     */
    public static void appendFile(String fileName, String content) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName), true);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)) {
            outputStreamWriter.write(content);
            outputStreamWriter.flush();
        } catch (Exception ex) {

        }
    }
}
