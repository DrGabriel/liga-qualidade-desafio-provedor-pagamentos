package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.mapeador.MapeadorMensagemParaDadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.mapeador.MapeadorRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util.MapeadorValores;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ServicoMapeadorRecebimentoAdiantado {

    static List<DadosRecebimentoAdiantado> mapeiaInfoAdiantamentos(List<String> infoRecebimentoAdiantado) {
        return Optional.of(infoRecebimentoAdiantado).orElse(List.of()).stream()
                .map(ServicoMapeadorRecebimentoAdiantado::mapeiaInfoRecebimentoAdiantadoPosicionalParaDadosRecebimentoAdiantado)
                .collect(Collectors.toList());
    }



    private static DadosRecebimentoAdiantado mapeiaInfoRecebimentoAdiantadoPosicionalParaDadosRecebimentoAdiantado(String infoTransacao) {
        List<String> infoTransacaoSeparadoPorVirgula = MapeadorValores.separaInfoPorVirgula(infoTransacao);
        return MapeadorRecebimentoAdiantado.mapeiaInfoAdiantamentoParaRecebimentoAdiantado(infoTransacaoSeparadoPorVirgula);
    }
}
