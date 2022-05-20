package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Collect;
import com.chutiiing.backendsystem.entity.Tips;
import com.chutiiing.backendsystem.entity.TipsStarBySno;
import com.chutiiing.backendsystem.mapper.TipsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tips")
public class TipsController {

    @Autowired
    private TipsMapper tipsMapper;

    //查询全部数据
    @GetMapping("/findAll")
    public List<Tips> findAll() {
        return tipsMapper.findAll();
    }

    //查询是否被收藏
    @GetMapping("/isStar/{sno}/{tipsId}")
    public Boolean findBySno(@PathVariable String sno, @PathVariable String tipsId){
        return tipsMapper.isStar(tipsId,sno) == 1;
    }

    //收藏
    @PostMapping("/star")
    public Boolean insert(@RequestBody Collect collect) {
        return tipsMapper.insert(collect) == 1;
    }

    //取消收藏
    @DeleteMapping("/delStar")
    public Boolean delete(@RequestBody Collect collect){
        return tipsMapper.delStar(collect) == 1;
    }

    //查询收藏列表
    @GetMapping("/starList/{sno}")
    public List<TipsStarBySno> findBySno(@PathVariable String sno){
        return tipsMapper.stuStarList(sno);
    }

}
