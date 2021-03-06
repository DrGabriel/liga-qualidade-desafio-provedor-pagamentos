package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.constantes;

import java.time.format.DateTimeFormatter;

public class ConstantesFormatoData {

    public static final String FORMATO_DATA_DD_MM_YYYY_COM_BARRA = "dd/mm/yyyy";

    public static final DateTimeFormatter FORMATADOR_PADRAO_DD_MM_YYYY_COM_BARRA = DateTimeFormatter.ofPattern(FORMATO_DATA_DD_MM_YYYY_COM_BARRA);
    private ConstantesFormatoData(){}
}
