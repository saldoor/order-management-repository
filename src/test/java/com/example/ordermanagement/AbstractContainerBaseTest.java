package com.example.ordermanagement;

import org.testcontainers.containers.PostgreSQLContainer;

public abstract class AbstractContainerBaseTest {

    static final PostgreSQLContainer POSTGRES_SQL_CONTAINER;

    static {
        POSTGRES_SQL_CONTAINER = new PostgreSQLContainer("postgres:latest");
        POSTGRES_SQL_CONTAINER.start();
    }

}
