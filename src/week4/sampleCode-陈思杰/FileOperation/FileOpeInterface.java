package Week4.FileOperation;

import java.io.File;
import java.io.IOException;

public interface FileOpeInterface {
    /**
     * 创建txt
     * @return
     */
    File createFile() throws IOException;

    /**
     * 创建文件夹
     * @return
     */
    File createDir(String... FileDir);

    /**
     * 创建多个文件夹
     * @return
     */
    File createDirs();

    /**
     * 读取文件内容
     * @param file
     */
    void readFile(File file);

    /**
     * 写入指定文件
     * @param file
     */
    void write2File(File file);

    /**
     * 用于定位文件夹
     * @param filePath
     * @return
     */
    void fileJump();

    /**
     * 删除文件夹
     * @param file
     */
    void deleteDir(File file);

    /**
     * 删除目标文件夹下的文件
     * @param newDir
     * @param fileNameNew
     */
    void deleteFile(File newDir, String fileNameNew);

    /**
     * 重命名文档
     * @param newDir
     * @param fileName
     * @return
     */
    String renameFile(File newDir, String fileName);

}
