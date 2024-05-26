package org.example.user;

import java.util.ArrayList;
import java.util.List;

public class WorkerManager {
  private static final WorkerManager WORKER_MANAGER = new WorkerManager();
  private final List<Worker> workers = new ArrayList<>();

  private WorkerManager() {

  }

  public static WorkerManager getInstance() {
    return WORKER_MANAGER;
  }

  public void add(Worker worker) {
    workers.add((worker));
  }

  public boolean isExistByIdAndPassword(String id, String password) {
    return workers.stream()
        .anyMatch(worker -> worker.getId().equals(id) && worker.getPassword().equals(password));
  }

  public Worker findByIdAndPassword(String id, String password) {
    return workers.stream()
        .filter(worker -> worker.getId().equals(id) && worker.getPassword().equals(password))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid id or password"));
  }
}
