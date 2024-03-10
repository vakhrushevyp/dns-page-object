package ru.ibs.framework.steps;

import io.cucumber.java.en.And;

public class BasketPageSteps extends BasePageSteps {

   @And("^Добавляем продукту услугу \"(.+)\"$")
   public void addServiceItem(String text){
       pageManager.getBasketPage().addServiceItem(text);

   }
   @And("^Добавляем к услуге срок действия \"(.+)\"$")
   public void setServiceItemYear(String text){
        pageManager.getBasketPage().setServiceItemYear(text);
   }

    @And("^Проверяем соответствие суммы корзины и суммы товаров$")
    public void checkTotalPrice(){
        pageManager.getBasketPage().checkTotalPrice();
    }
    @And("^Проверяем что у \"(.+)\" в услуге выбран срок \"(.+)\"$")
    public void checkServiceItemYear(String productName, String year){
        pageManager.getBasketPage().checkServiceItemYear(productName, year);
    }



}
