package com.example.UnitTestingExercise;

public class NotificadorEmail {
    //Instancia de la clase "EmailCliente"
    private EmailCliente emailCliente;

    //Constructor con parámetros
    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String destinatario, String asunto, String mensaje) {
        if(destinatario == null || destinatario.isEmpty() || asunto == null || asunto.isEmpty() || mensaje == null || mensaje.isEmpty()){
            System.out.println("Debe ingresar todos los datos que se solicitan");
            //Que hacer si todos los datos fueron ingresados...
        } else {
            // Lógica para enviar una notificación por correo
            emailCliente.enviarCorreo(destinatario, asunto, mensaje);
        }
    }
}

