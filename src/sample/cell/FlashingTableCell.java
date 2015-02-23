package sample.cell;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import com.sun.javafx.scene.control.skin.LabeledText;

import java.util.Comparator;

/**
 *
 * @author jaakkju
 * @param <S>
 * @param <T>
 */
public class FlashingTableCell<S, T> extends TableCell<S, T> {

    private static final Color INCREASE_HIGHLIGHT_COLOR = Color.rgb(0, 255, 0, 0.8);
    private static final Color DECREASE_HIGHLIGHT_COLOR = Color.rgb(255, 0, 0, 0.8);
    private static final Color HIGHLIGHT_COLOR = Color.rgb(255, 255, 0, 0.8);
    private static final Duration HIGHLIGHT_TIME = Duration.millis(300);

    private final Background bgIncrease = new Background(new BackgroundFill(INCREASE_HIGHLIGHT_COLOR, CornerRadii.EMPTY, Insets.EMPTY));
    private final Background bgDecrease = new Background(new BackgroundFill(DECREASE_HIGHLIGHT_COLOR, CornerRadii.EMPTY, Insets.EMPTY));
    private final Background bgChange = new Background(new BackgroundFill(HIGHLIGHT_COLOR, CornerRadii.EMPTY, Insets.EMPTY));

    private final BorderPane background = new BorderPane();
    private final FadeTransition animation = new FadeTransition(HIGHLIGHT_TIME, background);

    private T prevValue;
    private S prevItem;

    final private Comparator<T> comparator;


    public FlashingTableCell(Comparator<T> comparator, Pos alignment) {
        super();
        this.comparator = comparator;

        LabeledText lblText = new LabeledText(this);
        lblText.textProperty().bindBidirectional(textProperty());
//        lblText.textProperty().bindBidirectional(itemProperty());
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        setPadding(Insets.EMPTY);
        StackPane container = new StackPane();
        container.getChildren().addAll(background, lblText);
        container.setAlignment(alignment);
        setGraphic(container);
    }

    @Override
    protected void updateItem(T value, boolean empty) {
        super.updateItem(value, empty);

        //noinspection unchecked
        TableRow<S> r = getTableRow();
        S currentItem = r != null ? r.getItem() : null;

        /*
         * We check that the value has been updated and that the row model/item
         * under the cell is the same. JavaFX table reuses cells so item is not
         * always the same!
         */
        boolean valueChanged = (prevValue == null && value != null)
                || (value != null && (prevValue.hashCode() != value.hashCode()));
        boolean sameItem = currentItem != null && prevItem != null && currentItem == prevItem;

        if (valueChanged && sameItem) {

            if (comparator != null) {
                int compare = comparator.compare(value, prevValue);
                if (compare > 0) {
                    background.setBackground(bgIncrease);
                } else if (compare < 0) {
                    background.setBackground(bgDecrease);
                }
            } else {
                background.setBackground(bgChange);
            }

            animation.setFromValue(1);
            animation.setToValue(0);
            animation.setCycleCount(1);
            animation.setAutoReverse(false);
            animation.playFromStart();
        }

        prevValue = value;
        prevItem = currentItem;
    }
}