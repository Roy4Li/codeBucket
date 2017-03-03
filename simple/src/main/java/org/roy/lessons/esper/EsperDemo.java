package org.roy.lessons.esper;

import com.espertech.esper.client.*;

/**
 * Created by lilei on 2017/3/3.
 */
public class EsperDemo {
    /**
     * 示例类
     */
    public static class HelloSper {
        private String message;
        public HelloSper(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 事件监听器
     */
    public static class HelloSperListener implements UpdateListener{
        @Override
        public void update(EventBean[] eventBeans, EventBean[] eventBeans1) {
            if (eventBeans != null) {
                String str = (String) eventBeans[0].get("message");
                System.out.println("我的第一个Esper示例程序：" + str);
                System.out.println(eventBeans[0].getUnderlying());
            }
        }
    }

    public static void main(String[] args) {
        EPServiceProvider epServiceProvider = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator epAdministrator = epServiceProvider.getEPAdministrator();
        String epl = "select message from " + HelloSper.class.getName();
        EPStatement statement = epAdministrator.createEPL(epl);
        statement.addListener(new HelloSperListener());
        EPRuntime epRuntime = epServiceProvider.getEPRuntime();
        epRuntime.sendEvent(new HelloSper("hello world"));
    }

}
