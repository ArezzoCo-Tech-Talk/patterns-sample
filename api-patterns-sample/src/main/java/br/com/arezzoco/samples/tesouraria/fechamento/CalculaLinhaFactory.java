package br.com.arezzoco.samples.tesouraria.fechamento;

import br.com.arezzoco.samples.domain.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CalculaLinhaFactory {

    @Autowired
    private List<CalculaLinhaPorSite> strategies;

    public CalculaLinhaPorSite get(final Site site) {
        return strategies
                .stream()
                .filter(s -> s.getSiteType().equals(site))
                .findFirst()
                .orElseThrow(() -> new InternalError("Ocorreu um erro calcular linhas"));
    }

}
