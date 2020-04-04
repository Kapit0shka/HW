package horstmann3chapter.myfile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyFile {

    static public ArrayList<File> getListDirectoryWithLambda(String directory) {

        return getListDirectory(directory,(File dirLambda)->dirLambda.isDirectory());
    }

    static public ArrayList<File > getListDirectoryWithAnonimClass(String directory) {

        FileFilter filter = new FileFilter() {

            public boolean accept(File file) {
                if(file.isDirectory()) {
                    return true;
                }
                return false;
            }
        };
        return getListDirectory(directory,filter::accept);
    }

    private static ArrayList<File > getListDirectory(String directory, FileFilter filter) {

        File dir = new File(directory);
        if (!dir.isDirectory()) {
            return new ArrayList<>(0);
        }
        else {
            File[] listFile = dir.listFiles(filter);
            ArrayList<File> listDirectory = new ArrayList<>();

            for (File file : listFile) {
                listDirectory.add(file);
            }
            return listDirectory;
        }
    }

    public static ArrayList<String > getListFile(String directory, String extension) {
        File dir = new File(directory);
        if (dir.isDirectory()){
            String[]listFileTemp = dir.list((dir1,name)-> name.toLowerCase().endsWith(extension));
            ArrayList<String> listFile = new ArrayList<>();

            for (String tempString : listFileTemp){
                listFile.add(tempString);
            }
            return listFile;
        }
        else {
            ArrayList<String> listFile = new ArrayList<>();
            listFile.add(dir.getName());
            return (listFile);
        }
    }

    public static File[] sortFiles(File[] files) {

        Comparator<File> comparator = (file1,file2) -> {
            if (file1.isDirectory() & file2.isFile()){
                return -1;
            }
            else if (file1.getName().equals(file2.getName())){
                return 0;
            }
            else {
                char[] charFile1 = file1.getName().toCharArray();
                char[] charFile2 = file2.getName().toCharArray();

                for (int i = 0; i < Math.min(charFile1.length,charFile2.length); i++) {
                    if (charFile1[i] < charFile2[i]){
                        return 1;
                    }
                }
                return -1;
            }
        };

        ArrayList<File> tempFiles = new ArrayList<File>(Arrays.asList(files));
        tempFiles.sort(comparator);

        for (File fil : tempFiles) {
            System.out.println(fil.getName());
        }

        return files;
    }
}
