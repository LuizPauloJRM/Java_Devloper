package br.com.sistemaerplite.financeiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define esta classe como um controlador REST, onde os métodos retornam dados
 * (geralmente JSON ou XML) diretamente no corpo da resposta HTTP.
 * A anotação @RestController combina @Controller e @ResponseBody.
 */
@RestController
/**
 * Mapeia as requisições HTTP para este controlador. O valor "/primeira"
 * indica que todos os endpoints dentro desta classe terão este prefixo.
 * Por exemplo: /primeira/get.
 */
@RequestMapping("/primeira")
public class InitController {

    /**
     * http://localhost:8080/primeira/get
     * Stateless: o servidor não mantém o estado do cliente entre requisições.
     * Cada requisição é independente e contém todas as informações necessárias.
     * (A anotação @RequestMapping é o lugar para o mapeamento, não o @RestController).
     *
     * Statefull: o servidor mantém o estado do cliente entre requisições,
     * como em uma sessão.
     *
     * Para esta aplicação, estamos usando um modelo REST, que é stateless.
     */

    /**
     * Mapeia requisições HTTP do tipo GET para o método. O caminho "/get"
     * é combinado com o caminho da classe ("/primeira"), resultando na URL
     * completa: /primeira/get.
     *
     * @return Uma string que será retornada no corpo da resposta HTTP.
     */
    @GetMapping("/get")
    public String primeiraRequisicao() {
        // Retorna uma mensagem de sucesso como o conteúdo da resposta.
        return "Primeira requisição GET concluída com sucesso!";
    }
}
