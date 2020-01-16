package br.com.arezzoco.samples.dto;

import br.com.arezzoco.samples.domain.Processadora;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class FaturaDTO implements Serializable {

    private static final long serialVersionUID = -3553024259091446693L;

    private final Processadora processadora;
    private final Calendar data;
    private final BigDecimal valor;
    private final BigDecimal valorPago;

    public FaturaDTO(final Processadora processadora, final Calendar data, final BigDecimal valor, final BigDecimal valorPago) {
        this.processadora = processadora;
        this.data = data;
        this.valor = valor;
        this.valorPago = valorPago;
    }

    public Processadora getProcessadora() {
        return processadora;
    }

    public Calendar getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

}
