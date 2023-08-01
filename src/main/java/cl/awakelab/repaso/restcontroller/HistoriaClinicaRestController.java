package cl.awakelab.repaso.restcontroller;

import cl.awakelab.repaso.entity.HistoriaClinica;
import cl.awakelab.repaso.service.IHistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/historiaClinica", headers = "Accept=Application/json")
public class HistoriaClinicaRestController {
    @Autowired
    IHistoriaClinicaService historiaClinicaService;

    //(METODO GET PARA LISTAR)
    @GetMapping
    public List<HistoriaClinica> listarHistoriasClinicas() {
        return historiaClinicaService.listarHistoriasClinicas();
    }

    //(METODO POST PARA CREAR)
    @PostMapping("/crearHistoriaClinica")
    public HistoriaClinica crearHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica historiaClinicaNueva = new HistoriaClinica();
        historiaClinicaNueva.setId(historiaClinica.getId());
        historiaClinicaNueva.setPaciente(historiaClinica.getPaciente());
        historiaClinicaNueva.setDoctor(historiaClinica.getDoctor());
        historiaClinicaNueva.setSintomas(historiaClinica.getSintomas());
        historiaClinicaNueva.setDiagnostico(historiaClinica.getDiagnostico());
        historiaClinicaNueva.setTratamiento(historiaClinica.getTratamiento());
        return historiaClinicaService.crearHistoriaClinica(historiaClinicaNueva);
    }

    //(METODO GET PARA BUSCAR POR ID)
    @GetMapping("/{id}")
    public HistoriaClinica buscarHistoriaClinicaPorId(@PathVariable int id) {
        return historiaClinicaService.buscarHistoriaClinicaPorId(id);
    }

    //(METODO PUT PARA ACTUALIZAR)
    @PutMapping("/{id}")
    public HistoriaClinica actualizarHistoriaClinica(@RequestBody HistoriaClinica historiaClinicaActualizar, @PathVariable int id) {
        HistoriaClinica historiaClinica = historiaClinicaService.buscarHistoriaClinicaPorId(id);
        historiaClinica.setPaciente(historiaClinicaActualizar.getPaciente());
        historiaClinica.setDoctor(historiaClinicaActualizar.getDoctor());
        historiaClinica.setSintomas(historiaClinicaActualizar.getSintomas());
        historiaClinica.setDiagnostico(historiaClinicaActualizar.getDiagnostico());
        historiaClinica.setTratamiento(historiaClinicaActualizar.getTratamiento());
        return historiaClinicaService.actualizarHistoriaClinica(id, historiaClinica);
    }

    //(METODO DELETE PARA ELIMINAR)
    @DeleteMapping("/{id}")
    public void eliminarHistoriaClinica(@PathVariable int id) {
        historiaClinicaService.eliminarHistoriaClinica(id);
    }
}

