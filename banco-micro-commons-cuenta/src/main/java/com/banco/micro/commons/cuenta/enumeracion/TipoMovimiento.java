package com.banco.micro.commons.cuenta.enumeracion;

public enum TipoMovimiento {
    D("DEPOSITO"),
    R("RETIRO");

    private final String label;

    TipoMovimiento(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
