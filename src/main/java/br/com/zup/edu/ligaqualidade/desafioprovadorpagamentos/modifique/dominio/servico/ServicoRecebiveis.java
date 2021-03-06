package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.dto.Recebivel;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.fabrica.FabricaRecebivel;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ServicoRecebiveis {

    static List<Recebivel> gerarRecebiveis(List<DadosTransacao> transacoes) {
        return Optional.of(transacoes).orElse(List.of()).stream().map(
                transacao -> FabricaRecebivel.valueOf(transacao.metodo.name())
                        .aplicaRegrasPorTipo(transacao)
        ).collect(Collectors.toList());
    }

}
