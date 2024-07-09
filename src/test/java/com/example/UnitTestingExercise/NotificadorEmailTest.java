package com.example.UnitTestingExercise;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    //***********************************************************************************************************************

    // Test para verificar que no se envía correo con dirección vacía
    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje", "Hola");

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }

    //***********************************************************************************************************************

    //Notificar que el correo se envío
    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("jenny@test.com", "Hola Mundo", "Ejemplo de mensaje");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("jenny@test.com", "Hola Mundo", "Ejemplo de mensaje");
        System.out.println("Correo enviado correctamente");
    }

    //***********************************************************************************************************************

    // Test para verificar el comportamiento con mensaje nulo
    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("jenny@test.com", "Asunto", null);

        // Verificar que se maneja adecuadamente un mensaje nulo
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }

    //***********************************************************************************************************************

    // Test para verificar el comportamiento con asunto nulo
    @Test
    public void testNotificarConAsuntoNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("jenny@test.com", null, "Hola");

        // Verificar que no se realiza el envío si el asunto es vacío
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }

    //***********************************************************************************************************************

    // Test para verificar el comportamiento con correo en blanco
    @Test
    public void testNotificarCorreoTotalmenteVacio() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, null, null);

        // Verificar que no se realiza el envío si el correo está en blanco
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }

    //***********************************************************************************************************************

    // Test para verificar el comportamiento con destinatario y asunto en blanco
    @Test
    public void testNotificarDestinatarioYAsuntoVacío() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, null, "Mensaje");

        // Verificar que no se realiza el envío si el destinatario y asunto en blanco
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }

    //***********************************************************************************************************************

    // Test para verificar el comportamiento con destinatario y mensaje en blanco
    @Test
    public void testNotificarDestinatarioYMensajeVacío() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, "Asunto", null);

        // Verificar que no se realiza el envío si el destinatario y mensaje en blanco
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }

    //***********************************************************************************************************************

    // Test para verificar el comportamiento con asunto y mensaje en blanco
    @Test
    public void testNotificarAsuntoYMensajeVacío() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("jenny@test.com", null, null);

        // Verificar que no se realiza el envío si el asunto y mensaje en blanco
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString(), anyString());
    }
}

