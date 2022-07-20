# HTML MIME Types
When using the annotation, we will see something like this: <br/>

```java
@PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postContact(@RequestBody MultiValueMap<String, String> form, Model model) {

        Contact c = new Contact();
        c.setName(form.getFirst("name"));
        c.setEmail(form.getFirst("email"));
        c.setPhone(form.getFirst("phone"));

        dbSvc.save(c);

        return "success";
    }
```  
<br/>

The interesting parts of this code is the "MIME" type: <br/>
`application/x-www-form-urlencoded` & `text/html` <br/>

For more information, google "MIME type". <br/>

