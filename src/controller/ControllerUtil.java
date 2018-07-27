package controller;

import java.io.File;

public class ControllerUtil {
    private static final String CURRENTPATH =  ControllerUtil.class.getClassLoader().getResource("./").getPath();
    private static final String RESPATH = CURRENTPATH + "../../";

    public static boolean checkFileExist(String filePath){
        File file = new File(RESPATH + filePath);
        return file.isFile() || file.isDirectory();
    }

    public static File[] getFilesByPath(String filePath){
        File file = new File(RESPATH + filePath);
        if (file.isDirectory()){
            return file.listFiles();
        } else return new File[]{file};
    }

    public static String getRespath(){
        return RESPATH;
    }
}
