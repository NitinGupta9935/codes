## Rest Client

### Limitation of RestTemplate
* In RestTemplate, there are already so many overloaded methods, so its hard to remember and maintain. 
* RestTemplate was build before concepts like Retry, circuit breaker etc.. So adding support means more overloaded methods and not user friendly. 
* RestTemplate is in Maintenance mode - means no new feature, only bug fixes. 