# 📊 XlsxSwagTest

Сервис на **Java + Spring Boot**, который читает `.xlsx` с целыми числами (один столбец) и возвращает **N-ое минимальное** число.

---

## Требования
- **Java 17+**
- **Maven 3.8+**
- (опционально) **IntelliJ IDEA 2022.3+**

---

## Сборка и запуск

### Вариант A — через Maven (CLI)

1. **Сборка**
   ```bash
   mvn clean package
   ```
   Результат: `target/xlsx-swag-test-1.0.0.jar`

2. **Запуск**
   ```bash
   java -jar target/xlsx-swag-test-1.0.0.jar

---

### Вариант B — через интерфейс IntelliJ IDEA

1. Откройте проект как **Maven Project** (File → Open → выберите папку с `pom.xml`).
2. Запуск:
   - Откройте класс  `@SpringBootApplication` - XslxSwagApplication.
   - Нажмите **Run ▶** (или ПКМ → Run).  
   Остановить можно кнопкой **■ Stop** в IDE.

---

## Swagger / OpenAPI

- Swagger UI: **http://localhost:8080/swagger-ui/index.html**  
---

## Endpoint

`GET /n-min`

**Параметры:**
- `path` — строка, путь к `.xlsx` (первый лист, читается первый столбец)
- `n` — целое, номер искомого минимального

**Пример запроса:**
```
GET http://localhost:8080/n-min?path=C:/Users/you/Desktop/123.xlsx&n=3
```
> На Windows в URL лучше экранировать обратные слэши `\`.

