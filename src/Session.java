import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Управление пользовательскими сеансами и взаимодействиями.
 */
public class Session {

    public static void run(String userId, Scanner scanner, ShortLink shortLink) {
        boolean sessionActive = true;
        while (sessionActive) {
            System.out.println("""
                  1. Создать короткую ссылку по основной
                  2. Получить основную ссылку по короткой
                  3. Изменить параметры короткой ссылки
                  4. Удалить короткую ссылку
                  5. Выйти из сессии
                  
                  Введите число:""");
            String userInput = scanner.next();
            switch (userInput) {
                case "1":
                    createShortLink(userId, scanner, shortLink);
                    break;
                case "2":
                    retrieveOriginalLink(userId, scanner, shortLink);
                    break;
                case "3":
                    updateLinkParameters(userId, scanner, shortLink);
                    break;
                case "4":
                    deleteShortLink(userId, scanner, shortLink);
                    break;
                case "5":
                    sessionActive = false;
                    break;
                default:
                    System.out.println("Неверная опция. Попробуйте снова.");
            }
        }
    }

    private static void createShortLink(String userId, Scanner scanner, ShortLink shortLink) {
        System.out.print("Введите основную ссылку: ");
        String originalUrl = scanner.next();

        try {
            System.out.print("Введите лимит переходов: ");
            int clickLimit = scanner.nextInt();

            System.out.print("Введите срок действия в часах: ");
            long expiryHours = scanner.nextInt();
            long expiryTimeMs = TimeUnit.HOURS.toMillis(expiryHours);

            String shortUrl = shortLink.encode(originalUrl, userId, clickLimit, expiryTimeMs);
            System.out.println("Короткая ссылка: " + shortUrl);
        } catch (Exception e) {
            System.out.println("Ошибка введен некорректный формат.");
            scanner.nextLine(); // Clear buffer
        }
    }

    private static void retrieveOriginalLink(String userId, Scanner scanner, ShortLink shortLink) {
        System.out.print("Введите короткую ссылку: ");
        String shortUrl = scanner.next();

        ShortUrl urlData = shortLink.decode(userId, shortUrl);
        if (urlData != null) {
            System.out.println("Оригинальная ссылка: " + urlData.getOriginalUrl());
            urlData.incrementClicks();
        }
    }

    private static void updateLinkParameters(String userId, Scanner scanner, ShortLink shortLink) {
        System.out.print("Введите короткую ссылку: ");
        String shortUrl = scanner.next();

        if (shortLink.containsShortUrl(userId, shortUrl)) {
            try {
                System.out.print("Введите новый лимит переходов: ");
                int newClickLimit = scanner.nextInt();

                ShortUrl urlData = shortLink.decode(userId, shortUrl);
                if (urlData != null) {
                    urlData.resetClickThroughLimit(newClickLimit);
                    System.out.println("Лимит обновлен.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка введен некорректный формат.");
                scanner.nextLine(); // Clear buffer
            }
        } else {
            System.out.println("Ссылка не найдена.");
        }
    }

    private static void deleteShortLink(String userId, Scanner scanner, ShortLink shortLink) {
        System.out.print("Введите короткую ссылку для удаления: ");
        String shortUrl = scanner.next();

        boolean deleted = shortLink.deleteLink(userId, shortUrl);
        if (deleted) {
            System.out.println("Ссылка успешно удалена.");
        } else {
            System.out.println("Ссылка не найдена.");
        }
    }
}