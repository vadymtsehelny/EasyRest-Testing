package com.easyrest.facade;

import com.easyrest.components.administrator.AdministratorMenu;
import com.easyrest.components.administrator.OrderAction;
import com.easyrest.pages.AdministratorPage;
import com.easyrest.pages.administratorPanel.AcceptedOrders;
import com.easyrest.pages.administratorPanel.WaitingForConfirmOrders;
import org.openqa.selenium.WebDriver;

public class AdministratorOperationsFacade {
    WebDriver driver;
    AdministratorPage administratorPage;
    OrderAction orderAction;

    public AdministratorOperationsFacade(WebDriver driver) {
        this.driver = driver;
        this.administratorPage = new AdministratorPage(driver);
        this.orderAction = new OrderAction(driver);
    }

    public WaitingForConfirmOrders seeWaitingForConfirmOrders() {
        return goToTabMenu()
                .clickOnWaitingForConfirmOrders();
    }

    public AcceptedOrders seeAcceptedOrders() {
        return goToTabMenu()
                .clickOnAcceptedOrders();
    }

    public void seeAssignedWaitersOrders() {
        goToTabMenu()
                .clickOnAssignedWaiters();
    }

    public void seeWaiters() {
        goToTabMenu()
                .clickOnWaiters();
    }

    public void acceptOrder() {
        seeWaitingForConfirmOrders()
                .getOrder()
                .clickOnExpandOrderDetails();
        orderAction.clickOnAcceptOrder();
    }

    public void assignWaiter() {
        seeAcceptedOrders()
                .getOrder()
                .clickOnExpandOrderDetails();
        orderAction
                .clickOnPickWaiter()
                .clickOnAssignWaiter();
    }

    public void logOut() {
        administratorPage
                .getToolbarMenu()
                .clickOnUserProfileIcon()
                .clickOnLogOutMenuItem();
    }

    public Integer seeWaitingForConfirmOrdersCount() {
        return seeWaitingForConfirmOrders()
                .getOrdersCount();
    }

    public Integer seeAcceptedOrdersCount() {
        return seeAcceptedOrders()
                .getOrdersCount();
    }

    public AdministratorMenu goToTabMenu() {
        return administratorPage
                .getAdministratorTabMenu();
    }

}
