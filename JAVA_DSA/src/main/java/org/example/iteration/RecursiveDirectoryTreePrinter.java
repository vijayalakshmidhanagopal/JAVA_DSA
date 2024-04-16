package org.example.iteration;
import java.io.File;


public final class RecursiveDirectoryTreePrinter {
    private static final String SPACE = " ";


    public static void main(String[] args) {
        assert args != null : "args can't be null";


        if (args.length != 1) {
            System.err.println("usage: RecursiveDirectoryPrinterTree <directory>");
            System.exit(4);
        } else {
            print(new File(args[0]), " ");
        }
    }



    public static void print(File file, String indent) {
        assert file != null : "file can't be null";

        assert indent != null : "indent can't be null";

        System.out.print(indent);
        System.out.println(file.getName());
        if (file.isDirectory()) {
            print(file.listFiles(), indent + " ");
        }

    }

    public static void print(File[] files, String indent) {
        assert files != null : "file can't be null";

        for(int i = 0; i < files.length; ++i) {
            print(files[i], indent);
        }

    }

}
