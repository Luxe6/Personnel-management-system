package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.domain.TbUser;
import com.example.service.TbUserService;
import com.example.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private TbUserService userService;
//
//    @PostMapping("/checkLogin")
//    public Result checkLogin(@RequestBody TbUser user){
//        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<TbUser>();
//        wrapper.eq(TbUser::getUsername,user.getUsername());
//        wrapper.eq(TbUser::getPassword,user.getPassword());
//        wrapper.eq(TbUser::getState,1);
//
//        List<TbUser> list = TbUserService.list(wrapper);
//        if(list.size() > 0){
//            return new Result(1,"scuess",list.get(0));
//
//        }
//        return new Result(0,"failed");
//
//    }
//}
public class UserController {

    @Autowired
    private TbUserService userService;

    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody TbUser user) {
        //1、根d查询当前完整的数据
        TbUser u = userService.getById(user.getId());
        //2、判断传递的密码和数据库密码是否一致
        if (u.getPassword().equals(user.getPassword())) {
            //3、如果一致 将新密码替换到user中并更新数据
            u.setPassword(user.getNewPassword());
            userService.updateById(u);
            return new Result(1, "修改成功");
        } else {
            //不一致
            return new Result(0, "原始密码不一致");
        }
    }
    /**
     * 分页快捷查询
     * 分页工具需要两个必要的参数 pageNum当前页数  pageSize每页多少条
     * @return
     */
    // todo 添加快捷查询
    // fixme 待处理
    @GetMapping()
    public Result list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize,
            @RequestParam(value = "username",required = false,defaultValue = "") String username,
            @RequestParam(value = "nikeName",required = false,defaultValue = "") String nikeName
    ){

        PageInfo pageInfo = userService.queryList(pageNum,pageSize,username,nikeName);

        return new Result(1,"success",pageInfo);
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable int id){
        TbUser user = userService.getById(id);

        return new Result(1,"查询成功",user);
    }


    /**
     * 修改用户
     * @param user
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody TbUser user){

        boolean b = userService.updateById(user);
        if(b){
            return new Result(1,"修改用户成功");
        }
        return new Result(0,"修改用户失败");
    }


    /**
     * 用户的增加信息
     * @param user
     * @return boolean
     */
    @PostMapping
    public Result save(@RequestBody TbUser user){

        user.setPassword("123456");

        boolean b = userService.save(user);
        if(b){
            return new Result(1,"增加用户成功");
        }
        return new Result(0,"增加用户失败");
    }

    /**
     * 根据传输的id进行逻辑删除
     * @param id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){

        //定义一个对象
        TbUser user = new TbUser();
        user.setId(id);
        user.setState("2");
        user.setCreateTime(LocalDateTime.now());

        boolean b = userService.updateById(user);
        if(b){
            return new Result(1,"删除用户成功");
        }
        return new Result(0,"删除用户失败");

    }

    /**
     * 用户登录功能
     * @return
     */
    @PostMapping("/checkLogin")
    public Result checkLogin(@RequestBody TbUser user){

        //定义查询条件
        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<>();
        //账号信息
        wrapper.eq(TbUser::getUsername,user.getUsername());
        //密码
        wrapper.eq(TbUser::getPassword,user.getPassword());
        //账号状态
        wrapper.eq(TbUser::getState,1);

        // select * from tb_user where username = ? and password = ? and state = 1

        //说明： username=张三 password=123  查询username值是张三并且密码是123并且状态值为1
        List<TbUser> list = userService.list(wrapper);
        if(list.size() > 0){
            //如果判断当前查询有数据，我们就直接获取第一个数据并且返回给vue前端
            return new Result(1,"登录成功",list.get(0));
        }
        //如果没有数据就直接返回null
        return new Result(0,"账号或密码错误");
    }

}