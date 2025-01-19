package model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Models GCUTour entities
 *
 * @author Reignu
 */
public class GCUTour {
    private IntegerProperty id;
    private StringProperty tourDate;
    private IntegerProperty tourDuration;
    private List<Destination> destinationsVisited;

    public GCUTour() {
        this.id = new SimpleIntegerProperty();
        this.tourDate = new SimpleStringProperty();
        this.tourDuration = new SimpleIntegerProperty();
        this.destinationsVisited = new ArrayList<>();
    }

    public GCUTour(String tourDate, int tourDuration) {
        this();
        this.tourDate.set(tourDate);
        this.tourDuration.set(tourDuration);
    }

    public GCUTour(int id, String tourDate, int tourDuration) {
        this();
        this.id.set(id);
        this.tourDate.set(tourDate);
        this.tourDuration.set(tourDuration);
    }

    public GCUTour(int id, String tourDate, int tourDuration, List<Destination> destinationsVisited) {
        this(id, tourDate, tourDuration);
        this.destinationsVisited = destinationsVisited;
    }

    public IntegerProperty gcuTourIdProperty() {
        return id;
    }

    public StringProperty tourDateProperty() {
        return tourDate;
    }

    public IntegerProperty tourDurationProperty() {
        return tourDuration;
    }

    /**
     * A getter for id values
     */
    public int getId() {
        return id.get();
    }

    /**
     * A setter method for id values
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * A getter for tour date values
     */
    public String getTourDate() {
        return tourDate.get();
    }

    /**
     * A setter method for tour date values
     */
    public void setTourDate(String tourDate) {
        this.tourDate.set(tourDate);
    }

    /**
     * A getter for tour duration values
     */
    public int getTourDuration() {
        return tourDuration.get();
    }

    /**
     * A setter method for tour duration values
     */
    public void setTourDuration(int tourDuration) {
        this.tourDuration.set(tourDuration);
    }

    /**
     * A getter for places visited values
     */
    public List<Destination> getDestinationsVisited() { return this.destinationsVisited;}
    
    /**
     * Adds a supplied Destination object to the destinations visited attribute
     */
    public void addPlaceVisited(Destination destination) {
        this.destinationsVisited.add(destination);
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return "ID: " + id.get() + " Tour Date: " + tourDate.get() + " Duration: " + tourDuration.get() + "\nDestinations: " + destinationsVisited;
    }
}
