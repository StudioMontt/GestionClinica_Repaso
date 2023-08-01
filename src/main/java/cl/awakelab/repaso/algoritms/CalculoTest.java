package cl.awakelab.repaso.algoritms;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CalculoTest {

    @Test
    public void testCalculoEdad() {
        CalculoDescuento calculadora = new CalculoEdad();
        List<Detalles> detalles = Arrays.asList(
                new Detalles(4, 25, "Neurólogo"),
                new Detalles(37, 3, "Cardiólogo"),
                new Detalles(25, 8, "Dermatólogo"),
                new Detalles(29, 15, "Oncólogo"),
                new Detalles(10, 49, "Dermatólogo"),
                new Detalles(57, 40, "Neurólogo")
        );
        List<Double> resultadosEsperados = Arrays.asList(0.05, 0.1, 0.0, 0.0, 0.0, 0.3);
        List<Double> resultadosObtenidos = calculadora.descuento(detalles);
        assertEquals(resultadosEsperados, resultadosObtenidos);
    }

    @Test
    public void testCalculoEspecialidadExperiencia() {
        CalculoDescuento calculadora = new CalculoEspecialidadExperiencia();
        List<Detalles> detalles = Arrays.asList(
                new Detalles(4, 25, "Neurólogo"),
                new Detalles(37, 3, "Cardiólogo"),
                new Detalles(25, 8, "Dermatólogo"),
                new Detalles(29, 15, "Oncólogo"),
                new Detalles(10, 49, "Dermatólogo"),
                new Detalles(57, 40, "Neurólogo")
        );
        List<Double> resultadosEsperados = Arrays.asList(0.03, 0.15, 0.0, 0.1, 0.0, 0.05);
        List<Double> resultadosObtenidos = calculadora.descuento(detalles);
        assertEquals(resultadosEsperados, resultadosObtenidos);
    }

    @Test
    public void testCalculoEspecialidadExperienciaMax() {
        CalculoDescuento calculadoraMax = new CalculoEspecialidadExperiencia();
        List<Detalles> detalles = Arrays.asList(
                new Detalles(150, 50, "Neurólogo"),
                new Detalles(150, 50, "Cardiólogo"),
                new Detalles(150, 50, "Dermatólogo"),
                new Detalles(150, 50, "Oncólogo"),
                new Detalles(150, 50, "Dermatólogo"),
                new Detalles(150, 50, "Neurólogo")
        );
        List<Double> resultadosEsperados = Arrays.asList(0.03, 0.15, 0.0, 0.1, 0.0, 0.05);
        List<Double> resultadosObtenidos = calculadoraMax.descuento(detalles);
        assertEquals(resultadosEsperados, resultadosObtenidos);
    }

    @Test
    public void testCalculoEspecialidadExperienciaMin() {
        CalculoDescuento calculadoraMin = new CalculoEspecialidadExperiencia();
        List<Detalles> detalles = Arrays.asList(
                new Detalles(0, 0, "Neurólogo"),
                new Detalles(0, 0, "Cardiólogo"),
                new Detalles(0, 0, "Dermatólogo"),
                new Detalles(0, 0, "Oncólogo"),
                new Detalles(0, 0, "Dermatólogo"),
                new Detalles(0, 0, "Neurólogo")
        );
        List<Double> resultadosEsperados = Arrays.asList(0.03, 0.15, 0.0, 0.1, 0.0, 0.05);
        List<Double> resultadosObtenidos = calculadoraMin.descuento(detalles);
        assertEquals(resultadosEsperados, resultadosObtenidos);
    }

}
