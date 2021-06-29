package com.example.familytree.utils;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.assertj.core.util.Files;

/**
 * Класс предназначен для упрощения доступа к ресурсным файлам проекта.
 */
public class TestResources {

    /**
     * Корневой путь проекта.
     */
    public static final Path PROJECT_ROOT = Paths.get(System.getProperty("user.dir"));

    /**
     * Путь до дирректории с тестовыми ресурсами.
     */
    public static final Path MESSAGES = PROJECT_ROOT.resolve("src/test/resources/msg");

    public static String get(String path) {
        File file = MESSAGES.resolve(path).toFile();
        return Files.contentOf(file, UTF_8);
    }

}
