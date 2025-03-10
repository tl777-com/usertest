package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
//    List<User> users=new ArrayList<>();
//    public UserController() {
//        users.add(new User(1,"tl",18));
//        users.add(new User(2,"wd",18));
//        users.add(new User(3,"xy",18));
//    }
//    @GetMapping("/users")
//    public List<User> getAllUser(){
//
//        return users;
//    }
//    @PostMapping("/users")
//    public User createUser(@RequestBody User user){
//        user.setId((users.size()+1));
//        users.add(user);
//        return user;
//    }
//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable Integer id,@RequestBody User updateUser){
//        // 使用流操作查找匹配 id 的用户
//        Optional<User> optionalUser = users.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst();
//
//        if (optionalUser.isPresent()) {
//            User existUser = optionalUser.get();
//            // 更新用户信息
//            existUser.setName(updateUser.getName());
//            existUser.setAge(updateUser.getAge());
//            return existUser;
//        }
//        return null; // 如果未找到匹配的用户，返回 null
//        /*@PathVariable Integer id：从请求路径中获取用户的 id。
//@RequestBody User updateUser：从请求体中获取更新后的用户信息。
//使用 stream() 方法将 users 列表转换为流，然后使用 filter() 方法过滤出 id 匹配的用户，最后使用 findFirst() 方法获取第一个匹配的用户。
//如果找到了匹配的用户，使用 Optional 的 isPresent() 方法判断是否存在，若存在则更新用户的 name 和 age 信息，并返回更新后的用户对象。
//如果未找到匹配的用户，返回 null。*/
//
//
//    }
//    @DeleteMapping("/users/{id}")
//    public String deleteUser(@PathVariable Integer id){
//        boolean remove=users.removeIf(user -> user.getId()==id);
//        if(!remove){
//            return "不存在的用户ID"+id;
//
//        }
//        return "用户ID【"+ id +"】已删除";
//    }

    @Autowired
    UserMapper userMapper;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userMapper.selectList(null);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userMapper.selectById(id);

    }
    @PostMapping("/users")
    public int createUser(@RequestBody User user){
        return userMapper.insert(user);
    }

//    public User createUser(User user){
//        userMapper.insert(user);
//        return user;
//    }

    @PutMapping("/users")
    public Integer updateUser(@RequestBody User updateUser){

        return userMapper.updateById(updateUser);
    }

    @DeleteMapping("/users/{id}")
    public Integer deleteUser(@PathVariable int id){
        System.out.println("");
        return userMapper.deleteById(id);
    }

}





