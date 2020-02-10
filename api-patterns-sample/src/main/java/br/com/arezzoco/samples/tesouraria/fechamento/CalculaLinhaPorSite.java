package br.com.arezzoco.samples.tesouraria.fechamento;

import br.com.arezzoco.samples.domain.Site;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinha;

import java.util.List;

interface CalculaLinhaPorSite {

    List<CalculaLinha> getLinhas();

    Site getSiteType();

}
