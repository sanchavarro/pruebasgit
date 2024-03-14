package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.view.View;

public class Controller {
    private View view;
    private Cancion cancion;

    public Controller() {
        this.view = new View();
        this.cancion = new Cancion();
    }

    public void iniciar() {
        view.mostrarMenu(cancion);
    }
}