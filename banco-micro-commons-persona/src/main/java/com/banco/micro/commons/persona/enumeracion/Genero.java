package com.banco.micro.commons.persona.enumeracion;

public enum Genero {
    M ("MASCULINO"),  // Representa el género masculino
    F ("FEMENINO"),   // Representa el género femenino
    O ("OTRO");
    
    private final String label;

    Genero(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
