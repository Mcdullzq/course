package com.javapandeng.controller;

import com.github.pagehelper.Page;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.ItemCategory;
import com.javapandeng.service.ItemCategoryService;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类目c层
 */
@Controller
@RequestMapping("/itemCategory")
public class ItemCategoryController extends BaseController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    /*
    分页查询类目列表
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model,ItemCategory itemCategory){
        String sql ="select * from item_category where isDelete = 0 and pid is null order by id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategory);
        return "itemCategory/itemCategory";
    }
    /*转向到新增一级分类页面*/
    @RequestMapping("/add")
    public String add(){
        return "itemCategory/add";
    }
//    新增一级分类保存功能
    @RequestMapping("/exAdd")
    public String exAdd(ItemCategory itemCategory){
        itemCategory.setIsDelete(0);
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/findBySql.action";
    }
    //转向修改功能页面
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update";
    }
    //修改一级分类
    @RequestMapping("/exUpdate")
    public String exUpdate(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql.action";
    }
    //删除类目
    @RequestMapping("/delete")
    public String delete(Integer id){
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);

        String sql = "update item_category set isDelete=1 where pid = "+ id;
        itemCategoryService.updateBysql(sql);
        return "redirect:/itemCategory/findBySql.action";
    }
//显示二级类目
    @RequestMapping("findBySql2")
    public String findBySql2(ItemCategory itemCategory,Model model){
        String sql = "select * from item_category where isDelete = 0 and pid =" + itemCategory.getPid()+" order by id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlRerturnEntity(sql);
        model.addAttribute("obj",itemCategory);
        model.addAttribute("pagers",pagers);
        return "itemCategory/itemCategory2";
    }
//新增二级类目
    @RequestMapping("/add2")
    public String add2(int pid ,Model model ){
        model.addAttribute("pid",pid);
        return "itemCategory/add2";
    }

    //    新增二级类目保存功能
    @RequestMapping("/exAdd2")
    public String exAdd2(ItemCategory itemCategory){
        itemCategory.setIsDelete(0);
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
    }
    //    转向修改二级类目页面
    @RequestMapping("/update2")
    public String update2(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update2";
    }
    //    修改二级类目页面
    @RequestMapping("/exUpdate2")
    public String exUpdate2(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
    }
    @RequestMapping("/delete2")
    public String delete2(Integer id,Integer pid){
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        return "redirect:/itemCategory/findBySql2.action?pid="+pid;
    }
}
