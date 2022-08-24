package br.com.goqueiroz.hrworker.controller;

import br.com.goqueiroz.hrworker.entities.Worker;
import br.com.goqueiroz.hrworker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

  private WorkerService workerService;

  @Autowired
  public WorkerController(WorkerService workerService) {
    this.workerService = workerService;
  }

  @GetMapping
  public ResponseEntity<List<Worker>> findAll(){
    List<Worker> allWorker = workerService.findAllWorker();

    return ResponseEntity.ok(allWorker);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id){

    Worker worker = workerService.findById(id);

    return ResponseEntity.ok(worker);
  }
}
