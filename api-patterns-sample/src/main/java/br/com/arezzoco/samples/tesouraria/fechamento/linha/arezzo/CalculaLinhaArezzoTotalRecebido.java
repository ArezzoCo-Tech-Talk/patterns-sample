package br.com.arezzoco.samples.tesouraria.fechamento.linha.arezzo;

import br.com.arezzoco.samples.dto.PagamentoDTO;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaArezzo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CalculaLinhaArezzoTotalRecebido implements CalculaLinhaArezzo {

    @Override
    public String getCodigo() {
        return "A38";
    }

    @Override
    public BigDecimal calculaValorLinha(List<PagamentoDTO> pagamentos) {
        return Optional
                .ofNullable(pagamentos)
                .orElseGet(ArrayList::new)
                .stream()
                .map(PagamentoDTO::getValorPago)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
