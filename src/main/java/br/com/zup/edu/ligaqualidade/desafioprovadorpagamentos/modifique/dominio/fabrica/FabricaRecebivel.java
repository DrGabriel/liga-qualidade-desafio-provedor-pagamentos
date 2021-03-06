package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.fabrica;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes.ConstantesRecebivel;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.dto.Recebivel;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.dto.enums.StatusRecebivel;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum FabricaRecebivel {

    DEBITO {
        @Override
        public Recebivel aplicaRegrasPorTipo(DadosTransacao dadosTransacao) {
            return new Recebivel(
                    StatusRecebivel.PAGO,
                    calculaDiaRecebimentoDebito(),
                    calculaValorTotalRecebivelAplicandoDesconto(dadosTransacao, ConstantesRecebivel.PORCENTAGEM_DESCONTO_DEBITO
                    ), dadosTransacao.valor
            );
        }
    },

    CREDITO {
        @Override
        public Recebivel aplicaRegrasPorTipo(DadosTransacao dadosTransacao) {
            return new Recebivel(
                    StatusRecebivel.AGUARDANDO_LIBERACAO_FUNDOS,
                    FabricaRecebivel.calculaDiaRecebimentoCredito(),
                    calculaValorTotalRecebivelAplicandoDesconto(dadosTransacao, ConstantesRecebivel.PORCENTAGEM_DESCONTO_CREDITO),
                    dadosTransacao.valor);
        }
    };


    public abstract Recebivel aplicaRegrasPorTipo(DadosTransacao dadosTransacao);

    private static LocalDate calculaDiaRecebimentoDebito() {
        return LocalDate.now();
    }

    private static LocalDate calculaDiaRecebimentoCredito() {
        return LocalDate.now().plusDays(ConstantesRecebivel.ADICIONAL_DIA_RECEBIMENTO_CREDITO);
    }

    private static BigDecimal calculaValorTotalRecebivelAplicandoDesconto(DadosTransacao dadosTransacao, Integer porcentagemDesconto) {
        BigDecimal taxaDesconto = BigDecimal.valueOf(1.0 - (porcentagemDesconto / 100.0));

        return dadosTransacao.valor.multiply(taxaDesconto);
    }


}
