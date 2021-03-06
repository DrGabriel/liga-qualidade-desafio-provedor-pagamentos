package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes;

public class ConstantesIndicesPosicaoMensagem {

    public static class IndiciesTransacao {
        public static final Integer VALOR = 0;
        public static final Integer METODO_PAGAMENTO = 1;
        public static final Integer NUMERO_CARTAO = 2;
        public static final Integer NOME_CARTAO = 3;
        public static final Integer VALIDADE = 4;
        public static final Integer CCV = 5;
        public static final Integer ID_TRANSACAO = 6;

        private IndiciesTransacao(){}
    }

    public static class IndicesAdiantamento {
        public static final Integer ID_TRANSACAO = 0;
        public static final Integer VALOR_ADIANTAMENTO = 1;

        private IndicesAdiantamento(){}
    }

    private ConstantesIndicesPosicaoMensagem(){}
}
