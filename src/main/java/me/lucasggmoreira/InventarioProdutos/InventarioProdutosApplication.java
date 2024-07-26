package me.lucasggmoreira.InventarioProdutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "me.lucasggmoreira.modelos")
@ComponentScan(basePackages = "me.lucasggmoreira")
public class InventarioProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioProdutosApplication.class, args);
	}

}
