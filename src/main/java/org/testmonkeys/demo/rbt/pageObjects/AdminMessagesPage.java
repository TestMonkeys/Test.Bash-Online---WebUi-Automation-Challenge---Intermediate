package org.testmonkeys.demo.rbt.pageObjects;

import lombok.Getter;
import org.testmonkeys.demo.rbt.pageObjects.webComponents.MessageDetailsModal;
import org.testmonkeys.demo.rbt.pageObjects.webComponents.MessageRow;
import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.GroupComponent;

@Getter
@PageAccessor(name = "Admin Messages Page", url = "/#/admin/messages")
public class AdminMessagesPage extends AbstractPage {

    @ElementAccessor(elementName = "Messages", byXPath = "//div[@class='messages']//div[contains(@class,'row detail')]")
    private GroupComponent<MessageRow> messageList;

    @ElementAccessor(elementName = "Messages Modal window", byXPath = "//div[@class='ReactModalPortal']")
    private MessageDetailsModal messageDetails;

}
