package br.com.arezzoco.samples.tesouraria.fechamento.linha;

import br.com.arezzoco.samples.dto.PagamentoDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CalculaLinha {

    String getCodigo();

    BigDecimal calculaValorLinha(final List<PagamentoDTO> pagamentos);

}
