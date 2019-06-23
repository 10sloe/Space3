import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;

class Spielsteuerung
{
    // Attribute
    Schiff schiff;  
    Kugel kugel;
    Alien[] aliens;
    int anzahlAliens;

    // Taktgeber
    Timer timer;
    // Zeichenfläche
    GraphicsContext gc;

    //Konstruktor
    Spielsteuerung(GraphicsContext gc_)
    {
        gc = gc_; // Zeichenfläche übernehmen
        gc.setFill(Color.BLACK);  
        gc.fillRect(0,0,800,500); // Zeichenfläche schwarz färben

        timer = new Timer(this); //Timer erstellen

        // Alle Spielfiguren erstellen
        schiff = new Schiff(300,350);   
        kugel = new Kugel(schiff.getX()+schiff.getBreite()/2-3, schiff.getY());
        anzahlAliens = 8;
        aliens = new Alien[anzahlAliens];

        for (int i = 0; i < 8; i++)
        {          
            aliens[i] = new Alien(100+ 50*i, 100);
        }
    }

    //Methoden
    //--------------------------------------------------------------
    //--- Button -------
    // Wird aufgerufen,wenn auf den Start-Button geklickt wird
    void start()
    {
        // Startet den Timer
        timer.start();
    }

    //--------------------------------------------------------------
    // Gameloop
    // Diese Methode wird vom Timer immer und immer wieder ausgerufen
    void loop(){
        alleBewegen();  // Alle Spielfiguren müssen bewegt werden
        trefferErkennen();
        zeichnen(); // Alles neu Zeichnen!
    }

    // ------------------------------------------
    // update
    void alleBewegen()
    {
        schiff.update();
        kugel.update();
        for (int i = 0; i < anzahlAliens; i++)
        {
            aliens[i].update();
        }

    }

    void trefferErkennen()
    {
        Rectangle kugelBox = kugel.getBox();
        for (int i = 0; i < anzahlAliens; i++)
        {
            Rectangle alienBox = aliens[i].getBox();
            Shape schnitt = Shape.intersect(kugelBox, alienBox);
            if(schnitt.getBoundsInParent().getWidth() != -1)
            {
                timer.stop();
            }
        }
    }

    // ------------------------------------------------
    // Zeichnet alles neu, wird von den Methoden loop(), 
    // dem Konstruktor und reset() aufgerufen
    void zeichnen()
    {
        gc.clearRect(0,0,800,500);
        gc.setFill(Color.BLACK);  
        gc.fillRect(0,0,800,500); 

        schiff.zeichnen(gc);
        kugel.zeichnen(gc);
        for (int i = 0; i < anzahlAliens; i++)
        {
            aliens[i].zeichnen(gc); 
        }
    }

    //------------------------------------------------------------
    // Steuerung mit den Tasten
    // wird aufgerufen, wenn eine Taste gedrückt wurde
    public void gedrueckt(KeyEvent ke)
    {
        // Spiel beenden mit X
        if (ke.getCode() == KeyCode.X)
        {
            Platform.exit();
        }

        // Steuerung des Schiffs mit Links und Rechts
        if (ke.getCode() == KeyCode.LEFT)
        {
            // Das Schiff soll nach links
            schiff.nachLinks();
        }

        if (ke.getCode() == KeyCode.RIGHT)
        {
            // Das Schiff soll nach rechts
            schiff.nachRechts();
        }

        // Feuern mit der Leertaste
        if (ke.getCode() == KeyCode.SPACE)
        {
            kugel.setPosition(schiff.getX()+schiff.getBreite()/2-3, schiff.getY());
            kugel.setVy(-2);
            kugel.sichtbarMachen();
        }

    }

    // wird aufgerufen, wenn eine Taste losgelassen wurde
    public void losgelassen(KeyEvent ke)
    {
        if (ke.getCode() != KeyCode.SPACE)
        {
            schiff.stoppen();
        }
    }

}
