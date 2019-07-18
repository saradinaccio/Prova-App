package it.univaq.disim.mobile.unievent.business.web;

import it.univaq.disim.mobile.unievent.business.domain.Routine;
import it.univaq.disim.mobile.unievent.business.impl.FitWomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
public class RESTRoutineController {

    @Autowired
    private FitWomanService service;

    @GetMapping("/{token}/tipo/{tipo}")
    public Response getRoutineByTipo(@PathVariable(value = "token") String token, @PathVariable int tipo) {
        List<Routine> routines = service.getRoutineByTipo(token, tipo);

        if (routines != null) {
            Response<Object> response = new Response<>(true, "getRoutineByTipo");
            response.setData(routines);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
}