package br.com.arezzoco.samples.tesouraria.fechamento.linha.arezzo;

import br.com.arezzoco.samples.domain.Processadora;
import br.com.arezzoco.samples.dto.FaturaDTO;
import br.com.arezzoco.samples.dto.PagamentoDTO;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaArezzo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CalculaLinhaArezzoTotalRecebidoFaturaProcessadoraA implements CalculaLinhaArezzo {

    @Override
    public String getCodigo() {
        return "A28";
    }

    @Override
    public BigDecimal calculaValorLinha(List<PagamentoDTO> pagamentos) {
        return Optional
                .ofNullable(pagamentos)
                .orElseGet(ArrayList::new)
                .stream()
                .flatMap(p -> p.getFaturas().stream())
                .filter(c -> c.getProcessadora() == Processadora.PROCESSADORA_A)
                .map(FaturaDTO::getValorPago)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
