import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OtoparkArayuz extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane anaPanel = new BorderPane();
        anaPanel.setPadding(new Insets(20));
        anaPanel.setStyle("-fx-background-color: #121212;");

        // ust baslik
        Label baslik = new Label("Otopark Doluluk ve Arac Takip Sistemi");
        baslik.setStyle("-fx-text-fill: #f0f0f0; -fx-font-size: 20px; -fx-font-weight: bold;");
        BorderPane.setAlignment(baslik, Pos.CENTER);
        BorderPane.setMargin(baslik, new Insets(0, 0, 20, 0));
        anaPanel.setTop(baslik);

        // sol kisim: arac giris / silme formu
        VBox formPaneli = new VBox(12);
        formPaneli.setPadding(new Insets(15));
        formPaneli.setPrefWidth(260);
        formPaneli.setStyle("-fx-background-color: #1e1e1e; -fx-background-radius: 8;");

        Label formBaslik = new Label("Arac Islemleri");
        formBaslik.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-font-weight: bold;");

        TextField txtPlaka = kutuOlustur("Plaka (Orn: 44 AB 123)");
        TextField txtParkYeri = kutuOlustur("Park Yeri (Orn: A-01)");
        TextField txtSahip = kutuOlustur("Arac Sahibi");
        TextField txtSaat = kutuOlustur("Giris Saati (Orn: 10:00)");

        Button btnEkle = new Button("Arac Ekle");
        btnEkle.setMaxWidth(Double.MAX_VALUE);
        btnEkle.setStyle("-fx-background-color: #2e7d32; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8;");

        Button btnSil = new Button("Arac Sil");
        btnSil.setMaxWidth(Double.MAX_VALUE);
        btnSil.setStyle("-fx-background-color: #c62828; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8;");

        formPaneli.getChildren().addAll(formBaslik, txtPlaka, txtParkYeri, txtSahip, txtSaat, btnEkle, btnSil);
        anaPanel.setLeft(formPaneli);

        // orta kisim: park yeri izgarasi (A-01 ... A-10)
        GridPane parkIzgarasi = new GridPane();
        parkIzgarasi.setHgap(15);
        parkIzgarasi.setVgap(15);
        parkIzgarasi.setAlignment(Pos.CENTER);
        parkIzgarasi.setPadding(new Insets(0, 0, 0, 25));

        int yerNo = 1;
        for (int satir = 0; satir < 2; satir++) {
            for (int sutun = 0; sutun < 5; sutun++) {
                String kod = String.format("A-%02d", yerNo++);
                Label kutu = new Label(kod + "\nBOS");
                kutu.setPrefSize(100, 80);
                kutu.setAlignment(Pos.CENTER);
                kutu.setStyle("-fx-background-color: #1e2d24; -fx-text-fill: #81c784; " +
                              "-fx-border-color: #2e7d32; -fx-border-radius: 6; -fx-background-radius: 6; " +
                              "-fx-font-weight: bold;");
                parkIzgarasi.add(kutu, sutun, satir);
            }
        }
        anaPanel.setCenter(parkIzgarasi);

        Scene sahne = new Scene(anaPanel, 900, 480);
        stage.setTitle("Otopark Takip Sistemi");
        stage.setScene(sahne);
        stage.show();
    }

    private TextField kutuOlustur(String ipucu) {
        TextField tf = new TextField();
        tf.setPromptText(ipucu);
        tf.setStyle("-fx-background-color: #2c2c2c; -fx-text-fill: white; -fx-prompt-text-fill: #888888; -fx-padding: 8;");
        return tf;
    }

    public static void main(String[] args) {
        launch(args);
    }
}