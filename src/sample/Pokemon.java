package sample;

public class Pokemon {

    private final String nombre;
    private final int vidaMaxima;
    private int vidaActual;
    private final int nivel;

    public Pokemon(String nombre, int vidaMaxima, int nivel) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = Math.floorDiv(vidaMaxima, 2);
        this.nivel = nivel;
    }

    public String getNombre(){ return nombre; }

    public int getNivel(){ return nivel; }

    public int getVidaMaxima(){ return vidaMaxima; }

    public int getVidaActual(){ return vidaActual; }

    public void setVidaActual(int hp) { this.vidaActual = hp;}
}
