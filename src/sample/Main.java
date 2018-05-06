package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;

public class Main extends Application {
    int i=0;
    int play=0;
    private double xOffset=0;
    private double yOffset=0;
    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane borderPane=new BorderPane();
        Image image=new Image("Pic/cat0.png");
        Image image1=new Image("Pic/cat1.png");
        Image image2=new Image("Pic/cat2.png");
        ImageView imageView=new ImageView(image);
//        String myurl="f:\\Music\\年轮.mp3";
//        File file=new File(myurl);
//        Media media=new Media(file.toURI().toString());
//        MediaPlayer mediaplay=new MediaPlayer(media);
        borderPane.setCenter(imageView);

        imageView.setOnMouseClicked(event1 -> {
            play=1;
            i=0;
        });

        EventHandler<ActionEvent> eventHandler= event -> {
            if(i==0){
                imageView.setImage(image);
            }
            if(i==1&&play==1){
                imageView.setImage(image1);
            }
            if (i==2&&play==1){
                imageView.setImage(image2);
            }
            if(i==3&&play==1){
                imageView.setImage(image1);
            }
            if (i==4&&play==1){
                imageView.setImage(image2);
            }
            if(i==5){
                play=0;
                imageView.setImage(image);
                i=0;
            }
            i++;
        };
        KeyFrame keyFrame=new KeyFrame(Duration.millis(500),eventHandler);
        Timeline animation=new Timeline(keyFrame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        //隐藏窗口
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //隐藏背景
        Scene scene=new Scene(borderPane);
        scene.setFill(null);
        //鼠标点击，图片移动
        scene.setOnMousePressed((MouseEvent event)->{
            event.consume();
            xOffset=event.getSceneX();
            yOffset=event.getSceneY();
        });
        scene.setOnMouseDragged((MouseEvent event)->{
            event.consume();
            primaryStage.setX(event.getScreenX()-xOffset);
            primaryStage.setY(event.getScreenY()-yOffset);

        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
