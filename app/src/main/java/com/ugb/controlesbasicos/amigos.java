package com.ugb.controlesbasicos;

public class amigos {
    String idAmigo;
    String nombre;
    String direccion;
    String telefono;
    String email;

    String urlFotoAmigo;

    public amigos(String idAmigo, String nombre, String direccion, String telefono, String email,  String urlFoto) {
        this.idAmigo = idAmigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.urlFotoAmigo = urlFoto;
    }

    public String getUrlFotoAmigo() {
        return urlFotoAmigo;
    }

    public void setUrlFotoAmigo(String urlFotoAmigo) {
        this.urlFotoAmigo = urlFotoAmigo;
    }

    public String getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(String idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
