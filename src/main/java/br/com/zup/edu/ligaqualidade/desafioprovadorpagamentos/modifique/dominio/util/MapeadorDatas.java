package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.dominio.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapeadorDatas {

    public static LocalDate mapeiaDataComoStringParaLocalDate(String dataComoString, DateTimeFormatter formatoData){
        return LocalDate.parse(dataComoString, formatoData);
    }
}
