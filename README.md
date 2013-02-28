Ducksboard Java API
===================

About:
------
This is a Java API to send data to custom [Ducksboard](http://ducksboard.com/) widgets. It supports
most of the custom widgets at Ducksboard, and is easily extendable.

It uses [Google GSON](https://code.google.com/p/google-gson/) and
[Apache HTTP client 4](http://hc.apache.org/httpcomponents-client-ga/index.html)
for sending data.

Just new two classes with your API-key from Ducksboard, and you are ready to go.


Example usage:
--------------

```java
// Create a DAO with your API-key
DucksboardDao dao = new DucksboardDao(new DefaultHttpClient(), "api-key");
// Create a service (optionally with a endpoint suffix)
DucksboardService service = new DucksboardService(dao);

// For each widget, insert the ID from you custom widget.
// If the endpoint is https://push.ducksboard.com/v/1234 you ID is 1234
DucksboardId id = service.createId("ducksboard_endpoint");
// Send a value to your widget
service.pushValue(id, 1);
```
