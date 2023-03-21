package com.biblioteca.gestionBiblioteca.domain.usecase.utils;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final double FEE_PER_DAY = 1000.0;
}
