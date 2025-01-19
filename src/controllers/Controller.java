package controllers;

import app.GCUToursApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Destination;
import model.GCUTour;
import repositories.Repository;
import viewmodels.GCUToursView;
import views.RootLayoutController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Stage primaryStage;
    private BorderPane rootLayout;

   public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
   }

   public void initRootLayout() {
        try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(GCUToursApp.class
                   .getResource("/views/RootLayout.fxml"));

           rootLayout = (BorderPane) loader.load();

           Scene scene = new Scene(rootLayout);
           primaryStage.setScene(scene);

           RootLayoutController rootLayoutController = loader.getController();
           rootLayoutController.setMainController(this);

           primaryStage.show();
           listGCUTours();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listGCUTours() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GCUToursApp.class.getResource("/views/GCUTourList.fxml"));
            AnchorPane tourListView = loader.load(); // Load the FXML
    
            // Set the new scene
            primaryStage.setScene(new Scene(tourListView));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addGCUTourForm() {

    }

    public void addGCUTour(String tourDate, int tourDuration) {

    }

    public void addPlaceForm(int GCUTourId) {

    }

    public void addPlace(String placeName, String country, int GCUTourId) {

    }

}
