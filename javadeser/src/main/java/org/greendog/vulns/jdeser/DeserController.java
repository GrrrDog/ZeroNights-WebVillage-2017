package org.greendog.vulns.jdeser;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.Base64;
import java.util.Random;

@Controller
public class DeserController {

    @RequestMapping("/")
    @ResponseBody
    public String home(@RequestParam(value = "name", defaultValue = "guest", required = false) String name) throws IOException {
        Random rand = new Random();
        int id = rand.nextInt();

        User webUser = new User(id, name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(webUser);
        oos.close();
        String webUserOISB64 = Base64.getEncoder().encodeToString(baos.toByteArray());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);

        String webUserJackson = objectMapper.writeValueAsString(webUser);
        String webUserJacksonB64 = Base64.getEncoder().encodeToString(webUserJackson.getBytes("utf-8"));
        return String.format("<a href='/?name=test'>set your name</a></br><a href='ois?sess=%s'>look at yourself</a></br><a href='jackson?sess=%s'>look at yourself</a>", webUserOISB64, webUserJacksonB64);
    }

    @RequestMapping("/ois")
    @ResponseBody
    public String ios(@RequestParam(value = "sess") String session) throws IOException, ClassNotFoundException {

        byte[] byteSession = Base64.getDecoder().decode(session);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteSession));
        User web_user = (User) ois.readObject();
        ois.close();

        return "Hello " + web_user;
    }


    @RequestMapping("/jackson")
    @ResponseBody
    public String jackson(@RequestParam(value = "sess") String session) throws IOException, ClassNotFoundException {

        String webUserJackson = new String(Base64.getDecoder().decode(session), "utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();
        User webUser = (User) objectMapper.readValue(webUserJackson, Object.class);

        return "Hello " + webUser;
    }

    @RequestMapping("/spel")
    @ResponseBody
    public String spel(@RequestParam(value = "id", required = false) Integer id) throws IOException {

        return "Your id: " + id;
    }

}
