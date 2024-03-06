/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author CATA
 */
public class controladorTiempo {
   

    private static boolean tieneDobleBeneficio = false;
    private static ArrayList<String> accionesRegistradas = new ArrayList<>();

    public static void main(String[] args) {
      
        registrarAccion("Estudiante recibe merienda", 9, 00);

      
        registrarAccion("no recibe", 12, 00);

       
        tieneDobleBeneficio = true;
        registrarAccion("Estudiante recibe merienda", 9, 00);

      
        registrarAccion("Estudiante  recibe almuerzo", 12, 00);
    }

    public static void registrarAccion(String accion, int hora, int minuto) {
      
        System.out.println("Registro: " + accion + " a las " + hora + ":" + minuto);
        accionesRegistradas.add(accion);

       
        if (accion.equals("Estudiante recibe merienda") && hora >= 9 && hora <= 10 && minuto <= 30) {
           
            programarVerificacionAlmuerzo();
        }
    }

    public static void programarVerificacionAlmuerzo() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               
                int horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (horaActual >= 12 && horaActual <= 14 && !tieneDobleBeneficio) {
                    System.out.println("Alerta: Estudiante ya recibio");
                } else {
                    System.out.println("No hay alerta");
                }
                timer.cancel(); 
            }
        }, 0); 
    }
}

