package br.com.helpcsistemas.paciente.cmd.api.models.enums;

public enum Escolaridade {

    ANALFABETO(1, "Analfabeto"),
    ENS_FUN_INC(2, "Ensino fundamental incompleto"),
    ENS_FUN_COMP(3, "Ensino fundamental completo"),
    ENS_MED_INC(4, "Ensino médio incompleto"),
    ENS_MED_COMP(5, "Ensino médio completo"),
    SUP_COMP(6, "Superior completo"),
    SPU_INC(7, "Pós-graduação"),
    MESTRADO(8, "Mestrado"),
    DOUTORADO(9, "Doutorado"),
    POS_DOUTORADO(10, "Pós-Doutorado");

    private final Integer cod;
    private final String nome;

    Escolaridade(Integer cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public Integer getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public static Escolaridade toEnum(Integer cod) {
        if (cod == null) { return null; }

        for (Escolaridade x : Escolaridade.values()) {
            if (cod.equals(x.getCod())) { return x; }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
