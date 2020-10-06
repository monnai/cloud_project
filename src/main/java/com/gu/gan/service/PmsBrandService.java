package com.gu.gan.service;

import com.gu.gan.mbg.model.PmsBrand;
import java.util.List;

/**
 * @author gu.sc
 */
public interface PmsBrandService {
  List<PmsBrand> listAllBrand();

  int createBrand(PmsBrand brand);

  int updateBrand(Long id, PmsBrand brand);

  int deleteBrand(Long id);

  List<PmsBrand> listBrand(int pageNum, int pageSize);

  PmsBrand getBrand(Long id);
}
