#language: ru

  @smoke
  Функционал: Корзина

    @test_id_123
    Сценарий: Проверка добавления продуктов в корзину
      * Закрытие сообщение cookies
      * Поиск продуктов с названием "playstation"
      * Выбор продукта с названием "PlayStation 5 Slim"
      * Добавляем продукт в корзину
      * Добавляем продукту услугу "Продления гарантии"
      * Добавляем к услуге срок действия "+2 года"
      * Поиск продуктов с названием "телевизор xiaomi"
      * Выбор продукта с названием "50" Телевизор Xiaomi Mi TV A2, 4K Ultra HD"
      * Добавляем продукт в корзину
      * Проверяем соответствие суммы корзины и суммы товаров
      * Проверяем что у "PlayStation 5 Slim" в услуге выбран срок "+2 года"





