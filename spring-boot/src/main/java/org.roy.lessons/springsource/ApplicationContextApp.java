package org.roy.lessons.springsource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by lilei on 2016/10/14.
 */
public class ApplicationContextApp {
    String configLocation = "";
    ApplicationContext ctx = new FileSystemXmlApplicationContext(configLocation);
}
