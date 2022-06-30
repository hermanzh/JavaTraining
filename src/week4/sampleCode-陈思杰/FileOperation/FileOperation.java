package Week4.FileOperation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileOperation implements FileOpeInterface {

    private static final Scanner in = new Scanner(System.in);
    public String FileAddress = "." + File.separator;

    String txtfile=null;

    public File target=null;

    private static String joinRestDir(String... restPaths) {
        return Arrays.stream(restPaths).map(String::trim).collect(Collectors.joining(File.separator));
    }

    @Override
    public File createFile() throws IOException {
        System.out.println("请输入txt文件名：");
        String fileName = in.nextLine().trim();
        File f = new File(FileAddress + fileName + ".txt");
        if (f.isFile()) {
            System.out.println("目标文件存在，删除：" + f.delete());
        }
        System.out.println(f.createNewFile());
        this.target = f;
        return f;
    }

    @Override
    public File createDir(String... restPaths) {
        String rest = joinRestDir(restPaths);
        System.out.println("将在" + FileAddress + "下创建" + rest);
        File dir = new File(FileAddress, rest);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("文件夹已经存在" + dir.toString());
            return dir;
        } else {
            boolean createSuccess = dir.mkdirs();
            if (createSuccess) {
                return dir;
            } else {
                throw new IllegalArgumentException("无法在" + FileAddress + "下创建" + rest);
            }
        }
    }

    @Override
    public File createDirs() {
        List<String> pathList = new ArrayList<>();
        while (true) {
            System.out.println("请输入文件路径，如果为空则结束");
            String path = in.nextLine();
            if (path.isEmpty()) {
                break;
            }
            pathList.add(path);
        }
        return createDir(pathList.toArray(new String[0]));
    }

    @Override
    public void readFile(File file) {
        try (
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write2File(File file) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("请输入内容，输入空行则结束。");
            while (true) {
                String lineToWrite = in.nextLine().trim();
                System.out.println("输入内容为" + lineToWrite);
                if (lineToWrite.trim().isEmpty()) {
                    System.out.println("输入结束");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fileJump() {
        System.out.println("请设置根目录:");
        this.FileAddress = in.nextLine()+File.separator;
    }

    @Override
    public void deleteDir(File file) {
        System.out.println("删除文件夹？");

        boolean deleteDir = in.nextBoolean();

        // TODO 删除文件夹的前提是文件夹是空的，否则将删除失败
        if (deleteDir) {
            System.out.println("删除文件夹：" + file.delete());
        }
    }

    @Override
    public void deleteFile(File newDir, String fileNameNew) {
        System.out.println("删除文件？");

        boolean deleteFiles = in.nextBoolean();

        if (deleteFiles) {
            File fn = new File(newDir, fileNameNew);
            System.out.println("删除文件" + fn.delete());
        }
    }

    @Override
    public String renameFile(File newDir, String fileName) {
        System.out.println("请输入新的文件名的前缀：");
        String fileNameNew = in.next().trim();

        for (int i = 0; i < 20; i++) {
            File f = new File(newDir, fileName + i + ".txt");
            File fn = new File(newDir, fileNameNew + i + ".txt");
            System.out.println("重命名文件" + f.getName() + "：" + f.renameTo(fn));
        }
        return fileNameNew;
    }
}
