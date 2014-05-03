package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int HEIGHT = 800;
    private static final int WIDTH  = 800;

    private static final Paint BACKGROUND = Color.BLACK;
    private static final Paint FOREGROUND = Color.CYAN;
    private static final Paint TEXT_COLOR = Color.WHITE;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Cellular Automata");
        final Pane root = new Pane();
        root.setMinSize(WIDTH, HEIGHT);
        root.setMaxSize(WIDTH, HEIGHT);

        final Canvas canvas = new Canvas(WIDTH, HEIGHT);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(BACKGROUND);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));

        final Label label = new Label();
        label.setTextFill(TEXT_COLOR);
        label.setLayoutX(5);
        label.setLayoutY(5);

        World world = new World(WIDTH);
        world.set((WIDTH / 2) - 1);

        gc.setStroke(FOREGROUND);
        for (int c = 1; c < HEIGHT; c++) {
            nextFrame(gc, world, RuleImpl.RULE90, c);
        }

        primaryStage.show();
    }

    public static void nextFrame(GraphicsContext gc, World world, Rule ruleset, int line) {
        if (gc == null || world == null || ruleset == null) {
            return;
        }
        boolean[] frame = world.nextFrame(ruleset);
        int n = 0;
        for (boolean b : frame) {
            if (b) {
                gc.strokeLine(n, line, n, line);
            }
            n += 1;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
