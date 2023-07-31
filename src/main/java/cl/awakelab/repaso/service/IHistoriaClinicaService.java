package cl.awakelab.repaso.service
        ;

import cl.awakelab.repaso.entity.HistoriaClinica;

import java.util.List;

public interface IHistoriaClinicaService {

    HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica);

    List<HistoriaClinica> listarHistoriasClinicas();

    HistoriaClinica buscarHistoriaClinicaPorId(int id);

    HistoriaClinica actualizarHistoriaClinica(int id, HistoriaClinica historiaClinicaActualizar);

    void eliminarHistoriaClinica(int id);
}


