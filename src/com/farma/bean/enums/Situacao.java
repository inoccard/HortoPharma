package com.farma.bean.enums;

/**
 * Enumeração das possíveis situações de um registro
 *
 * @author Inocencio
 */
public enum Situacao {

    /**
     * Situação para registros ainda pendentes de alteração
     */
    ABERTA(1, "Aberta"),
    /**
     * Situação para registros já finalizados
     */
    FINALIZADA(2, "Finalizada"),
    /**
     * Situação para registros cancelados durante o processo
     */
    CANCELADA(3, "Cancelada");

    private final int ID;
    private final String DESCRICAO;

    private Situacao(int id, String descricao) {
        this.ID = id;
        this.DESCRICAO = descricao;
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
        return this.DESCRICAO;
    }
}
