package java_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;

public class Path_Files_Paths_test {
    public static void main(String[] args) throws IOException {

        String path = "/home/dell/Desktop/Files/Java.txt";
        Path p = Paths.get(path);
//
//        System.out.println("Get full path: " + path);
//        System.out.println("Get filename : " + p.getFileName());
//        System.out.println("Get parent element: " + p.getParent());
//        System.out.println("Get number of elements(folders): " + p.getNameCount());
//        System.out.println("Get root: " + p.getRoot());
//        System.out.println("Is absolute: " + p.isAbsolute());
//        System.out.println("Get filesystem: " + p.getFileSystem());
//        System.out.println("Sub path : " + p.subpath(2, 4));
//        System.out.println("Normalize method " + p.normalize());
//
//        System.out.println("--------------------------------------");

//        Files.createFile(p);
        BasicFileAttributes atr = Files.readAttributes(p, BasicFileAttributes.class);
        System.out.println(atr.creationTime());
        System.out.println(atr.fileKey());
        System.out.println(atr.lastModifiedTime());
        System.out.println(atr.size());
    }
}
