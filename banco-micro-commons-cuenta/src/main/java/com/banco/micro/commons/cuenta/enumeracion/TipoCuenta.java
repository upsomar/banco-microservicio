package com.banco.micro.commons.cuenta.enumeracion;

public enum TipoCuenta {
    A ("AHORRO"),  
    C ("CORRIENTE");
    
    private final String label;

    TipoCuenta(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
