package it.univaq.disim.mobile.unievent.business.web;

import it.univaq.disim.mobile.unievent.business.domain.Session;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import it.univaq.disim.mobile.unievent.business.impl.FitWomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FitWomanService fitWomanService;

    @PostMapping("/login")
    public Response login(@RequestBody Utente u) {
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());
        Session session = fitWomanService.login(u.getUsername(), u.getPassword());
        if (session != null) {
            Response<Login> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            Login login = new Login();
            login.setToken(session.getToken());
            login.setUsername(session.getUser().getUsername());
            login.setFirstname(session.getUser().getNome());
            login.setLastname(session.getUser().getCognome());
            login.setEmail(session.getUser().getEmail());
            result.setData(login);
            return result;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @GetMapping("/logout/{token}")
    public Response logout(@PathVariable String token) {
        fitWomanService.logout(token);
        return Response.DEFAULT_RESPONSE_OK;
    }

    @PostMapping("/utente")
    public Response createUser(@RequestBody Utente user) {
        boolean result = fitWomanService.createUtente(user);
        Response<Object> response = new Response<>();
        response.setResult(result);
        if (result) {
            response.setMessage("Ok");
        } else {
            response.setMessage("L'utente già esiste!");
        }
        return response;
    }

    @GetMapping("/utente/{token}/{Id}")
    public Response getUtente (@PathVariable(value = "token") String token, @PathVariable(value = "Id") Long Id){
        Utente utente = fitWomanService.findUtenteById(token, Id);
        Response<Utente> response = new Response<>(true, "utenteById");
        response.setData(utente);
        return response;
    }

    @PutMapping("/utente/{token}/{Id}")
    public Response updateUtente (@PathVariable(value = "token") String token, @PathVariable(value = "Id") Long Id, @RequestBody Utente utente){
        utente.setId(Id);
        Utente newUtente = fitWomanService.updateUtente(token, utente);
        Response<Utente> response = new Response<>(true, "updateUtente");
        response.setData(utente);
        return response;
    }

}
