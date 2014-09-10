package com.wyble.procesagro.models;

import java.io.Serializable;

/**
 * Created by david on 9/7/14.
 */
public class Tramite implements Serializable {

    private int id;
    private String ica;
    private String nombreFinca;
    private String nombrePropietario;
    private String cedulaPropietario;
    private String fijoPropietario;
    private String celularPropietario;
    private String municipio;
    private String departamento;
    private String nombreSolicitante;
    private String cedulaSolicitante;
    private String fijoSolicitante;
    private String celularSolicitante;
    private int menor1Bovinos;
    private int entre12Bovinos;
    private int entre23Bovinos;
    private int mayores3Bovinos;
    private int menor1Bufalino;
    private int entre12Bufalino;
    private int entre23Bufalino;
    private int mayor3Bufalino;
    private int primeraVez;
    private int nacimiento;
    private int compra;
    private int perdidaDIN;
    private String justificacion;
    private Boolean terminos;

    public void paso1(String ica, String nombreFinca, String nombrePropietario, String cedulaPropietario, String fijoPropietario, String celularPropietario) {
        this.ica = ica;
        this.nombreFinca = nombreFinca;
        this.nombrePropietario = nombrePropietario;
        this.cedulaPropietario = cedulaPropietario;
        this.fijoPropietario = fijoPropietario;
        this.celularPropietario = celularPropietario;
    }

    public void paso2(String municipio, String departamento) {
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public void paso3(String nombreSolicitante, String cedulaSolicitante, String fijoSolicitante, String celularSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
        this.cedulaSolicitante = cedulaSolicitante;
        this.fijoSolicitante = fijoSolicitante;
        this.celularSolicitante = celularSolicitante;
    }

    public void paso4(int menor1Bovinos, int entre12Bovinos, int entre23Bovinos, int mayores3Bovinos) {
        this.menor1Bovinos = menor1Bovinos;
        this.entre12Bovinos = entre12Bovinos;
        this.entre23Bovinos = entre23Bovinos;
        this.mayores3Bovinos = mayores3Bovinos;
    }

    public void paso5(int menor1Bufalino, int entre12Bufalino, int entre23Bufalino, int mayor3Bufalino) {
        this.menor1Bufalino = menor1Bufalino;
        this.entre12Bufalino = entre12Bufalino;
        this.entre23Bufalino = entre23Bufalino;
        this.mayor3Bufalino = mayor3Bufalino;
    }

    public void paso6(int perdidaDIN, int compra, int nacimiento, int primeraVez) {
        this.perdidaDIN = perdidaDIN;
        this.compra = compra;
        this.nacimiento = nacimiento;
        this.primeraVez = primeraVez;
    }

    public void paso7(String justificacion, Boolean terminos) {
        this.justificacion = justificacion;
        this.terminos = terminos;
    }

    @Override
    public String toString() {
        return "Tramite{" +
                "nombrePropietario='" + nombrePropietario + '\'' +
                ", cedulaPropietario='" + cedulaPropietario + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getIca() {
        return ica;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getCedulaPropietario() {
        return cedulaPropietario;
    }

    public String getFijoPropietario() {
        return fijoPropietario;
    }

    public String getCelularPropietario() {
        return celularPropietario;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public String getCedulaSolicitante() {
        return cedulaSolicitante;
    }

    public String getFijoSolicitante() {
        return fijoSolicitante;
    }

    public String getCelularSolicitante() {
        return celularSolicitante;
    }

    public int getMenor1Bovinos() {
        return menor1Bovinos;
    }

    public int getEntre12Bovinos() {
        return entre12Bovinos;
    }

    public int getEntre23Bovinos() {
        return entre23Bovinos;
    }

    public int getMayores3Bovinos() {
        return mayores3Bovinos;
    }

    public int getMenor1Bufalino() {
        return menor1Bufalino;
    }

    public int getEntre12Bufalino() {
        return entre12Bufalino;
    }

    public int getEntre23Bufalino() {
        return entre23Bufalino;
    }

    public int getMayor3Bufalino() {
        return mayor3Bufalino;
    }

    public int getPrimeraVez() {
        return primeraVez;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public int getCompra() {
        return compra;
    }

    public int getPerdidaDIN() {
        return perdidaDIN;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public Boolean getTerminos() {
        return terminos;
    }
}
