package com.banco.micro.persona.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;

public class PersonaUtil {

    private PersonaUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static synchronized String decode(String value) {
		try {
			if (value == null)
				return value;
			return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			throw new BancoException(e);
		}
	}

    public static synchronized <T> List<T> convertListMapToListEntidadOrDTO(Class<T> retorno, List<Tuple> datax) throws Exception  {
		if(datax == null) {
			return null;
		}
		
		ObjectMapper modelMapper = new Jackson2ObjectMapperBuilder()
        .featuresToEnable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        .build();
        modelMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
		modelMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return datax.stream().map(p -> {
			Map<String, Object> maps = new HashMap<>();
			List<TupleElement<?>> cols = ((Tuple) p).getElements();
			cols.forEach(te -> maps.put(te.getAlias(), ((Tuple) p).get(te.getAlias())));
			return modelMapper.convertValue(maps, retorno);
		}).collect(Collectors.toList());
	}

	public static String mensajeErrorExceptio(Exception e) {
		try {
			String mensaje = "";
			while (e != null) {
				mensaje = e.getMessage();
				e = (Exception) e.getCause();
			}
			return mensaje;
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}
	
	public static Map<String, Object> getMensajeError(String titulo, Exception e) {
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", titulo);
		response.put("error", mensajeErrorExceptio(e));
		return response;
	}
    
}
