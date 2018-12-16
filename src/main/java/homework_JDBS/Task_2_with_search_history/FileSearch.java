package homework_JDBS.Task_2_with_search_history;


import homework_JDBS.Task_2_with_search_history.model.FileModel;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Don't forget to delete FILE: /home/dell/Programs/Dell driver package/debs !!!
 */


public class FileSearch {

    public void search(String path, String name) {

        File file = new File(path);
        if (file.isDirectory()) {
            File[] filesInTheFolder = file.listFiles();
            for (File f : filesInTheFolder) {

                if (f.isDirectory()) {
                    Runnable task = () -> {
                        search(f.getPath(), name);
                    };
                    ExecutorService es = Executors.newSingleThreadExecutor();
                    es.execute(task);
                    if (!es.isTerminated()) {
                        try {
                            es.awaitTermination(150, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    es.shutdown();
                } else {
                    if (f.getName().contains(name)) {
                        addFoundFileToList(f);

                        MainController.addResultToDB(name, f.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void addFoundFileToList(File f) {
        FileModel.getFoundFiles().add(f);
    }
}




