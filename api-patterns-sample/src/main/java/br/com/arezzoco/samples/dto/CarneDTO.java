package br.com.arezzoco.samples.dto;

import br.com.arezzoco.samples.domain.Processadora;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class CarneDTO implements Serializable {

    private static final long serialVersionUID = 240684459637485302L;

    private final BigDecimal valorJuros;
    private final BigDecimal valorDesconto;
    private final BigDecimal valorTotal;
    private final BigDecimal valorPago;
    private final Calendar dataVencimento;
    private final Processadora processadora;

    public CarneDTO(final BigDecimal valorJuros, final BigDecimal valorDesconto, final BigDecimal valorTotal,
                    final BigDecimal valorPago, final Calendar dataVencimento, final Processadora processadora) {
        this.valorJuros = valorJuros;
        this.valorDesconto = valorDesconto;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.dataVencimento = dataVencimento;
        this.processadora = processadora;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public Processadora getProcessadora() {
        return processadora;
    }

}
