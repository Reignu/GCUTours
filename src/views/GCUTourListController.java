package views;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.GCUTour;
import daos.SQLDAO; // Assuming you have a DAO class to interact with the database
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GCUTourListController {
    @FXML
    private TableView<GCUTour> tourTable;
    @FXML
    private TableColumn<GCUTour, Integer> tourIdColumn;
    @FXML
    private TableColumn<GCUTour, String> tourDateColumn;
    @FXML
    private TableColumn<GCUTour, Integer> tourDurationColumn;

    private SQLDAO sqlDao; // DAO for database operations
    private ObservableList<GCUTour> tourList; // List to hold tour data

    public GCUTourListController() {
        sqlDao = new SQLDAO(); // Initialize your DAO
        tourList = FXCollections.observableArrayList(); // Initialize the observable list
    }

    @FXML
    public void initialize() {
        // Set up the table columns
        tourIdColumn.setCellValueFactory(cellData -> cellData.getValue().gcuTourIdProperty().asObject());
        tourDateColumn.setCellValueFactory(cellData -> cellData.getValue().tourDateProperty());
        tourDurationColumn.setCellValueFactory(cellData -> cellData.getValue().tourDurationProperty().asObject());

        // Load the tour data
        loadTourData();
    }

    private void loadTourData() {
        // Fetch data from the database and populate the tourList
        tourList.addAll(sqlDao.getGCUTours()); // Fetch data from the DAO
        tourTable.setItems(tourList); // Set the items in the table
    }

    @FXML
    private void handleAddTour() {
        // Logic to add a new tour
        // This could open a new dialog or form to input tour details
    }
}