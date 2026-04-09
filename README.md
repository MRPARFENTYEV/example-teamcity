# Домашнее задание TeamCity

## Ссылка на репозиторий
https://github.com/MRPARFENTYEV/example-teamcity

## Выполненные задачи

### 1. Миграция build configuration в репозиторий
- Создан файл `.teamcity/settings.kts` с конфигурацией сборки
- Конфигурация включает:
  - VCS root и ветки
  - Два Maven шага (для master и остальных веток)
  - VCS trigger
  - Performance monitor feature
  - Артефакты: `target/*.jar → artifacts/`

### 2. Работа с веткой feature/add_reply
- Создана ветка `feature/add_reply`
- Добавлен новый метод `sayHunterReply()` в класс `Welcomer`
- Метод возвращает произвольную реплику, содержащую слово "hunter"

### 3. Тестирование
- Добавлен тест `welcomerSaysHunterReplyContainsWordHunter()`
- Тест проверяет наличие слова "hunter" в реплике

### 4. Merge в master
- Изменения из ветки `feature/add_reply` вмержены в `master`

### 5. Артефакты сборки
- Настроен сбор артефактов: `target/*.jar` → `artifacts/`
- При сборке master создаётся `.jar` файл

### 6. Проверка конфигурации
- Конфигурация в репозитории (.teamcity/settings.kts) содержит все настройки из TeamCity UI

## Файлы изменённые/добавленные

| Файл | Изменение |
|------|-----------|
| `.teamcity/settings.kts` | Добавлен |
| `src/main/java/plaindoll/Welcomer.java` | Добавлен метод `sayHunterReply()` |
| `src/test/java/plaindoll/WelcomerTest.java` | Добавлен тест `welcomerSaysHunterReplyContainsWordHunter()` |

## Код изменений

### Welcomer.java (новый метод)
```java
public String sayHunterReply() {
    List<String> replies = Arrays.asList(
        "The hunter is always watching",
        "Every hunter needs a prey",
        "Hunter's instinct never fails",
        "The night hunter awakens",
        "A true hunter never rests",
        "The hunter becomes the hunted",
        "Hunter's moon is rising"
    );
    return replies.get(new Random().nextInt(replies.size()));
}
