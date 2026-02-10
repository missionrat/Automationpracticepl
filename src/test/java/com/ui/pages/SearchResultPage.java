package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentInProductList(String searchTerm) {

		List<String> keyWords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);
		boolean result = productNamesList.stream()
				.anyMatch(name -> (keyWords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;

	}

	public ProductDetailPage clickonProductAtIndex(int index) {
		ClickOn(getAllElements(ALL_PRODUCT_LISTS_NAME).get(index));
		ProductDetailPage productDetailpage = new ProductDetailPage(getDriver());
		return productDetailpage;
	}

}
