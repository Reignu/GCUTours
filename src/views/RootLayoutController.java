package views;

import controllers.Controller;
import javafx.fxml.FXML;

public class RootLayoutController {
    private Controller mainController;
    
    public RootLayoutController() {
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }    
    
    @FXML
    private void handleListGCUTours() {
    	mainController.listGCUTours();
    }  
    
    @FXML
    private void handleAddGCUTourForm() {
    	mainController.addGCUTourForm();
    }	
    
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }    
}
