<!-- ABOUT THE PROJECT -->
## Сервис сокращения ссылок (консольное приложение)
Это приложение, которое позволяет пользователям сокращать URL-адреса, управлять сессиями и сохранять историю сокращенных ссылок. Оно включает в себя репозиторий для хранения и управления сокращенными URL-адресами и пользователями.

Дополнительные функции сервиса:
* Лимит переходов (ограничение количества кликов по ссылке);
* Время жизни (срок действия ссылки);
* Уведомления (оповещения при недоступности ссылки);
* Работа нескольких пользователей (идентификация по UUID);
* Переход по короткой ссылке через браузер.

### Возможности приложения

* Создать новую сессию
* Войти в сессию
* Создать короткую ссылку по оригинальной
* Получить оригинальную ссылку по короткой
* Изменить параметры короткой ссылки
* Удалить короткую ссылку
* Выйти из сессии или приложения

## Зависимости

Этот проект опирается на стандартные библиотеки Java, включая java.util, java.security и java.util.logging. Для его корректной работы необходимо убедиться, что у вас установлена последняя версия Java Development Kit (JDK).

### Пример сценария работы

1. Стартовое меню
```
1. Создать новую сессию
2. Войти в сессию
3. Выйти из приложения

Введите число:
```
2. Главное меню после создания сессии:
```
1. Создать короткую ссылку по основной
2. Получить основную ссылку по короткой
3. Изменить параметры короткой ссылки
4. Удалить короткую ссылку
5. Выйти из сессии

Введите число:
```
3. Создание короткой ссылки
```
Введите основную ссылку: https://github.com/RommyGoose/ShortLink
Введите лимит переходов: 50
Введите срок действия в часах: 24
Короткая ссылка: http://short.url/jb1txZV
```
4. Изменение параметров короткой ссылки
```
Введите короткую ссылку: http://short.url/jb1txZV
Введите новый лимит переходов: 45
Лимит обновлен.
```



