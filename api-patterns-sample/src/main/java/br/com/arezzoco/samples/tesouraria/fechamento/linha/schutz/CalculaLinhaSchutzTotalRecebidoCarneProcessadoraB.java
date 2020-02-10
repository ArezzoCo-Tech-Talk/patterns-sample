package br.com.arezzoco.samples.tesouraria.fechamento.linha.schutz;

import br.com.arezzoco.samples.domain.Processadora;
import br.com.arezzoco.samples.dto.CarneDTO;
import br.com.arezzoco.samples.dto.PagamentoDTO;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaSchutz;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CalculaLinhaSchutzTotalRecebidoCarneProcessadoraB implements CalculaLinhaSchutz {

    @Override
    public String getCodigo() {
        return "S49";
    }

    @Override
    public BigDecimal calculaValorLinha(List<PagamentoDTO> pagamentos) {
        return Optional
                .ofNullable(pagamentos)
                .orElseGet(ArrayList::new)
                .stream()
                .flatMap(p -> p.getCarnes().stream())
                .filter(c -> c.getProcessadora() == Processadora.PROCESSADORA_B)
                .map(CarneDTO::getValorPago)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
