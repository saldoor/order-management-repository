package com.example.ordermanagement;

import com.example.ordermanagement.entity.OrderEntity;
import com.example.ordermanagement.repository.OrderRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class OrdermanagementApplicationTests extends AbstractContainerBaseTest {

	@Container
	private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest");
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MockMvc mockMvc;

    @Test
    public void saveOrder() throws Exception {
		/*System.out.println(POSTGRES_SQL_CONTAINER.getDatabaseName());
		System.out.println(POSTGRES_SQL_CONTAINER.getUsername());
		System.out.println(POSTGRES_SQL_CONTAINER.getPassword());
		System.out.println(POSTGRES_SQL_CONTAINER.getJdbcUrl());*/

        List<OrderEntity> orderEntityList = List.of(OrderEntity.builder()
                        .orderName("abc")
                        .build(),
                OrderEntity.builder()
                        .orderName("efg")
                        .build());
		List<OrderEntity> orderEntities = orderRepository.saveAll(orderEntityList);
		System.out.println(orderEntities);
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/order/getAllOrder"));

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(orderEntities.size())));
	}

}
