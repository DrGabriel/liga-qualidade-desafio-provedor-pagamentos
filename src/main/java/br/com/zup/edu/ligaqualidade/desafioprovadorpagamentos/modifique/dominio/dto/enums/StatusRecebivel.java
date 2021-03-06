package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.dto.enums;

public enum StatusRecebivel {

    PAGO("pago"), AGUARDANDO_LIBERACAO_FUNDOS("aguardando_liberacao_fundos");

    public final String descricao;

    StatusRecebivel(String descricao) {
        this.descricao = descricao;
    }

}
