Ducksboard Java API
===================

Example usage:

```java
DucksboardDao dao = new DucksboardDao(new DefaultHttpClient(), "api-key");
DucksboardService service = new DucksboardService(dao);
DucksboardId id = service.createId("ducksboard_endpoint");

service.pushValue(id, 1);
```