package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.mapeador;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes.ConstantesFormatoData;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes.ConstantesIndicesPosicaoMensagem;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util.MapeadorDatas;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util.MapeadorValores;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface MapeadorMensagemParaDadosTransacao {

    static DadosTransacao mapeiaTransacao(List<String> infoTransacao) {

        return new DadosTransacao(mapeiaValorTransacao(infoTransacao),
                mapeiaMetodoPagamento(infoTransacao),
                mapeiaNumeroCartao(infoTransacao),
                mapeiaNomeCartao(infoTransacao),
                mapeiaValidadeCartao(infoTransacao),
                mapeiaCvv(infoTransacao),
                mapeiaId(infoTransacao)
        );
    }

    private static BigDecimal mapeiaValorTransacao(List<String> infoTransacao) {
        return MapeadorValores.mapeiaValorStringParaBigDecimal(infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.VALOR));
    }

    private static MetodoPagamento mapeiaMetodoPagamento(List<String> infoTransacao) {
        return MetodoPagamento.valueOf(infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.METODO_PAGAMENTO).toUpperCase());
    }

    private static String mapeiaNumeroCartao(List<String> infoTransacao) {
        return infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.NUMERO_CARTAO);
    }

    private static String mapeiaNomeCartao(List<String> infoTransacao) {
        return infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.NOME_CARTAO);
    }

    private static LocalDate mapeiaValidadeCartao(List<String> infoTransacao) {
        String dataValidadeComoString = infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.VALIDADE);
        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern(ConstantesFormatoData.FORMATO_DATA_DD_MM_YYYY_COM_BARRA);

        return MapeadorDatas.mapeiaDataComoStringParaLocalDate(dataValidadeComoString, formatadorDeData);
    }

    private static int mapeiaCvv(List<String> infoTransacao) {
        return Integer.parseInt(infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.CCV));
    }

    private static int mapeiaId(List<String> infoTransacao) {
        return Integer.parseInt(infoTransacao.get(ConstantesIndicesPosicaoMensagem.IndiciesTransacao.ID_TRANSACAO));
    }
}
