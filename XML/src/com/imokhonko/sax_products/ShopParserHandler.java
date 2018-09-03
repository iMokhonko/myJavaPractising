package com.imokhonko.sax_products;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class ShopParserHandler extends DefaultHandler {

    // nodes in root node
    private static final String NAME_NODE = "name";
    private static final String SHOP_LOCATION_NODE = "location";
    private static final String SHOP_WEBSITE_NODE = "website";

    // nodes for products items
    private static final String PRODUCT_NODE = "product";
    private static final String PRODUCT_CATEGORY_NODE = "category";
    private static final String PRODUCT_DESCRIPTION_NODE = "description";
    private static final String PRODUCT_PRICE_NODE = "price";
    private static final String PRODUCT_PRICE_CURRENCY_NODE = "currency";

    // current product objects
    private Product currentProduct = null;
    private Category currentCategory = null;
    private Price currentPrice = null;

    // current node and flag for the NAME_NODE
    String currentNode;
    boolean inProduct = false;

    // information about shop
    private String shopName;
    private String shopLocation;
    private String shopWebsite;

    // this is used instead of setters in class
    private String currentProductName = "";
    private Category currentProductCategory = null;
    private String currentProductDescription = "";
    private Price currentProductPrice = null;
    private String currentProductPriceCurrency = "";

    List<Product> products;

    public ShopParserHandler(List<Product> products) {
        this.products = products;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentNode = qName;

        switch (currentNode) {
            case PRODUCT_NODE: {
                inProduct = true;
            } break;

            case PRODUCT_PRICE_NODE: {
                currentProductPriceCurrency = attributes.getValue(PRODUCT_PRICE_CURRENCY_NODE);
            } break;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length).trim();

        if(text.length() == 0)
            return;

        switch (currentNode) {
            case NAME_NODE: {
                if(inProduct == false)
                    this.shopName = text;
                else
                    this.currentProductName = text;
            } break;

            case SHOP_LOCATION_NODE: {
                this.shopLocation = text;
            } break;

            case SHOP_WEBSITE_NODE: {
                this.shopWebsite = text;
            } break;

            case PRODUCT_CATEGORY_NODE: {
                this.currentProductCategory = new Category(text);
            } break;

            case PRODUCT_DESCRIPTION_NODE: {
                this.currentProductDescription = text;
            } break;

            case PRODUCT_PRICE_NODE: {
                this.currentProductPrice =
                        new Price(Float.valueOf(text),
                                currentProductPriceCurrency);
            } break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case PRODUCT_NODE: {
                currentProduct = new Product(currentProductName,
                        currentProductCategory,
                        currentProductDescription,
                        currentProductPrice);
                products.add(currentProduct);
                currentProduct = null;
                inProduct = false;
                break;
            }
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Shop name: " + getShopName());
        System.out.println("Shop location: " + getShopLocation());
        System.out.println("Shop website: " + getShopWebsite());
    }


    public String getShopName() {
        return shopName;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public String getShopWebsite() {
        return shopWebsite;
    }

    @Override
    public String toString() {
        return "ShopParserHandler{" +
                "currentProduct=" + currentProduct +
                ", currentCategory=" + currentCategory +
                ", currentPrice=" + currentPrice +
                ", currentNode='" + currentNode + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopLocation='" + shopLocation + '\'' +
                ", shopWebsite='" + shopWebsite + '\'' +
                '}';
    }
}
