package com.desafio.injecao;

import com.desafio.entities.Order;
import com.desafio.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.desafio"})
public class InjecaoApplication implements CommandLineRunner {



	private OrderService orderService;

	public InjecaoApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(InjecaoApplication.class, args);
	}

	@java.lang.Override
	public void run(java.lang.String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();
		Order order = new Order(code, basic, discount);

		System.out.println("Codigo do pedido: " + order.getCode());
		System.out.println("Valor total: R$" + orderService.total(order));
	}
}
