package lesson6;

// Tigashov Valeriy Evgen'evich - Home Work #6.

/*
 * Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
 * Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
 * ^ Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
 */

import java.io.*;
import java.util.Scanner;

public class HW6 {

    public static void main(String[] args) {

        writeFile ("FileWrite-01.txt", "Java[прим. 1] — строго типизированный объектно-ориентированный " +
                "язык программирования общего назначения, разработанный\r\n компанией Sun Microsystems (в последующем " +
                "приобретённой компанией Oracle). Разработка ведётся сообществом, организованным\r\n через Java " +
                "Community Process; язык и основные реализующие его технологии распространяются по лицензии GPL. " +
                "Права на\r\n торговую марку принадлежат корпорации Oracle.");

        writeFile ("FileWrite-02.txt", "Приложения Java обычно транслируются в специальный байт-код, " +
                "поэтому они могут работать на любой компьютерной\r\n архитектуре, для которой существует реализация " +
                "виртуальной Java-машины. Дата официального выпуска — 23 мая 1995\r\n года. Стабильно занимает высокие " +
                "места в рейтингах популярности языков программирования (2-е место в рейтингах\r\n IEEE Spectrum (2020)" +
                "[2] и TIOBE (2021)[3]).");

        String content1 = readFile("FileWrite-01.txt");
        String content2 = readFile("FileWrite-02.txt");

        writeFile("FileWrite-03.txt", content1 + "\r\n"+ content2);

        System.out.print("Search Your Word: ");

        String word = scanner.nextLine();
        if (checkWord("FileWrite-03.txt", word))
            System.out.println("Found result: " + word);
        else
            System.out.println("Word " + word + " not found!");

    }

    private static Scanner scanner = new Scanner(System.in);

    private static boolean checkWord(String nameFile, String word){
        String content = readFile(nameFile);
        return content.contains(word);
    }

    private static void writeFile(String nameFile, String content) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.print(content);
            printStream.flush();
            printStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File Not Found!");
        } catch (IOException ioException) {
            System.out.println("Error: IOException");
        }
    }

    private static String readFile(String nameFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(nameFile);
            long size = fileInputStream.getChannel().size();
            byte[] buffer = new byte[(int)size];
            fileInputStream.read(buffer, 0, (int)size);
            String content = new String(buffer);
            fileInputStream.close();
            return content;

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File Not Found!");
        } catch (IOException ioException) {
            System.out.println("Error: IOException");
        }
        return "";
    }


}
