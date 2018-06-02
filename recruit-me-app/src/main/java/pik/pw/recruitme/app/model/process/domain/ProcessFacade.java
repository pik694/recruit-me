package pik.pw.recruitme.app.model.process.domain;

import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Transactional
public class ProcessFacade {

    private ProcessRepository repository;
    private ProcessFactory processFactory;

    public ProcessFacade(ProcessRepository repository, ProcessFactory creator) {

        this.processFactory = creator;
        this.repository = repository;
    }

    public ProcessDTO add(ProcessDTO dto) {

        requireNonNull(dto);

        Process process = processFactory.from(dto);
        process = repository.save(process);

        return process.toDTO();
    }

    public ProcessDTO show(Integer id) {

        Process process = repository.findByIdOrThrow(id);
        return process.toDTO();
    }

    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(repository::deleteById);
    }

    public List<ProcessDTO> findAll() {

        List<ProcessDTO> dtos = new ArrayList<>();

        for(Process process: repository.findAll()) {
            dtos.add(process.toDTO());
        }

        return dtos;
    }
}
