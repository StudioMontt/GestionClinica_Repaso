package cl.awakelab.repaso.algoritms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Detalles> detalles = new ArrayList<>();
        CalculoEdad calculoEdad = new CalculoEdad();
        CalculoEspecialidadExperiencia calculoEspecialidadExperiencia = new CalculoEspecialidadExperiencia();
        Detalles detalle1 = new Detalles(4, 25, "Neurólogo");
        Detalles detalle2 = new Detalles(37, 3, "Cardiólogo");
        Detalles detalle3 = new Detalles(25, 8, "Dermatólogo");
        Detalles detalle4 = new Detalles(29, 15, "Oncólogo");
        Detalles detalle5 = new Detalles(10, 49, "Dermatólogo");
        Detalles detalle6 = new Detalles(57, 40, "Neurólogo");
        detalles.addAll(List.of(detalle1, detalle2, detalle3, detalle4, detalle5, detalle6));

        System.out.println(calculoEdad.descuento(detalles));
        System.out.println(calculoEspecialidadExperiencia.descuento(detalles));
    }
}