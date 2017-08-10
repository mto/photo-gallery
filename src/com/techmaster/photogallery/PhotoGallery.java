package com.techmaster.photogallery;

import com.techmaster.photogallery.widget.PhotoDetail;
import com.techmaster.photogallery.widget.PhotoList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date: 8/8/17
 */
public class PhotoGallery extends Application implements EventHandler<MouseEvent> {

    private PhotoDetail pDetail;

    private PhotoList pList;

    private PhotoExplorer px;

    @Override
    public void start(Stage primaryStage) throws Exception {
        px = new PhotoExplorer();
        pDetail = new PhotoDetail();
        pList = new PhotoList();
        pList.initData(px.getPhotos().keySet());

        pList.listPhotos.setOnMouseClicked(this);

        BorderPane bdp = new BorderPane();
        bdp.setPadding(new Insets(10, 10, 10, 10));
        bdp.setLeft(pDetail.vbox);

        bdp.setCenter(pList.listPhotos);

        if (px.getPhotos().size() > 0) {
            String defaultfImgName = px.getPhotos().keySet().iterator().next();
            File defaultImg = px.getPhotos().get(defaultfImgName);

            pDetail.showPhoto(defaultImg, defaultfImgName);
        }

        Scene scene = new Scene(bdp, 800, 400);
        primaryStage.setTitle("Photo Gallery");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(MouseEvent event) {
        String fname = pList.listPhotos.getSelectionModel().getSelectedItem();
        System.out.println("Select photo " + fname);
        File f = px.getPhotos().get(fname);
        if (f != null) {
            pDetail.showPhoto(f, fname);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
