import java.io.File;

public class Main {
    public static void main(String[] args) {
        String srcFolder = "Data/start";
        String dstFolder = "Data/destination";
        File srcDir = new File(srcFolder);

        int newWidth = 300;

        File[] files = srcDir.listFiles();
        int part = files.length / 5;
        File[] files1 = new File[part];
        System.arraycopy(files, 0, files1, 0, part);
        Resizer resizer1 = new Resizer(files1, newWidth, dstFolder);
        resizer1.start();
        File[] files2 = new File[part];
        System.arraycopy(files, part, files2, 0, part);
        Resizer resizer2 = new Resizer(files2, newWidth, dstFolder);
        resizer2.start();
        File[] files3 = new File[part];
        System.arraycopy(files, part * 2, files3, 0, part);
        Resizer resizer3 = new Resizer(files3, newWidth, dstFolder);
        resizer3.start();
        File[] files4 = new File[part];
        System.arraycopy(files, part * 3, files4, 0, part);
        Resizer resizer4 = new Resizer(files4, newWidth, dstFolder);
        resizer4.start();
        File[] files5 = new File[files.length - part * 4];
        System.arraycopy(files, part * 4, files5, 0, files5.length);
        Resizer resizer5 = new Resizer(files5, newWidth, dstFolder);
        resizer5.start();
    }
}
