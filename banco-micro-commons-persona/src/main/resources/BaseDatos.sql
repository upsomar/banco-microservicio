CREATE TABLE per_persona (
    persona_codigo INTEGER PRIMARY KEY,  -- Clave primaria autoincremental
    persona_nombre VARCHAR(100) NOT NULL,  -- Nombre de la persona
    persona_genero CHAR(1) NOT NULL,  -- Género (M: Masculino, F: Femenino, O: Otro)
    persona_edad INTEGER NOT NULL,  -- Edad de la persona
    persona_identificacion VARCHAR(15) NOT NULL UNIQUE,  -- Identificación única
    persona_direccion VARCHAR(200),  -- Dirección de la persona
    persona_telefono VARCHAR(15)  -- Teléfono de la persona
);



-- Crear la tabla per_cliente
CREATE TABLE per_cliente (
    cliente_codigo INTEGER PRIMARY KEY,  -- Clave primaria autoincremental
    persona_codigo INTEGER NOT NULL,  -- Clave foránea que referencia a per_persona
    cliente_clave VARCHAR(100) NOT NULL,  -- Contraseña del cliente
    cliente_estado BOOLEAN NOT NULL DEFAULT TRUE,  -- Estado del cliente (activo/inactivo)
    CONSTRAINT fk_persona_cliente  -- Nombre de la restricción de clave foránea
        FOREIGN KEY (persona_codigo)
        REFERENCES per_persona(persona_codigo)  -- Referencia a la tabla per_persona
);


-- Crear la tabla ban_cuenta
CREATE TABLE ban_cuenta (
    cuenta_codigo INTEGER PRIMARY KEY,  -- Clave primaria autoincremental
    cliente_codigo INTEGER NOT NULL,  -- Clave foránea que referencia a per_cliente
    cuenta_numero VARCHAR(20) NOT NULL UNIQUE,  -- Número de la cuenta (único)
    cuenta_tipo VARCHAR(50) NOT NULL,  -- Tipo de cuenta (ahorros, corriente, etc.)
    cuenta_saldo_inicial DECIMAL(15, 2) NOT NULL,  -- Saldo inicial de la cuenta
    cuenta_saldo_actual DECIMAL(15, 2) NOT NULL,
    cuenta_estado BOOLEAN NOT NULL DEFAULT TRUE,  -- Estado de la cuenta (activo/inactivo)    
    CONSTRAINT fk_cliente_cuenta  -- Nombre de la restricción de clave foránea
        FOREIGN KEY (cliente_codigo)
        REFERENCES per_cliente(cliente_codigo)  -- Referencia a la tabla per_cliente        
);

-- Crear la tabla movimiento
CREATE TABLE ban_movimiento (
    movimiento_codigo INTEGER PRIMARY KEY,  -- Clave primaria autoincremental
    movimiento_fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Fecha del movimiento
    movimiento_tipo VARCHAR(50) NOT NULL,  -- Tipo de movimiento (depósito, retiro, etc.)
    movimiento_valor DECIMAL(15, 2) NOT NULL,  -- Valor del movimiento
    movimiento_saldo DECIMAL(15, 2) NOT NULL,  -- Saldo después del movimiento
    cuenta_codigo INT NOT NULL,  -- Clave foránea que referencia a ban_cuenta
    CONSTRAINT fk_cuenta_movimiento  -- Nombre de la restricción de clave foránea
        FOREIGN KEY (cuenta_codigo)
        REFERENCES ban_cuenta(cuenta_codigo)  -- Referencia a la tabla ban_cuenta
);

CREATE SEQUENCE seq_per_persona
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
    
    CREATE SEQUENCE SEQ_PER_CLIENTE
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
    CREATE SEQUENCE seq_ban_cuenta
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
    
    CREATE SEQUENCE SEQ_BAN_MOVIMIENTO
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


select * from public.jv_snapshot

