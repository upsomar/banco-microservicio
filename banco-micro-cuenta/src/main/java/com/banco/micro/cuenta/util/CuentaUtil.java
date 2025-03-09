package com.banco.micro.cuenta.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class CuentaUtil {
	private static final String FORMATO_FECHA = "yyyy-MM-dd";

    private CuentaUtil() {
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

	public static synchronized Date convertirStringADate(String fechaStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);

        try {
            return sdf.parse(fechaStr);
        } catch (Exception e) {
            throw new BancoException(e);
        }
    }
    
	/**
	 * Devuelve la fecha seteada a 00 horas 00 minutos 00 segundos en formato
	 * calendar
	 *
	 * @param fecha fecha para transformar
	 * @return fecha con formato de hora 00:00:00
	 * @author cggm
	 */

	public static synchronized Date fechaInicioCalendar(Date fecha) {
		Calendar fInicio = Calendar.getInstance();
		fInicio.setTime(fecha);
		fInicio.set(Calendar.HOUR_OF_DAY, 0);
		fInicio.set(Calendar.MINUTE, 0);
		fInicio.set(Calendar.SECOND, 0);
		fInicio.set(Calendar.MILLISECOND, 0);
		return fInicio.getTime();
	}

	/**
	 * Devuelve la fecha seteada a 23 horas 59 minutos 59 segundos en formato
	 * calendar
	 *
	 * @param fecha fecha para transformar
	 * @return fecha con formato de hora 23:59:59
	 * @author cggm
	 */

	public static synchronized Date fechaFinCalendar(Date fecha) {
		Calendar fFin = Calendar.getInstance();
		fFin.setTime(fecha);
		fFin.set(Calendar.HOUR_OF_DAY, 23);
		fFin.set(Calendar.MINUTE, 59);
		fFin.set(Calendar.SECOND, 59);
		fFin.set(Calendar.MILLISECOND, 0);
		return fFin.getTime();
	}
}
