package com.example.UnitTestingExercise;

public class EmailCliente {
    //Método "EnviarCorreo"
    public void enviarCorreo(String destinatario, String asunto, String mensaje){
        //Título
        System.out.println("----- DATOS PARA EL CORREO -----");
        //Mostrar destinatario del correo
        System.out.println("Para: " + destinatario);
        //Mostrar asunto del correo
        System.out.println("Asunto: " + asunto);
        //Mostrar mensaje del correo
        System.out.println("Mensaje: " + mensaje);
    }
}
