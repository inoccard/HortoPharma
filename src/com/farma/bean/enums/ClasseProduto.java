package com.farma.bean.enums;

/**
 * Enumeração das possíveis Tipo de um medicamento
 *
 * @author Inocencio
 */
public enum ClasseProduto {

    /**
     * Doença crônica
     */
    CRONICA(1,"CRONICA"),
    /**
     * Doença alérgica
     */
    ALERGIA(2,"ALERGIA");
	
	private final int ID;
    private final String classe;

    private ClasseProduto(int id, String classe) {
        this.ID = id; 
    	this.classe = classe;
    }
    
    /**
     * Retorna o código da situação
     *
     * @return int id
     */
    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return this.classe;
    }
}
