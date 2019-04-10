package com.tools.qa.cucumber;

import com.tools.qa.dataproviders.PageObjectManager;
import com.tools.qa.dataproviders.MyWebDriverManager;

public class TestContext {

    private MyWebDriverManager myWebDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext(){
        myWebDriverManager = new MyWebDriverManager();
        pageObjectManager = new PageObjectManager(myWebDriverManager.getDriver());
    }

    public MyWebDriverManager getMyWebDriverManager() {
        return myWebDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}
