package com.alevel.web.ui.pages;

import com.alevel.entity.SearchResultItem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    private static final String SEARCH_RES_LINK_XPATH = "//div[@class='gs-title']//a[@class='gs-title']";
    private static final String SEARCH_RES_TEXT_XPATH = "//div[@class='gs-bidi-start-align gs-snippet']";

    @FindBy(xpath = "//div[contains(@class, 'gsc-webResult')]//div[contains(@class, 'gsc-webResult')]")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Receiving search results")
    public List<SearchResultItem> getSearchResults() {
        List<SearchResultItem> items = new ArrayList<>();
        for (WebElement searchResultElement : searchResults){
            SearchResultItem item = getItem(searchResultElement);
            items.add(item);
//            items.add(getItem(searchResultElement));
        }
        return items;
    }

    private SearchResultItem getItem(WebElement searchResultElement){
        SearchResultItem item = new SearchResultItem();
        item.setLinkText(searchResultElement.findElement(By.xpath(SEARCH_RES_LINK_XPATH)).getText());
        item.setText(searchResultElement.findElement(By.xpath(SEARCH_RES_TEXT_XPATH)).getText());
        return item;
    }

}
