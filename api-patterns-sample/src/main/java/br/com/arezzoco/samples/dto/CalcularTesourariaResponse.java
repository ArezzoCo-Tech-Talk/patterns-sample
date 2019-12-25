package br.com.arezzoco.samples.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalcularTesourariaResponse implements Serializable {

    private static final long serialVersionUID = 8342576954710454248L;

    private final Map<String, BigDecimal> linhas;

    public CalcularTesourariaResponse() {
        this.linhas = new HashMap<>();
    }

    public Map<String, BigDecimal> getLinhas() {
        return this.linhas;
    }

}
