import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String dir = "C:" + File.separator + "Games";
        String srcDir = dir + File.separator + "src";
        String resDir = dir + File.separator + "res";
        String saveGamesDir = dir + File.separator + "savegames";
        String tempDir = dir + File.separator + "temp";
        String mainDir = srcDir + File.separator + "main";
        String testDir = srcDir + File.separator + "test";
        String temp = "temp.txt";
        String mainFile = "Main.java";
        String utilsFile = "Utils.java";
        String[] resDirArr = {"drawables", "vectors", "icons"};
        StringBuilder sb = new StringBuilder();

        File f;
        FileWriter fw = null;

        if ((f = new File(mainDir)).mkdirs()) {
            sb.append("Создан каталог: ").append(f.getAbsolutePath()).append("\n");
            try {
                if ((f = new File(mainDir, mainFile)).createNewFile()) {
                    sb.append("Создан файл: ").append(f.getAbsolutePath()).append("\n");
                }
                if ((f = new File(mainDir, utilsFile)).createNewFile()) {
                    sb.append("создан файл: ").append(f.getAbsolutePath()).append("\n");
                }
            } catch (Exception e) {
                sb.append(e);
            }
        }

        if((f = new File(testDir)).mkdirs()){
            sb.append("Создан каталог: ").append(f.getAbsolutePath()).append("\n");
        }

        if((f = new File(saveGamesDir)).mkdirs()){
            sb.append("Создан каталог: ").append(f.getAbsolutePath()).append("\n");
        }

        if ((f = new File(tempDir)).mkdirs()) {
            sb.append("Создан каталог: ").append(f.getAbsolutePath()).append("\n");
            try {
                if ((f = new File(tempDir, temp)).createNewFile()){
                    sb.append("создан файл: ").append(f.getAbsolutePath()).append("\n");
                    fw = new FileWriter(f.getAbsolutePath());

                }
            } catch (Exception e) {
                sb.append(e);
            }
        }

        for (String str : resDirArr){
            f = new File(resDir + File.separator + str);
            if (f.mkdirs()){
             sb.append("Создан каталог: ").append(f.getAbsolutePath()).append("\n");
            }
        }

        assert fw != null;
        fw.write(sb.toString());
        fw.flush();
        fw.close();
    }
}