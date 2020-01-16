package br.com.arezzoco.samples.dto;

import br.com.arezzoco.samples.domain.Adquirente;
import br.com.arezzoco.samples.domain.FormaPagamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class PagamentoDTO implements Serializable {

    private static final long serialVersionUID = 8612443543182045685L;

    private final BigDecimal valorPago;
    private final Calendar dataPagamento;
    private final FormaPagamento formaPagamento;
    private final Adquirente adquirente;
    private final List<CarneDTO> carnes;
    private final List<FaturaDTO> faturas;

    public PagamentoDTO(final BigDecimal valorPago, final Calendar dataPagamento, final FormaPagamento formaPagamento,
                        final Adquirente adquirente, final List<CarneDTO> carnes, final List<FaturaDTO> faturas) {
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.adquirente = adquirente;
        this.carnes = carnes;
        this.faturas = faturas;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public Adquirente getAdquirente() {
        return adquirente;
    }

    public List<CarneDTO> getCarnes() {
        return carnes;
    }

    public List<FaturaDTO> getFaturas() {
        return faturas;
    }

}
