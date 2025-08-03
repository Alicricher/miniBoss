# Используем базовый образ с Java
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный jar-файл внутрь контейнера
COPY target/miniBoss-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем переменные окружения
ENV JAVA_OPTS=""

# Команда запуска
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
