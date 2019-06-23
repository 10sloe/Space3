import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;
import javafx.scene.image.Image;
import javafx.scene.shape.*;

public class Alien extends Spielobjekt
{
    //Attribute
    Image img;

    int zaehler; // zählt die Schritte nach links und die Schritte nach rechts

    //Konstruktor
    public Alien(double x_,double y_)
    {
        super(x_,y_);
        vx = 0.4;
        vy = 0;
        breite = 48;
        hoehe = 48;
        box.setX(x);
        box.setY(y);
        box.setWidth(breite);
        box.setHeight(hoehe);

        img = new Image("alien1.png", true);
        zaehler = 0;
    }
    //Methoden

    public void update()
    {
        zaehler++;
        if (zaehler > 300) // Nach 300 Einheiten
        {
            zaehler = 0;
            vx = -vx;      // ändert das Alien die Richtung
            y = y + 10;    // und fliegt ein bisschen tiefer
        }
        x = x + vx;
        box.setX(x);
        box.setY(y);
    }

    void zeichnen(GraphicsContext gc)
    {
        gc.drawImage(img,x, y,breite,hoehe);
    }

}

