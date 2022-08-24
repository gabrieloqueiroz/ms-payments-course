package br.com.goqueiroz.hrworker.services;

import br.com.goqueiroz.hrworker.entities.Worker;
import br.com.goqueiroz.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WorkerService {

  private WorkerRepository workerRepository;

  @Autowired
  public WorkerService(WorkerRepository workerRepository){
    this.workerRepository = workerRepository;
  }

  public List<Worker> findAllWorker(){
    return workerRepository.findAll();
  }

  public Worker findById(Long id){
    return workerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
