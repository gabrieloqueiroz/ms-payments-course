package br.com.goqueiroz.hrworker.repositories;

import br.com.goqueiroz.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
