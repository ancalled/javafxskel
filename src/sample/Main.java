package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.items.Instrument;

import java.util.Locale;
import java.util.ResourceBundle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setResources(ResourceBundle.getBundle("sample.bundles.TableNames", Locale.ENGLISH));

        Parent root = loader.load();
        MainController controller = loader.getController();

        initMarket(controller);


        primaryStage.setTitle("Jafax Skel");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("/sample/table.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void initMarket(MainController controller) {
        ObservableList<Instrument> instr = FXCollections.observableArrayList();
        instr.add(new Instrument("KZTK", 1300.1));
        instr.add(new Instrument("KKGB", 1101.4));
        instr.add(new Instrument("KCEL", 2510.5));
        instr.add(new Instrument("RDGZ", 882.1));


        controller.addInstruments(instr);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
