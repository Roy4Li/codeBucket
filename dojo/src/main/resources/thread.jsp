<%@ page import="java.util.Map" %>
<html>
<head>
    <title>服务器线程信息</title>
</head>
<body>
<h2>Hello World!</h2>
<pre>
    <%
        for(Map.Entry<Thread,StackTraceElement[]> stackTrace:Thread.getAllStackTraces().entrySet()){
            Thread thread = (Thread) stackTrace.getKey();
            StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
            if(thread.equals(Thread.currentThread())){
                continue;
            }
            out.print("\nthread: -- " + thread.getName() + "\n");
            for(StackTraceElement element:stack){
                out.print("\t"+element+"\n");
            }
        }
    %>

</pre>
</body>
</html>
