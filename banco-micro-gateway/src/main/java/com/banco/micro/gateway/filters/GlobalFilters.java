package com.banco.micro.gateway.filters;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//@Component
public class GlobalFilters implements GlobalFilter, Ordered {
	private final Logger log = LoggerFactory.getLogger(GlobalFilters.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("EJECUTANDO filtro  PRE");
		exchange.getRequest().mutate().headers(h -> h.add("token", "123456"));
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			log.info("EJECUTANDO filtro  POST");
			Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(valor -> {
				exchange.getResponse().getHeaders().add("token", valor);
			});
			exchange.getResponse().getCookies().add("volor", ResponseCookie.from("color", "rojo").build());
			// exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
		}));
	}

	@Override
	public int getOrder() {
		return 1;
		/**
		 * Solo en caso de que les de algún error relacionado al filtro
		 * EjemploGlobalFilter en el ejemplo del video anterior de Spring Cloud Gateway
		 * con Resilience4J.
		 * 
		 * La solución es modificar el orden dejándolo en 10 o 100:
		 */
	}

}
