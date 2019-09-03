package com.alevel;

import com.alevel.dataprovider.GeneralDataProvider;
import com.alevel.entity.SearchResultItem;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends TestBase {

    @Test(dataProviderClass = GeneralDataProvider.class, dataProvider = "provide",
            description = "Check search is working on the main page")
    public void checkSearchResultsPO(String searchText) {
        List<SearchResultItem> searchResults = new MainPage(driver)
                .inputSearchText(searchText)
                .startSearch()
                .getSearchResults();

        for (SearchResultItem result : searchResults) {
            Assert.assertTrue(result.containsInfo(searchText),
                    "Search result doesn't contain text '" + searchText + "'\n" +
                            "Found search result:\n" + result);
        }
    }
}
