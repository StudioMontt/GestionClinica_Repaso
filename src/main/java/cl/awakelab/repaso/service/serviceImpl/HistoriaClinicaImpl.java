package cl.awakelab.repaso.service.serviceImpl;

import cl.awakelab.repaso.entity.HistoriaClinica;
import cl.awakelab.repaso.repository.IHistClinicaRepository;
import cl.awakelab.repaso.service.IHistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HistoriaClinicaImpl implements IHistoriaClinicaService {
    @Autowired
    IHistClinicaRepository historiaClinicaRepo;

    @Override
    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepo.save(historiaClinica);
    }

    @Override
    public List<HistoriaClinica> listarHistoriasClinicas() {
        return historiaClinicaRepo.findAll();
    }

    @Override
    public HistoriaClinica buscarHistoriaClinicaPorId(int id) {
        return historiaClinicaRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Historia Clínica no fue encontrada"));
    }

    @Override
    public HistoriaClinica actualizarHistoriaClinica(int id, HistoriaClinica historiaClinicaActualizar) {
        HistoriaClinica historiaClinica = historiaClinicaRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Historia Clínica no fue encontrada"));
        historiaClinica.setId(historiaClinicaActualizar.getId());
        historiaClinica.setPaciente(historiaClinicaActualizar.getPaciente());
        historiaClinica.setListaDoctores(historiaClinicaActualizar.getListaDoctores());
        historiaClinica.setSintomas(historiaClinicaActualizar.getSintomas());
        historiaClinica.setDiagnostico(historiaClinicaActualizar.getDiagnostico());
        historiaClinica.setTratamiento(historiaClinicaActualizar.getTratamiento());
        return historiaClinicaRepo.save(historiaClinica);
    }

    @Override
    public void eliminarHistoriaClinica(int id) {
        historiaClinicaRepo.deleteById(id);
    }
}
