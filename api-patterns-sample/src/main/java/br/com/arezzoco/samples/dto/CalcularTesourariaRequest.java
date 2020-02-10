package br.com.arezzoco.samples.dto;

import br.com.arezzoco.samples.domain.Site;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CalcularTesourariaRequest implements Serializable {

    private static final long serialVersionUID = 8749362194416628261L;

    private final List<PagamentoDTO> pagamentos;
    private final Site site;

    public CalcularTesourariaRequest(final List<PagamentoDTO> pagamentos, final Site site) {
        this.pagamentos = pagamentos;
        this.site = site;
    }

    public List<PagamentoDTO> getPagamentos() {
        return this.pagamentos;
    }

    public Site getSite() {
        return site;
    }
}
