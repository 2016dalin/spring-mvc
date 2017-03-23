package com.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xiaolinzi on 2016/9/19.
 */
public class TestFileAction {
    public void writeByFileOutputStream(){
        FileOutputStream fop = null;
        File file;
        String content = "This is the text content";
        try {
            file = new File("g:/500SQL.txt");
            fop = new FileOutputStream(file);

            if (!file.exists()){
                file.createNewFile();
            }

            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fop != null){
                    fop.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
