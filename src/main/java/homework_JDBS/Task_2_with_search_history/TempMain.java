package homework_JDBS.Task_2_with_search_history;

import homework_JDBS.Task_2_with_search_history.model.FileModel;

public class TempMain {
    public static void main(String[] args) {
        String path = "/home/dell/Programs";
        String fileName = "SomeFile";

        FileSearch fileSearch = new FileSearch();
        fileSearch.search(path, fileName);

        System.out.println(FileModel.getFoundFiles());
    }
}
