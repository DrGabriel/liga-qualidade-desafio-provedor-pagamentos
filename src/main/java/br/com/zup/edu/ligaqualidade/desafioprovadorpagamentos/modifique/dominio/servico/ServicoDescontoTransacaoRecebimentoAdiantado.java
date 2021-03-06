package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ServicoDescontoTransacaoRecebimentoAdiantado {

    static List<DadosTransacao> aplicaRecebimentos(List<DadosTransacao> dadosTransacoes, List<DadosRecebimentoAdiantado> dadosRecebimentoAdiantados) {
        return Optional.of(dadosTransacoes).orElse(List.of())
                .stream().map(dadoTransacao -> {

                    Optional<DadosRecebimentoAdiantado> dadosRecebimentoAdiantado = Optional.of(dadosRecebimentoAdiantados).orElse(List.of())
                            .stream().filter(dadoRecebimentoAdiantado -> dadoRecebimentoAdiantado.idTransacao == dadoTransacao.id).findFirst();

                    dadosRecebimentoAdiantado.ifPresent(recebimentoAdiantado -> dadoTransacao.valor = dadoTransacao.valor.multiply(recebimentoAdiantado.taxa));

                    return dadoTransacao;
                }).collect(Collectors.toList());
    }
}
