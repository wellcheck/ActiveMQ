package br.com.well.testeActiveMq.controller;

import br.com.well.testeActiveMq.util.Status;

public record RegisterDTO(String login, String password, Status status) {
}
