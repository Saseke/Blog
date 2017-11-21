package IFile;


import model.File;

import java.util.List;

/**
 * Created by Yoke on 2017/8/9.
 */
public interface IFile {
          void addFile(File file);
          List<File> findFile(String content);
          List<File> listAll();
          File findById(int id);
          void deleteFile(int id);
          void updateFile(File file);
          List<File> findFileByTitle(String title);
          List<File> list(int id);
          void realUpdate(File file);
}
