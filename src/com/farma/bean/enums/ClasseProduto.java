package com.farma.bean.enums;

/**
 * Enumera��o das poss�veis Tipo de um medicamento
 *
 * @author Inocencio
 */
public enum ClasseProduto {

    /**
     * Doen�a cr�nica
     */
    CRONICA(1,"CRONICA"),
    /**
     * Doen�a al�rgica
     */
    ALERGIA(2,"ALERGIA");
	
	private final int ID;
    private final String classe;

    private ClasseProduto(int id, String classe) {
        this.ID = id; 
    	this.classe = classe;
    }
    
    /**
     * Retorna o c�digo da situa��o
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
