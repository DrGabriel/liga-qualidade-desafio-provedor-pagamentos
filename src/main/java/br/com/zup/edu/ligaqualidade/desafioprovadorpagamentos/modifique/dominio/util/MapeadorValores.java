package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes.ConstantesIndicesPosicaoMensagem;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MapeadorValores {

    public static BigDecimal mapeiaValorStringParaBigDecimal(String valor){
        return new BigDecimal(valor);
    }
    public static List<String> separaInfoPorVirgula(String infoTransacao) {
        return Arrays.asList(infoTransacao.split("\\s*,\\s*"));
    }



}
