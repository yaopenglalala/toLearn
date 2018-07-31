package controller;

import org.apache.commons.fileupload.FileItem;

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

    public static boolean removeFileByPath(String filePath){
        File file = new File(RESPATH + filePath);
        if (!file.exists()) return false;
        else return removeDir(RESPATH + filePath);
    }

    private static boolean removeDir(String absPath){
        removeAllFile(absPath);
        File index = new File(absPath);
        return index.delete();
    }

    private static boolean removeAllFile(String absPath){
        boolean flag = false;
        File index = new File(absPath);
        if (!index.exists()) {
            return false;
        }
        if (!index.isDirectory()) {
            return index.delete();
        }
        String[] fileList = index.list();
        File temp = null;
        for (String filePath : fileList) {
            if (absPath.endsWith(File.separator)) {
                temp = new File(absPath + filePath);
            } else {
                temp = new File(absPath + File.separator + filePath);
            }

            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                removeAllFile(absPath + "/" + filePath);// 先删除文件夹里面的文件
                removeDir(absPath + "/" +filePath);
                flag = true;
            }
        }
        return flag;
    }

    public static boolean upLoadFile(FileItem item, String path, boolean clear){
         File uploadIndex = new File(RESPATH + path);
         if (!checkFileExist(path)){
             uploadIndex.mkdir();
         } else if (clear){
             removeAllFile(RESPATH + path);
         }

         try {
             //System.out.println(item.getName());
             String fileName = new File(item.getName()).getName();
             if (!path.endsWith(File.separator)){
                 path += File.separator;
             }
             File uploadFile = new File(RESPATH + path + fileName);
             item.write(uploadFile);
         } catch (Exception e){
             e.printStackTrace();
             return false;
         }
         return true;
    }

    public static String getRespath(){
        return RESPATH;
    }

    public static String getMD5(String string){

    }

    public static String checkMD5(String origin, String secret){

    }
}
