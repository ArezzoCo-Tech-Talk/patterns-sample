package br.com.arezzoco.samples.tesouraria.fechamento.linha.arezzo;

import br.com.arezzoco.samples.domain.Adquirente;
import br.com.arezzoco.samples.dto.PagamentoDTO;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaArezzo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CalculaLinhaArezzoTotalRecebidoBanrisul implements CalculaLinhaArezzo {

    @Override
    public String getCodigo() {
        return "A62";
    }

    @Override
    public BigDecimal calculaValorLinha(List<PagamentoDTO> pagamentos) {
        return Optional
                .ofNullable(pagamentos)
                .orElseGet(ArrayList::new)
                .stream()
                .filter(p -> p.getAdquirente() == Adquirente.BANRISUL)
                .map(PagamentoDTO::getValorPago)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
