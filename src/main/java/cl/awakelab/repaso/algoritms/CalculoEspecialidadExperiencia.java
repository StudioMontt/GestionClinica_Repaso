package cl.awakelab.repaso.algoritms;

import java.util.ArrayList;
import java.util.List;

public class CalculoEspecialidadExperiencia implements CalculoDescuento {

    @Override
    public List<Double> descuento(List<Detalles> detalles) {

        double descuento = 0.0;
        List<Double> descuentos = new ArrayList<>();

        for (Detalles detalle : detalles) {
            if (detalle.getEspecialidad().equals("Dermatólogo")) {
                descuento = 0.0;
            } else if (detalle.getExperienciaDoctor() < 10) {
                descuento = 0.15;
            } else if ((detalle.getEspecialidad().equals("Cardiólogo") ||
                    detalle.getEspecialidad().equals("Neurólogo")) &&
                    detalle.getExperienciaDoctor() >= 10 &&
                    detalle.getExperienciaDoctor() < 20) {
                descuento = 0.05;
            } else if ((detalle.getEspecialidad().equals("Endocrinólogo") ||
                    detalle.getEspecialidad().equals("Oncólogo")) &&
                    detalle.getExperienciaDoctor() >= 5) {
                descuento = 0.1;
            } else if (detalle.getExperienciaDoctor() >= 20) {
                descuento = 0.05;
            }
            descuentos.add(descuento);
        }
        return descuentos;
    }
}