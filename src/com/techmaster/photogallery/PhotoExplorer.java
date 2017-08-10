package com.techmaster.photogallery;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date: 8/9/17
 */
public class PhotoExplorer {

    private List<String> photoFolders;

    private Map<String, File> photos;

    public PhotoExplorer() {
        photoFolders = new LinkedList<>();

        photos = new HashMap<>();

        initPhotoFolders();

        loadPhotos();
    }

    private void initPhotoFolders() {
        photoFolders.add("/Users/java/Pictures");
    }

    private void loadPhotos() {
        for (String pfName : photoFolders) {
            File pdir = new File(pfName);
            if (pdir.exists() && pdir.isDirectory()) {
                Map<String, File> pfs = photosInFolder(pdir);

                photos.putAll(pfs);
            }
        }
    }

    public Map<String, File> getPhotos() {
        return photos;
    }

    private Map<String, File> photosInFolder(File f) {
        Map<String, File> ret = new HashMap<>();

        File[] pfs = f.listFiles();

        for (File pf : pfs) {
            String pfn = pf.getName();
            if (pfn.endsWith(".png") || pfn.endsWith(".jpg") || pfn.endsWith(".jpeg") || pfn.endsWith(".gif")) {
                ret.put(pf.getName(), pf);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        PhotoExplorer px = new PhotoExplorer();

        System.out.println("Folders containing pictures:");
        for (String pf : px.photoFolders) {
            System.out.println(pf);
        }

        System.out.println("List of pictures: \n");
        for (Map.Entry<String, File> e : px.photos.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue().getAbsolutePath());
        }
    }
}
