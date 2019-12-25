package br.com.arezzoco.samples.web;

import br.com.arezzoco.samples.dto.CalcularTesourariaRequest;
import br.com.arezzoco.samples.dto.CalcularTesourariaResponse;
import br.com.arezzoco.samples.service.CalculaTesourariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tesouraria")
public class TesourariaController {

    @Autowired
    private CalculaTesourariaService calculaTesourariaService;

    @RequestMapping(method = RequestMethod.POST, value = "/calcular")
    public CalcularTesourariaResponse calcular(@RequestBody final CalcularTesourariaRequest request) {
        return calculaTesourariaService.calcular(request);
    }

}
