package org.example.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkerList {

    private static final WorkerList WORKER_MANAGER = new WorkerList();
    private final List<Worker> workers = new ArrayList<>();

    private WorkerList() {
        Worker worker = new Worker();
        worker.id = String.valueOf(1);
        worker.password = String.valueOf(1);
        worker.userType = UserType.WORKER;
        workers.add(worker);
    }

    public static WorkerList getInstance() {
        return WORKER_MANAGER;
    }

    public void add(Worker worker) {
        workers.add((worker));
    }

    public boolean isExistByIdAndPassword(String id, String password) {
        return workers.stream()
            .anyMatch(worker -> worker.getId().equals(id) && worker.getPassword().equals(password));
    }

    public Optional<Worker> findByIdAndPassword(String id, String password) {
        return workers.stream()
            .filter(worker -> worker.getId().equals(id) && worker.getPassword().equals(password))
            .findFirst();
    }

    public List<Worker> getWorkerList() {
        return workers;
    }
}
