package cl.awakelab.repaso.algoritms;

import java.util.ArrayList;
import java.util.List;

// CREAR CLASE
public class CalculoEdad implements CalculoDescuento {

    //CREAR METODO QUE RECIBA LOS VALORES SOLICITADOS
    @Override
    public List<Double> descuento(List<Detalles> detalles) {

        //INICIALIZAR LAS VARIABLES
        double descuento;
        List<Double> descuentos = new ArrayList<>();

        //APLICAR LOGICA DEL CÓDIGO
        for (Detalles detalle : detalles) {
            if (detalle.getEdadPaciente() > 60) {
                descuento = 30.00 / 100;
            } else if (detalle.getEdadPaciente() > 35) {
                descuento = 0.1;
            } else if (detalle.getEdadPaciente() >= 13) {
                descuento = 0.0;
            } else if (detalle.getEdadPaciente() > 5) {
                descuento = 0.03;
            } else {
                descuento = 0.05;
            }
            descuentos.add(descuento);
        }
        //RETORNO DE LA FUNCIÓN
        return descuentos;
    }
}
