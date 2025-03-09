package com.banco.micro.persona.util;


public class BancoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public final static String ALL = "All ";
	public final static String ENTCHILD = "related tables(childs)";
	public final static String FOREIGNDATA = "foreign classes data: ";
	public static String ENTITY_SUCCESFULLYSAVED = "DATOS GUARDADOS CORRECTAMENTE";
	public static String ENTITY_SUCCESFULLYDELETED = "SE ELIMINO SATISFACTORIAMENTE";
	public static String ENTITY_SUCCESFULLYMODIFIED = "SE MODIFICO SATISFACTORIAMENTE";
	public static String ENTITY_FAIL = "NO EXISTEN REGISTROS PENDIENTES PARA GRABAR !!! ";
	public static String ENTITY_DONT_SAVE = "PROBLEMAS AL GUARDAR LA INFORMACION EN LA BASE DE DATOS";
	public static String ENTITY_WITHSAMEKEY = "Another Entity with the same key was found";
	public static String ENTITY_NOENTITYTOUPDATE = "No Entity was found, with the typed key ";
	public static String ERROR_ELIMINAR_REGISTRO = "PROBLEMAS AL ELIMINAR EL REGISTRO SELECCIONADO";
	public static String ERROR_CREAR_NUEVO_REGISTRO = "PROBLEMAS ENCONTRADOS AL CREAR UN NUEVO REGISTRO";
	public static String ERROR_INGRESAR_NUEVO_REGISTRO = "PROBLEMAS AL INGRESAR UN NUEVO REGISTRO, REVISAR QUE TODOS LOS CAMPOS ESTEN LLENOS";
	public static String ERROR_LV_SELECCIONAR = "DEBE SELECCIONAR UN REGISTRO DE LA LISTA PARA PODER CONTINUAR";
	public static String ERROR_TB_FILA_PENDIENTE_INGRESO = "EXISTE UN REGISTRO EN EDICION !!!";
	public static String WARNING_DATOS_INCOMPLETOS = "DATOS INCORRECTO O INCOMPLETOS !!!";
	public static String ERROR_REGISTRO_PENDIENTE_COMMIT = "EXISTEN REGISTROS PENDIENTES DE GRABAR !!! ";
	public static String ERROR_PASSWORD_CHANGE = "Error no se actualizo la contraseña del usuario !!! ";
	public static String PASSWORD_SAVED = "Se actualizo la contraseña del usuario !!! ";
	public static String PASSWORD_REPEATED = "No puede ingresar un password utilizado anteriormente";
	public static String IMAGE_DELETE = "Imagen eliminada";

	public BancoException() {
	}

	public BancoException(String exception) {
		super(exception);
	}

	public BancoException(Exception exception) {
		super(exception);
	}

	public BancoException(String mensaje, Throwable thowable) {
		super(mensaje, thowable);
	}

	public class NotValidFieldException extends BancoException {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("El valor para: \"" + info + "\" no es válido");
		}
	}

	public class NullEntityExcepcion extends BancoException {
		private static final long serialVersionUID = 1L;

		public NullEntityExcepcion(String info) {
			super("Datos de " + info + " No existe o son incompletos");
		}
	}

	public class EmptyFieldException extends BancoException {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("El valor de \"" + info + "\" no puede estar vacio");
		}
	}

	public class NotValidFormatException extends BancoException {
		private static final long serialVersionUID = 1L;

		public NotValidFormatException(String info) {
			super("The Format or length for the field: \"" + info + "\" is not valid");
		}
	}

	public class DeletingException extends BancoException {
		private static final long serialVersionUID = 1L;

		public DeletingException(String info) {
			super("The Entity you are trying to delete " + "may have related information, "
					+ "please before trying again, " + "check the data on the entity, \"" + info + "\"");
		}
	}

	public class ForeignException extends BancoException {
		private static final long serialVersionUID = 1L;

		public ForeignException(String info) {
			super("There was no data related with the input \"" + info + "\"");
		}
	}

	public class DuplicateException extends BancoException {
		private static final long serialVersionUID = 1L;

		public DuplicateException(String info) {
			super("Registro ya existe \"" + info + "\"");
		}
	}

	public class GettingException extends BancoException {
		private static final long serialVersionUID = 1L;

		public GettingException(String info) {
			super("EXCEPCIÓN: \"" + info + "\"");
		}
	}

	public class FindingException extends BancoException {
		private static final long serialVersionUID = 1L;

		public FindingException(String info) {
			super("EXCEPCIÓN: " + info);
		}
		public FindingException(String info, Exception exception) {
			super("EXCEPCIÓN: " + info+": "+PersonaUtil.mensajeErrorExceptio(exception));
		}
	}
	
	public class NullException extends BancoException {
		private static final long serialVersionUID = 1L;

		public NullException() {
			super("EXCEPCIÓN: CONSULTA NO RETORNA VALOR!");
		}
	}

	public class NotSaveException extends BancoException {
		private static final long serialVersionUID = 1L;

		public NotSaveException(String info) {
			super("DATOS NO GUARDADOS : \"" + info + "\"");
		}

		public NotSaveException(String info, Exception e) {
			super("DATOS NO GUARDADOS : <b>\"" + info +  "\" :</b> "+PersonaUtil.mensajeErrorExceptio(e) );
		}
	}

}
