package com.telran.backend;

import java.time.Duration;

/**
 * The data structure stores the information about all the backends appealed
 * to the balancer and keeps their actual load parameter
 */

public interface IBackendServerStorage {

    /**
     * @return the amount of active backend
     */
    int size();

    /**
     * updates server's load or adds the new backend server if not present
     *
     * @param backend server to add or update
     */
    void update(BackendServerEntity backend);

    /**
     * @return the optimal backend according to the load parameter or null if absent
     */
    BackendServerEntity getOptimal();

    /**
     * Clears the data structure from inactive backends
     */
    void clearOlderThan(Duration duration);
}
