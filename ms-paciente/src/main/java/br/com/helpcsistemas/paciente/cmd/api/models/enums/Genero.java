package br.com.helpcsistemas.paciente.cmd.api.models.enums;

public enum Genero {

    MASCULINO(1,"Masculino"),
    FEMININO(2,"Feminino");

    private final Integer cod;
    private final String nome;

    Genero(Integer cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public Integer getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public static Genero toEnum(Integer cod) {
        if (cod == null) { return null; }

        for (Genero x : Genero.values()) {
            if (cod.equals(x.getCod())) { return x; }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
