package com.fc.web;

import com.fc.mapper.BatchDAO;
import com.fc.model.Batch;
import com.fc.model.BatchExample;
import com.fc.param.BatchParam;
import com.fc.result.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 批次管理
 *
 * @author: feng.chuang
 * @date: 2020-04-06 18:19
 **/
@RestController
@RequestMapping("/batch")
public class BatchController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BatchDAO batchDAO;

    @RequestMapping("/batchList")
    @Cacheable(value="user_list")
    public String list(Model model, @RequestParam(value = "cpage", defaultValue = "0") Integer cpage,
                       @RequestParam(value = "size", defaultValue = "6") Integer pageSize) {
        //page当前页号
        if (cpage==null ||cpage==0) {
            cpage=1;
        }
        //滑动窗口中格子个数，自行设置
        int navigatePages=6;

        int startrow=(cpage-1)*pageSize;
        //从startrow行开始，查询pageSize条记录
        BatchExample batchExample = new BatchExample();
        batchExample.setOrderByClause("id limit "+startrow+","+pageSize);
        List<Batch> batchList=batchDAO.selectByExample(batchExample);
        int total= (int) batchDAO.countByExample(new BatchExample());
        //根据页面属性生成页面对象
        Page<Batch> pageInfo =new Page<>(total, pageSize, navigatePages, cpage, batchList);
        //传递到前台页面
        model.addAttribute("page", pageInfo);
        model.addAttribute("batchList", batchList);
        return "batch/batchList";
    }

    @RequestMapping("/toAddBatch")
    public String toAdd() {
        return "batch/batchAdd";
    }

    @RequestMapping("/addBatch")
    public String add(@Valid BatchParam batchParam, BindingResult result, ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            return "batch/batchAdd";
        }
        BatchExample batchExample = new BatchExample();
        BatchExample.Criteria criteria = batchExample.createCriteria();
        criteria.andNameEqualTo(batchParam.getName());
        List<Batch> batchList = batchDAO.selectByExample(batchExample);
        Batch b = (batchList == null||batchList.size()==0)?null:batchList.get(0);
        if(b!=null){
            model.addAttribute("errorMsg","用户已存在!");
            return "batch/batchAdd";
        }
        Batch batch=new Batch();
        BeanUtils.copyProperties(batchParam,batch);
        batchDAO.insert(batch);
        return "redirect:/batch/batchList";
    }

    @RequestMapping("/toEditBatch")
    public String toEdit(Model model,Integer id) {
        Batch batch=batchDAO.selectByPrimaryKey(id);
        model.addAttribute("batch", batch);
        return "batch/batchEdit";
    }

    @RequestMapping("/editBatch")
    public String edit(@Valid BatchParam batchParam, BindingResult result,ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            model.addAttribute("batch", batchParam);
            return "batch/batchEdit";
        }

        Batch batch=batchDAO.selectByPrimaryKey(batchParam.getId());
        BeanUtils.copyProperties(batchParam,batch);

        batchDAO.updateByPrimaryKeySelective(batch);
        return "redirect:/batch/batchList";
    }

    @RequestMapping("/deleteUser")
    public String delete(Integer id) {
        batchDAO.deleteByPrimaryKey(id);
        return "redirect:/batch/batchList";
    }
}