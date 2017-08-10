package com.techmaster.photogallery.widget;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date: 8/9/17
 */
public class PhotoDetail {

    private ImageView imgView;

    private Label imgName;

    public VBox vbox;

    public PhotoDetail() {
        vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        imgView = new ImageView();
        imgView.setFitWidth(300);
        imgView.setPreserveRatio(true);
        imgView.setCache(true);

        imgName = new Label("");

        vbox.getChildren().addAll(imgView, imgName);
    }

    public void showPhoto(File img, String name) {
        try {
            BufferedImage bf = ImageIO.read(img);
            Image image = SwingFXUtils.toFXImage(bf, null);
            imgView.setImage(image);

            imgName.setText("Name: " + name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
