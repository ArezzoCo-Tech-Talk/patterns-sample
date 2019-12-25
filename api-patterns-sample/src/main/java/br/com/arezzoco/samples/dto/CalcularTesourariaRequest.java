package br.com.arezzoco.samples.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CalcularTesourariaRequest implements Serializable {

    private static final long serialVersionUID = 8749362194416628261L;

    private final List<PagamentoDTO> pagamentos;

    public CalcularTesourariaRequest(final List<PagamentoDTO> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public CalcularTesourariaRequest() {
        this.pagamentos = new ArrayList<>();
    }

    public List<PagamentoDTO> getPagamentos() {
        return this.pagamentos;
    }

}
