package br.com.arezzoco.samples.tesouraria.fechamento.linha.vans;

import br.com.arezzoco.samples.dto.CarneDTO;
import br.com.arezzoco.samples.dto.PagamentoDTO;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaVans;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CalculaLinhaVansTotalRecebidoCarneJuros implements CalculaLinhaVans {

    @Override
    public String getCodigo() {
        return "V91";
    }

    @Override
    public BigDecimal calculaValorLinha(List<PagamentoDTO> pagamentos) {
        return Optional
                .ofNullable(pagamentos)
                .orElseGet(ArrayList::new)
                .stream()
                .flatMap(p -> p.getCarnes().stream())
                .map(CarneDTO::getValorJuros)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
