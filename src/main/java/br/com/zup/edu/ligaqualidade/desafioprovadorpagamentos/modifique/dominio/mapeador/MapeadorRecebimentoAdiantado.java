package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.mapeador;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes.ConstantesIndicesPosicaoMensagem;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util.MapeadorValores;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;

import java.math.BigDecimal;
import java.util.List;

public interface MapeadorRecebimentoAdiantado {

    static DadosRecebimentoAdiantado mapeiaInfoAdiantamentoParaRecebimentoAdiantado(List<String> infoAdiantamento) {
        return new DadosRecebimentoAdiantado(
                mapeiaIdTransacao(infoAdiantamento),
                mapeiaTaxa(infoAdiantamento)
        );
    }

    private static int mapeiaIdTransacao(List<String> infoAdiantamento) {
        return Integer.parseInt(infoAdiantamento.get(ConstantesIndicesPosicaoMensagem.IndicesAdiantamento.ID_TRANSACAO));
    }

    private static BigDecimal mapeiaTaxa(List<String> infoAdiantamento){
        String valorTxaComoString = infoAdiantamento.get(ConstantesIndicesPosicaoMensagem.IndicesAdiantamento.VALOR_ADIANTAMENTO);
        return MapeadorValores.mapeiaValorStringParaBigDecimal(valorTxaComoString);
    }


}
