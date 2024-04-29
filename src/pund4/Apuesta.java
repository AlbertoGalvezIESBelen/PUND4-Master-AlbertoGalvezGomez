/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;

/**
 *
 * @author Alberto Gálvez Gómez
 * @since 29/04/24
 * @version 1.0
 */
public class Apuesta {

    /**
     * Método de selección del atributo goles_local
     *
     * @return
     */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Método de acceso al atributo goles_local
     *
     * @param goles_local
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * Método de selección del atributo goles_visitante
     *
     * @return
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Método de acceso al atributo goles_visitante
     *
     * @param goles_visitante
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Método de selección del atributo apostado
     *
     * @return
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Método de acceso al atributo apostado
     *
     * @param apostado
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    /**
     * Atributo que indica el dinero disponible
     */
    protected int dinero_disp;
    /**
     * Atributo que indica los goles del equipo local
     */
    protected int goles_local;
    /**
     * Atributo que indica los goles del equipo visitante
     */
    protected int goles_visitante;
    /**
     * Atributo que indica el dinero apostado
     */
    protected int apostado;

    /**
     * Constructor por defecto
     */
    public Apuesta() {
    }

    /**
     * Contructor con parámetros
     * @param dinero_disp parámetro que indica el dinero disponible
     * @param goles_local parámetro que indica los goles del equipo local
     * @param goles_visitante parámetro que indica los goles del equipo visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }

    /**
     * Método de selección del atributo dinero_disp
     *
     * @return
     */
    public int getDinero_disp() {
        return dinero_disp;
    }

    /**
     * Método de acceso al atributo dinero_disp
     *
     * @param dinero_disp
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     * @param dinero indica el dinero que vas a apostar
     * @throws Exception 
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }  
    /**
     * Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * @param local indica los goles del equipo local
     * @param visitante indica los goles del equipo visitante
     * @return
     * @throws Exception 
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /**
     * Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     * @param cantidad_goles_local indica la cantidad de los goles del equipo local
     * @param cantidad_goles_visit indica la cantidad de los goles del equipò visitante
     * @throws Exception 
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}
