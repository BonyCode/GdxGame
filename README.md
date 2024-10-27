<h1><b>GdxGame</b></h1>

<div align="center"><i>(Это задание по интеграции новых библиотек и плагинов в проект с использованием Gradle и дженериков. Задание было адаптировано для Gradle вместо Maven, чтобы сохранить совместимость с исходным проектом LibGDX, который обычно собирается с помощью Gradle. Мы добавили необходимые плагины и зависимости, включая Lombok, Checkstyle и maven-publish, что позволило автоматизировать генерацию кода, проверку стиля и публикацию артефактов в Nexus, сохраняя все исходные функции проекта. Помимо этого, реализована система иерархии оружия для героев с параметризацией типов.)</i></div>

<h2>1. Практика по Maven</h2>

<b>Добавление зависимости на библиотеку Lombok:</b>
<i>В файле build.gradle.kts добавлены зависимости на библиотеку Lombok и плагин io.freefair.lombok, которые автоматически генерируют стандартные методы, такие как геттеры, сеттеры и конструкторы.</i>

<b>Подключение плагина Checkstyle:</b>
<i>Добавлен плагин checkstyle и указаны настройки для него (версия, конфигурационный файл), чтобы обеспечить проверку стиля кода в проекте.</i>

<b>Подключение плагина для формирования исполняемого .jar файла:</b>
С помощью плагина application в файле build.gradle.kts указана точка входа, что позволяет собрать исполняемый .jar файл.

<b>Запуск в локальном окружении Nexus и настройка процесса деплоя:</b>
<i>Добавлен плагин maven-publish и настроена публикация в локальный Nexus с указанием репозитория http://localhost:8081/repository/maven-releases/. Это позволяет деплоить собранный .jar в локальный репозиторий.</i>

<h2>2. Практика по Generics</h2>

<b>Создание иерархии оружий:</b>
<i>Реализован интерфейс Weapon с методом getDamage().</i><br>
<i>Созданы классы MeleeWeapon (оружие ближнего боя) и RangedWeapon (оружие дальнего боя), реализующие интерфейс Weapon.</i>

<b>Параметризация классов героев с ограничением типов:</b>
<i>Класс Hero стал абстрактным классом, параметризованным типом &lt;T extends Weapon&gt;.</i><br>
<i>Созданы классы Warrior и Archer, ограниченные типами оружия (ближнего и дальнего боя соответственно).</i><br>
<i>Таким образом, каждый герой параметризован подходящим типом оружия, что делает использование дженериков более безопасным.</i>

<b>Переписывание метода attackEnemy():</b>
<i>Метод attackEnemy() переписан для использования параметризованного типа оружия, и теперь урон, наносимый героем, зависит от показателя урона оружия, которым он экипирован.</i>

    <h1><b>Проект GdxGamee</b></h1>
Проект создавался на основе каркаса, предоставленного незавершенным проектом **GdxGame**, написанным с использованием фреймворка [LibGDX](https://libgdx.com/). Этот каркас включал базовую структуру для 2D-игры с различными модулями и классами, такими как экраны, менеджеры ресурсов, классы персонажей и врагов. Однако ему не хватало некоторых аспектов, таких как конкретная система оружия, более сложные взаимодействия персонажей и средства автоматизированной сборки и проверки.

## Что собой представлял каркас проекта
Изначально проект **GdxGame** имел:

- Базовую структуру экранов и классов для игры (например, экраны выбора персонажа и меню).
- Основные классы для представления персонажей, но без конкретной логики атаки или взаимодействий между ними.
- Простую конфигурацию Gradle для сборки, но без дополнительных плагинов и инструментов для проверки стиля кода, генерации документации и публикации артефактов.

## Какие изменения были внесены и зачем
Добавлено в проект несколько ключевых элементов, чтобы сделать его более функциональным и завершенным.

### Основные изменения

#### Иерархия оружия и дженерики для героев
- Добавлен интерфейс `Weapon` с методом `getDamage()` и созданы классы `MeleeWeapon`, `RangedWeapon`, и `MagicWeapon`, представляющие оружие ближнего, дальнего боя и магическое оружие соответственно.
- При этом использована параметризация классов героев дженериками, чтобы каждый герой мог использовать только определенные типы оружия. Например, `Warrior` теперь использует `MeleeWeapon`, `Archer` — `RangedWeapon`, а `Mage` — `MagicWeapon`.
- Данные изменения добавили гибкости и расширяемости игре, позволив каждому классу персонажа иметь собственное оружие и уникальную логику атаки.

#### Настройка сборки и плагинов Gradle
- Подключены плагины `Lombok` для сокращения кода, `Checkstyle` для проверки соответствия стиля и `maven-publish` для автоматической публикации артефактов в Nexus.
- Эти изменения упростили управление проектом, улучшили читаемость кода и добавили возможности для публикации.

#### Дополнительные улучшения классов игры
- Внесены изменения в `GdxGame.java`, чтобы он демонстрировал работу с новыми героями и их атаками.
- Обновлены классы героев, добавив логику атаки, зависящую от оружия, чтобы повысить взаимодействие и динамику в игре.

## Что этим было достигнуто

- **Полноценная система героев и оружия**: Каждый герой теперь оснащен собственным типом оружия и наносит соответствующий урон.
- **Легкость управления и проверка кода**: Использование `Lombok` сократило шаблонный код, а `Checkstyle` гарантирует, что код соответствует заданным стандартам.
- **Готовность к распространению**: С помощью плагина `maven-publish` можно легко публиковать артефакты, что облегчает управление версиями проекта и развертывание.

## Итоговый вид проекта

Проект теперь представляет собой законченную базовую 2D-игру с:

- Рабочей системой персонажей, каждый из которых имеет собственный класс и тип оружия.
- Поддержкой уникальных атак и анимаций для каждого персонажа.
- Структурой сборки, поддерживающей автоматическую проверку стиля, генерацию документации и публикацию.

Таким образом, проект **GdxGame** теперь является законченным каркасом для создания 2D-игры, на основе которого можно развивать более сложные игровые механики и функции.
