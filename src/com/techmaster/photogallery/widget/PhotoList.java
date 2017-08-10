package com.techmaster.photogallery.widget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.Set;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date: 8/9/17
 */
public class PhotoList {

    public ListView<String> listPhotos;

    private ObservableList<String> data;

    public PhotoList(){
        data = FXCollections.observableArrayList();
        listPhotos = new ListView<>(data);
    }

    public void initData(Set<String> photoNames){
        data.addAll(photoNames);
    }
}
