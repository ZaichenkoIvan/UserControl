
#UserControlService
##Description:
Необходимо разработать веб-приложение, позволяющее управлять пользователями 
(создавать, редактировать, просматривать список и детали, удалять)

###Функциональные требования к веб-приложению:

Наличие RESTful интерфейса;
Поддержка операций управления (создания, чтения, редактирования и удаления) пользователями.
Пользователь определяется следующими значениями:
Имя
Фамилия
Дата рождения
Логин
Пароль
Поле ввода “О себе”
Адрес проживания
Наличие пользовательского WEB-интерфейса

###Нефункциональные требования:

JEE стек технологий
Фреймворки, библиотеки: Hibernate, Spring
Система хранения данных: PostgreSQL
Код приложения необходимо снабдить комментариями
Приложение должно собираться при помощи maven без установки или настройки каких либо дополнительных компонент;
Архив с результатом тестового задания должен содержать текстовый файл readme.txt с инструкцией по сборке, настройке, конфигурированию и развертыванию приложения (если необходимо).

###Бонусное задание:
Покрыть функционал тестами используя JUnit, Mockito


##You should install to launch the project:
-JDK 8

-PostgreSQl v12

-Intellij Idea, last version

##Installation instructions:
-Clone or download project from GitHub

-change in "UserControl/src/main/resources/application.properties" spring.jpa.hibernate.ddl-auto=create

-create database

-return to spring.jpa.hibernate.ddl-auto=update

-build project with test use command "mvn clean install" 

-start server with command "mvn spring-boot:run", launch your web browser, navigate to application URL

##In this application there are two controllers.They are annotated @Controller and @RestController respectively.
To work with @Controller you need to use: "http://localhost:8080/user"
To work with @RestController you need to use: "http://localhost:8080/user/rest"
