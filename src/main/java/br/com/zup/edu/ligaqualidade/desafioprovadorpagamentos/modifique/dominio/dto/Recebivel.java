package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.dto;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes.ConstantesFormatoData;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.dto.enums.StatusRecebivel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Recebivel {
    public final StatusRecebivel statusRecebivel;
    public final LocalDate diaRecebimento;
    public final BigDecimal valorASerRecebido;
    public final BigDecimal valorOriginal;

    public Recebivel(StatusRecebivel statusRecebivel, LocalDate diaRecebimento, BigDecimal valorASerRecebido,  BigDecimal valorOriginal) {
        this.statusRecebivel = statusRecebivel;
        this.diaRecebimento = diaRecebimento;
        this.valorASerRecebido = valorASerRecebido;
        this.valorOriginal = valorOriginal;
    }

    @Override
    public String toString() {
        return statusRecebivel.descricao + ","
                + valorOriginal + "," + valorASerRecebido
                + "," + diaRecebimento.format(ConstantesFormatoData.FORMATADOR_PADRAO_DD_MM_YYYY_COM_BARRA) ;
    }
}
