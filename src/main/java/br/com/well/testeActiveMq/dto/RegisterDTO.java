package br.com.well.testeActiveMq.dto;

import br.com.well.testeActiveMq.util.Status;

public record RegisterDTO(String login, String password, Status status) {
}
