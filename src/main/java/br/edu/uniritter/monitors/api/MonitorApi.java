package br.edu.uniritter.monitors.api;

import br.edu.uniritter.monitors.dto.MonitorDTO;
import br.edu.uniritter.monitors.entity.Monitor;
import br.edu.uniritter.monitors.service.MonitorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/monitors")
public class MonitorApi {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    MonitorService monitorService;

    @GetMapping
    public List<Monitor> index() {
        return monitorService.all();
    }

    @PostMapping
    public Monitor store(@Valid @RequestBody MonitorDTO monitor) {
        return monitorService.save(modelMapper.map(monitor, Monitor.class));
    }
}
