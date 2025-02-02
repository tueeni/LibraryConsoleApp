### Теоретические вопросы

**Объясните основные принципы объектно-ориентированного программирования:**

1. **Наследование:** Позволяет создавать новые классы на основе существующих, способствуя повторному использованию кода и уменьшению дублирования.

2. **Полиморфизм:** Различные объекты могут обладать одинаковым интерфейсом, что упрощает написание и использование кода.

3. **Инкапсуляция:** Сокрытие внутренних деталей реализации объекта и предоставление доступа к ним только через установленные методы, обеспечивая безопасность данных и предотвращая ошибки.

4. **Абстракция:** Выделение общих характеристик объектов для создания более простых моделей, что упрощает их использование.

**Что такое Garbage Collection в Java и как он работает?**

Garbage Collection (GC) автоматически освобождает память, занятую объектами, которые больше не используются приложением. Процесс включает этапы marking, sweeping и compacting.

**Какие различия между ArrayList и LinkedList?**

ArrayList основан на массиве и подходит для быстрого доступа к элементам, в то время как LinkedList использует связи между узлами и предоставляет гибкость при вставке и удалении элементов.

**Что такое ConcurrentHashMap и в чем его преимущества по сравнению с HashMap?**

ConcurrentHashMap предназначен для безопасной работы в многопоточных приложениях, поддерживает параллельный доступ без блокировок на чтение и эффективное управление данными.

**Объясните, что такое JVM, JRE и JDK.**

- **JVM (Java Virtual Machine):** Исполняет байт-код Java и управляет памятью и процессом выполнения программы.
- **JRE (Java Runtime Environment):** Включает в себя JVM и необходимые библиотеки для запуска Java-приложений, но без инструментов разработки.
- **JDK (Java Development Kit):** Включает в себя JRE и инструменты для разработки, такие как компилятор и отладчик Java.

