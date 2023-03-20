package Beudicri.RestFulEx.controller;

import jakarta.annotation.PostConstruct;
import Beudicri.RestFulEx.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "홍길동1", "111-1111", "천안시 서북구1"));
        userMap.put("2", new UserProfile("2", "홍길동2", "111-1112", "천안시 서북구2"));
        userMap.put("3", new UserProfile("3", "홍길동3", "111-1113", "천안시 서북구3"));
    }

    @GetMapping("/user/{id}") //여기서 {id}를 @PathVariable의 id로 인식하여 api호출
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return userMap.get(id); //JSON형식으로 자동으로 리턴
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList(){
        return new ArrayList<UserProfile>(userMap.values());
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@RequestParam("id") String id,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone,
                               @RequestParam("address") String address){
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);

    }

}
