import javafx.animation.AnimationTimer;

/*
 * Timer ist ein Animationtimer
 * Diese Klasse hat die Methoden start() und stop().
 * Wenn der Timer gestartet wurde, ruft er ständig die Methode handle() auf!
 */

class Timer extends AnimationTimer
{
    Spielsteuerung spielsteuerung;

    Timer(Spielsteuerung spielsteuerung_)
    {
        spielsteuerung = spielsteuerung_;
    }

    // Wenn er an ist, ruft er so oft er kann diese Methode auf
    public void handle(long now) {
        spielsteuerung.loop();
    }

}
