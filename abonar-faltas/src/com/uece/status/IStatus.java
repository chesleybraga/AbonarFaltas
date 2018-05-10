package com.uece.status;

public interface IStatus {

    void solicitar();

    void aprovar();

    void recusar();

    void retornar(String motivo);
}