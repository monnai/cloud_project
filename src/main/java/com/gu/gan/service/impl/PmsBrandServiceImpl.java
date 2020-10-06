package com.gu.gan.service.impl;

import com.github.pagehelper.PageHelper;
import com.gu.gan.mbg.model.PmsBrand;
import com.gu.gan.mbg.model.PmsBrandExample;
import com.gu.gan.service.PmsBrandService;
import com.macro.mall.tiny.mbg.mapper.PmsBrandMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gu.sc
 */
  @Service
  public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
      return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
      return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
      brand.setId(id);
      return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
      return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
      PageHelper.startPage(pageNum, pageSize);
      return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
      return brandMapper.selectByPrimaryKey(id);
    }
}
