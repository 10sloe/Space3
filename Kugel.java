import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Kugel extends Spielobjekt
{
    Color farbe;
    boolean sichtbar;

    Kugel(double x_, double y_)
    {      
        super(x_, y_);
        vx = 0;
        vy = 0;       
        breite = 6;
        hoehe = 6;

        farbe = Color.YELLOW;
        sichtbar = false;
        box.setX(x);
        box.setY(y);
        box.setWidth(breite);
        box.setHeight(hoehe);
    }

    void update()
    {
        y = y + vy;   
        box.setX(x);
        box.setY(y);
    }

    void sichtbarMachen()
    {
        sichtbar = true;
    }

    void unsichtbarMachen()
    {
        sichtbar = false;
    }

    void zeichnen(GraphicsContext gc)
    {
        if(sichtbar)
        {
            gc.setFill(farbe);  
            gc.fillOval(x,y,breite,hoehe); 
        }
    }
}

