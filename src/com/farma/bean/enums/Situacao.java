package com.farma.bean.enums;

/**
 * Enumera��o das poss�veis situa��es de um registro
 *
 * @author Inocencio
 */
public enum Situacao {

    /**
     * Situa��o para registros ainda pendentes de altera��o
     */
    ABERTA(1, "Aberta"),
    /**
     * Situa��o para registros j� finalizados
     */
    FINALIZADA(2, "Finalizada"),
    /**
     * Situa��o para registros cancelados durante o processo
     */
    CANCELADA(3, "Cancelada");

    private final int ID;
    private final String DESCRICAO;

    private Situacao(int id, String descricao) {
        this.ID = id;
        this.DESCRICAO = descricao;
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
        return this.DESCRICAO;
    }
}
