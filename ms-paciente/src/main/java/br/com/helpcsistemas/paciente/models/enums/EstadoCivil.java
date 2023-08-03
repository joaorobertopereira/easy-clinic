package br.com.helpcsistemas.paciente.models.enums;

public enum EstadoCivil {

    Solteiro(1, "Solteiro"),
    Casado(2, "Casado"),

    Separado(3, "Separado"),
    Divorciado(4, "Divorciado"),
    Viuvo(5, "Viúvo");

    private final Integer cod;
    private final String nome;

    EstadoCivil(Integer cod, String name) {
        this.cod = cod;
        this.nome = name;
    }

    public Integer getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public static EstadoCivil toEnum(Integer cod) {
        if (cod == null) { return null; }

        for (EstadoCivil x : EstadoCivil.values()) {
            if (cod.equals(x.getCod())) { return x; }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
