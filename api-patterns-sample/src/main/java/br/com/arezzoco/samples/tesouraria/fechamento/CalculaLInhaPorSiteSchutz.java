package br.com.arezzoco.samples.tesouraria.fechamento;

import br.com.arezzoco.samples.domain.Site;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinha;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaArezzo;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhaSchutz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class CalculaLInhaPorSiteSchutz implements CalculaLinhaPorSite {

    @Autowired
    private List<CalculaLinhaSchutz> linhas;

    @Override
    public List<CalculaLinha> getLinhas() {
        return new ArrayList<>(linhas);
    }

    @Override
    public Site getSiteType() {
        return Site.SCHUTZ;
    }

}
