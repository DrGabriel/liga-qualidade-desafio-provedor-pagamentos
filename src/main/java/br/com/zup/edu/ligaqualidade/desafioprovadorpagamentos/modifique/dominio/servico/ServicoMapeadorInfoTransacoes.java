package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.mapeador.MapeadorMensagemParaDadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util.MapeadorValores;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ServicoMapeadorInfoTransacoes {

    static List<DadosTransacao> mapeiaTransacoes(List<String> infoTransacoes) {
        return Optional.of(infoTransacoes).orElse(List.of()).stream()
                .map(ServicoMapeadorInfoTransacoes::mapeiaInfoTransacaoPosicionalParaDadosTransacao)
                .collect(Collectors.toList());
    }



    private static DadosTransacao mapeiaInfoTransacaoPosicionalParaDadosTransacao(String infoTransacao) {
        List<String> infoTransacaoSeparadoPorVirgula = MapeadorValores.separaInfoPorVirgula(infoTransacao);
        return MapeadorMensagemParaDadosTransacao.mapeiaTransacao(infoTransacaoSeparadoPorVirgula);
    }
}
