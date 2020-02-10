package br.com.arezzoco.samples.tesouraria.fechamento;

import br.com.arezzoco.samples.domain.Site;
import br.com.arezzoco.samples.dto.PagamentoDTO;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CalculaLinhaStrategy {

    @Autowired
    private CalculaLinhaFactory factory;

    public Map<String, BigDecimal> calcular(final Site sistema, final List<PagamentoDTO> pagamentos) {
        return factory
                .get(sistema)
                .getLinhas()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(CalculaLinha::getCodigo, l -> l.calculaValorLinha(pagamentos)));
    }

}
