import javafx.scene.shape.Rectangle;

class Spielobjekt
{
    //Attribute
    double x;
    double y;
    double vx;
    double vy;

    double breite;
    double hoehe;

    Rectangle box;

    // Konstruktor
    Spielobjekt(double x_, double y_)
    {
        x = x_;
        y = y_;
        box = new Rectangle();
    }

    //Methoden
    Rectangle getBox()
    {
        return box;
    }

    void setPosition(double x_, double y_)
    {
        x = x_;
        y = y_;
    }

    void setVy(double vy_)
    {
        vy = vy_;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getBreite()
    {
        return breite;
    }

}