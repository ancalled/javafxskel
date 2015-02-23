package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sample.cell.FlashingTableCell;
import sample.items.Instrument;

import java.util.Comparator;


public class MainController {


    @FXML
    public TableView<Instrument> instrsTable;
    @FXML
    public TableColumn<Instrument, String> symbolColumn;
    @FXML
    public TableColumn<Instrument, String> statusColumn;
    @FXML
    public TableColumn<Instrument, Number> lastPriceColumn;
    @FXML
    public TableColumn<Instrument, Number> lowPriceColumn;
    @FXML
    public TableColumn<Instrument, Number> highPriceColumn;

    public MainController() {
    }


    @FXML
    public void initialize() {
        symbolColumn.setCellValueFactory(c -> c.getValue().symbolProperty());
        statusColumn.setCellValueFactory(c -> c.getValue().statusProperty());
        lastPriceColumn.setCellValueFactory(c -> c.getValue().lastPriceProperty());
        lowPriceColumn.setCellValueFactory(c -> c.getValue().lowPriceProperty());
        highPriceColumn.setCellValueFactory(c -> c.getValue().highPriceProperty());

        lastPriceColumn.setCellFactory(c -> new FlashingTableCell<>(
//                (o1, o2) -> Double.compare(o1.doubleValue(), o2.doubleValue()),
                null,
                Pos.CENTER_RIGHT));

    }

    public void addInstruments(ObservableList<Instrument> instrs) {
        instrsTable.setItems(instrs);
    }


}
