package br.com.arezzoco.samples.tesouraria.fechamento.linha;

import br.com.arezzoco.samples.dto.PagamentoDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CalculaLinhaTotalRecebidoCarneProcessadoraB implements CalculaLinha {

    @Override
    public String getCodigo() {
        return "R49";
    }

    @Override
    public BigDecimal calculaValorLinha(List<PagamentoDTO> pagamentos) {
        return Optional
                .ofNullable(pagamentos)
                .orElseGet(ArrayList::new)
                .stream()
                .flatMap(p -> p.getCarnes().stream())
                .filter(c -> c.getProcessadora().equals("PROCESSADORA_B"))
                .map(c -> c.getValorPago())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}