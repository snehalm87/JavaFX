package resizewindowapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ResizeWindowApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        final ResizeWindow resizeWindow = new ResizeWindow(primaryStage, 300, 250);
        StackPane root = new StackPane() {
            @Override
            protected void layoutChildren() {
                super.layoutChildren();
                resizeWindow.autosize();
                resizeWindow.setLayoutX(getWidth() - resizeWindow.getLayoutBounds().getWidth());
                resizeWindow.setLayoutY(getHeight() - resizeWindow.getLayoutBounds().getHeight());
            }
        };

        resizeWindow.setManaged(false);

        root.getStylesheets().add(ResizeWindowApplication.class.getResource("style.css").toExternalForm());
        root.setId("mainWindow");
        root.getChildren().add(resizeWindow);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
