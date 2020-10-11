package com.telran.backend;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class SetBackendStorage implements IBackendServerStorage{

    Collection<BackendServerEntity> storage;
    BackendLoadComparator comparator;

    public SetBackendStorage() {
        storage = new HashSet<>();
        comparator = new BackendLoadComparator();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void update(BackendServerEntity backend) {
        storage.remove(backend);
        storage.add(backend);
    }

    @Override
    public BackendServerEntity getOptimal() {
        return storage.stream().min(comparator).orElse(null);
    }

    // TODO: complete
    @Override
    public void clearOlderThan(Duration duration) {
        LocalDateTime now = LocalDateTime.now();

        storage = storage.stream()
                .filter(server -> server
                        .getUpdateTime()
                        .isAfter(ChronoZonedDateTime.from(now.minus(duration))))
                .collect(Collectors.toCollection(PriorityQueue::new));
    }
}
